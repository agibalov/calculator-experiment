package com.loki2302.failure;

public class DivisionByZeroFailureReason implements FailureReason {
	@Override
	public <T> T accept(FailureReasonVisitor<T> visitor) {
		return visitor.visitDivisionByZero(this);
	}		
}