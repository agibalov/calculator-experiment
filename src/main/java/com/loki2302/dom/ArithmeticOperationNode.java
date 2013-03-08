package com.loki2302.dom;

public class ArithmeticOperationNode implements CalculatorNode {
	private final ArithmeticOperation arithmeticOperation;
	private final CalculatorNode leftNode;
	private final CalculatorNode rightNode;
	
	public ArithmeticOperationNode(
			ArithmeticOperation arithmeticOperation,
			CalculatorNode leftNode,
			CalculatorNode rightNode) {
		this.arithmeticOperation = arithmeticOperation;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public ArithmeticOperation getOperation() {
		return arithmeticOperation;
	}
	
	public CalculatorNode getLeftNode() {
		return leftNode;
	}
	
	public CalculatorNode getRightNode() {
		return rightNode;
	}
	
	@Override
	public <T> T accept(CalculatorNodeVisitor<T> visitor) {
		return visitor.visitArithmeticOperationNode(this);
	}
	
	@Override
	public String toString() {
		return String.format("(%s%s%s)", leftNode, arithmeticOperation, rightNode);
	}	
}