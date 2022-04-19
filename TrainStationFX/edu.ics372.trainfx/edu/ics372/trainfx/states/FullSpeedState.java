package edu.ics372.trainfx.states;

/**
 * This is the fullSpeed state, indicating that the train is done accelerating
 * and is now moving at its full speed. This state is exited only in the event
 * of the Approaching Station signal being received.
 * 
 * @author Sharon Shin an James Sawicki
 *
 */
public class FullSpeedState extends TrainState {
	private static FullSpeedState instance;

	/**
	 * Singleton pattern
	 */
	private FullSpeedState() {

	}

	/**
	 * Returns the singleton instance
	 * 
	 * @return the instance of FullSpeedState
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
		TrainContext.getInstance().showTimeLeft(0);
	}

	/**
	 * Method for when the train enters the full speed state. Time is shown as 0 and
	 * the state of the train is indicated in the display.
	 */
	@Override
	public void enter() {
		System.out.println("FULLSPEED"); // TODO debug
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().showFullSpeedState();
		;

	}

	/**
	 * This method is called when the changeState method in trainContext is called.
	 */
	@Override
	public void leave() {
		TrainContext.getInstance().showDeceleratingState();
	}

}
