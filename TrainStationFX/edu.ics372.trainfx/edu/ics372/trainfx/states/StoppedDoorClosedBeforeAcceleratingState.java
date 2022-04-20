package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the train state when it is stopped, the doors are already closed,
 * and it is waiting to begin the acceleration state.
 * 
 * @author Jim Sawicki, Sharon Shin and Parker Talley.
 *
 */
public class StoppedDoorClosedBeforeAcceleratingState extends TrainState implements Notifiable {
	private static StoppedDoorClosedBeforeAcceleratingState instance;
	private Timer timer;

	/**
	 * Singleton Pattern.
	 */
	private StoppedDoorClosedBeforeAcceleratingState() {
	}

	/**
	 * Retrieves the StoppedDoorClosedBeforeAcceleratingState instance
	 * 
	 * @return StoppedDoorClosedBeforeAcceleratingState instance.
	 */
	public static StoppedDoorClosedBeforeAcceleratingState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorClosedBeforeAcceleratingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		System.out.println("Entering: Stopped; Doors Closed; Before accelerating state..."); // TODO debug
		// Sets the time spent closing to 0; reset value for next stop.
		StoppedDoorsClosingState.setTimeSpentClosing(0);
		timer = new Timer(this, 3);
		TrainContext.getInstance().showStoppedDoorClosedBeforeAcceleratingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showAcceleratingState();
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		System.out.println("Leaving: Stopped; Doors Closed; Before accelerating state...\n"); // TODO debug
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(AcceleratingState.getInstance());
	}
}
