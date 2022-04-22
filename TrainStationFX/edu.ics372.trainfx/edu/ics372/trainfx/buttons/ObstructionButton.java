package edu.ics372.trainfx.buttons;

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

	/**
	 * A constructor for ObstructionButton. 
	 * 
	 * @param String a string.
	 */
	public ObstructionButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.getInstance().onObstructionSignal();
	}

}
