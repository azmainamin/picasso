/**
 * 
 */
package picasso.view.commands;

import java.util.Random;

import picasso.util.Command;
import picasso.view.Frame;


/** 
 * Extension 2
 * A random expression is generated when the user selects the
 * button 'RandomExpression'. The expression can then be evaluated
 * by selecting the button 'Evaluate'.
 * 
 * @author aminm
 *
 */
@SuppressWarnings("rawtypes")
public class RandomExpression implements Command{
	//Arrays of the functions, variables and operations, so that we can randomly choose from them.
	
	public static String[] functionArray = { "cos(" , "sin(" , "tan(" , "clamp(", 
			"exp("  , "log(", "RGBToYCrCb(" , "YCrCbtoRGB(" , "wrap(" , "atan(" , "perlinColor(x," ,
			"perlinBW(y,"};
	
	public static String[] operationArray = {"+" , " - " , "*" , "/"};
	
	public static char[] variableArray = {'x' , 'y'};
	
	//Represents Function
	public static final int FUNCTION = 1;
	
	//Range of functions
	public static final int HIGH = 15;
	public static final int LOW = 10;
	
	static Random r = new Random();
	

	
	/**
	 * Generates a random expression.
	 * @author aminm
	 * @return a random expression as a string
	 */
	public static String generateRandomExpression(){
		int numOfExp = r.nextInt(HIGH-LOW) + LOW;
		
		String expression = "";
		
		//To keep count of number of functions, so we can put appropriate ending parentheses.
		int pCounter = 0;
		
		//Initial random function + variable // Can be improved
		expression += generateRandomFunction()+ generateRandomVariable();
		
		pCounter ++;
		
		for(int i = 0 ; i < numOfExp ;i++){
			
			expression += generateRandomOperator();
			//Choose a function + variable or just variable
			int j = r.nextInt(1) + 1;
			if (j==FUNCTION){
				expression+= generateRandomFunction() + generateRandomVariable();
				pCounter ++;
			}
			else {
				expression += generateRandomVariable();
			}
			expression += generateRandomOperator();
			expression += generateRandomVariable();
			
			
		}
		//Complete the parentheses
		for (int p =0 ; p < pCounter; p++){
			expression += ")";
		}
		
		return expression;
	}
	/**
	 * 
	 * @returns a random function from functionArray
	 */
	public static String generateRandomFunction(){
		int randInt = r.nextInt(functionArray.length);
		return functionArray[randInt];
		
	}
	/**
	 * 
	 * @returns a random variable from variableArray
	 */
	public static char generateRandomVariable(){
		int randInt = r.nextInt(variableArray.length);
		return variableArray[randInt];
		
	}
	/**
	 * 
	 * @returns a random operator from operatorArray
	 */
	public static String generateRandomOperator(){
		int randInt = r.nextInt(operationArray.length);
		return operationArray[randInt];
		
	}

	@Override
	public void execute(Object target) {
		Frame.textField.setText("");
		Frame.textField.setText(generateRandomExpression());	
	}


}
