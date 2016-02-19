package picasso;

import java.awt.Dimension;

import picasso.view.Frame;

/**
 * Starting point for Picasso.
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main {
	public static final Dimension SIZE = new Dimension(800, 600);
	// This title isn't used. Instead, the title is set to the image or file
	// name used.
	public static final String TITLE = "PICASSO!";

	public static void main(String[] args) {
		Frame frame = new Frame(TITLE, SIZE);
		frame.setVisible(true);
	}
}
