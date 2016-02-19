package picasso.parser.tokens.operations;
import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the exponentiate sign
 * 
 * @author aminm
 *
 */
public class ExponentToken extends CharToken implements OperationInterface{

	public ExponentToken() {
		super(CharConstants.CARET);
	}

}
