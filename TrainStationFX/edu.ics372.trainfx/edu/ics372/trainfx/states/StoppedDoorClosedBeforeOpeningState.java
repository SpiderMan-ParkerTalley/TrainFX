package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * 
 * @author Sharon Shin
 *
 */
public class StoppedDoorClosedBeforeOpeningState extends TrainState implements Notifiable{
	private static StoppedDoorClosedBeforeOpeningState instance;
	private Timer timer;

	/**
	 * Singleton Pattern
	 */
	private StoppedDoorClosedBeforeOpeningState() {

	}
	
	/**
	 * Returns the singleton instance
	 * 
	 * @return the instance of FullSpeedState
	 */
	public static StoppedDoorClosedBeforeOpeningState getInstance() {
		if (instance == null) {
			instance = new StoppedDoorClosedBeforeOpeningState();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);
		
	}
	
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(StoppedDoorsOpeningState.getInstance());
	 }

	@Override
	public void enter() {
		System.out.println("ENTERED STOPPED DOOR CLOSED BEFORE OPENING"); // TODO debug
		timer = new Timer(this, 1);
		TrainContext.getInstance().showStoppedDoorClosedBeforeOpeningState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
		
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().showDoorsOpeningState();
		TrainContext.getInstance().showTimeLeft(0);
	}

}
