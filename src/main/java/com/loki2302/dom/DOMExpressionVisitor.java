package com.loki2302.dom;

public interface DOMExpressionVisitor<T> {
	T visitLiteralExpression(DOMLiteralExpression expression);
	T visitAddExpression(DOMAddExpression expression);
	T visitSubExpression(DOMSubExpression expression);
	T visitMulExpression(DOMMulExpression expression);
	T visitDivExpression(DOMDivExpression expression);
}