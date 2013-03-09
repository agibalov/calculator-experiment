package com.loki2302;

import com.loki2302.dom.DOMExpression;

public class App {
    public static void main(String[] args) {
    	CalculatorParser calculatorParser = new CalculatorParser();
    	DOMExpression expressionRoot = calculatorParser.parse("123");
		System.out.println(expressionRoot);
    }
}
