/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * 
 * Represents the yCrCbtoRGB function.
 * 
 * @author barryj
 *
 */
public class YCrCbtoRGB extends UnaryFunction {

	/**
	 * @param param
	 */
	public YCrCbtoRGB(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() + result.getBlue() * 1.4022;
		double green = result.getRed() + result.getGreen() * -0.3456 + result.getBlue()
				* -0.7145;
		double blue = result.getRed() + result.getGreen() * 1.7710;
		return new RGBColor(red, green, blue);
	}

}
