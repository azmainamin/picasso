package picasso.parser.binaryFunctions;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Multiply;
import picasso.parser.tokens.Token;


/**
 * Parses the multiplication operation
 * @author aminm
 *
 */
public class MultiplyAnalyzer extends BinaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		super.generateExpressionTree(tokens);
		return new Multiply(left, right);
	}
}
