package edu.ics372.trainfx.display;

import edu.ics372.trainfx.buttons.GUIButton;
import edu.ics372.trainfx.buttons.ObstructionButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * GUI to implement the TrainDisplay interface.
 * 
 * @author Jim Sawicki TODO: MARK UNTIL CONFIRMED FINISHED
 */

public class GUIDisplay extends Application implements TrainDisplay {

	GUIButton AtStationButton;
	GUIButton ApproachingButton;
	GUIButton ObstructionButton;
	private Text trainStatus = new Text("Train is stopped and doors are closed"); // TODO The train will need to "start"
																					// somewhere.
	private Text timeValue = new Text(" Fix Me "); // TODO Fix me

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ObstructionButton = new ObstructionButton("Obstruction");
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});

	}

	/**
	 * Shows the time remaining
	 */
	@Override
	public void showTimeLeft(int time) {

	}

	/**
	 * Indicate that the train is in the Accelerating state.
	 */
	@Override
	public void showAcceleratingState() {
		trainStatus.setText("Train is accelerating");

	}

	/**
	 * Indicate that the train is in the Decelerating state.
	 */
	@Override
	public void showDeceleratingState() {
		trainStatus.setText("Train is decelerating");

	}

	/**
	 * Indicate that the train is in the FullSpeed state.
	 */
	@Override
	public void showFullSpeedState() {
		trainStatus.setText("Train is at full speed");
	}

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeAccelerating state.
	 */
	@Override
	public void showStoppedDoorClosedBeforeAcceleratingState() {
		trainStatus.setText("Train is stopped and doors are closed");
	}

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeOpening state.
	 */
	@Override
	public void showStoppedDoorClosedBeforeOpeningState() {
		trainStatus.setText("Train is stopped and doors are closed");
	}

	/**
	 * Indicate that the train is the StoppedDoorsClosing state.
	 */
	@Override
	public void showStoppedDoorsClosingState() {
		trainStatus.setText("Train is stopped and doors are closing");
	}

	/**
	 * Indicate that the train is the StoppedDoorsOpening state.
	 */
	@Override
	public void showStoppedDoorsOpeningState() {
		trainStatus.setText("Train is stopped and doors are opening");
	}

	/**
	 * Indicate that the train is the StoppedDoorsOpen state.
	 */
	@Override
	public void showStoppedDoorsOpenState() {
		trainStatus.setText("Train is stopped and doors are open");
	}
}
