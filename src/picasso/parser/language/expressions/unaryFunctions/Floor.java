package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the floor function
 * 
 * @author Sara Sprenkle
 * 
 */
public class Floor extends UnaryFunction {

	public Floor(ExpressionTreeNode param) {
		super(param);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.floor(result.getRed());
		double green = Math.floor(result.getGreen());
		double blue = Math.floor(result.getBlue());

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Floor)) {
			return false;
		}
		Floor f = (Floor) obj;
		return param.equals(f.param);
	}

}
