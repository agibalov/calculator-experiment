package com.loki2302;

import com.loki2302.dom.CalculatorNode;

public class App {
    public static void main(String[] args) {
    	CalculatorParser calculatorParser = new CalculatorParser();
    	CalculatorNode expressionRoot = calculatorParser.parse("123");
		System.out.println(expressionRoot);
    }
}
