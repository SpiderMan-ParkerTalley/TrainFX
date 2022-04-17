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

	/**
	 * When the deceleration event is triggered, AcceleratingState goes to
	 * DeceleratingState() instead of FullSpeedState().
	 */
	@Override
	public void onDecelerationSignal() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

	/**
	 * When the timer runs out, AcceleratingState transitions to FullSpeedState.
	 */
	@Override
	public void onTimerRunsOut() {
		timer.stop();
		timer = null;
		TrainContext.getInstance().changeState(FullSpeedState.getInstance());
		TrainContext.getInstance().showTimeLeft(0);
	}

	/**
	 * The AcceleratingState is entered from the StoppedBeforeAcceleratingState.
	 * Timer is instantiated and set to 6 seconds and the display is updated to show
	 * the state and time left in the state.
	 */
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
