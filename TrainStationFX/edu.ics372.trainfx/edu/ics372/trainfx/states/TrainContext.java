package edu.ics372.trainfx.states;

import edu.ics372.trainfx.display.TrainDisplay;

/*
 * @author Cristian Zendejas
 * 
 * The observer for the clock and stores info for the states.
 */
public class TrainContext {
	private TrainDisplay display;
	private TrainState currentState;
	private static TrainContext instance;

	/*
	 * TrainContext Singleton
	 */
	private TrainContext() {
		instance = this;
		currentState = StoppedDoorClosedBeforeAcceleratingState.getInstance();
	}

	/*
	 * Returns the instance of TrainContext
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * The display could change. So we have to get the reference.
	 * 
	 * @param The current display object
	 */
	public void setDisplay(TrainDisplay display) {
		this.display = display;
	}

	/**
	 * The train being stopped and doors closed before accelerating is starting
	 * state. Adds the object as an observable for clock
	 */
	public void initialize() {
		currentState = StoppedDoorClosedBeforeAcceleratingState.getInstance();
		currentState.enter();

	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState the next state
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void onAccelerating() {
		currentState.onAccelerating();
	}

	/**
	 * Process doors opening request
	 */
	public void stoppedDoorsOpening() {
		currentState.stoppedDoorsOpening();
	}

	/**
	 * Process doors opened request
	 */
	public void stoppedDoorsOpened() {
		currentState.stoppedDoorsOpened();
	}

	/**
	 * Processed stopped train before doors opening request
	 */

	public void stoppedDoorsClosedBeforeOpening() {
		currentState.stoppedDoorClosedBeforeOpening();
	}

	/**
	 * This invokes the right method of the display. This helps protect the states
	 * from changes to the way the system utilizes the state changes.
	 * 
	 * @param time time left for cooking
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

	/**
	 * Displays the text to indicate the train has entered the
	 * stoppedDoorClosedBeforeAcceleratingState.
	 */
	public void showStoppedDoorClosedBeforeAcceleratingState() {
		display.showStoppedDoorClosedBeforeAcceleratingState();

	}

	public void showAcceleratingState() {
		display.showAcceleratingState();

	}

	/**
	 * Displays the text to indicate the train has entered the FullSpeedState.
	 */
	public void showFullSpeedState() {
		display.showFullSpeedState();

	}

	/**
	 * Displays the text to indicate the train has entered the DeceleratingState.
	 */
	public void showDeceleratingState() {
		display.showDeceleratingState();

	}

	/**
	 * Used for the Approaching Station signal.
	 */
	public void onApproachingStationSignal() {
		currentState.onApproachingStationSignal();
	}
	
	public void onArrivedAtStationSignal() {
		currentState.onArrivedAtStationSignal();
	}

	public void showStoppedDoorClosedBeforeOpeningState() {
		display.showStoppedDoorClosedBeforeOpeningState();
	}

	public void showDoorsOpeningState() {
		display.showStoppedDoorsOpeningState();

	}

}
