package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * State to represent when the doors are in a state of opening.
 * 
 * @author Jim Sawicki and Parker Talley.
 */

public class StoppedDoorsOpeningState extends TrainState implements Notifiable {

	private static StoppedDoorsOpeningState instance;
	private Timer timer;

	/**
	 * Singleton Pattern.
	 */
	private StoppedDoorsOpeningState() {
	}

	/**
	 * Returns the StoppedDoorsOpeningState instance.
	 * 
	 * @return StoppedDoorsOpeningState instance.
	 */
	public static StoppedDoorsOpeningState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsOpeningState();
		}
		return instance;
	}

	/**
	 * Method for entering this state. Called in the changeState method of
	 * TrainContext.
	 */
	@Override
	public void enter() {
//		System.out.println("Entering: Stopped; Doors opening state...");
		// Check if the door has been obstructed to close already.
		if (StoppedDoorsClosingState.getTimeSpentClosingDoors() == 0) {
//			System.out.println("Doors were NOT obstructed.");
			timer = new Timer(this, 4);
		} else {

			timer = new Timer(this, (int) (StoppedDoorsClosingState.getTimeSpentClosingDoors() * (4.0 / 5.0)));
		}
		TrainContext.getInstance().showDoorsOpeningState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());

	}

	/**
	 * This method is called when the changeState method in trainContext is called.
	 */
	@Override
	public void leave() {
		// System.out.println("Leaving: Stopped; Doors opening state...\n");
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
		TrainContext.getInstance().changeState(StoppedDoorsOpenState.getInstance());
	}

}
