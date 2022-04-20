package edu.ics372.trainfx.buttons;

import edu.ics372.trainfx.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This button tells the train a station is approaching and makes the train slow
 * down.
 * 
 * @author Sharon Shin and Parker Talley
 *
 */

public class ApproachingStationButton extends GUIButton implements EventHandler<ActionEvent> {

	public ApproachingStationButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onApproachingStationSignal();
	}

}
