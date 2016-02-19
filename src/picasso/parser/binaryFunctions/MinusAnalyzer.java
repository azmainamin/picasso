package picasso.parser.binaryFunctions;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Minus;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the plus or "subtraction function".
 * 
 * @author aminm
 * 
 */
public class MinusAnalyzer extends BinaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		super.generateExpressionTree(tokens);
		return new Minus(left, right);
	}
}
