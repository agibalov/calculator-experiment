package com.loki2302;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.support.Var;

import com.loki2302.dom.ArithmeticOperation;
import com.loki2302.dom.ArithmeticOperationNode;
import com.loki2302.dom.CalculatorNode;
import com.loki2302.dom.LiteralNode;


public class CalculatorGrammar extends BaseParser<CalculatorNode> {
	public Rule expression() {
		return FirstOf(			
				additiveExpression(),
				parensExpression(),
				EOI);
	}
	
	public Rule parensExpression() {
		return Sequence("(", expression(), ")");
	}
	
	public Rule additiveExpression() {
		Var<Character> op = new Var<Character>();
		return Sequence(
				multiplicativeExpression(),
				ZeroOrMore(
						FirstOf("+", "-"),
						op.set(matchedChar()),
						multiplicativeExpression(),
						push(new ArithmeticOperationNode(
								ParserHelpers.arithmeticOperationFromChar(op.get()), 
								pop(1), 
								pop()))						
						));
	}
	
	public Rule multiplicativeExpression() {
		Var<Character> op = new Var<Character>();
		return Sequence(
				factorExpression(),
				ZeroOrMore(
						FirstOf("*", "/"),
						op.set(matchedChar()),
						factorExpression(),
						push(new ArithmeticOperationNode(
								ParserHelpers.arithmeticOperationFromChar(op.get()), 
								pop(1), 
								pop()))						
						));
	}
	
	public Rule factorExpression() {
		return Sequence(
				space(),
				FirstOf(
						literal(),
						parensExpression()),
				space());
	}
	
	public Rule literal() {
		return Sequence(
				OneOrMore(CharRange('0', '9')),
				push(new LiteralNode(Integer.parseInt(match()))));
	}
	
	public Rule space() {
		return ZeroOrMore(" ");
	}
	
	private static class ParserHelpers {
		public static ArithmeticOperation arithmeticOperationFromChar(char op) {
			if(op == '+') {
				return ArithmeticOperation.Add;
			} else if(op == '-') {
				return ArithmeticOperation.Sub;
			} else if(op == '*') {
				return ArithmeticOperation.Mul;
			} else if(op == '/') {
				return ArithmeticOperation.Div;					
			} else {
				throw new RuntimeException();
			}
		}
	} 
}