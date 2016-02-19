package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the random function
 * 
 * wrap results around [-1, 1] (i.e., 1.5 -> -0.5)
 * 
 * @author sharmas
 * 
 */
public class Random extends ExpressionTreeNode {
	
	
	public Random() {
		super();
	}
	
	public static int MIN_COLOR = -1;
	public static int MAX_COLOR = 1;
	
	public RGBColor evaluate(double x, double y) {
		 
		double red = MIN_COLOR + (Math.random() * (MAX_COLOR - MIN_COLOR));
		
		double green = MIN_COLOR + (Math.random() * (MAX_COLOR - MIN_COLOR));
		
		double blue = MIN_COLOR + (Math.random() * (MAX_COLOR - MIN_COLOR));		

		return new RGBColor(red, green, blue);
	}
}
