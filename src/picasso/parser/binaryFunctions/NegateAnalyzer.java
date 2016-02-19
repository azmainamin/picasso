package picasso.parser.binaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.SemanticAnalyzerInterface;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Negate;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the negate function.
 * 
 * @author aminm
 * 
 */

public class NegateAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree (Stack<Token> tokens){
		tokens.pop();
		
		return new Negate(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}
	
}
