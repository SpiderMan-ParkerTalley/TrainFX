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
	 * Process obstruction event.
	 */
	public void onObstruction() {

	}

	/**
	 * Process deceleration signal
	 */
	public void onDecelerationSignal() {

	}

	/**
	 * Process station arrival signal.
	 */
	public void onStationArrivalSignal() {

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
