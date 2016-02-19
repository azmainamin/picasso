/**
 * 
 */
package picasso.parser.binaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzerInterface;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.StringToken;

/**
 * @author barryj
 *
 */
public class StringAnalyzer implements SemanticAnalyzerInterface  {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		StringToken st = (StringToken) tokens.pop();
		
		// Check that the string input is a valid string
		String input = st.input();
		
		return new Image(input);
	}
}
