package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * State to represent when the doors are in a state of opening.
 * 
 * @author Jim Sawicki and Parker Talley.
 *
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

	@Override
	public void enter() {
//		System.out.println("Entering: Stopped; Doors opening state...");
		// Check if the door has been obstructed to close already.
		if (StoppedDoorsClosingState.getTimeSpentClosingDoors() == 0) {
			System.out.println("Doors were NOT obstructed.");
			timer = new Timer(this, 4);
		} else {

			timer = new Timer(this, (int) (StoppedDoorsClosingState.getTimeSpentClosingDoors() * (4.0 / 5.0)));
		}
		TrainContext.getInstance().showDoorsOpeningState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());

	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorsOpenState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void leave() {
//		System.out.println("Leaving: Stopped; Doors opening state...\n");
		timer.stop();
		timer = null;
	}

}
