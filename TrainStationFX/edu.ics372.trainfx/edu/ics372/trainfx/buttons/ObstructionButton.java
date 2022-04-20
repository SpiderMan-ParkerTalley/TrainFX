package edu.ics372.trainfx.buttons;

import edu.ics372.trainfx.states.StoppedDoorsClosingState;
import edu.ics372.trainfx.states.TrainContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This button triggers an obstruction event.
 * 
 * @author Jim Sawicki and Parker Talley.
 * 
 */
public class ObstructionButton extends GUIButton implements EventHandler<ActionEvent>{

	public ObstructionButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onObstructionSignal();
	}

}
