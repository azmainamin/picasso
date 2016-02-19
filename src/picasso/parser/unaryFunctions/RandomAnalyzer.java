package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the random function.
 * 
 * @author sharmas
 * 
 */
public class RandomAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		// TODO Auto-generated method stub
		return new picasso.parser.language.expressions.unaryFunctions.Random();
	}

}
