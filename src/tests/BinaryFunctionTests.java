/**
 * 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.binaryFunctions.PerlinBW;
import picasso.parser.language.expressions.binaryFunctions.PerlinColor;
import picasso.parser.language.expressions.binaryFunctions.Plus;

/**
 * Tests of the evaluation of x and y for the Perlin functions
 * 
 * @author sharmas
 * 
 */
public class BinaryFunctionTests {

	private ExpressionTreeGenerator parser;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void testPerlinBW() {
		ExpressionTreeNode e1 = parser.makeExpression("perlinBW(x, y )");
		assertEquals(new PerlinBW(new X(), new Y()), e1);
		
		ExpressionTreeNode e2 = parser.makeExpression("perlinBW(y, x+x )");
		assertEquals(new PerlinBW(new Y(), (new Plus(new X(), new X()))), e2);
		
	}
	
	@Test
	public void testPerlinColor() {
		ExpressionTreeNode e1 = parser.makeExpression("perlinColor(x, y )");
		assertEquals(new PerlinColor(new X(), new Y()), e1);
		
		ExpressionTreeNode e2 = parser.makeExpression("perlinColor(y, x+x )");
		assertEquals(new PerlinColor(new Y(), (new Plus(new X(), new X()))), e2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

}
