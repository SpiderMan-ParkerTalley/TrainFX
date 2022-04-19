package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/*
 * Represents the doors opened state for the train
 * @author Cristian Zendejas
 */

public class StoppedDoorsOpenState extends TrainState implements Notifiable {
	private static StoppedDoorsOpenState instance;
	private Timer timer;
	
	/*
	 * Singleton Pattern
	 */
	private StoppedDoorsOpenState() {

	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return instance of the class
	 */
	public static StoppedDoorsOpenState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsOpenState();
		}
		return instance;
	}

	@Override
	public void enter() {
		System.out.println("ENTERED DOORS OPEN STATE");
		timer = new Timer(this, 4);
		TrainContext.getInstance().showStoppedDoorsOpenState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showStoppedDoorsClosingState();
		TrainContext.getInstance().showTimeLeft(0);

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
