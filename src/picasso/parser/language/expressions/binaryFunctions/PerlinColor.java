/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.binaryFunctions.BinaryFunction;

/**
 * Represents the PerlinColor function
 * 
 * @author sharmas
 * 
 */
public class PerlinColor extends BinaryFunction {

	public PerlinColor(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override	
	public RGBColor evaluate(double x, double y) {
		RGBColor first = left.evaluate(x, y);
		RGBColor second = right.evaluate(x, y);	
		
		double red = ImprovedNoise.noise(first.getRed() + 0.3, second
				.getRed() + 0.3, 0);
		double blue = ImprovedNoise.noise(first.getBlue() + 0.1, second
				.getBlue() + 0.1, 0);
		double green = ImprovedNoise.noise(first.getGreen() - 0.8, second
				.getGreen() - 0.8, 0);
		return new RGBColor(red, green, blue);
	}

}
