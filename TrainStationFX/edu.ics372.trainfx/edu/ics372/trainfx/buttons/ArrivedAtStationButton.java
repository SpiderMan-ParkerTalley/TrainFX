package edu.ics372.trainfx.buttons;

import edu.ics372.trainfx.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This button tells the train it has arrived at a station and stops the train.
 * 
 * @author Sharon Shin and Parker Talley.
 *
 */

public class ArrivedAtStationButton extends GUIButton implements EventHandler<ActionEvent> {

	/**
	 * A constructor for ArrivedAtStationButton.
	 * 
	 * @param String a string.
	 */
	public ArrivedAtStationButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent evnet) {
		TrainContext.getInstance().onArrivedAtStationSignal();
	}

}
