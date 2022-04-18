package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;

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
	public static TrainState getInstance() {
		if (instance == null) {
			instance = new FullSpeedState();
		}
		return instance;
	}

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
		// TODO Auto-generated method stub

	}

}
