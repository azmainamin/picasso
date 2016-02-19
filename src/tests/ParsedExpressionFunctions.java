package tests;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;
import picasso.parser.language.expressions.binaryFunctions.*;
import picasso.parser.language.expressions.unaryFunctions.*;
import picasso.parser.language.expressions.unaryFunctions.Random;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the creation of all the functions
 * @author aminm
 *
 */
public class ParsedExpressionFunctions {
	private ExpressionTreeGenerator parser;
	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void floorTests() {
		ExpressionTreeNode e = parser.makeExpression("floor( x )");
		assertEquals(new Floor(new X()), e);

		e = parser.makeExpression("floor( x + y )");
		assertEquals(new Floor(new Plus(new X(), new Y())), e);
	}
	@Test
	public void absFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("abs( x )");
		assertEquals(new AbsoluteVal(new X()), e);

		e = parser.makeExpression("abs( x + y )");
		assertEquals(new AbsoluteVal(new Plus(new X(), new Y())), e);
	}
	@Test
	public void arcTanCeilingFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("atan( x )");
		assertEquals(new Arctan(new X()), e);

		e = parser.makeExpression("atan( x ^ y ) - ceil(y) ");
		assertEquals(new Minus (new Arctan ( new Exponent (new X(), new Y())) , new Ceiling (new Y())), e);
	}
	@Test
	public void sinCosFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("sin( x ) % cos(x)");
		assertEquals(new Mod ( new Sine ( new X()), new Cosine ( new X())), e);

	}
	
	@Test
	public void clampExpFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("exp(clamp(x))");
		assertEquals(new Exp ( new Clamp ( new X ())), e);

	}
	
	@Test
	public void logRandomFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("log(x) / Random()");
		assertEquals( new Divide (new Log (new X()), new Random()) , e);

	}
	
	@Test
	public void wrapTanFunctionTest() {
		ExpressionTreeNode e = parser.makeExpression("wrap(tan(x) ^ tan (y))");
		assertEquals(new Wrap ( new Exponent ( new Tangent (new X()), new Tangent ( new X ()))), e);

	}
}
