/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.model.ImprovedNoise;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.binaryFunctions.BinaryFunction;

/**
 * Represents the PerlinBW function
 * 
 * @author sharmas
 * 
 */
public class PerlinBW extends BinaryFunction {

	public PerlinBW(ExpressionTreeNode param1, ExpressionTreeNode param2) {
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

		double grey = ImprovedNoise.noise(first.getRed() + second.getRed(),
				first.getGreen() + second.getGreen(), first.getBlue()
							+ second.getBlue());
			return new RGBColor(grey, grey, grey);
	}

}
