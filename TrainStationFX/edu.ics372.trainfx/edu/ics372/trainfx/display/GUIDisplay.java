package edu.ics372.trainfx.display;

import edu.ics372.trainfx.buttons.ApproachingStationButton;
import edu.ics372.trainfx.buttons.ArrivedAtStationButton;
import edu.ics372.trainfx.buttons.GUIButton;
import edu.ics372.trainfx.buttons.ObstructionButton;
import edu.ics372.trainfx.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * GUI to implement the TrainDisplay interface.
 * 
 * @author Jim Sawicki, Sharon Shin TODO: MARK UNTIL CONFIRMED FINISHED
 */

public class GUIDisplay extends Application implements TrainDisplay {

	private GUIButton AtStationButton;
	private GUIButton ApproachingButton;
	private GUIButton ObstructionButton;
	private Text trainStatus = new Text("Initial"); // TODO The train will need to "start"
													// somewhere.
	private Text timeValue = new Text(" FIX ME "); // TODO Fix me

	/**
	 * Sets up the interface
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ObstructionButton = new ObstructionButton("Obstruction");
		ApproachingButton = new ApproachingStationButton("Approaching Station");
		AtStationButton = new ArrivedAtStationButton("Arrived at Station");

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(trainStatus, 0, 0);
		pane.add(timeValue, 1, 0);
		pane.add(AtStationButton, 2, 0);
		pane.add(ApproachingButton, 3, 0);
		pane.add(ObstructionButton, 4, 0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TrainGUI");
		primaryStage.show();
		showStoppedDoorClosedBeforeAcceleratingState();
		TrainContext.getInstance().setDisplay(this);
		TrainContext.getInstance().initialize();
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
		timeValue.setText(" " + time);
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
