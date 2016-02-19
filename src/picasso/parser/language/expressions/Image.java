/**
 * 
 */
package picasso.parser.language.expressions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.tokens.TokenFactory;
import picasso.parser.tokens.operations.StringToken;

/**
 * Handles an image generated from a file
 * 
 * @author barryj
 *
 */
public class Image extends ExpressionTreeNode {	
	/**
	 * 
	 */
	public static final double COLOR_MIN = -1;
	public static final double COLOR_MAX = 1;
	public static final int JAVA_COLOR_MAX = 255;
	
	protected String myFileName;
	private BufferedImage myImage;
	private int myHeight;
	private int myWidth;
	
	private double myRed;
	private double myGreen;
	private double myBlue;
	
	private Color myColor;
	
	public Image(String input) {
		try {
			myFileName = input;
			myImage = ImageIO.read(new File(myFileName));
			myHeight = myImage.getHeight() - 1;
			myWidth = myImage.getWidth() - 1;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	/* (non-Javadoc)
	 * @see picasso.parser.language.ExpressionTreeNode#evaluate(double, double)
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		myColor = new Color(myImage.getRGB(domainToImageScaleX(x), domainToImageScaleY(y)));
		myRed = toDouble(myColor.getRed());
		myGreen = toDouble(myColor.getGreen());
		myBlue = toDouble(myColor.getBlue());
		return new RGBColor(myRed, myGreen, myBlue);
	}



	protected double toDouble(int value) {
		double range = COLOR_MAX - COLOR_MIN;
		return (double) value / JAVA_COLOR_MAX * range + COLOR_MIN;
	}

	protected int domainToImageScaleX(double value) {
		return (int)((value + 1) * (myWidth / 2));
	}
	
	protected int domainToImageScaleY(double value) {
		return (int)((value + 1) * (myHeight / 2));
	}
	

}
