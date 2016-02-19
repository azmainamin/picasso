package picasso.parser.language.expressions;

import picasso.parser.IdentifierAnalyzer;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Assigns an expression to a variable
 * 
 * @author sharmas
 *
 */
public class Assignment extends Variable {

	private ExpressionTreeNode param;
	
	public Assignment(String name, ExpressionTreeNode param) {
		super(name);
		this.param = param;
		IdentifierAnalyzer.idToExpression.put(name, param);
	}	
	
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = result.getRed();
		double green = result.getGreen();
		double blue = result.getBlue();

		return new RGBColor(red, green, blue);
	}

	public String toString() {
		return "Variable name: " + name + "Expression: " + param;
	}
}
