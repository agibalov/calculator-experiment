package com.loki2302;

public class App {
    public static void main(String[] args) {
    	String expression = "1 + 9999999999999999";
    	EvaluationResult evaluationResult = Calculator.calculate(expression);
    	
    	System.out.println(expression);
    	if(evaluationResult.isOk()) {
    		System.out.println("ok");
    		System.out.printf("result is %d\n", evaluationResult.getValue());
    	} else {
    		System.out.println("fail");
    		ErrorsTreeBuilder errorsTreeBuilder = new ErrorsTreeBuilder();
    		ErrorPrinter errorPrinter = new ErrorPrinter();
    		
    		ErrorNodeModel error = errorsTreeBuilder.buildErrorsTree(evaluationResult.getFailureReasons());    		
    		errorPrinter.printError(error);
    	}
    }
}
