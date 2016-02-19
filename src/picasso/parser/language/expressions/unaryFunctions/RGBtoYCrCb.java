/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Respresents the rgbToYCrCb function. 
 * 
 * @author barryj
 *
 */
public class RGBtoYCrCb extends UnaryFunction {

	/**
	 * @param param
	 */
	public RGBtoYCrCb(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed() * 0.2989 + result.getGreen() * 0.5866
				+ result.getBlue() * 0.5;
		double green = result.getRed() * -0.1687 + result.getGreen() * -0.3312
				+ result.getBlue() * 0.5;
		double blue = result.getRed() * 0.5000 + result.getGreen() * -0.4183
				+ result.getBlue() * -0.0816;
		return new RGBColor(red, green, blue);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RGBtoYCrCb)) {
			return false;
		}
		RGBtoYCrCb f = (RGBtoYCrCb) obj;
		return param.equals(f.param);
	}
}
