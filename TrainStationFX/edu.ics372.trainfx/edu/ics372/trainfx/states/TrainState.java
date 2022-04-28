package edu.ics372.trainfx.states;

/**
 * Abstract class for all states
 * 
 * @author Cristian Zendejas, Sharon Shin, and Parker Talley.
 */

public abstract class TrainState {
	/**
	 * Initializes the state.
	 */
	public abstract void enter();

	/**
	 * Initializes the state.
	 */
	public abstract void leave();

	/**
	 * Process deceleration
	 */
	public void onApproachingStationSignal() {
	}

	/**
	 * Processes the doors closed before accelerating.
	 */
	public void stoppedDoorClosedBeforeAccelerating() {
	}

	/**
	 * Processes the doors closed before opening.
	 */
	public void stoppedDoorClosedBeforeOpening() {
	}

	/**
	 * Processes the doors closing.
	 */
	public void stoppedDoorsClosing() {
	}

	/**
	 * Processes the doors opening.
	 */
	public void stoppedDoorsOpening() {
	}

	/*
	 * processes the doors open.
	 */
	public void stoppedDoorsOpened() {
	}

	/**
	 * Process clock ticks Generates the timer runs out event.
	 */
	public void onTimerRunsOut() {
	}

	/**
	 * Processes the arrived at station signal.
	 */
	public void onArrivedAtStationSignal() {
	}

	/**
	 * Processes the on obstruction signal.
	 */
	public void onObstructionSignal() {
	}

}
