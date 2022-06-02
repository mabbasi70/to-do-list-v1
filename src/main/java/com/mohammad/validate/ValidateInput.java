package com.mohammad.validate;

public class ValidateInput {
	
	
	public static boolean validateTaskName(String taskName) {
		return taskName.matches("[a-zA-Z]{1,10}");
	}
	
	public static boolean validateTaskPriority(String taskPriority) {
		return taskPriority.matches("HIGH|MEDIUM|LOW|OFF");
	}
	
	public static boolean validateDeadline(String deadline) {
		return deadline.matches("([2][0][2][23])-([1-9]|[1][012])-([1-9]|[1][1-9]|[2][1-9]|[3][01])");
	}

}
