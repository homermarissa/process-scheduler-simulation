/** 
 * 
 * SCS 321 01 Project 2 Part 2
 * Marissa Homer
 * Matthew Lewis
 * Shane Simpson
 * 
 */
package processingAlgorithms;

import algoLinkedList.LinkedList;
import operatingsystemsproject.process;

/*Algorithm to process the processes in a first-in, first-out manner, taking into account process priority.
 * This algorithm looks through the initial Linked List and pulls any process with an arrival time
 * that matches or exceeds the current time into the scheduledList Linked List. The process is placed into
 * the scheduledList based on its priority; thus, the processes are operated on a priority basis.
 * */

public class priorityFifoAlgorithm {

	//method that runs the priority fifo algorithm, taking in a process list and the current time as parameters
	public void run(LinkedList<process> processList, LinkedList<process> scheduledList, LinkedList<process> completedList, int currentTime) {

	//loops through each process in the processList LinkedList
		System.out.println("Checking for new processes...");
		for(int i = processList.sizeOfList(); i >= 0 ; i--) {
			/*if a process's arrival time is less than (error handling) or equal to the current time,
			 * then add it to the scheduled list and remove it from the process list*/
			if(!processList.isEmpty()) {
				if(processList.getAtIndex(i).getArrivalTime() <= currentTime) {
					//prints that a process was found
					System.out.println("Available process found: Process " + processList.getAtIndex(i).getProcID() + ". Adding to waiting list...");
					//if the ScheduledList is not empty, then compare priorities
					if(!scheduledList.isEmpty()) {
						//if the priority is higher than the first process, then add the new process to the beginning
						if(processList.getAtIndex(i).getPriority() > scheduledList.getAtIndex(0).getPriority()) {
							System.out.println("Interrupting Process " + scheduledList.getFirst().getProcID() + "...");
							scheduledList.addFirst(processList.getAtIndex(i));
						//otherwise, look through the ScheduledList from end to beginning to find position	
						}else {
							for(int j = scheduledList.sizeOfList(); j >= 0; j--) {
								if(processList.getAtIndex(i).getPriority() < scheduledList.getAtIndex(j).getPriority()) {
									scheduledList.addAtIndex(j+1,processList.getAtIndex(i));
									j = 0;
								}
							}
						}
						
					//if the ScheduledList is empty, then simply add the process to the end	
					}else {
						scheduledList.addLast(processList.getAtIndex(i));
					}
					//removes process from processList since it has been added to ScheduledList
					processList.removeAtIndex(i);
				
				}
			}

		}
		
	}
}
