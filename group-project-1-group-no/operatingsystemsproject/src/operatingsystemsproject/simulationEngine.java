package operatingsystemsproject;

import algoLinkedList.LinkedList;
import processingAlgorithms.*;
import java.util.Timer;
import java.util.TimerTask;

public class simulationEngine {
	//creates processes
	int[][] procValues = {
			{1,0,10,6},
			{2,7,10,10},
			{3,13,10,2},
			{4,28,10,16},
			{5,35,10,5},
	};

	
	//creates LinkedList to hold processes
	LinkedList<process> processList = new LinkedList<>();
	//LinkedList to hold the processes that are scheduled
	LinkedList<process> scheduledList = new LinkedList<>();
	//LinkedList to hold the processes that have completed
	LinkedList<process> completedList = new LinkedList<>();

	//adds processes to processList
	public void addProcesses(){
		for(int i = 0; i < procValues.length; i++) {
			int[] cur = procValues[i];
			process proc = new process(cur[0], cur[1], cur[2], cur[3]);
			processList.addLast(proc);
		}
	}
	
	//creates new fifo algorithm
	fifoAlgorithm fifo = new fifoAlgorithm();
	//creates new priority fifo algorithm
	priorityFifoAlgorithm pfifo = new priorityFifoAlgorithm();
	
	//assembles processList
	public LinkedList<process> processes(int[][] procDef) {
		LinkedList<process> processList = new LinkedList<>();
		
		for(int i = 0; i < procDef.length; i++) {
			int[] cur = procDef[i];
			process proc = new process(cur[0], cur[1], cur[2], cur[3]);
			processList.addLast(proc);
		}
		
		return processList;
	}
	
	//works on tasks in scheduleList
	public void work() {
		//if there is a process in the scheduledList
		if(scheduledList.getFirst() != null) {
			//prints the currently running process
			System.out.println("Currently running Process: " + scheduledList.getFirst().getProcID());
			//prints the amount of time remaining before the process is worked on
			System.out.println("Time remaining before cycle: " + scheduledList.getFirst().getRemainingTime());
			//works on the process
			scheduledList.getFirst().setRemainingTime(scheduledList.getFirst().getRemainingTime()-1);
			//prints the amount of time remaining after the process is worked on
			System.out.println("Time remaining after cycle: " + scheduledList.getFirst().getRemainingTime());
			//check to see if the first scheduled process is complete
			if(scheduledList.getFirst().getRemainingTime() == 0) {
				//if so, pops it and adds it to completedList
				completedList.addLast(scheduledList.pop());
				//prints whichever process has completed
				System.out.println("Process " + completedList.getLast().getProcID() + " completed; moving to completion list...");
			}
		}
		//prints scheduled List
		printFinal("Scheduled", scheduledList);
		
		//prints completed List
		printFinal("Completed", completedList);
	}
	
	
	public void runFifoTimer() {
		
		Timer timer = new Timer();
		
		//This will run 55 times
		for(int i = 0; i<55; i++) {
			//integer to hold the current time; used when scheduling the timer task
			final int k = i;
		//creates new timerTask
		TimerTask algoTask = new TimerTask() {
			//defining the task
			public void run() {
				//prints current system time
				System.out.println("\nCURRENT SYSTEM TIME: " + k);
				//prints processList
				printFinal("Process", processList);
				//runs the fifo algorithm
				fifo.run(processList, scheduledList, completedList, k);
				
				/**
				* if there is a process in the scheduledList
				* prints the currently running process
				* prints the amount of time remaining before the process is worked on
				* works on the process
				* prints the amount of time remaining after the process is worked on
				* check to see if the first scheduled process is complete
				* if so, pops it and adds it to completedList
				* prints whichever process has completed
				* 
				* finalPrint completed and scheduled lists
				*/
				work();

		
			}
		};

		//scheduling the task after a delay of 1.5 seconds
		//The schedule method takes a TimerTask instance and a delay after which we want to execute the task
		//the delay is modified by the time the task arrives in order to ensure they execute in order
		timer.schedule(algoTask, 1500*k);
		
	}
	}
	
	public void runPriorityFifoTimer() {
	
	Timer timer = new Timer();
	
	//This will run 55 times
	for(int i = 0; i<55; i++) {
		//integer to hold the current time; used when scheduling the timer task
		final int k = i;
		//creates new timerTask
		TimerTask algoTask = new TimerTask() {
			//defining the task
			public void run() {
				//prints current system time
				System.out.println("\nCURRENT SYSTEM TIME: " + k);
				
				//prints processList
				printFinal("Process", processList);
				
				//runs the fifo algorithm
				pfifo.run(processList, scheduledList, completedList, k);
				
				/**
				* if there is a process in the scheduledList
				* prints the currently running process
				* prints the amount of time remaining before the process is worked on
				* works on the process
				* prints the amount of time remaining after the process is worked on
				* check to see if the first scheduled process is complete
				* if so, pops it and adds it to completedList
				* prints whichever process has completed
				* 
				* finalPrint completed and scheduled lists
				*/
				work();		
			}
		};

		//scheduling the task after a delay of 1.5 seconds
		//The schedule method takes a TimerTask instance and a delay after which we want to execute the task
		//the delay is modified by the time the task arrives in order to ensure they execute in order
		timer.schedule(algoTask, 1500*k);
	
		}	
	}
	
	public void printFinal(String name, LinkedList<process> List) {
		if(!List.isEmpty()) {
			System.out.println(name + " List: ");
			for(int j = 0; j<=List.sizeOfList(); j++) {
				System.out.println(List.getAtIndex(j).getProcID());
			}
		}
	}
}



