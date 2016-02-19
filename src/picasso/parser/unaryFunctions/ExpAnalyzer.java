package picasso.parser.unaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.Exp;
import picasso.parser.tokens.Token;

public class ExpAnalyzer extends UnaryFunctionAnalyzer{

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); 
	
		return new Exp(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
