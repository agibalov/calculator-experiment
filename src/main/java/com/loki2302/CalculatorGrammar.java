package com.loki2302;

import org.parboiled.BaseParser;
import org.parboiled.Rule;


public class CalculatorGrammar extends BaseParser<CalculatorNode> {
	public Rule expression() {
		return literal();
	}
	
	public Rule literal() {
		return Sequence(
				OneOrMore(CharRange('0', '9')),
				push(new LiteralNode(Integer.parseInt(match()))));
	}    	
}