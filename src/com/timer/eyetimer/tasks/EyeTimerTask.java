package com.timer.eyetimer.tasks;

import java.util.TimerTask;

/**
 * This class is used for timer execution.
 * A provided task in the run() method will
 * be executed when the timer is run.
 * @author debashis
 * @version 1.3
 */
public class EyeTimerTask extends TimerTask{

	// Member variables
	
	// The message that will be displayed to the user
	private String timerMessage;
	// This variable is used if the timer has to be 
	// executed a certain 'timerMaxRunCount' no of times
	private Integer timerMaxRunCount; 
	// This variable is used to track the number of times
	// run() is called
	private Integer timerRunCounter;
	
	
	/**
	 * This method will be called when 
	 * when the timer executes
	 */
	@Override
	public void run() {

		// Line up the tasks to be executed

		if( this.timerMaxRunCount >= 1) { // to see whether run() has to be executed once or multiple times
			
			if( this.timerRunCounter < this.timerMaxRunCount ) {
				// Line up the tasks to be executed
				
				// This is the task to print the mes
				displayMessageTask(this.timerMessage); 
			
				// increment the counter
				incrementRunCounter();
			} else {
				this.cancel();
			}
		}else { // No action will be done if any other integer value is passed
        
		}
		
	}

	/**
	 * Default Constructor
	 */
	public EyeTimerTask() {

		initializeVariables(new String(""), new Integer(1));
	}

	/**
	 * Constructor of this class, where a 'timerMessage' is used
	 * to display to the user
	 * @param timerMessage
	 */
	public EyeTimerTask(String timerMessage) {

		initializeVariables(timerMessage, new Integer(1));
	}

	/**
	 * Constructor of this class, where a 'timerMessage' is used
	 * to display to the user and 'timerMaxRunCount' is used
	 * for the no of execution it should be run at max 
	 * @param timerMessage
	 * @param timerMaxRunCount
	 */
	public EyeTimerTask(String timerMessage, Integer timerMaxRunCount) {

		initializeVariables(timerMessage, timerMaxRunCount);
	}

	/**
	 * This is a method where the task is written to be executed in run().
	 * This will print the provided 'message'
	 * @param message
	 */ 
	private void displayMessageTask(String message) {

		System.out.println(message);  // print a message 
	}

	/**
	 * This private method is used to initialize the class members
	 * @param timerMessage
	 * @param timerMaxRunCount
	 */
	private void initializeVariables(String timerMessage, Integer timerMaxRunCount) {
		
		this.timerMessage = new String(timerMessage);
		this.timerMaxRunCount = new Integer(timerMaxRunCount);
		this.timerRunCounter = new Integer(0);
	}
	
	/**
	 * This method is to increment the timerRunCounter
	 */
	private void incrementRunCounter() {
		this.timerRunCounter = new Integer(this.timerRunCounter.intValue() + 1);
	}
}
