import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		List<Task> taskList = new ArrayList<>();
		Task task1 = new Task();
		taskList.add(task1);

		System.out.println("==============================================================================================");
		System.out.println("                                 Welcome to the Task System!");
		listOptions();
		
		boolean areWeDone = false;
		while(!areWeDone) {
			int firstChoice = Validator.getInt(scnr, "What would you like to do? (1-6)(7 for Main Menu)");

			switch(firstChoice){
				
				case 1:
					listTasks(taskList);
					break;
				
				case 2:
					taskList.add(addTask());
					break;
				
				case 3:
					listTasks(taskList);
					int choice = Validator.getInt(scnr, "Which task would you like to delete?: ");
					if (choice < 1 || choice > taskList.size()) {
						System.out.println("UH OH... That wasnt one of the choices!");
						break;
					} else {
						taskList.remove(choice-1);
						listTasks(taskList);
						break;
					}
				
				case 4:
					
					listTasks(taskList);
					int newChoice = Validator.getInt(scnr, "Which task would you like to mark as completed?");
					
					if (newChoice < 1 || newChoice > taskList.size()) {
						System.out.println("That is not possible");
						break;
					}
					System.out.println("==============================================================================================");
					System.out.printf("%-20s %-20s %-30s %-20s", taskList.get(newChoice-1).getName(), taskList.get(newChoice-1).getDate(), taskList.get(newChoice-1).getDescription(), taskList.get(newChoice-1).getFinished());
					System.out.println();
					String areYouSure = Validator.getString(scnr, "are you sure this is the task you would like to mark completed?(y/n)");
					System.out.println("==============================================================================================");
					if (areYouSure.toLowerCase().startsWith("n")) {
						System.out.println("Alright, did not mark completed!");
						System.out.println("==============================================================================================");
						break;
					}
					
					
					if (newChoice < 1 || newChoice > taskList.size()) {
						System.out.println("UH OH... That wasnt one of the choices!");
						break;
					} else {
						taskList.get(newChoice-1).setFinished("Finished");
						break;
					}
				case 5:
					changeTask(taskList);
					break;
					
				case 6:
					System.out.println("==============================================================================================");
					if(Validator.getString(scnr, "Are you sure about that? (y/n)").startsWith("y")) {
						areWeDone = true;
						break;
					} else {
					break;
					}

				case 7:
					listOptions();
					break;
					
				default:
					System.out.println("I'm sorry that wasn't one of the options...");
			}
		
		}
		
		System.out.println("==============================================================================================");
		System.out.println("Have a great day!");
		System.out.println("==============================================================================================");

	}

	public static void listOptions() {
		System.out.println("==============================================================================================");
		System.out.printf("%6d) %-15s", 1, "List Tasks");
		System.out.println();
		System.out.printf("%6d) %-15s", 2, "Add Tasks");
		System.out.println();
		System.out.printf("%6d) %-15s", 3, "Delete Task");
		System.out.println();
		System.out.printf("%6d) %-15s", 4, "Mark Task Completed");
		System.out.println();
		System.out.printf("%6d) %-15s", 5, "Change Task");
		System.out.println();
		System.out.printf("%6d) %-15s", 6, "Quit");
		System.out.println();
		System.out.println("==============================================================================================");
	}
	
	public static void listTasks(List<Task> list1) {
		
		System.out.println("==============================================================================================");
		System.out.println("   Name                 Due Date             Description                    Finished/Not");
		System.out.println(" --------             ------------         ---------------                ----------------");
		int j = 1;
		for (int i = 0; i < list1.size(); i++) {
			System.out.printf(j + ") %-20s %-20s %-30s %-20s", list1.get(i).getName(), list1.get(i).getDate(), list1.get(i).getDescription(), list1.get(i).getFinished());
			System.out.println();
			j++;
		}
		
		System.out.println("==============================================================================================");
	}
	
	public static Task addTask() {
		System.out.println("==============================================================================================");

		Scanner scnr = new Scanner(System.in);
		
		String name = Validator.getString(scnr, "Enter the name: ");
		String date = Validator.getString(scnr, "Please enter the due date(MM/DD/YYYY): ");
		String description = Validator.getString(scnr, "Please enter a short description of the task: ");
		
		Task newTask = new Task(name, date, description);
		System.out.println("==============================================================================================");

		
		return newTask;
		
	}
	
	public static void changeTask(List<Task> list1) {
		
		Scanner scnr = new Scanner(System.in);
		listTasks(list1);
		int choice = Validator.getInt(scnr, "Which task would you like to edit?");
		String description = Validator.getString(scnr, "What would you like to change the task to?");
		list1.get(choice - 1).setDescription(description);
		
		
	}
}
