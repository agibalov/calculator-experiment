package com.loki2302;

import java.util.List;

public class ErrorNodeModel {
	private final String description;
	private final List<ErrorNodeModel> errors;
	
	public ErrorNodeModel(String description, List<ErrorNodeModel> errors) {
		this.description = description;
		this.errors = errors;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<ErrorNodeModel> getErrors() {
		return errors;
	}
}