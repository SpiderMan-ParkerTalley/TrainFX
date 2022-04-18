package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the train state when it is stopped, the doors are already closed,
 * and it is waiting to begin the acceleration state.
 * 
 * @author Jim Sawicki
 *
 */
public class StoppedDoorClosedBeforeAcceleratingState extends TrainState implements Notifiable {

	private static StoppedDoorClosedBeforeAcceleratingState instance;
	private Timer timer;

	/**
	 * Singleton Pattern
	 */
	private StoppedDoorClosedBeforeAcceleratingState() {

	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return instance of the class
	 */
	public static StoppedDoorClosedBeforeAcceleratingState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorClosedBeforeAcceleratingState();
		}
		return instance;
	}

	/**
	 * Sets the timer, display text, and
	 */
	@Override
	public void enter() {
		System.out.println("ENTERED SDCBA"); // TODO debug
		timer = new Timer(this, 3);
		TrainContext.getInstance().showStoppedDoorClosedBeforeAcceleratingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(AcceleratingState.getInstance());
	}
}
