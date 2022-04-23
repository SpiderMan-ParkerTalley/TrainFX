package edu.ics372.trainfx.states;

import edu.ics372.trainfx.display.TrainDisplay;

/**
 * The observer for the clock and stores info for the states.
 * 
 * @author Cristian Zendejas and Parker Talley.
 */

public class TrainContext {
	private TrainDisplay display;
	private TrainState currentState;
	private static TrainContext instance;

	/**
	 * TrainContext Singleton
	 */
	private TrainContext() {
		instance = this;
		currentState = StoppedDoorClosedBeforeAcceleratingState.getInstance();
	}

	/**
	 * Returns the TrainContext instance.
	 * 
	 * @return TrainContext instance.
	 */
	public static TrainContext getInstance() {
		if (instance == null) {
			instance = new TrainContext();
		}
		return instance;
	}

	/**
	 * Called from the states to change the current state.
	 * 
	 * @param nextState the next state.
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * The train being stopped and doors closed before accelerating is starting
	 * state. Adds the object as an observable for clock.
	 */
	public void initialize() {
		currentState = StoppedDoorClosedBeforeAcceleratingState.getInstance();
		currentState.enter();
	
	}

	/**
	 * Used for the Approaching Station signal.
	 */
	public void onApproachingStationSignal() {
		currentState.onApproachingStationSignal();
	}

	/**
	 * Used for the arrived at station signal.
	 */
	public void onArrivedAtStationSignal() {
		currentState.onArrivedAtStationSignal();
	}

	/**
	 * Used for the obstruction signal
	 */
	public void onObstructionSignal() {
		currentState.onObstructionSignal();
	}

	/**
	 * The display could change. So we have to get the reference.
	 * 
	 * @param The current display object.
	 */
	public void setDisplay(TrainDisplay display) {
		this.display = display;
	}

	/**
	 * Shows that the train is in the AcceleratingState().
	 */
	public void showAcceleratingState() {
		display.showAcceleratingState();
	
	}

	/**
	 * Displays the text to indicate the train has entered the DeceleratingState.
	 */
	public void showDeceleratingState() {
		display.showDeceleratingState();
	
	}

	/**
	 * Displays the text to indicate the doors are opening.
	 */
	public void showDoorsOpeningState() {
		display.showStoppedDoorsOpeningState();
	
	}

	/**
	 * Displays the text to indicate the train has entered the FullSpeedState.
	 */
	public void showFullSpeedState() {
		display.showFullSpeedState();
	
	}

	/**
	 * Displays the text to indicate the train has entered the
	 * stoppedDoorClosedBeforeAcceleratingState.
	 */
	public void showStoppedDoorClosedBeforeAcceleratingState() {
		display.showStoppedDoorClosedBeforeAcceleratingState();

	}

	/**
	 * Displays the text to indicate the train has stopped, doors are closed and
	 * before they have opened at the state.
	 */
	public void showStoppedDoorClosedBeforeOpeningState() {
		display.showStoppedDoorClosedBeforeOpeningState();
	}

	/**
	 * Displays the text to indicate the train has entered the
	 * StoppedDoorsClosingState.
	 */
	public void showStoppedDoorsClosingState() {
		display.showStoppedDoorsClosingState();
	}

	/*
	 * Displays the text to indicate the train has entered the
	 * StoppedDoorsOpenState.
	 */
	public void showStoppedDoorsOpenState() {
		display.showStoppedDoorsOpenState();
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

}
