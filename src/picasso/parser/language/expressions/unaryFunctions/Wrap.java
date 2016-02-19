package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the wrap function
 * 
 * wrap results around [-1, 1] (i.e., 1.5 -> -0.5)
 * 
 * @author sharmas
 * 
 */
public class Wrap extends UnaryFunction {

	public Wrap(ExpressionTreeNode param) {
		super(param);
	}
	
	public static int MIN_VALUE = -1;
	public static int MAX_VALUE = 1;

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		 
		double red = result.getRed();
		if (red < MIN_VALUE) 
			red = MIN_VALUE - red;
		if (red > MAX_VALUE)
			red = MAX_VALUE - red;
		
		double green = result.getGreen();
		if (green < MIN_VALUE) 
			green = MIN_VALUE - green;
		if (green > MAX_VALUE)
			green = MAX_VALUE - green;
		
		
		double blue = result.getBlue();
		if (blue < MIN_VALUE) 
			blue = MIN_VALUE - blue;
		if (blue > MAX_VALUE)
			blue = MAX_VALUE - blue;
		

		return new RGBColor(red, green, blue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Wrap)) {
			return false;
		}
		Wrap f = (Wrap) obj;
		return param.equals(f.param);
	}

}
