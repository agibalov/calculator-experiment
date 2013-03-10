package com.loki2302;

import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.support.Var;

import com.loki2302.dom.DOMAddExpression;
import com.loki2302.dom.DOMBinaryExpression;
import com.loki2302.dom.DOMDivExpression;
import com.loki2302.dom.DOMExpression;
import com.loki2302.dom.DOMLiteralExpression;
import com.loki2302.dom.DOMMulExpression;
import com.loki2302.dom.DOMSubExpression;

public class CalculatorGrammar extends BaseParser<DOMExpression> {
	public Rule rootExpression() {
		return Sequence(
				expression(),
				EOI);
	}
	
	public Rule expression() {
		return FirstOf(
				additiveExpression(),
				parensExpression());
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
						push(ParserHelpers.makeBinaryExpression(
								op.get(), 
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
						push(ParserHelpers.makeBinaryExpression(
								op.get(), 
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
				push(new DOMLiteralExpression(getContext().getMatchRange(), match())));
	}
	
	public Rule space() {
		return ZeroOrMore(" ");
	}
	
	private static class ParserHelpers {
		public static DOMBinaryExpression makeBinaryExpression(char op, DOMExpression leftExpression, DOMExpression rightExpression) {
			if(op == '+') {
				return new DOMAddExpression(leftExpression, rightExpression);
			} else if(op == '-') {
				return new DOMSubExpression(leftExpression, rightExpression);
			} else if(op == '*') {
				return new DOMMulExpression(leftExpression, rightExpression);
			} else if(op == '/') {
				return new DOMDivExpression(leftExpression, rightExpression);					
			}
			
			throw new RuntimeException();
		}
	} 
}