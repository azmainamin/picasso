package picasso.view.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import picasso.util.Command;
import picasso.view.Frame;

/**
 * Extension 1: part 1
 * Automatically saves a history of expressions that are evaluated
 * by the user in an ArrayList.
 * 
 * @author sharmas
 * @author aminm
 */
@SuppressWarnings("rawtypes")
public class SaveHistory implements Command{	
	
	static List<String> expressionList = new ArrayList<String>();
	
	public static void saveExpression() {
		String expression = Frame.textField.getText();
		String imageName = JOptionPane.showInputDialog("Please enter the image name.");
		try {
			FileWriter out = new FileWriter(new File("expressionList.txt"), true);
		    out.write(imageName + " : ");
			out.write(expression);
		    out.write(System.getProperty("line.separator"));
		    out.close();
		} catch (IOException e) {}	
	}
	
	
	@Override
	public void execute(Object target) {
		saveExpression();
		
	}
	
}
	

    
	
