package com.loki2302;

import java.util.ArrayList;
import java.util.List;

import com.loki2302.dom.DOMAddExpression;
import com.loki2302.dom.DOMDivExpression;
import com.loki2302.dom.DOMExpression;
import com.loki2302.dom.DOMExpressionVisitor;
import com.loki2302.dom.DOMLiteralExpression;
import com.loki2302.dom.DOMMulExpression;
import com.loki2302.dom.DOMSubExpression;

public class Calculator {
	public static EvaluationResult calculate(String expression) {
		CalculatorParser calculatorParser = new CalculatorParser();
    	DOMExpression expressionRoot = calculatorParser.parse(expression);
    	return processExpression(expressionRoot);
	}
	
	private static EvaluationResult processExpression(DOMExpression domExpression) {
		return domExpression.accept(new DOMExpressionVisitor<EvaluationResult>() {
			@Override
			public EvaluationResult visitLiteralExpression(DOMLiteralExpression expression) {
				int value = expression.getValue();
				return EvaluationResult.ok(value);
			}

			@Override
			public EvaluationResult visitAddExpression(DOMAddExpression expression) {				
				List<FailureReason> failureReasons = new ArrayList<FailureReason>();
				EvaluationResult leftResult = processExpression(expression.getLeftExpression());
				if(!leftResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(leftResult));
				}
				
				EvaluationResult rightResult = processExpression(expression.getRightExpression());
				if(!rightResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(rightResult));
				}
				
				if(!failureReasons.isEmpty()) {
					return EvaluationResult.fail(failureReasons);
				}
				
				int leftValue = leftResult.getValue();
				int rightValue = rightResult.getValue();
				return EvaluationResult.ok(leftValue + rightValue);
			}

			@Override
			public EvaluationResult visitSubExpression(DOMSubExpression expression) {
				List<FailureReason> failureReasons = new ArrayList<FailureReason>();
				EvaluationResult leftResult = processExpression(expression.getLeftExpression());
				if(!leftResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(leftResult));
				}
				
				EvaluationResult rightResult = processExpression(expression.getRightExpression());
				if(!rightResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(rightResult));
				}
				
				if(!failureReasons.isEmpty()) {
					return EvaluationResult.fail(failureReasons);
				}
				
				int leftValue = leftResult.getValue();
				int rightValue = rightResult.getValue();
				return EvaluationResult.ok(leftValue - rightValue);
			}

			@Override
			public EvaluationResult visitMulExpression(DOMMulExpression expression) {
				List<FailureReason> failureReasons = new ArrayList<FailureReason>();
				EvaluationResult leftResult = processExpression(expression.getLeftExpression());
				if(!leftResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(leftResult));
				}
				
				EvaluationResult rightResult = processExpression(expression.getRightExpression());
				if(!rightResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(rightResult));
				}
				
				if(!failureReasons.isEmpty()) {
					return EvaluationResult.fail(failureReasons);
				}
				
				int leftValue = leftResult.getValue();
				int rightValue = rightResult.getValue();
				return EvaluationResult.ok(leftValue * rightValue);
			}

			@Override
			public EvaluationResult visitDivExpression(DOMDivExpression expression) {
				List<FailureReason> failureReasons = new ArrayList<FailureReason>();
				EvaluationResult leftResult = processExpression(expression.getLeftExpression());
				if(!leftResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(leftResult));
				}
				
				EvaluationResult rightResult = processExpression(expression.getRightExpression());
				if(!rightResult.isOk()) {
					failureReasons.add(new SubexpressionInErrorFailureReason(rightResult));
				}
				
				if(!failureReasons.isEmpty()) {
					return EvaluationResult.fail(failureReasons);
				}
				
				int leftValue = leftResult.getValue();
				int rightValue = rightResult.getValue();
				
				if(rightValue == 0) {
					return EvaluationResult.fail(new DivisionByZeroFailureReason());
				}
				
				return EvaluationResult.ok(leftValue / rightValue);
			}			
		});
	}
}