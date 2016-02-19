package picasso.parser.binaryFunctions;

import java.util.Stack;

import picasso.parser.SemanticAnalyzer;
import picasso.parser.SemanticAnalyzerInterface;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

/**
 * Parses a function that takes two expressions as a parameter.
 * 
 * 
 * @author sharmas
 * @author aminm
 * 
 */
public abstract class BinaryFunctionAnalyzer implements SemanticAnalyzerInterface {
	
	protected ExpressionTreeNode left;
	protected ExpressionTreeNode right;
	
	public ExpressionTreeNode generateExpressionTree(
			Stack<Token> tokens){
		
		//pop the operator token
		tokens.pop();
		
		
		//do right param first
		right = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		left =  SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		//Just for the sake returning a tree node.
		return right;
	}
		
	
	

	

}
