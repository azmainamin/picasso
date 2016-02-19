/**
 * 
 */
package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the log function.
 * 
 * @author barryj
 *
 */
public class Log extends UnaryFunction {

	/**
	 * @param param
	 */
	public Log(ExpressionTreeNode param) {
		super(param);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.log(Math.abs(result.getRed()));
		double green = Math.log(Math.abs(result.getGreen()));
		double blue = Math.log(Math.abs(result.getBlue()));
		return new RGBColor(red, green, blue);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Log)) {
			return false;
		}
		Log f = (Log) obj;
		return param.equals(f.param);
	}
}
