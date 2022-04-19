package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * State to represent when the doors are in a state of opening.
 * 
 * @author Jim Sawicki
 *
 */
public class StoppedDoorsOpeningState extends TrainState implements Notifiable {

	private static StoppedDoorsOpeningState instance;
	private Timer timer;

	/**
	 * Singleton Pattern
	 */
	private StoppedDoorsOpeningState() {

	}

	/**
	 * Returns the singleton instance.
	 * 
	 * @return instance of the class
	 */
	public static TrainState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorsOpeningState();
		}
		return instance;
	}

	@Override
	public void enter() {
		System.out.println("ENTERED SDOS"); // TODO debug
		timer = new Timer(this, 4);
		TrainContext.getInstance().showDoorsOpeningState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().stoppedDoorsOpened();
		TrainContext.getInstance().showTimeLeft(0);
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
	}

}
