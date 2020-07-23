/**
 * 
 */
package application;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.animation.PauseTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Displays the credits and exits the program
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 30 minutes
 * 
 */
public class Exit {

	/* Displays the credit screen and exits the program
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputed on 
	 */
	public Exit (Group root, Scene scene, Stage stage)
	{
		Image image = new Image ("Credits.jpg");
		ImageView iv2 = new ImageView();
		iv2.setImage(image);
		iv2.setPreserveRatio (true);
		iv2.setSmooth(true);
		iv2.setCache(true);
		root.getChildren().add(iv2);
		PauseTransition pt = new PauseTransition();
		pt.setDuration(new Duration(4000)); //delay
		pt.setOnFinished(e ->
		{
			Platform.exit(); //exits program
		});
		pt.play();
		stage.setScene(scene);
		stage.show();
	}
}
