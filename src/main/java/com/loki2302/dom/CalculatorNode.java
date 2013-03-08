package com.loki2302.dom;

public interface CalculatorNode {
	<T> T accept(CalculatorNodeVisitor<T> visitor);	
}