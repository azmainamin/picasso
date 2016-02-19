package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a constant in the Picasso language.
 * 
 * @author Sara Sprenkle
 * 
 */
public class Constant extends ExpressionTreeNode {

	protected double value;

	/**
	 * 
	 * @param d
	 *            must be in range [-1, 1]
	 */
	public Constant(double d) {
		if (d < -1 || d > 1) {
			throw new IllegalArgumentException(
					"Constant must be in range [-1, 1]");
		}
		value = d;
	}

	public double value() {
		return value;
	}

	public String toString() {
		return "Constant: " + value;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		// The constant is like an RGB Color with the constant as each
		// component.
		return new RGBColor(value, value, value);
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Constant)) {
			return false;
		}
		Constant other = (Constant) obj;
		return other.value == value;
	}
}
