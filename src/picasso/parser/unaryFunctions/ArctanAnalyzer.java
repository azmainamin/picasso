package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Arctan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the sine function.
 * 
 * @author sharmas
 * 
 */
public class ArctanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Arctan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}