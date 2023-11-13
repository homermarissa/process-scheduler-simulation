/** 
 * 
 * SCS 321 01 Project 1
 * Marissa Homer
 * Matthew Lewis
 * Shane Simpson
 * 
 */
package processingAlgorithms;

import algoLinkedList.LinkedList;
import operatingsystemsproject.process;

/*Algorithm to process the processes in a first-in, first-out manner.
 * This algorithm looks through the initial Linked List and pulls any process with an arrival time
 * that matches or exceeds the current time into the scheduledList Linked List. The scheduledList
 * thus operates on a first in, first out basis.
 * */
public class fifoAlgorithm {

	//method that runs the fifo algorithm, taking in a process list and the current time as parameters
	public void run(LinkedList<process> processList, LinkedList<process> scheduledList, LinkedList<process> completedList, int currentTime) {

	//loops through each process in the processList LinkedList
		System.out.println("Checking for new processes...");
		for(int i = processList.sizeOfList(); i >= 0 ; i--) {
			/*if a process's arrival time is less than (error handling) or equal to the current time,
			 * then add it to the scheduled list and remove it from the process list*/
			if(!processList.isEmpty()) {
				if(processList.getAtIndex(i).getArrivalTime() <= currentTime) {
					scheduledList.addLast(processList.getAtIndex(i));
					System.out.println("Available process found: Process " + processList.getAtIndex(i).getProcID() + ". Adding to waiting list...");
					processList.removeAtIndex(i);
				}
			}
			

			
		}
	}
}
