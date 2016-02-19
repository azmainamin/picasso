/**
 * 
 */
package picasso.parser.binaryFunctions;


import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Exponent;
import picasso.parser.tokens.Token;

/**
 * Parses the exponentiation operation
 * @author aminm
 *
 */
public class ExponentAnalyzer extends BinaryFunctionAnalyzer {
	
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens){
		super.generateExpressionTree(tokens);
		return new Exponent(left,right);
	}

}
