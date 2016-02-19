/**
 * 
 */
package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.RGBtoYCrCb;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the YCrCbtoRGB function. 
 * 
 * @author barryj
 *
 */
public class RGBToYCrCbAnalyzer extends UnaryFunctionAnalyzer {



	/* (non-Javadoc)
	 * @see picasso.parser.UnaryFunctionAnalyzer#generateExpressionTree(java.util.Stack)
	 */
	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new RGBtoYCrCb(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
