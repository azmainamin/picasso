package picasso.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import picasso.parser.language.BuiltinFunctionsReader;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.TokenFactory;

/**
 * SemanticAnalyzer calls appropriate SemanticAnalyzer for the given token
 * 
 * @author Sara Sprenkle
 */
public class SemanticAnalyzer implements SemanticAnalyzerInterface {

	private Map<Class, SemanticAnalyzerInterface> tokenToSemAnalyzer;
	private static SemanticAnalyzer ourInstance;

	private static final String thisPackage = "picasso.parser.";
	private static final String OPS_FILE = "src/picasso/parser/operations.prop";

	public static SemanticAnalyzer getInstance() {
		if (ourInstance == null) {
			ourInstance = new SemanticAnalyzer();
		}
		return ourInstance;
	}

	private SemanticAnalyzer() {
		tokenToSemAnalyzer = new HashMap<Class, SemanticAnalyzerInterface>();
		createFunctionParserMappings();
		createOperationMappings();

		// add for constants
		String tokenName = thisPackage + "tokens." + "NumberToken";
		String parserName = thisPackage + "ConstantAnalyzer";
		addSemanticAnalyzerMapping(tokenName, parserName);

		// IdentifierToken --> IdentifierAnalyzer
		tokenName = thisPackage + "tokens." + "IdentifierToken";
		parserName = thisPackage + "IdentifierAnalyzer";
		addSemanticAnalyzerMapping(tokenName, parserName);

		// Color mapping
		tokenName = thisPackage + "tokens." + "ColorToken";
		parserName = thisPackage + "ColorAnalyzer";
		addSemanticAnalyzerMapping(tokenName, parserName);

	}

	/**
	 * Adds the mapping between the Token class and the SemanticAnalyzer class
	 * 
	 * @param tokenName
	 * @param semanticAnalyzerName
	 */
	private void addSemanticAnalyzerMapping(String tokenName,
			String semanticAnalyzerName) {
		Class tokenClass = null;
		try {
			tokenClass = Class.forName(tokenName);
		} catch (ClassNotFoundException e) {
			throw new ParseException(tokenName + " not found " + e);
		}
		try {
			SemanticAnalyzerInterface p = (SemanticAnalyzerInterface) Class
					.forName(semanticAnalyzerName).newInstance();
			tokenToSemAnalyzer.put(tokenClass, p);
		} catch (ClassNotFoundException e) {
			throw new ParseException(semanticAnalyzerName + " not found " + e);
		} catch (InstantiationException e) {
			throw new ParseException(semanticAnalyzerName
					+ " not instantiated " + e);
		} catch (IllegalAccessException e) {
			throw new ParseException(semanticAnalyzerName + " not creatable "
					+ e);
		}
	}

	/**
	 * Map the function token to its semantic analyzer
	 */
	private void createFunctionParserMappings() {

		List<String> functionsList = BuiltinFunctionsReader.getFunctionsList();

		for (String function : functionsList) {
			String functionClass = TokenFactory.capitalize(function);
			String tokenName = thisPackage + "tokens.functions."
					+ functionClass + "Token";
			String semanticAnalyzer = thisPackage +"unaryFunctions." +  functionClass + "Analyzer";
			addSemanticAnalyzerMapping(tokenName, semanticAnalyzer);
		}
	}

	
	/**
	 * Map the operation token to its parser
	 */
	private void createOperationMappings() {

		String operationsTokensPackage = "picasso.parser.tokens.operations.";
		String parserPackage = "picasso.parser.binaryFunctions.";

		Properties opProps = new Properties();
		try {
			opProps.load(new FileReader(OPS_FILE));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (Object op : opProps.keySet()) {
			String opName = (String) opProps.get(op);
			String tokenName = operationsTokensPackage + opName + "Token";
			String parserName = parserPackage + opName + "Analyzer";
			addSemanticAnalyzerMapping(tokenName, parserName);
		}
	}

	/**
	 * From a stack of tokens in postfix order, creates an expression tree
	 * 
	 * @param tokens
	 *            in postfix order
	 * @return the root node of the expression tree.
	 */
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {

		if (tokens.isEmpty()) {

			throw new ParseException("Expected another argument.");
		}

		// Find the appropriate semantic analyzer for the token.
		Token t = tokens.peek();
		SemanticAnalyzerInterface analyzer = (SemanticAnalyzerInterface) tokenToSemAnalyzer
				.get(t.getClass());
		if (analyzer == null) {
			throw new ParseException("No semantic analyzer for " + t.getClass());
		}
		return analyzer.generateExpressionTree(tokens);
	}

}
