package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the wrap function
 * 
 * clamp results to [-1, 1]
 * 
 * @author sharmas
 * 
 */
public class Clamp extends UnaryFunction {

	public Clamp(ExpressionTreeNode param) {
		super(param);
	}
	public static int MIN_VALUE = -1;
	public static int MAX_VALUE = 1;

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		 
		double red = result.getRed();
		if (red < MIN_VALUE) 
			red = MIN_VALUE;
		if (red > MAX_VALUE)
			red = MAX_VALUE;
		
		double green = result.getGreen();
		if (green < MIN_VALUE) 
			green = MIN_VALUE;
		if (green > MAX_VALUE)
			green = MAX_VALUE;
		
		
		double blue = result.getBlue();
		if (blue < MIN_VALUE) 
			blue = MIN_VALUE;
		if (blue > MAX_VALUE)
			blue = MAX_VALUE;
		
		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Clamp)) {
			return false;
		}
		Clamp f = (Clamp) obj;
		return param.equals(f.param);
	}

}
