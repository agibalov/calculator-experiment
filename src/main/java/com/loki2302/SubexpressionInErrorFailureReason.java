package com.loki2302;

public class SubexpressionInErrorFailureReason implements FailureReason {
	private final EvaluationResult subexpressionEvaluationResult;
	
	public SubexpressionInErrorFailureReason(EvaluationResult subexpressionEvaluationResult) {
		this.subexpressionEvaluationResult = subexpressionEvaluationResult;
	}
	
	public EvaluationResult getSubexpressionEvaluationResult() {
		return subexpressionEvaluationResult;
	}
}