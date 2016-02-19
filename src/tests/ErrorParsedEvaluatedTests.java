package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import picasso.parser.ParseException;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Tests of incorrect parsing
 * 
 * @author Sara Sprenkle
 * 
 */
public class ErrorParsedEvaluatedTests {

	private ExpressionTreeGenerator parser;

	@Before
	public void setUp() throws Exception {
		parser = new ExpressionTreeGenerator();
	}

	@Test(expected = ParseException.class)
	public void errorConstantExpressionTest() {
		parser.makeExpression("- 7");
	}

	@Test(expected = ParseException.class)
	public void errorUnrecognizedInputTest() {
		parser.makeExpression("a");
	}

	@Test(expected = ParseException.class)
	public void errorTooFewArgsTest() {
		parser.makeExpression("( 7 + )");
	}

	@Test(expected = ParseException.class)
	public void errorExtraOperandTest() {
		parser.makeExpression("( 7 + 3 5)");
	}

	@Test(expected = ParseException.class)
	public void errorExtraOperandTest2() {
		parser.makeExpression("( 7 * 3 ) 5");
	}

	@Test(expected = ParseException.class)
	public void errorMissingRightParenTest() {
		ExpressionTreeNode e = parser.makeExpression("( 7 * 3 ");
		System.out.println(e);
	}

	@Test(expected = ParseException.class)
	public void errorMissingLeftParenTest() {
		ExpressionTreeNode e = parser.makeExpression("7 * 3 )");
		System.out.println(e);
	}
	
	@Test(expected = ParseException.class)
	public void errorTooFewArgFuncTest() {
		parser.makeExpression("sin(x) + tan() )");
	}
	
	@Test(expected = ParseException.class)
	public void errorTooManyArgFuncTest2() {
		parser.makeExpression("sin(x,y) + tan(sin(x)) )");
	}
	
	@Test(expected = ParseException.class)
	public void errorTooFewArgFuncTestPerlin() {
		parser.makeExpression("perlinColor(x) + tan(sin(x)) )");
	}
	
	@Test(expected = ParseException.class)
	public void errorTooFewArgFuncTestImage() {
		parser.makeExpression("ImageClip(x,y) + tan(sin(x)) )");
	}
	
	@Test(expected = ParseException.class)
	public void errorTooManyArgFuncTestImage() {
		parser.makeExpression("ImageClip(\"image.png\", x,y,sin(x)) + tan(sin(x)))");
	}

	@After
	public void tearDown() throws Exception {
	}

}
