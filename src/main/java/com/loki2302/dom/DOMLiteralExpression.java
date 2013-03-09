package com.loki2302.dom;

public class DOMLiteralExpression implements DOMExpression {
	private final int value;
	
	public DOMLiteralExpression(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public <T> T accept(DOMExpressionVisitor<T> visitor) {
		return visitor.visitLiteralExpression(this);
	}
	
	@Override
	public String toString() {
		return String.format("(%d)", value);
	}	
}