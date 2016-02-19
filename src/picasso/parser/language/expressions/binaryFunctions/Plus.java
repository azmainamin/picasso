package picasso.parser.language.expressions.binaryFunctions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.UnaryFunction;
/**
 * Evaluates the addition operation
 * @author aminm
 *
 */
public class Plus extends BinaryFunction {

	public Plus(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1,param2);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = left.evaluate(x, y);
		RGBColor result2 = right.evaluate(x,y);
		double red = result1.getRed() + result2.getRed();
		double green = result1.getGreen() + result2.getGreen();
		double blue = result1.getBlue() + result2.getBlue();

		return new RGBColor(red, green, blue);
	}
	
	public boolean equals(Object obj){
		if (!(obj instanceof Plus)){
			return false;
		}
		Plus f = (Plus) obj;
		return left.equals(f.left) && right.equals(right);
	}
} 
