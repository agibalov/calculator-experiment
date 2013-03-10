package com.loki2302.dom;

public class DOMLiteralExpression implements DOMExpression {
	private final String valueString;
	
	public DOMLiteralExpression(String valueString) {
		this.valueString = valueString;
	}
	
	public String getValueString() {
		return valueString;
	}
	
	@Override
	public <T> T accept(DOMExpressionVisitor<T> visitor) {
		return visitor.visitLiteralExpression(this);
	}
	
	@Override
	public String toString() {
		return String.format("(%s)", valueString);
	}	
}