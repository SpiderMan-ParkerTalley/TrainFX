package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the train state when it is stopped and the doors are starting to
 * close after being open
 * 
 * @author Cristian Zendejas, Emmanuel Ojogwu, and Parker Talley.
 */
public class StoppedDoorsClosingState extends TrainState implements Notifiable {
	private static StoppedDoorsClosingState instance;
	private Timer timer;
	private static int timeSpentClosingDoors = 0;
	private static final int TIME_TO_CLOSE_DOORS = 5;

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
	 * 
	 * @return int time spent closing doors.
	 */
	public static int getTimeSpentClosingDoors() {
		return timeSpentClosingDoors;
	}

	/**
	 * Setter for timer spent closing doors.
	 * 
	 * @param int value to be set.
	 */
	public static void setTimeSpentClosing(int value) {
		timeSpentClosingDoors = value;
	}

	/**
	 * Method for entering this state. Called in the changeState method of
	 * TrainContext.
	 */
	@Override
	public void enter() {
//		System.out.println("Entering: Stopped; Doors closing state...");
		timer = new Timer(this, TIME_TO_CLOSE_DOORS);
		TrainContext.getInstance().showStoppedDoorsClosingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	/**
		 * This method is called when the changeState method in trainContext is called.
		 */
		@Override
		public void leave() {
	//		System.out.println("Leaving: Stopped; Doors closing state...\n");
			timer.stop();
			timer = null;
			TrainContext.getInstance().showTimeLeft(0);
		}

	/**
	 * Called in the Timer class. This is used to update the time value in the GUI.
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		timeSpentClosingDoors = timerValue;
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	/**
	 * Called in the Timer class. This is used to change state once the timer runs
	 * out.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorClosedBeforeAcceleratingState.getInstance());
	}

	@Override
	public void onObstructionSignal() {
		timeSpentClosingDoors = TIME_TO_CLOSE_DOORS - timer.getTimeValue();
		/*
		 * If the Obstruction occurs in less than 1 second, timeSpentClosingDoors will
		 * be 0 and the non-obstruction branch of the stopped doors opening state will
		 * fire. To circumvent this, if the onObstructionSignal is fired
		 * timeSpentClosingDoors is set to a minimum of 1 second.
		 */
		if (timeSpentClosingDoors == 0) {
			timeSpentClosingDoors = 1;
		}
		TrainContext.getInstance().changeState(StoppedDoorsOpeningState.getInstance());
	}
}
