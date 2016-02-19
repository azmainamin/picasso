/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.unaryFunctions.*;
import picasso.parser.language.expressions.binaryFunctions.*;
import picasso.parser.language.expressions.*;


/**
 * Tests precedence
 * @author aminm
 *
 */
public class ParsedExpresssionPrecedenceTest {

	private ExpressionTreeGenerator parser;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void parenthesesExpressionTests() {
		ExpressionTreeNode e = parser.makeExpression("( x + y )");
		assertEquals(new Plus(new X(), new Y()), e);

		e = parser.makeExpression("( x + (y + [ 1, 1, 1] ) )");
		assertEquals(new Plus(new X(), new Plus(new Y(), new RGBColor(
				1, 1, 1))), e);
	}
	@Test 
	public void parenthesesPrecedenceTest(){
		ExpressionTreeNode e = parser.makeExpression("x+(y - sin(x))");
		assertEquals(new Plus(new X(),(new Minus(new Y(),new Sine(new X())))),e);
	}
	@Test 
	public void parenthesesPrecedenceTest2(){
		ExpressionTreeNode e = parser.makeExpression("x+(y - (x+x))");
		assertEquals(new Plus(new X(),(new Minus(new Y(),(new Plus (new X(), new X()))))),e);
	}
	@Test
	public void additionMultiplyPrecedenceTest(){
		ExpressionTreeNode e = parser.makeExpression("x+y*x");
		assertEquals(new Plus( new X(), new Multiply(new Y(), new X())), e);
		
		
		//Do we need this? 
		ExpressionTreeNode multi = new Multiply (new Y(), new X());
		assertEquals(new Plus(new X(), multi), e);
		
	}
	@Test 
	public void exponentMultiplyPrecedenceTest(){
		ExpressionTreeNode e = parser.makeExpression("y^x*sin(x)");
		assertEquals( new Multiply (new Exponent (new Y(), new X()) , new Sine ( new X())),e);
	}

}
