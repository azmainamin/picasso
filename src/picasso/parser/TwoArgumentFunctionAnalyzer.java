package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.Token;

/**
 * Parses a function that takes two expressions as a parameter.
 * 
 * 
 * @author sharmas
 * 
 */
public abstract class TwoArgumentFunctionAnalyzer implements SemanticAnalyzerInterface {

	public abstract ExpressionTreeNode generateExpressionTree(
			Stack<Token> tokens, Stack<Token> tokens2);

}
