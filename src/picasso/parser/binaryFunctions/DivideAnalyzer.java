package picasso.parser.binaryFunctions;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Divide;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the divisor or "division function".
 * 
 * @author aminm
 *
 */

public class DivideAnalyzer extends BinaryFunctionAnalyzer{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		super.generateExpressionTree(tokens);
	
		return new Divide(left, right);
	}

}
