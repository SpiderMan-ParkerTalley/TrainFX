package edu.ics372.trainfx.display;

/**
 * Lays out the bare minimum that the display should be able to do.
 * 
 * @author Jim Sawicki and Emmanuel Ojogwu .
 *
 */
public interface TrainDisplay {

	/**
	 * Indicate that the train is in the Accelerating state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showAcceleratingState(int timerValue);

	/**
	 * Indicate that the train is in the Decelerating state.
	 */
	public void showDeceleratingState();

	/**
	 * Indicate that the train is in the FullSpeed state.
	 */
	public void showFullSpeedState();

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeAccelerating state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showStoppedDoorClosedBeforeAcceleratingState(int timerValue);

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeOpening state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showStoppedDoorClosedBeforeOpeningState(int timerValue);

	/**
	 * Indicate that the train is the StoppedDoorsClosing state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showStoppedDoorsClosingState(int timerValue);

	/**
	 * Indicate that the train is the StoppedDoorsOpening state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showStoppedDoorsOpeningState(int timerValue);

	/**
	 * Indicate that the train is the StoppedDoorsOpen state.
	 * 
	 * @param timerValue the current timer value.
	 */
	public void showStoppedDoorsOpenState(int timerValue);
}
