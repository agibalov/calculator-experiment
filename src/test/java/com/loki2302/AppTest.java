package com.loki2302;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {	
	@Test
	public void CalculatorIsOk() {
		assertEquals(123, Calculator.calculate("  123 "));
		assertEquals(3, Calculator.calculate("1 + 2"));
		assertEquals(6, Calculator.calculate(" 2*3  "));
		assertEquals(7, Calculator.calculate(" 1 + 2 * 3 "));
		assertEquals(10, Calculator.calculate("2 * 3 + 4"));
		assertEquals(26, Calculator.calculate("2 * 3 + 4 * 5"));
		assertEquals(9, Calculator.calculate(" ( 1 + 2 ) * 3 "));
		assertEquals(10, Calculator.calculate("(1 + 2) * 3 + 1"));
		assertEquals(53, Calculator.calculate("(1 + 2) * 3 + 4 * (5 + 6)"));	
		assertEquals(123, Calculator.calculate("(((((123)))))"));
		assertEquals(246, Calculator.calculate(" ( ( ( ( ( 123 ) ) ) * 2 ) ) "));
	}    
}
