package edu.ics372.trainfx.states;

/**
 *
 * @author Sharon Shin
 *
 */

public class DeceleratingState extends TrainState {
	private static DeceleratingState instance;

	/**
	 * Singleton Pattern
	 */
	private DeceleratingState() {

	}

	/**
	 * Returns the static singleton instance
	 *
	 * @return the State
	 */
	public static DeceleratingState getInstance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	public void onStationArrivedSignal() {
		TrainContext.getInstance().changeState(StoppedDoorClosedBeforeOpeningState.getInstance());
		TrainContext.getInstance().showTimeLeft(0);
	}

	/**
	 * Method to enter the deceleration state. Called in the changeState method of
	 * trainContext.
	 */
	@Override
	public void enter() {
		System.out.println("ENTERED DECEL"); // TODO debug
		TrainContext.getInstance().showDeceleratingState();
		TrainContext.getInstance().showTimeLeft(0);
	}

	/**
	 * Method to leave the deceleration state. Called in the changeState method of
	 * trainContext.
	 */
	@Override
	public void leave() {
		TrainContext.getInstance().stoppedDoorsClosedBeforeOpening();
	}
}
