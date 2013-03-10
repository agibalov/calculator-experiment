package com.loki2302;

import java.util.ArrayList;
import java.util.List;

import com.loki2302.failure.FailureReason;


public class EvaluationResult {
	private boolean isOk;
	private int value;
	private List<FailureReason> failureReasons;
	
	public boolean isOk() {
		return isOk;
	}
	
	public int getValue() {
		return value;
	}
	
	public List<FailureReason> getFailureReasons() {
		return failureReasons;
	}
	
	public static EvaluationResult ok(int value) {
		EvaluationResult evaluationResult = new EvaluationResult();
		evaluationResult.isOk = true;
		evaluationResult.value = value;
		return evaluationResult;
	}
	
	public static EvaluationResult fail(FailureReason failureReason) {
		List<FailureReason> failureReasons = new ArrayList<FailureReason>();
		failureReasons.add(failureReason);
		return fail(failureReasons);
	}
	
	public static EvaluationResult fail(List<FailureReason> failureReasons) {
		EvaluationResult evaluationResult = new EvaluationResult();
		evaluationResult.isOk = false;
		evaluationResult.failureReasons = failureReasons;
		return evaluationResult;
	}
}