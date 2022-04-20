package edu.ics372.trainfx.start;

import edu.ics372.trainfx.display.GUIDisplay;
import edu.ics372.trainfx.timer.Clock;
import javafx.application.Application;

/**
 * This class starts the GUI by running a thread.
 * 
 * @author Sharon Shin
 */

//TODO: Fix error? Not sure if this is correct. 
public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}