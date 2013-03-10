package com.loki2302;

import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.support.ParsingResult;

import com.loki2302.dom.DOMExpression;


public class CalculatorParser {
	public DOMExpression parse(String expression) {
		CalculatorGrammar grammar = Parboiled.createParser(CalculatorGrammar.class);
		ParsingResult<DOMExpression> result = 
				new RecoveringParseRunner<DOMExpression>(grammar.rootExpression())
				.run(expression);
		return result.resultValue;
	}
}