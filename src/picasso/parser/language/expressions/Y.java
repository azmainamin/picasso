package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents y
 * 
 * @author Sara Sprenkle
 * 
 */
public class Y extends ExpressionTreeNode {

	@Override
	public RGBColor evaluate(double x, double y) {
		return new RGBColor(y, y, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Y)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "y";
	}
}
