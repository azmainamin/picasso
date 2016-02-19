package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;
/**
 * Represents the Minus Token
 * @author aminm
 *
 */

public class MinusToken extends CharToken implements OperationInterface{
	
	public MinusToken(){
		super(CharConstants.MINUS);
	}

}
