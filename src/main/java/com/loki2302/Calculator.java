package com.loki2302;

import com.loki2302.dom.ArithmeticOperation;
import com.loki2302.dom.ArithmeticOperationNode;
import com.loki2302.dom.CalculatorNode;
import com.loki2302.dom.CalculatorNodeVisitor;
import com.loki2302.dom.LiteralNode;

public class Calculator {
	public static int calculate(String expression) {
		CalculatorParser calculatorParser = new CalculatorParser();
    	CalculatorNode expressionRoot = calculatorParser.parse(expression);
    	return expressionRoot.accept(new CalculatorNodeVisitor<Integer>() {
			@Override
			public Integer visitLiteralNode(LiteralNode node) {
				return node.getValue();
			}

			@Override
			public Integer visitArithmeticOperationNode(ArithmeticOperationNode node) {
				int left = node.getLeftNode().accept(this);
				int right = node.getRightNode().accept(this);
				ArithmeticOperation operation = node.getOperation();
				if(operation == ArithmeticOperation.Add) {
					return left + right;
				} else if(operation == ArithmeticOperation.Sub) {
					return left - right;
				} else if(operation == ArithmeticOperation.Mul) {
					return left * right;
				} else if(operation == ArithmeticOperation.Div) {
					return left / right;
				}
				
				throw new RuntimeException();
			}        		
    	});
	}
}