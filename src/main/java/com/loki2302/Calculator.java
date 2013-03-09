package com.loki2302;

import com.loki2302.dom.DOMAddExpression;
import com.loki2302.dom.DOMDivExpression;
import com.loki2302.dom.DOMExpression;
import com.loki2302.dom.DOMExpressionVisitor;
import com.loki2302.dom.DOMLiteralExpression;
import com.loki2302.dom.DOMMulExpression;
import com.loki2302.dom.DOMSubExpression;

public class Calculator {
	public static int calculate(String expression) {
		CalculatorParser calculatorParser = new CalculatorParser();
    	DOMExpression expressionRoot = calculatorParser.parse(expression);
    	return processExpression(expressionRoot);
	}
	
	private static int processExpression(DOMExpression domExpression) {
		return domExpression.accept(new DOMExpressionVisitor<Integer>() {
			@Override
			public Integer visitLiteralExpression(DOMLiteralExpression expression) {
				return expression.getValue();
			}

			@Override
			public Integer visitAddExpression(DOMAddExpression expression) {
				int leftValue = processExpression(expression.getLeftExpression());
				int rightValue = processExpression(expression.getRightExpression());
				return leftValue + rightValue;
			}

			@Override
			public Integer visitSubExpression(DOMSubExpression expression) {
				int leftValue = processExpression(expression.getLeftExpression());
				int rightValue = processExpression(expression.getRightExpression());
				return leftValue - rightValue;
			}

			@Override
			public Integer visitMulExpression(DOMMulExpression expression) {
				int leftValue = processExpression(expression.getLeftExpression());
				int rightValue = processExpression(expression.getRightExpression());
				return leftValue * rightValue;
			}

			@Override
			public Integer visitDivExpression(DOMDivExpression expression) {
				int leftValue = processExpression(expression.getLeftExpression());
				int rightValue = processExpression(expression.getRightExpression());
				return leftValue / rightValue;
			}			
		});
	}
}