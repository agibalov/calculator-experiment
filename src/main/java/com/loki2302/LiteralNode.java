package com.loki2302;

public class LiteralNode implements CalculatorNode {
	private final int value;
	
	public LiteralNode(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("[%d]", value);
	}
}