package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes two arguments.
 * 
 * @author sharmas
 *
 */
public abstract class TwoArgumentsFunction extends ExpressionTreeNode {

	ExpressionTreeNode param1;
	ExpressionTreeNode param2;

	public TwoArgumentsFunction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.param1 = param1;
		this.param2 = param2;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param1 + " " + param2;
	}

}
