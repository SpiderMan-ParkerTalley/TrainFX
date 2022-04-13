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

	/*
	 * @Override public void start(Stage primaryStage) {
	 * primaryStage.setTitle("Hello World!"); Button btn = new Button();
	 * btn.setText("Say 'Hello World'"); btn.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) {
	 * System.out.println("Hello World!"); } });
	 * 
	 * StackPane root = new StackPane(); root.getChildren().add(btn);
	 * primaryStage.setScene(new Scene(root, 300, 250)); primaryStage.show(); }
	 */
}