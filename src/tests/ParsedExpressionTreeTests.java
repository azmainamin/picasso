package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.binaryFunctions.*;


/**
 * Tests of creating an expression tree from a string expression
 * Tests the creation of all the operations
 * 
 * @author Sara Sprenkle
 * @author aminm
 * 
 */
public class ParsedExpressionTreeTests {

	private ExpressionTreeGenerator parser;

	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test
	public void constantExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("[1,-1, 1]");
		assertEquals(new RGBColor(1, -1, 1), e);
	}

	@Test
	public void additionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x + y");
		assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);
	}
	@Test
	public void subtractionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x - y");
		assertEquals(new Minus(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] - y");
		assertEquals(new Minus(new RGBColor(1, .3, -1), new Y()), e);
	}

	@Test
	public void divisionExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x/y");
		assertEquals(new Divide(new X(), new Y()), e);
		
		e = parser.makeExpression("[1,.3,-1] / y");
		assertEquals(new Divide(new RGBColor(1, .3, -1), new Y()), e);

	}
	@Test
	public void multiplicationExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x*y");
		assertEquals(new Multiply(new X(), new Y()), e);
		
		e = parser.makeExpression("[1,.3,-1] / y");
		assertEquals(new Divide(new RGBColor(1, .3, -1), new Y()), e);

	}
	
	@Test
	public void modExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x%y");
		assertEquals(new Mod(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] % y");
		assertEquals(new Mod(new RGBColor(1, .3, -1), new Y()), e);
	}

	@Test
	public void exponentExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("x^y");
		assertEquals(new Exponent(new X(), new Y()), e);

		e = parser.makeExpression("[1,.3,-1] + y");
		assertEquals(new Plus(new RGBColor(1, .3, -1), new Y()), e);
	}

}
