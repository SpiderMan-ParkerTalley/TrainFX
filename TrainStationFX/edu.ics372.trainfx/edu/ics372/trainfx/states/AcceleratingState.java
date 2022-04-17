package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/*
 * @author Cristian Zendejas
 * 
 * Represents the accelerating state of the train. 
 */
public class AcceleratingState extends TrainState implements Notifiable {
	private static AcceleratingState instance;
	private Timer timer;

	/*
	 * private singleton for the pattern
	 */
	private AcceleratingState() {

	}

	/*
	 * Singleton
	 * 
	 * @return the instance
	 */
	public static AcceleratingState getInstance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showTimeLeft(timerValue);

	}

	@Override
	public void enter() {
		System.out.println("ENTERED ACCEL"); // TODO debug
		timer = new Timer(this, 6);
		TrainContext.getInstance().showAcceleratingState();
		TrainContext.getInstance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
