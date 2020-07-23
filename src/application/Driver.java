package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

/** Displays each level
 * @version 5
 * @author Grace Xu and Annie Chen
 * Date: June 8th, 2018
 * Time Spent: 1 hour
 */

public class Main extends Application {

	/* Override of the javafx start method
	 * 
	 * @param primaryStage The stage in which everything is displayed
	 */
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group(); 
		Scene scene = new Scene (root);		   
		primaryStage.setTitle("Bon Appletit");
		new Loading (root, scene, primaryStage);
	}

	/*
	 * Starts the execution of the animation 
	 * 
	 * @param args outputs everything to the screen
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
