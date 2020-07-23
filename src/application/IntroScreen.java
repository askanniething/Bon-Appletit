/**
 * 
 */
package application;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** This program displays the IntroScreen, allowing the user to choose to play, exit, or view highscores
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 1 hour
 * 
 */
public class IntroScreen {

	/* Outputs an introduction screen
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputted on 
	 */
	public IntroScreen(Group root, Scene scene, Stage stage)
	{
		Image image = new Image("IntroScreen.jpg");
		ImageView iv1 = new ImageView();
		iv1.setImage(image);
		iv1.setPreserveRatio (true);
		iv1.setSmooth(true);
		iv1.setCache(true);
		Rectangle rect = new Rectangle (); // creates a rectangle
		rect.setX(387);
		rect.setY(331);
		rect.setWidth(203);
		rect.setHeight(80);
		rect.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent>() { // creates an event handler
			@Override 
			public void handle(MouseEvent e) { 
				new EnterInfo (root, scene, stage);
			} 
		};  
		Rectangle exit = new Rectangle (); // creates a rectangle
		exit.setX(388);
		exit.setY(446);
		exit.setWidth(203);
		exit.setHeight(79);
		exit.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { // creates an event handler
			@Override 
			public void handle(MouseEvent e) { 
				new Exit (root, scene, stage);
			} 
		};  
		Rectangle high = new Rectangle (); // creates a rectangle
		high.setX(350);
		high.setY(562);
		high.setWidth(275);
		high.setHeight(85);
		high.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler3 = new EventHandler <MouseEvent>() { // creates an event handler
			@Override 
			public void handle(MouseEvent e) { 
				new HighScores (root, scene, stage);
			} 
		};  
		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2); // adds event filter to the exit button
		rect.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); // adds event filter to the play button
		high.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3); // adds event filter to highscores
		root.getChildren().addAll(iv1, rect, exit, high);
		stage.setScene(scene);
		stage.show();
	}
}
