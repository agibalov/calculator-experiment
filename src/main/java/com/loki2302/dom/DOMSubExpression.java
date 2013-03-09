package com.loki2302.dom;

public class DOMSubExpression extends DOMBinaryExpression {	
	public DOMSubExpression(DOMExpression leftExpression, DOMExpression rightExpression) {
		super(leftExpression, rightExpression);
	}
		
	@Override
	public <T> T accept(DOMExpressionVisitor<T> visitor) {
		return visitor.visitSubExpression(this);
	}
	
	@Override
	public String toString() {
		return String.format("(%s-%s)", getLeftExpression(), getRightExpression());
	}
}