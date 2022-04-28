/**
 * This classes code was borrowed from Professor Brahma Dathan.
 * 
 * @author Brahma Dathan.
 */

package edu.ics372.trainfx.timer;

public interface Notifiable {
	/**
	 * Process timer ticks
	 */
	public void OnTimerTick(int timerValue);

	/**
	 * Process timer runs out event
	 */
	public void onTimerRunsOut();

}