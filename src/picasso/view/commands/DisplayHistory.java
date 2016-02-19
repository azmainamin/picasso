package picasso.view.commands;

import picasso.util.Command;
import picasso.view.ButtonPanel;
import picasso.view.Frame;

/**
 * Extension 1: part 2
 * Allows users to view a history of expressions evaluated in a JComboBox.
 * This history is structured in a list starting from the first expression
 * evaluated to the most recent.
 * 
 * @author sharmas
 * @author aminm
 *
 */

@SuppressWarnings("rawtypes")
public class DisplayHistory implements Command{	
	
	//Not needed. 
	public String getExpression(){
		String expression = Frame.textField.getText();
		return expression;
	}
	
	public String toString(){
		return ">> " + getExpression();
	}
	
	@Override
	public void execute(Object target) {
		ButtonPanel.comboBox.setVisible(true);
		ButtonPanel.comboBox.setPopupVisible(true);
		Frame.textField.setText((String) ButtonPanel.comboBox.getSelectedItem());

				
	}
	
}
	

    
	
