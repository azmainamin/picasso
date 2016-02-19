package picasso.parser.binaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.PerlinColor;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the  perlinColor function.
 * 
 * @author sharmas
 * @author aminm
 * 
 */
public class PerlinColorAnalyzer extends BinaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop();
		return new PerlinColor(SemanticAnalyzer.getInstance().generateExpressionTree(tokens), 
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
