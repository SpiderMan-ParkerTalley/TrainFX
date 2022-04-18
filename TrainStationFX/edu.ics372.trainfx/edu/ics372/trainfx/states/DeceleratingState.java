package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * 
 * @author Sharon Shin
 *
 */

//TODO No amount of deceleration time specified in PDF. Do we need to implement timer?
public class DeceleratingState extends TrainState implements Notifiable {
	private static DeceleratingState instance;
	private Timer timer;

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
	
	@Override
	public void enter() {
		System.out.println("ENTERED DECEL"); // TODO debug
		timer = new Timer(this, 0);
		TrainContext.getInstance().showDeceleratingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		TrainContext.getInstance().showStoppedDoorClosedBeforeOpeningState();
	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO No timer needed for this?

	}

}
