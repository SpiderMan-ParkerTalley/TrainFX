package edu.ics372.trainfx.states;

import edu.ics372.trainfx.timer.Notifiable;
import edu.ics372.trainfx.timer.Timer;

/**
 * Represents the accelerating state of the train.
 * 
 * @author Cristian Zendejas, Sharon Shin and Parker Talley.
 */
public class AcceleratingState extends TrainState implements Notifiable {
	private static AcceleratingState instance;
	private Timer timer;

	/**
	 * Singleton Pattern.
	 */
	private AcceleratingState() {
	}

	/**
	 * Retrieves the AcceleratingState instance.
	 * 
	 * @return AcceleratingState instance.
	 */
	public static AcceleratingState getInstance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	/**
	 * When the deceleration event is triggered, AcceleratingState goes to
	 * DeceleratingState() instead of FullSpeedState().
	 */
	public void onApproachingStationSignal() {
		TrainContext.getInstance().showTimeLeft(0);
		TrainContext.getInstance().changeState(DeceleratingState.getInstance());
	}

	/**
	 * The AcceleratingState is entered from the StoppedBeforeAcceleratingState.
	 * Timer is instantiated and set to 6 seconds and the display is updated to show
	 * the state and time left in the state.
	 */
	@Override
	public void enter() {
//		System.out.println("Entering: Accelerating state...");
		timer = new Timer(this, 6);
		TrainContext.getInstance().showAcceleratingState(timer.getTimeValue());
	}

	/**
	 * Called during the changeState call in trainContext. Terminates the timer.
	 */
	@Override
	public void leave() {
//		System.out.println("Leaving: Accelerating state...\n");
		timer.stop();
		timer = null;
	}

	/**
	 * Called in the Timer class. This is used to update the time value in the GUI.
	 */
	@Override
	public void OnTimerTick(int timerValue) {
		TrainContext.getInstance().showAcceleratingState(timer.getTimeValue());
	}

	/**
	 * Called in the Timer class. This is used to change state once the timer runs
	 * out.
	 */
	@Override
	public void onTimerRunsOut() {
		TrainContext.getInstance().changeState(FullSpeedState.getInstance());
	}

}
