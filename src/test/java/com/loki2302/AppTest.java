package com.loki2302;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {	
	@Test
	public void CanParseLiteral() {
		CalculatorParser calculatorParser = new CalculatorParser();
    	CalculatorNode expressionRoot = calculatorParser.parse("123");
		assertTrue(expressionRoot.getClass() == LiteralNode.class);
		LiteralNode literalNode = (LiteralNode)expressionRoot;
		assertEquals(123, literalNode.getValue());
	}    
}
