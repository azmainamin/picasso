package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a function that takes one argument.
 * 
 * @author Sara Sprenkle
 *
 */
public abstract class UnaryFunction extends ExpressionTreeNode {

	protected ExpressionTreeNode param;

	public UnaryFunction(ExpressionTreeNode param) {
		this.param = param;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + param;
	}
	
	public boolean equals(Object obj) {
		
		if (!(obj instanceof UnaryFunction)) {
			return false;
		}
		UnaryFunction f = (UnaryFunction) obj;
		return param.equals(f.param);
	}

}
