/**
 * 
 */
package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.binaryFunctions.BinaryFunctionAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.ImageClip;
import picasso.parser.language.expressions.binaryFunctions.ImageWrap;
import picasso.parser.tokens.Token;
import picasso.parser.tokens.operations.StringToken;
import picasso.parser.language.expressions.Image;

/**
 * @author sharmas
 *
 */
public class ImageClipAnalyzer extends BinaryFunctionAnalyzer {

	/**
	 * 
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		super.generateExpressionTree(tokens);
		
		StringToken st = (StringToken) tokens.pop();
		
		String fileName = st.input();
		
		return new ImageClip(fileName, left, right);
	}

}
