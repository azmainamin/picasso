/**
 * 
 */
package picasso.parser.tokens.functions;

import picasso.parser.tokens.Token;

/**
 * Parent class for Tokens that represent functions.
 * 
 * @author Sara Sprenkle
 * 
 */
public abstract class FunctionToken extends Token {

	public FunctionToken(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see picasso.parser.tokens.Token#isConstant()
	 */
	@Override
	public boolean isConstant() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see picasso.parser.tokens.Token#isFunction()
	 */
	@Override
	public boolean isFunction() {
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj.getClass().equals(this.getClass());
	}

}
