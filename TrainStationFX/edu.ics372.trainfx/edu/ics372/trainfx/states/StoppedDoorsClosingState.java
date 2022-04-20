package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the train state when it is stopped and the doors are
 * starting to close after being open
 * 
 * @author Cristian Zendejas and Parker Talley.
 */
public class StoppedDoorsClosingState extends TrainState implements Notifiable {
	private static StoppedDoorsClosingState instance;
	private Timer timer;
	private static int timeSpentClosingDoors = 0;
	
	/**
	 * Singleton Pattern.
	 */
	private StoppedDoorsClosingState() {
	}

	/**
	 * Returns the StoppedDoorsClosingState instance.
	 * 
	 * @return StoppedDoorsClosingState instance.
	 */
	public static StoppedDoorsClosingState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsClosingState();
		}
		return instance;
	}
	
	/**
	 * Getter for timer spent closing doors.
	 * @return int time spent closing doors.
	 */
	public static int getTimeSpentClosingDoors() {
		return timeSpentClosingDoors;
	}
	
	/**
	 * Setter for timer spent closing doors.
	 * @param int value to be set.
	 */
	public static void setTimeSpentClosing(int value) {
		timeSpentClosingDoors = value;
	}

	@Override
	public void enter() {
		System.out.println("Entering: Stopped; Doors closing state...");
		timer = new Timer(this, 5);
		TrainContext.getInstance().showStoppedDoorsClosingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}
	
	@Override
	public void onObstructionSignal() {
		timeSpentClosingDoors = timer.getTimeValue();
		TrainContext.getInstance().changeState(StoppedDoorsOpeningState.getInstance());
	}

	@Override
	public void OnTimerTick(int timerValue) {
		timeSpentClosingDoors = timerValue;
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorClosedBeforeAcceleratingState.getInstance());
	}
	
	@Override
	public void leave() {
		System.out.println("Leaving: Stopped; Doors closing state...\n");
		timer.stop();
		timer = null;
		TrainContext.getInstance().showTimeLeft(0);
	}
}
