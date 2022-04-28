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
 * @author Jim Sawicki and Sharon Shin.
 */

public class GUIDisplay extends Application implements TrainDisplay {
	private GUIButton AtStationButton;
	private GUIButton ApproachingButton;
	private GUIButton ObstructionButton;
	private Text trainStatus = new Text("Stopped Door Closed Before Accelerating");
	private Text doorStatus = new Text("Doors Cloesd");

	/**
	 * Sets up the interface.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ObstructionButton = new ObstructionButton("Door Obstructing");
		ApproachingButton = new ApproachingStationButton("Station Reaching");
		AtStationButton = new ArrivedAtStationButton("Station Reached");

		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(11);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.add(trainStatus, 0, 0);
		pane.add(doorStatus, 3, 0);
		pane.add(AtStationButton, 6, 0);
		pane.add(ApproachingButton, 7, 0);
		pane.add(ObstructionButton, 8, 0);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("TrainGUI");
		primaryStage.show();
		initialState();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});

	}

	/**
	 * Sets the initial state of the application.
	 */
	private void initialState() {
		showStoppedDoorClosedBeforeAcceleratingState(3);
		TrainContext.getInstance().setDisplay(this);
		TrainContext.getInstance().initialize();
	}

	/**
	 * Indicate that the train is in the Accelerating state.
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showAcceleratingState(int timerValue) {
		trainStatus.setText(timerValue + " seconds left before train is at full speed");

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
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showStoppedDoorClosedBeforeAcceleratingState(int timerValue) {
		doorStatus.setText("Doors closed");
		trainStatus.setText(timerValue + " seconds left before accelerating");
	}

	/**
	 * Indicate that the train is the StoppedDoorClosedBeforeOpening state.
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showStoppedDoorClosedBeforeOpeningState(int timerValue) {
		trainStatus.setText("Train stopped");
		doorStatus.setText(timerValue + " seconds left before doors begin opening");
	}

	/**
	 * Indicate that the train is the StoppedDoorsClosing state.
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showStoppedDoorsClosingState(int timerValue) {
		doorStatus.setText(timerValue + " seconds left before doors are closed");
	}

	/**
	 * Indicate that the train is the StoppedDoorsOpening state.
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showStoppedDoorsOpeningState(int timerValue) {
		doorStatus.setText(timerValue + " seconds left before doors are open");
	}

	/**
	 * Indicate that the train is the StoppedDoorsOpen state.
	 * 
	 * @param timerValue the current timer value.
	 */
	@Override
	public void showStoppedDoorsOpenState(int timerValue) {
		doorStatus.setText(timerValue + " seconds before doors begin closing");
	}
}
