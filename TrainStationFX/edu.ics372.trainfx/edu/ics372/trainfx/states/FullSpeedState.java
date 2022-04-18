package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;

/**
 * This is the fullSpeed state, indicating that the train is done accelerating
 * and is now moving at its full speed. This state is exited only in the event
 * of the Approaching Station signal being received.
 * 
 * @author Sharon Shin an James Sawicki
 *
 */
public class FullSpeedState extends TrainState implements Notifiable {
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

	// TODO No timer ticking for this, since not indicated in PDF?
	@Override
	public void OnTimerTick(int timerValue) {

	}

	/**
	 * At full speed, the train begins to decelerate once the approaching station
	 * signal is received.
	 */
	public void onApproachingStationSignal() {
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
		TrainContext.getInstance().showTimeLeft(0);
	}

	@Override
	public void enter() {
		System.out.println("FULLSPEED"); // TODO debug
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().showFullSpeedState();
		;

	}

	@Override
	public void leave() {
		TrainContext.getInstance().showDeceleratingState();
	}

}
