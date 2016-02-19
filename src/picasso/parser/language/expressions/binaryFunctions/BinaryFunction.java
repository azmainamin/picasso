package picasso.parser.language.expressions.binaryFunctions;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.X;
import picasso.parser.language.expressions.Y;
/**
 * Represents a function that takes two arguments
 * 
 * @author oconnorp
 *
 */
public abstract class BinaryFunction extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;
	
	public BinaryFunction(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		
		this.left = param1;
		this.right = param2;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass() + ": " + left + "," + right;
	}
	
	public boolean equals(Object obj) {

		if (!(obj instanceof BinaryFunction)) {
			return false;
		}
		BinaryFunction f = (BinaryFunction) obj;
		return left.equals(f.left) && right.equals(f.right);
	}
}
