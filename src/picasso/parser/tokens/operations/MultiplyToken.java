package picasso.parser.tokens.operations;
import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Represents the multiplication sign
 * 
 * @author aminm
 *
 */
public class MultiplyToken extends CharToken implements OperationInterface{
	public MultiplyToken() {
		super(CharConstants.STAR);
	}

}
