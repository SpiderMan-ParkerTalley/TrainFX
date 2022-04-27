package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the train state when it is stopped, the doors are closed, and it
 * is waiting to begin opening the doors.
 * 
 * @author Sharon Shin, Emmanuel Ojogwu, and Parker Talley.
 */

public class StoppedDoorClosedBeforeOpeningState extends TrainState implements Notifiable {
	private static StoppedDoorClosedBeforeOpeningState instance;
	private Timer timer;

	/**
	 * Singleton Pattern.
	 */
	private StoppedDoorClosedBeforeOpeningState() {
	}

	/**
	 * Retrieves the singleton instance.
	 * 
	 * @return StoppedDoorClosedBeforeOpeningState instance.
	 */
	public static StoppedDoorClosedBeforeOpeningState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorClosedBeforeOpeningState();
		}
		return instance;
	}

	@Override
	public void enter() {
//		System.out.println("Entering: Stopped; Doors closed; Before opening state...");
		timer = new Timer(this, 1);
		TrainContext.getInstance().showStoppedDoorClosedBeforeOpeningState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	/**
	 * This method is called when the changeState method in trainContext is called.
	 */
	@Override
	public void leave() {
//		System.out.println("Leaving: Stopped; Doors closed; Before opening state...\n");
		timer.stop();
		timer = null;
	}

	/**
	 * Called in the Timer class. This is used to update the time value in the GUI.
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);

	}

	/**
	 * Called in the Timer class. This is used to change state once the timer runs
	 * out.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorsOpeningState.getInstance());
	}
}
