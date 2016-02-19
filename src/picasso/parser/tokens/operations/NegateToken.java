package picasso.parser.tokens.operations;
import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the negate sign
 * 
 * @author aminm
 */
public class NegateToken extends CharToken implements OperationInterface{
	
	public NegateToken() {
		super(CharConstants.BANG);
	}
}