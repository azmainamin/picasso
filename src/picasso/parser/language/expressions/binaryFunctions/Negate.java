
package picasso.parser.language.expressions.binaryFunctions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.UnaryFunction;

/**
 * Evaluates the negate function
 * @author aminm
 *
 */
public class Negate extends UnaryFunction {

	public Negate(ExpressionTreeNode param) {
		super(param);
	}
	
	@Override
	public RGBColor evaluate(double x, double y){
		RGBColor result = param.evaluate(x,y);
		
		double red = -result.getRed();
		double green = -result.getGreen();
		double blue = -result.getBlue();
		
		return new RGBColor(red, green, blue);
		
	}
}
