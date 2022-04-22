package edu.ics372.trainfx.states;

/**
 * This is the fullSpeed state, indicating that the train is done accelerating
 * and is now moving at its full speed. This state is exited only in the event
 * of the Approaching Station signal being received.
 * 
 * @author Sharon Shin, James Sawicki and Parker Talley.
 *
 */
public class FullSpeedState extends TrainState {
	private static FullSpeedState instance;

	/**
	 * Singleton Pattern.
	 */
	private FullSpeedState() {
	}

	/**
	 * Retrieves the FullSpeedState instance.
	 * 
	 * @return FullSpeedState instance.
	 */
	public static FullSpeedState getInstance() {
		if (instance == null) {
			instance = new FullSpeedState();
		}
		return instance;
	}

	/**
	 * At full speed, the train begins to decelerate once the approaching station
	 * signal is received.
	 */
	public void onApproachingStationSignal() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

	/**
	 * Method for when the train enters the full speed state. Time is shown as 0 and
	 * the state of the train is indicated in the display.
	 */
	@Override
	public void enter() {
//		System.out.println("Entering: Full speed state...");
		TrainContext.getInstance().showFullSpeedState();
	}

	/**
	 * This method is called when the changeState method in trainContext is called.
	 */
	@Override
	public void leave() {
//		System.out.println("Leaving: Full speed state...\n");
		TrainContext.getInstance().showDeceleratingState();
	}

}
