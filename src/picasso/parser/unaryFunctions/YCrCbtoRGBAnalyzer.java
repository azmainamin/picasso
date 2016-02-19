/**
 * 
 */
package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.YCrCbtoRGB;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the YCrCbtoRGB function. 
 * 
 * @author barryj
 *
 */
public class YCrCbtoRGBAnalyzer extends UnaryFunctionAnalyzer {

	/**
	 * 
	 */
	public YCrCbtoRGBAnalyzer() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see picasso.parser.UnaryFunctionAnalyzer#generateExpressionTree(java.util.Stack)
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new YCrCbtoRGB(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
