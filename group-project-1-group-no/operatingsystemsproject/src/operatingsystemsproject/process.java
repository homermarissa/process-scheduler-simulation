/** 
 * 
 * SCS 321 01 Project 1
 * Marissa Homer
 * Matthew Lewis
 * Shane Simpson
 * 
 */

package operatingsystemsproject;

//data structure to hold processes
public class process {
	private int procID;
	private int arrivalTime;
	private int remainingTime;
	private int burstTime;
	private int priority;
	
	//gets process id
	public int getProcID() {
		return procID;
	}
	//sets process id
	public void setProcID(int setID) {
		procID = setID;
	}
	//gets arrival time
	public int getArrivalTime() {
		return arrivalTime;
	}
	//sets arrival time
	public void setArrivalTime(int setArrival) {
		arrivalTime = setArrival;
	}
	//gets remaining time
	public int getRemainingTime() {
		return remainingTime;
	}
	//sets remaining time
	public void setRemainingTime(int setRemaining) {
		remainingTime = setRemaining;
	}
	//gets burst time
	public int getBurstTime() {
		return burstTime;
	}
	//sets burst time
	public void setBurstTime(int setBurst) {
		burstTime = setBurst;
	}
	//gets priority
	public int getPriority() {
		return priority;
	}
	//sets priority
	public void setPriority(int setPriority) {
		priority = setPriority;
	}
	//prints process
	public void printProcess() {
		System.out.println("Process ID: " + procID + "\nArrivalTime: " + arrivalTime + "\nBurst Time: " + burstTime + "\nRemaining Time: " + "\nPriority: " + priority + "\n-----");
	}
	//process constructor
	public process(int iprocID, int iarrivalTime, int iburstTime, int ipriority) {
		procID = iprocID;
		arrivalTime = iarrivalTime;
		burstTime = iburstTime;
		remainingTime = burstTime;
		priority = ipriority;
		
		
		
	}
}
