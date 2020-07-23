/**
 * 
 */
package application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Displays a message if the level is lost
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 1 hour
 * 
 */
public class Lost {


	/*Displays the losing screen and redirects user to try again or exit, if the user fails level 1
	 *
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputted on 
	 * @param images Array of image file names for level one tutorial 
	 */
	public Lost (Group root, Scene scene, Stage stage, String [] images) {
		Image image = new Image ("DEAD.png");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio (true);
		iv.setSmooth(true);
		iv.setCache(true);
		Rectangle r = new Rectangle ();
		r.setX(387);
		r.setY(331);
		r.setWidth(203);
		r.setHeight(80);
		r.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent>() { //adds an event handler 
			@Override 
			public void handle(MouseEvent e) { 

				EnterInfo.u.setLevel("");
				new Tutorials (root, scene, stage, images);
			} 
		};  
		r.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);


		Rectangle exit = new Rectangle ();
		exit.setX(388);
		exit.setY(446);
		exit.setWidth(203);
		exit.setHeight(79);
		exit.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				Platform.exit();
			} 
		};  
		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		root.getChildren().addAll(iv, r, exit);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	/*Displays the losing screen and redirects user to try again or exit, if the user fails level 2
	 *
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputted on 
	 * @param images Array of image file names for level two tutorial
	 * @param flag Flag variable to identify that it is the second level that has been failed 
	 */
	public Lost (Group root, Scene scene, Stage stage, String [] images, int flag) {
		Image image = new Image ("DEAD.png");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio (true);
		iv.setSmooth(true);
		iv.setCache(true);
		Rectangle r = new Rectangle ();
		r.setX(387);
		r.setY(331);
		r.setWidth(203);
		r.setHeight(80);
		r.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent>() { //adds an event handler
			@Override 
			public void handle(MouseEvent e) { 
				EnterInfo.u.setLevel("1");
				new Tutorials (root, scene, stage, images);
			} 
		};  
		r.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		Rectangle exit = new Rectangle ();
		exit.setX(388);
		exit.setY(446);
		exit.setWidth(203);
		exit.setHeight(79);
		exit.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				new Exit (root, scene, stage);
			} 
		};  
		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		root.getChildren().addAll(iv, r, exit);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();


	}

	/*Displays the losing screen and redirects user to try again or exit, if the user fails level 3
	 *
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage for all objects to be outputted on 
	 * @param images Array of image file names for level three tutorial
	 * @param flag Flag variable to identify that it is the third level that has been failed 
	 */
	public Lost (Group root, Scene scene, Stage stage, String [] images, double flag) {
		Image image = new Image ("DEAD.png");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setPreserveRatio (true);
		iv.setSmooth(true);
		iv.setCache(true);
		Rectangle r = new Rectangle ();
		r.setX(387);
		r.setY(331);
		r.setWidth(203);
		r.setHeight(80);
		r.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent>() { //adds an event handler
			@Override 
			public void handle(MouseEvent e) { 
				EnterInfo.u.setLevel("2");
				new Tutorials (root, scene, stage, images);
			} 
		};  
		r.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		Rectangle exit = new Rectangle ();
		exit.setX(388);
		exit.setY(446);
		exit.setWidth(203);
		exit.setHeight(79);
		exit.setFill(Color.TRANSPARENT);
		EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { 
			@Override 
			public void handle(MouseEvent e) { 
				Platform.exit();
			} 
		};  
		exit.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		root.getChildren().addAll(iv, r, exit);

		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}
}
