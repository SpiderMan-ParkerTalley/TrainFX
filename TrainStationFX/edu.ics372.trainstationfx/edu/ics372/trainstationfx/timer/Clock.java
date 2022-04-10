package edu.ics372.trainstationfx.timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Clock implements Runnable {
	private Thread thread = new Thread(this);
	private static Clock clock;
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	/**
	 * Adds a listener
	 *
	 * @param listener the listener to be added
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a listener
	 *
	 * @param listener the listener to be removed
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * Start the thread
	 */
	private Clock() {
		thread.start();
	}

	/**
	 * To get the instance
	 *
	 * @return returns the clock
	 */
	public static Clock getInstance() {
		if (clock == null) {
			clock = new Clock();
		}
		return clock;
	}

	/**
	 * Infinite loop to generate the clock ticks Notify all users when clock ticks
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				this.propertyChangeSupport.firePropertyChange(null, null, null);

			}
		} catch (InterruptedException ie) {
		}
	}

}
