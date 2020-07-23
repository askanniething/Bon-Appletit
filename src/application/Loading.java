/**
 * 
 */
package application;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Creates a loading image and animation
 * 
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 45 minutes
 */
public class Loading {

	/* Outputs an animation for the user to enjoy
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Loading (Group root, Scene scene, Stage stage)
	{

		Image image3 = new Image("White.jpg"); // creates a background image for the loading screen
		ImageView iv1 = new ImageView();

		iv1.setFitWidth(960);
		iv1.setFitHeight(677);
		iv1.setImage(image3);
		root.getChildren().add(iv1);
		iv1.setPreserveRatio (true);
		iv1.setSmooth(true);
		iv1.setCache(true);
		Image image2 = new Image ("Up Beet.jpg"); // creates a logo image
		ImageView iv2 = new ImageView(); // creates a new imageview
		iv2.setImage(image2);
		iv2.setPreserveRatio (true);
		iv2.setY(0);
		iv2.setX(275);
		PauseTransition pt = new PauseTransition(); // pauses the program until the animation is finished
		pt.setDuration(new Duration(2000));
		pt.setOnFinished(e ->
		{
			rotate (root, scene, stage);
		});
		root.getChildren().add(iv2);
		FadeTransition ft = new FadeTransition(); // fades the image out
		ft.setNode(iv2);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.play(); // plays the fade animation
		stage.setScene(scene); 
		stage.show(); 
		pt.play(); // plays the pause animation

	}

	/* Outputs the second part of the animation
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public void rotate (Group root, Scene scene, Stage stage)
	{
		Image image2 = new Image("White.jpg"); // creates a background image for the loading sreen
		ImageView iv1 = new ImageView(); // creates an imageview
		iv1.setFitWidth(960);
		iv1.setFitHeight(677);
		iv1.setImage(image2);
		root.getChildren().add(iv1);
		iv1.setPreserveRatio (true);
		iv1.setSmooth(true);
		iv1.setCache(true);
		Image image = new Image ("Appletite.jpg"); // creates a logo for the game
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio (true);
		iv.setY(100);
		iv.setX(250);
		RotateTransition rotateTransition = new RotateTransition(); // creates a rotate transition  
		rotateTransition.setDuration(Duration.millis(3000)); 
		rotateTransition.setNode(iv);      
		rotateTransition.setByAngle(360); 
		rotateTransition.setCycleCount(2); 
		rotateTransition.setAutoReverse(true); 
		rotateTransition.play();  // plays the rotate transition
		root.getChildren().add(iv);
		stage.setScene(scene); 
		stage.show(); 
		PauseTransition pt = new PauseTransition(); // creates a pause transition
		pt.setDuration(new Duration(7000));
		pt.setOnFinished(e ->
		{
			new IntroScreen (root, scene, stage);
		});
		pt.play(); // plays the pause transition
	}
}
