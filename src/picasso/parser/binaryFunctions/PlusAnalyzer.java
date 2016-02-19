package picasso.parser.binaryFunctions;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Plus;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the plus or "addition function".
 * 
 * @author Sara Sprenkle
 * @author aminm
 * 
 */
public class PlusAnalyzer extends BinaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		super.generateExpressionTree(tokens);
		return new Plus(left, right);
	}
}
