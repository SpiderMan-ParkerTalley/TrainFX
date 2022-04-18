package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;

/**
 * 
 * @author Sharon Shin
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

	//TODO No timer ticking for this, since not indicated in PDF?
	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

	public void onDecelerationSignal() {
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
