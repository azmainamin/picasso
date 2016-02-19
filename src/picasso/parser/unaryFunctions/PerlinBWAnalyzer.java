package picasso.parser.unaryFunctions;


import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.binaryFunctions.BinaryFunctionAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.binaryFunctions.PerlinBW;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the  perlinBW function.
 * 
 * @author sharmas
 * 
 */
public class PerlinBWAnalyzer extends BinaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		System.out.println(tokens);
		tokens.pop();
		System.out.println(tokens);
		return new PerlinBW(SemanticAnalyzer.getInstance().generateExpressionTree(tokens), 
				SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
	}

}
