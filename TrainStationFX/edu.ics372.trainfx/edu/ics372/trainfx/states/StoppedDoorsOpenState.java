package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the doors opened state for the train
 * 
 * @author Cristian Zendejas and Parker Talley.
 */

public class StoppedDoorsOpenState extends TrainState implements Notifiable {
	private static StoppedDoorsOpenState instance;
	private Timer timer;
	
	/**
	 * Singleton Pattern.
	 */
	private StoppedDoorsOpenState() {
	}

	/**
	 * Returns the StoppedDoorsOpenState instance.
	 * 
	 * @return StoppedDoorsOpenState instance.
	 */
	public static StoppedDoorsOpenState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsOpenState();
		}
		return instance;
	}

	@Override
	public void enter() {
//		System.out.println("Entering: Stopped; Doors open state...");
		// Check if the door has attempted to close already.
		if (StoppedDoorsClosingState.getTimeSpentClosingDoors() == 0) {
			System.out.println("Doors were NOT obstructed.");
			timer = new Timer(this, 30);
		}
		else {
			System.out.println("Doors were obstructed.");
			timer = new Timer(this, 8);
		}
		TrainContext.getInstance().showStoppedDoorsOpenState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
		
	}

	@Override
	public void leave() {
//		System.out.println("Leaving: Stopped; Doors open state...\n");
		timer.stop();
		timer = null;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorsClosingState.getInstance());
	}
}
