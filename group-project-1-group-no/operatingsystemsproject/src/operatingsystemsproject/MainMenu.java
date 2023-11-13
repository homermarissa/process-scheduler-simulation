package operatingsystemsproject;

import java.util.Scanner;

import algoLinkedList.LinkedList;

public class MainMenu {
	
	public int menu() {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		System.out.println("********************************");
		System.out.println("*      Pick an algorithm       *");
		System.out.println("*                              *");
		System.out.println("*      1. FIFO Algorithm       *");
		System.out.println("*  2. Priority FIFO Algorithm  *");//32
		System.out.println("*                              *");
		System.out.println("********************************");
		
		
		do {
			System.out.print("\nEnter an int value(1, 2): ");
			while (!scan.hasNextInt()) {
				System.out.println("That's not a number!");
				System.out.print("Enter a valid int value(1, 2): ");
				scan.next(); // this is important!
			}
			
			input = scan.nextInt();
		}while(input != 1 && input != 2);
		scan.close();	
		return input;	
	}
	
	
	public void printFinal(String listName, LinkedList<process> list) {
		if(!list.isEmpty()) {
			System.out.println(listName + " List: ");
			for(int j = 0; j<=list.sizeOfList(); j++){
				System.out.println(list.getAtIndex(j).getProcID());
			}
		}
	}

}
