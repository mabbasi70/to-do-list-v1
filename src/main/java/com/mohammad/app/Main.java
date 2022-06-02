package com.mohammad.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mohammad.model.Task;
import com.mohammad.validate.ValidateInput;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final List<Task> tasks = new ArrayList<Task>();
	private static final List<Task> doneTasks = new ArrayList<Task>();

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {
		int a = 1;
		printMenu();

		while (a != 0) {
			try {
				a = scanner.nextInt();				
				scanner.nextLine();
				switch (a) {
				case 1:
					printMenu();
					break;
				case 2:
					addTask();
					break;
				case 3:
					removeTask();
					break;
				case 4:
					addToDone();
					break;
				case 5:
					printTasks(tasks);
					break;
				case 6:
					printTasks(doneTasks);
					break;
				case 0:
					a = 0;
					break;
				default:
					System.out.println("Enter just Integer exists in the above list!!!");
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.println("Enter just Integer exists in the above list!!!");
				
			}
		}

	}

	private static void addToDone() {
		System.out.println("Enter task name ");
		String name = scanner.nextLine();
		Task temp = searchByNameV2(name);
		if(searchByNameV2(name) != null) {
			temp.setDone(true);
			doneTasks.add(temp);
			removeTask(name);
		}else {
			System.out.println("There is no task with name " + name);
		}
		

	}
	private static void removeTask(String name) {
		for(Task t:tasks) {
			if(t.getTaskName().equalsIgnoreCase(name)) {
				tasks.remove(t);
				System.out.println("task " + t.getTaskName() + " was successfully removed");
				return;
			}
		}
	}

	private static void removeTask() {
		
		System.out.println("enter a task name: ");
		String tn = scanner.nextLine();
		for(Task t:tasks) {
			if(t.getTaskName().equalsIgnoreCase(tn)) {
				tasks.remove(t);
				System.out.println("task " + t.getTaskName() + " was successfully removed");
				return;
			}
		}
		System.out.println("There is no task " + tn);
	}

	private static void addTask() {
		Task task = new Task();
		boolean exit = false;
		while (!exit) {
			try {
				System.out.println("Enter a task name: ");
				String name = scanner.nextLine();
				if (ValidateInput.validateTaskName(name) && searchByName(name)) {
					task.setTaskName(name);
					System.out.println("Enter 1 to add description\nEnter 0 to exit");
					int choice = scanner.nextInt();
					scanner.nextLine();
					if (choice == 1) {
						addDescription(task);
					}
					exit = true;
				} else {
					if(!ValidateInput.validateTaskName(name)) {
					throw new InputMismatchException(
							"The name of the task must be at least 1 and at most 10 character");
					}
					throw new Exception("We have task with name");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		exit = false;
		while (!exit) {
			try {
				System.out.println("Enter priority of the tast\n{HIGH,MEDIUM,LOW,OFF}");
				String pri = scanner.nextLine().toUpperCase();
				if (ValidateInput.validateTaskPriority(pri)) {
					task.setPriority(pri);
					exit = true;
				} else {
					throw new InputMismatchException("Wrong answer");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		tasks.add(task);
	}

	private static void addDescription(Task theTask) {
		System.out.println("Write here: ");
		String desc = scanner.nextLine();
		theTask.setDescription(desc);
		System.out.println("\n\n");

	}

	private static void printMenu() {
		System.out.println("Enter 1 to print menu\n" + "Enter 2 to add task\n" + "Enter 3 to remove task\n"
				+ "Enter 4 to add a task to done\n" + "Enter 5 to print tasks\n" + "Enter 0 to Quit\n\n");

	}

	private static void printTasks(List<Task> lt) {
		int index = 1;
		for (Task t : lt) {
			System.out.printf(
					"Task index: %d\nTask name : %s%nTask description: %s\nTaskpriority: %s\n==============\n", index++,
					t.getTaskName(), t.getDescription(), t.getPriority());
		}
	}
	private static boolean searchByName(String taskName) {
		for(Task t:tasks) {
			if(t.getTaskName().equalsIgnoreCase(taskName)){
				return false;
			}
		}
		return true;
	}
	private static Task searchByNameV2(String taskName) {
		for(Task t: tasks) {
			if(t.getTaskName().equalsIgnoreCase(taskName)) {
				return t;
			}
		}
		return null;
	}

}
