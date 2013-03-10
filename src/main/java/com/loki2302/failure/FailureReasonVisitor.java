package com.loki2302.failure;

public interface FailureReasonVisitor<T> {
	T visitBadNumber(BadNumberFailureReason failureReason);
	T visitDivisionByZero(DivisionByZeroFailureReason failureReason);
	T visitSubexpressionInError(SubexpressionInErrorFailureReason failureReason);
}