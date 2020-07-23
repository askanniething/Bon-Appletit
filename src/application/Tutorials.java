/**
 * 
 */
package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** Outputs all of the Tutorial screens of all 3 levels.
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 1 hour 30 minutes
 */
public class Tutorials {
	/*Image to be displayed*/
	private Image image;
	/*Counter for array index*/
	int counter = 1;

	/* Display tutorial screens for current level 
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputted on 
	 * @param images Array of ending file names or the current tutorial screens that are to be displayed
	 */
	public Tutorials(Group root, Scene scene, Stage stage, String [] images)
	{
		Text txt = new Text (672, 142, ""); //text for the points to be displayed that the user ended the second level with
		ImageView imageView = new ImageView();
		image = new Image ("Tutorial"+images[0]);	
		if ((EnterInfo.u.getLevel().equals("2"))) //if the tutorial level is 3
		{
			txt.setText(EnterInfo.u.getPoints()+ "");
			txt.setFont(Font.font ("Calibri", 20));
		}
		imageView.setImage(image);
		imageView.setFitWidth(960);
		imageView.setFitHeight(677);
		Button button = new Button ("Continue"); //continue button
		button.setPrefHeight(50);
		button.setPrefWidth(140);
		button.relocate(620,560);
		button.setStyle("-fx-font: 20 arial; -fx-base: #e2f0fd; "); //setting the button's style
		button.setOnAction(new EventHandler<ActionEvent>() { //adds an event handler to the button
			@Override
			public void handle(ActionEvent event) {
				if (counter >= images.length) { //if all the tutorial images have been gone through
					if (EnterInfo.u.getLevel().equals("")) { //if the user just started the game
						EnterInfo.u.setLevel("1");
						new Level1(root, scene, stage);
					}
					else if (EnterInfo.u.getLevel().equals("1")) { //if the user completed level one
						EnterInfo.u.setLevel("2");
						new Level2(root, scene, stage);
					}
					else if (EnterInfo.u.getLevel().equals("2")){ //if the user completed level two
						EnterInfo.u.setLevel("3");
						new Level3(root, scene, stage);
					}

					button.setOnAction(null);
				}
				else 
				{
					txt.setText("");
					image = new Image ("Tutorial"+images[counter]);
					counter++;
					imageView.setImage(image);
					imageView.setPreserveRatio (true);
					imageView.fitWidthProperty().bind(stage.widthProperty());
				}
			}
		});
		root.getChildren().addAll(imageView, button, txt);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}
