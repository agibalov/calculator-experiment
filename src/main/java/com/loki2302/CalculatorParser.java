package com.loki2302;

import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParsingResult;


public class CalculatorParser {
	public CalculatorNode parse(String expression) {
		CalculatorGrammar grammar = Parboiled.createParser(CalculatorGrammar.class);
		ParsingResult<CalculatorNode> result = 
				new RecoveringParseRunner<CalculatorNode>(grammar.expression())
				.run("123");
		return result.resultValue;
	}
}