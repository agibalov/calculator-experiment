package com.loki2302.dom;

public interface CalculatorNodeVisitor<T> {
	T visitLiteralNode(LiteralNode node);
	T visitArithmeticOperationNode(ArithmeticOperationNode node);
}