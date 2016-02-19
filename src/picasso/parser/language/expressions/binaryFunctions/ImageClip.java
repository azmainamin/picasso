/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.Clamp;


/**
 * @author barryj
 *
 */
public class ImageClip extends BinaryFunction {
	
	private Clamp wx;
	private Clamp wy;
	
	private Image myImage;

	/**
	 * @param param1
	 * @param param2
	 */
	public ImageClip(String fileName, ExpressionTreeNode param1, ExpressionTreeNode param2) {
		super(param1, param2);
		myImage = new Image(fileName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		wx = new Clamp(left);
		wy = new Clamp(right);
		
		RGBColor first = wx.evaluate(x, y);
		RGBColor second = wy.evaluate(x, y);
		
		double x1 = first.getRed();
		double y1 = second.getRed();

		return myImage.evaluate(x1, y1); 
	}

}
