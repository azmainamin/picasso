package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Ceiling;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the ceiling function
 * @author oconnorp
 *
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens){
		tokens.pop();
		//need to remove the ceiling token
		//the parameter is the next token on the stack.
		//but, it needs to be processed
		return new Ceiling(SemanticAnalyzer.getInstance().generateExpressionTree(tokens));
		
	}

}
