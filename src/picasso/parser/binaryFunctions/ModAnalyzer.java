
package picasso.parser.binaryFunctions;
import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.Mod;
import picasso.parser.tokens.Token;

/**
 * Parse the mod operation
 * @author aminm
 *
 */
public class ModAnalyzer extends BinaryFunctionAnalyzer {

	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens){
			super.generateExpressionTree(tokens);
			return new Mod(left, right);
	}
}
