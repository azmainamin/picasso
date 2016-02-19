/**
 * 
 */
package picasso.parser.language.expressions.binaryFunctions;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Image;
import picasso.parser.language.expressions.RGBColor;
import picasso.parser.language.expressions.unaryFunctions.Wrap;

/**
 * Represents the ImageWrap function.
 * 
 * @author barryj
 *
 */
public class ImageWrap extends BinaryFunction {

	private Wrap wx;
	private Wrap wy;
	
	private Image myImage;
	
	/**
	 * @param param1
	 * @param param2
	 */
	public ImageWrap(String fileName, ExpressionTreeNode param1, ExpressionTreeNode param2) {		
		super(param1, param2);
		myImage = new Image(fileName);
	}

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		
		wx = new Wrap(left);
		wy = new Wrap(right);
		
		RGBColor first = wx.evaluate(x, y);
		RGBColor second = wy.evaluate(x, y);
		
		double x1 = first.getRed();
		double y1 = second.getRed();

		return myImage.evaluate(x1, y1); 
		
	}

}
