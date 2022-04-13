package edu.ics372.trainfx.display;

/**
 * Lays out the bare minimum that the display should be able to do. Not finished
 * maybe.
 * 
 * @author Jim Sawicki TODO: MARK UNTIL CONFIRMED FINISHED
 *
 */
public interface TrainDisplay {

	/**
	 * Shows the time remaining before the particular state change.
	 * 
	 * @param time Time remaining in seconds.
	 */
	public void showTimeLeft(int time);

	/**
	 * Indicate that the train is in the Accelerating state.
	 */
	public void showAcceleratingState();

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
	 */
	public void showStoppedDoorClosedBeforeAcceleratingState();

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeOpening state.
	 */
	public void showStoppedDoorClosedBeforeOpeningState();

	/**
	 * Indicate that the train is the StoppedDoorsClosing state.
	 */
	public void showStoppedDoorsClosingState();

	/**
	 * Indicate that the train is the StoppedDoorsOpening state.
	 */
	public void showStoppedDoorsOpeningState();

	/**
	 * Indicate that the train is the StoppedDoorsOpen state.
	 */
	public void showStoppedDoorsOpenState();

}
