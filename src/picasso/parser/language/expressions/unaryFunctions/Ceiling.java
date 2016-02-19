package picasso.parser.language.expressions.unaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;

/**
 * Represents the ceiling function
 * 
 * @author oconnorp
 *
 */
public class Ceiling extends UnaryFunction {

	public Ceiling(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y){
		RGBColor result = param.evaluate(x, y);
		double red  = Math.ceil(result.getRed());
		double green = Math.ceil(result.getGreen());
		double blue = Math.ceil(result.getBlue());
		
		return new RGBColor(red,green,blue);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ceiling)) {
			return false;
		}
		Ceiling f = (Ceiling) obj;
		return param.equals(f.param);
	}
	
}
