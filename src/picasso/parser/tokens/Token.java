/**
 * 
 */
package picasso.parser.tokens;

/**
 * @author Sara Sprenkle
 *
 */
public abstract class Token {

	private String description;
	
	public Token( String description ) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
	
	/**
	 * 
	 * @return true iff this Token represents a constant
	 */
	public abstract boolean isConstant();
	
	/**
	 * 
	 * @return true iff this Token represents a function
	 */
	public abstract boolean isFunction();
	
}
