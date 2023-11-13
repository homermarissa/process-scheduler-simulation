/** 
 * 
 * SCS 321 01 Project 1
 * @author Marissa Homer
 * @author Matthew Lewis
 * @author Shane Simpson
 * 
 */


package operatingsystemsproject;
//import algoLinkedList.LinkedList;
//import processingAlgorithms.*;


public class main {
	//main method
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		simulationEngine simu = new simulationEngine();
		
		// 1 = fifo
		// 2 = pfifo
		int chosenAlgo = mainMenu.menu();
		simu.addProcesses();
		
		
		//runs the chosen algorithms
		switch(chosenAlgo) {
		  	case 1: // regular fifo
		  		simu.runFifoTimer();
		  		break;
		  	case 2: // priority fifo
		  		simu.runPriorityFifoTimer();
		  		break;
		  	default:
		  		System.out.println("Somehow wrong input??");
		}
		
		
	}

}
