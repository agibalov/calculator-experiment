package com.loki2302.failure;

import com.loki2302.EvaluationResult;

public class SubexpressionInErrorFailureReason implements FailureReason {
	private final EvaluationResult subexpressionEvaluationResult;
	
	public SubexpressionInErrorFailureReason(EvaluationResult subexpressionEvaluationResult) {
		this.subexpressionEvaluationResult = subexpressionEvaluationResult;
	}
	
	public EvaluationResult getSubexpressionEvaluationResult() {
		return subexpressionEvaluationResult;
	}

	@Override
	public <T> T accept(FailureReasonVisitor<T> visitor) {
		return visitor.visitSubexpressionInError(this);
	}
}