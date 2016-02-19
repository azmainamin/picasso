/**
 * 
 */
package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Log;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the Log function.
 * 
 * @author barryj
 *
 */
public class LogAnalyzer extends UnaryFunctionAnalyzer {


	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new Log(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
