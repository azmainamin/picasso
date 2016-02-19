package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a variable
 * 
 * @author Sara Sprenkle
 *
 */
public class Variable extends ExpressionTreeNode {

	public static String name;

	public Variable(String name) {
	}

	@Override
	public RGBColor evaluate(double x, double y) {

		return null;
	}

	public String getName() {
		return name;
	}

}
