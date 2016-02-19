/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.tokens.Token;

/**
 * Represents a string
 * 
 * @author barryj
 *
 */
public class StringToken extends Token implements OperationInterface{
	
	private final String myInput;

	/**
	 * @param description
	 */
	public StringToken(String input) {
		super("String Token");
		myInput = input;
		// TODO Auto-generated constructor stub
	}

	public String input() {
		return myInput;
	}
		
	/* (non-Javadoc)
	 * @see picasso.parser.tokens.Token#isConstant()
	 */
	@Override
	public boolean isConstant() {
		return true;
	}

	/* (non-Javadoc)
	 * @see picasso.parser.tokens.Token#isFunction()
	 */
	@Override
	public boolean isFunction() {
		return false;
	}

}
