package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;


/**
 * 
 *
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	//public static String exp;
	public static JTextField textField;
	public static JComboBox<String> comboBox;

	@SuppressWarnings("unchecked")
	public Frame(String title, Dimension size) {
		setTitle(title);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas,
				new Evaluater()));
		commands.add("Save", new Writer());
		commands.add("Random Expression", new RandomExpression());
		commands.add("Save Exp to file.", new SaveHistory());
		//commands.add("Display Saved Expressions", new DisplayHistory());
		commands.addJComboBox();
		
		

		//add text box

		textField = new JTextField("Enter expression.",20);
		textField.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseClicked(MouseEvent e){
				textField.setText("");
			}
		});
	

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		getContentPane().add(textField, BorderLayout.SOUTH);
		pack();
	}
}
