package com.loki2302.failure;

public interface FailureReason {
	<T> T accept(FailureReasonVisitor<T> visitor);
}