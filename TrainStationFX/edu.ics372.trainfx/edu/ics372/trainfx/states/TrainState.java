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
	  public void onAccelerating() {

	  }

	  /**
	   * Process deceleration
	   */
	  public void onApproachingStationSignal() {

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
	  public void stoppedDoorsOpened() {
		  
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

	  /**
	   * Processes stopping the train before opening the doors after arriving 
	   * at a station.
	   */
	  public void showStoppedDoorClosedBeforeOpeningState() {
			
	  }

	  /**
	   * Processes stopped train's doors opening at a station.
	   */
	  public void showDoorsOpeningState() {
		
	  }

	  public void onArrivedAtStationSignal() {
		
	  }

}
