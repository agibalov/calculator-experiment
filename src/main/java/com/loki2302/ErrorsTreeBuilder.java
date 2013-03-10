package com.loki2302;

import java.util.ArrayList;
import java.util.List;

import com.loki2302.failure.BadNumberFailureReason;
import com.loki2302.failure.DivisionByZeroFailureReason;
import com.loki2302.failure.FailureReason;
import com.loki2302.failure.FailureReasonVisitor;
import com.loki2302.failure.SubexpressionInErrorFailureReason;

public class ErrorsTreeBuilder {
	public ErrorNodeModel buildErrorsTree(List<FailureReason> failureReasons) {
    	List<ErrorNodeModel> errors = new ArrayList<ErrorNodeModel>();
    	for(FailureReason failureReason : failureReasons) {
    		ErrorNodeModel error = failureReason.accept(new FailureReasonVisitor<ErrorNodeModel>() {
				@Override
				public ErrorNodeModel visitBadNumber(BadNumberFailureReason failureReason) {
					// DOMLiteralExpression domLiteralExpression = failureReason.getDOMLiteralExpression();
					// IndexRange indexRange = domLiteralExpression.getIndexRange();
					// TODO: use indexRange to get related expression part
					return new ErrorNodeModel("Bad number", null);
				}

				@Override
				public ErrorNodeModel visitDivisionByZero(DivisionByZeroFailureReason failureReason) {
					return new ErrorNodeModel("Division by zero", null);
				}

				@Override
				public ErrorNodeModel visitSubexpressionInError(SubexpressionInErrorFailureReason failureReason) {
					return buildErrorsTree(failureReason.getSubexpressionEvaluationResult().getFailureReasons()); 
				}});
    		
    		errors.add(error);
    	}
    	
    	return new ErrorNodeModel("There are errors", errors);
    }	
}