package com.loki2302.dom;

import org.parboiled.support.IndexRange;

public class DOMLiteralExpression implements DOMExpression {
	private final IndexRange indexRange;
	private final String valueString;
	
	public DOMLiteralExpression(IndexRange indexRange, String valueString) {
		this.indexRange = indexRange;
		this.valueString = valueString;		
	}
	
	public IndexRange getIndexRange() {
		return indexRange;
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