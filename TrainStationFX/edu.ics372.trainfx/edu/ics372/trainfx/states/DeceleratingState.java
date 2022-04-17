package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;

public class DeceleratingState extends TrainState implements Notifiable {
	private static DeceleratingState instance;

	/**
	 * Singleton Pattern
	 */
	private DeceleratingState() {

	}

	/**
	 * Returns the static singleton instance
	 * 
	 * @return the State
	 */
	public static DeceleratingState getInstance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		System.out.println("Entered Decelerating State"); // TODO debug
		TrainContext.getInstance().showDeceleratingState();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnTimerTick(int timerValue) {
		// TODO Auto-generated method stub

	}

}
