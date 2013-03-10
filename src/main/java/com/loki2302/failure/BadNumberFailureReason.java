package com.loki2302.failure;

import com.loki2302.dom.DOMLiteralExpression;

public class BadNumberFailureReason implements FailureReason {	
	private final DOMLiteralExpression domLiteralExpression;
	
	public BadNumberFailureReason(DOMLiteralExpression domLiteralExpression) {
		this.domLiteralExpression = domLiteralExpression;
	}
	
	public DOMLiteralExpression getDOMLiteralExpression() {
		return domLiteralExpression;
	}
	
	@Override
	public <T> T accept(FailureReasonVisitor<T> visitor) {
		return visitor.visitBadNumber(this);
	}		
}