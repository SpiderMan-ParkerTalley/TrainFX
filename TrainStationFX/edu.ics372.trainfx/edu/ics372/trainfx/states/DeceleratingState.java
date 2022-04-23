package edu.ics372.trainfx.states;

/**
 * Represents the decelerating state of the train.
 *
 * @author Sharon Shin and Parker Talley.
 */

public class DeceleratingState extends TrainState {
	private static DeceleratingState instance;

	/**
	 * Singleton Pattern.
	 */
	private DeceleratingState() {
	}

	/**
	 * Returns the static singleton instance.
	 *
	 * @return DeceleratingState instance.
	 */
	public static DeceleratingState getInstance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	@Override
	public void onArrivedAtStationSignal() {
		TrainContext.getInstance().changeState(StoppedDoorClosedBeforeOpeningState.getInstance());
	}

	/**
	 * Method to enter the deceleration state. Called in the changeState method of
	 * trainContext.
	 */
	@Override
	public void enter() {
//		System.out.println("Entering: Decelerating state...");
		TrainContext.getInstance().showDeceleratingState();
	}

	/**
	 * Method to leave the deceleration state. Called in the changeState method of
	 * trainContext.
	 */
	@Override
	public void leave() {
//		System.out.println("Leaving: Decelerating state...\n");
	}
}
