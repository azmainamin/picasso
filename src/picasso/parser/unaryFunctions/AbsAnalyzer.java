package picasso.parser.unaryFunctions;
import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.AbsoluteVal;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the absolute value function
 * 
 * @author oconnorp
 *
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
	
		return new AbsoluteVal(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
