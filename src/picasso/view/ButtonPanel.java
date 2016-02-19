package picasso.view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.util.NamedCommand;



/**
 * The collection of commands represented as buttons that apply to the active
 * image.
 * 
 * @author Robert C Duvall
 * @author aminm - added method for adding JComboBox
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private Canvas myView;
	public static JComboBox<String> comboBox;

	/**
	 * Create panel that will update the given picasso.view.
	 */
	public ButtonPanel(Canvas view) {
		myView = view;
	}

	/**
	 * Add the given Command as a button with the given name.
	 */
	public void add(String name, final Command<Pixmap> action) {
		JButton button = new JButton(name);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action.execute(myView.getPixmap());
				myView.refresh();
			}
		});
		add(button);
	}

	/**
	 * Add the given Command as a button.
	 */
	public void add(NamedCommand<Pixmap> action) {
		add(action.getName(), action);
	}
	
	/**
	 * Add a JComboBox.
	 * ActionListener - whenever an item is selected on the combo box,
	 * it is displayed on the text field.
	 */

	public void addJComboBox(){
		comboBox = new JComboBox<String>();
		comboBox.setEditable(true);
		comboBox.setVisible(true);
		comboBox.setPreferredSize(new Dimension (650, 30));
		add(comboBox);
		
		comboBox.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String selected = (String) cb.getSelectedItem();
				Frame.textField.setText(selected);
			}
		});
	
	}
}
