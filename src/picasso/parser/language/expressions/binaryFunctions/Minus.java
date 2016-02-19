package picasso.parser.language.expressions.binaryFunctions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
/**
 * Evaluates the subtraction operation
 * @author aminm
 *
 */
public class Minus extends BinaryFunction {

	public Minus(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1,param2);
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = left.evaluate(x, y);
		RGBColor result2 = right.evaluate(x,y);
		double red = result1.getRed() - result2.getRed();
		double green = result1.getGreen() - result2.getGreen();
		double blue = result1.getBlue() - result2.getBlue();

		return new RGBColor(red, green, blue);
	}
}
