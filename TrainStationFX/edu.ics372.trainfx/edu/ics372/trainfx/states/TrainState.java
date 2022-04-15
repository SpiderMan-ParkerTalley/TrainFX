package edu.ics372.trainfx.states;

/*
 * @author Cristian Zendejas
 * Abstract class for all states
 */
public abstract class TrainState {
	/**
	   * Initializes the state
	   */
	  public abstract void enter();

	  /**
	   * Performs any necessary clean up while leaving the state
	   */
	  public abstract void leave();

	  /**
	   * Processes acceleration.
	   */
	  public void accelerating() {

	  }

	  /**
	   * Process deceleration
	   */
	  public void decelerating() {

	  }

	  /**
	   * Process when train reaches full speed
	   */
	  public void fullSpeed() {

	  }
	  
	  /*
	   * Processes the doors closed before accelerating
	   */
	  public void stoppedDoorClosedBeforeAccelerating() {
		  
	  }
	  
	  /*
	   * Processes the doors closed before opening
	   */
	  public void stoppedDoorClosedBeforeOpening() {
		  
	  }
	  
	  /*
	   * Processes the doors closing
	   */
	  public void stoppedDoorsClosing() {
		  
	  }
	  
	  /*
	   * Processes the doors opening
	   */
	  public void stoppedDoorsOpening() {
		  
	  }
	  
	  /*
	   * processes the doors open
	   */
	  public void stoppedDoorsOpen() {
		  
	  }
	  
	  /**
	   * Process clock tick Generates the timer runs out event
	   */
	  public void onTimerTick(int timerValue) {

	  }

	  /**
	   * Process clock ticks Generates the timer runs out event
	   */
	  public void onTimerRunsOut() {

	  }

}
