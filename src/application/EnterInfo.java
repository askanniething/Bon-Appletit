/**
 * 
 */
package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/** This class allows the user to create a user profile
 * 
 * @version 5
 * @author Grace Xu and Annie Chen
 * Date: June 8th, 2018
 * Time Spent: 45 minutes
 */
public class EnterInfo {
	// creates a user 
	public static User u;
	// creates a list of the images used in the first tutorial
	public static String [] tutorial1;

	/* Allows the user to enter information about themselves
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputed on 
	 */
	public EnterInfo (Group root, Scene scene, Stage stage)
	{
		tutorial1 = new String [9];
		for (int i = 0; i < tutorial1.length; i++) {
			tutorial1[i] = "1"+ Character.toString((char)(i+97)) + ".jpg";
		}
		u = new User ("","","");
		Image image = new Image ("PROFILE.png"); // creates a new image
		ImageView iv = new ImageView(); // creates a new imageview
		iv.setImage(image);
		iv.setPreserveRatio (true);
		iv.setSmooth(true);
		iv.setCache(true);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(300, 25, 25, 350));
		Label label1 = new Label("Name:"); // creates a new label
		grid.add(label1, 0, 1);
		TextField textField = new TextField (); // creates a new text field
		grid.add(textField, 1, 1);
		Label label2 = new Label("Age:");
		grid.add(label2, 0, 2);
		ComboBox<String> age = new ComboBox<String>(); // creates a new combobox object
		age.getItems().addAll(
				"4-8 years old",
				"9-13 years old"
				);
		grid.add(age, 1, 2);
		Button but= new Button ("Let's Play!"); // creates a new button
		grid.add(but, 2, 1);
		Label txt = new Label (""); // creates a new label
		grid.add(txt, 3, 1);
		root.getChildren().addAll(iv,grid);
		but.setOnAction(new EventHandler<ActionEvent>() { // errortraps for too long names
			@Override
			public void handle(ActionEvent event) {
				if ((textField.getText().length() > 20))
				{
					txt.setText("Sorry, your name is too long.");
					stage.setScene(scene);
					stage.show();
				}
				if (!(textField.getText().equals ("")) && (textField.getText().length() < 20) && age.getSelectionModel().getSelectedItem() != null) // errortraps for empty fields
				{
					u.setName(textField.getText());
					String userAge = age.getSelectionModel().getSelectedItem().toString();
					u.setAge(userAge);
					if (userAge.equals("4-8 years old")) { // switches the level image depending on the image
						tutorial1[0] = "1a4-8.jpg";
					}
					else {
						tutorial1[0] = "1a9-13.jpg";
					}
					new Tutorials(root, scene, stage, tutorial1);
				}
			}
		});
		stage.setScene(scene);
		stage.show();
	}

}
