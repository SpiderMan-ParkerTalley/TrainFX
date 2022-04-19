package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/*
 * Represents the train state when it is stopped and the doors are
 * starting to close after being open
 * 
 * @author Cristian Zendejas
 */
public class StoppedDoorsClosingState extends TrainState implements Notifiable {

	private static StoppedDoorsClosingState instance;
	private Timer timer;
	
	/*
	 * Singleton Pattern
	 */
	private StoppedDoorsClosingState() {

	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return instance of the class
	 */
	public static StoppedDoorsClosingState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsClosingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		System.out.println("ENTERED STOPPED DOORS CLOSING STATE");
		timer = new Timer(this, 5);
		TrainContext.getInstance().showStoppedDoorsClosingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showStoppedDoorClosedBeforeAcceleratingState();
		TrainContext.getInstance().showTimeLeft(0);

	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorClosedBeforeAcceleratingState.getInstance());
	}
}
