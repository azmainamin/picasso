package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents x
 * 
 * @author Sara Sprenkle
 * 
 */
public class X extends ExpressionTreeNode {

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(x, x, x);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof X)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "x";
	}

}
