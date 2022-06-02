package com.mohammad.model;

import java.time.LocalDate;

enum Priority {
	HIGH, MEDIUM, LOW, OFF
}

public class Task {

	private String taskName;
	private String description;
	private LocalDate initDate;
	private LocalDate deadline;
	private Priority priority;
	private boolean done = false;

	public Task() {initDate = LocalDate.now();}
	
	public void setTaskName(String theTaskName) {taskName = theTaskName;}
	
	public void setDescription(String theDescription) {description = theDescription;}
	
	public void setDealine(String theDeadline) {deadline = LocalDate.parse(theDeadline);}
	
	public void setPriority(String thePriority) {

		switch (thePriority) {
		case "HIGH":
			priority = Priority.HIGH;
			break;
		case "MEDIUM":
			priority = Priority.MEDIUM;
			break;
		case "LOW":
			priority = Priority.LOW;
			break;
		case "OFF":
			priority = Priority.OFF;
			break;
		}
	}
	public void setDone(boolean theDone) {
		done = theDone;
	}
	
	public String getTaskName() {return taskName;}
	
	public String getDescription() {return description;}
	
	public String getInitDate() {return initDate.toString();}
	
	public String getPriority() {return priority.toString();}
	
	public Task getTask() {
		return this;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
