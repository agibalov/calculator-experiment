package com.loki2302;

import java.util.List;

public class ErrorPrinter {
	public void printError(ErrorNodeModel error) {
    	printErrorImpl(error, 0);
    }
    
    private void printErrorImpl(ErrorNodeModel error, int padding) {
    	pad(padding);
    	System.out.println(error.getDescription());
    	List<ErrorNodeModel> childErrors = error.getErrors();
    	if(childErrors != null) {
    		for(ErrorNodeModel childError : childErrors) {
    			printErrorImpl(childError, padding + 1);
    		}
    	}
    }
    
    private static void pad(int padding) {
    	for(int i = 0; i < padding; ++i) {
    		System.out.print(" ");
    	}
    }
}