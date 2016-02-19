package picasso.parser.unaryFunctions;
import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Wrap;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the clamp function
 * 
 * @author sharmas
 *
 */
public class WrapAnalyzer extends UnaryFunctionAnalyzer{
	
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the clamp token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Wrap(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
