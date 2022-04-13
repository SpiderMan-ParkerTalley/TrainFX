package edu.ics372.trainfx.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Our very own abstract GUI button class.
 * 
 * @author Jim Sawicki
 * 
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {

	/**
	 * Create the button with the proper text. Makes the button a listener to clicks
	 * on itself.
	 * 
	 * @param string the text
	 */
	public GUIButton(String string) {
		super(string);
		setOnAction(this);
	}
}
