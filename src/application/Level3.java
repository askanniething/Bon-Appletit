/**
 * 
 */
package application;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Displays the third level game to the screen
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 3 hours
 * 
 */
public class Level3 {
	// holds the answer to each question image
	private int [] right = {2, 1, 3, 2, 3, 1, 3, 3, 1, 3, 2, 3, 2, 1, 3, 2, 1, 3};
	// holds the current image
	private int current = -1; 
	// holds the root of each image name
	private String th = "Level3 ";
	// holds the images
	private String[] images = {th+"1a.jpg", th+"2a.jpg", th+"2b.jpg", th+"3a.jpg", th+"4a.jpg", 
			th+"4b.jpg", th+"4c.jpg",th+"5a.jpg", th+"6a.jpg", th+"6b.jpg", th+"7a.jpg", th+"7b.jpg", th+"8a.jpg", 
			th+"8b.jpg", th+"9a.jpg",th+"9b.jpg", th+"9c.jpg", th+"10a.jpg"};
	// holds the images that have been randomly selected to appear
	private String[] newImages;
	// holds the answers to the images that have been randomly selected
	private int[] newRight;
	// holds the current amount of points earned in this level
	private int point; 
	// holds whether this is the first time playing the question or not
	private boolean first = true; 

	/* Starts the level 3 game
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Level3 (Group root, Scene scene, Stage stage)
	{
		point = 0;
		newImages = randomize (10, images, right);
		level3 (root, scene, stage);
	}

	/* Creates a game of level 3
	 *  
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public void level3 (Group root, Scene scene, Stage stage)
	{
		int temp;
		Text txt = new Text (850, 25, "");
		current ++;
		if (current <=9 )
		{
			first = true;
			Image image = new Image(newImages[current]);
			ImageView iv1 = new ImageView();
			iv1.setImage(image);
			iv1.setPreserveRatio (true);
			iv1.setSmooth(true);
			iv1.setCache(true);
			Rectangle rect1 = new Rectangle (); // creates a new rectangle object
			rect1.setX(164);
			rect1.setY(341);
			rect1.setWidth(167);
			rect1.setHeight(155);
			rect1.setFill(Color.TRANSPARENT);
			Rectangle rect2 = new Rectangle (); // creates a new rectangle object
			rect2.setX(354);
			rect2.setY(341);
			rect2.setWidth(167);
			rect2.setHeight(155);
			rect2.setFill(Color.TRANSPARENT);
			Rectangle rect3 = new Rectangle (); // creates a new rectangle object
			rect3.setX(544);
			rect3.setY(341);
			rect3.setWidth(167);
			rect3.setHeight(155);
			rect3.setFill(Color.TRANSPARENT);
			stage.setScene(scene);
			ProgressBar progress = new ProgressBar(); // creates a new progressbar object
			Label lab = new Label("Time Left:"); // creates a new label object
			Timeline timeline = new Timeline( 
					new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
					new KeyFrame(Duration.millis(20000), e-> { 
						wrong (root, scene, stage);
					}, new KeyValue(progress.progressProperty(), 1))    
					);
			EventHandler <MouseEvent> eventHandler1 = new EventHandler <MouseEvent>() {  // creates a new eventhandler if the question is correct		       
				@Override 
				public void handle(MouseEvent e) { 
					if (first == true)
					{
						point +=10;
						timeline.stop();
						first = false; 
						right (root, scene, stage);
					}
				} 
			};  
			EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { // creates a new eventhandler if the question is incorrect
				@Override 
				public void handle(MouseEvent e) { 
					if (first == true)
					{
						wrong (root, scene, stage);
						timeline.stop();
						first = false;
					}
				} 
			};  
			if (newRight[current] == 1) // adds eventfilters if the first option is correct
			{
				rect1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
				rect2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
				rect3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
			}
			else if (newRight[current] == 2) // adds eventfilters if the second option is correct
			{
				rect1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
				rect2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
				rect3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
			}
			else // adds eventfilters if the third option is correct
			{
				rect1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
				rect2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
				rect3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
			}
			txt.setFont(Font.font ("Calibri", 17));
			temp = EnterInfo.u.getPoints() + point;
			txt.setText("Points: " + temp);
			timeline.setCycleCount(1);
			timeline.play();
			GridPane doot = new GridPane(); // creates a new gridpane object
			doot.setAlignment(Pos.TOP_LEFT);
			doot.setPadding(new Insets(10));
			doot.setHgap(10);
			doot.add(lab, 0, 1);
			doot.add(progress, 1, 1);
			progress.setPrefWidth(760);
			stage.show();
			root.getChildren().addAll(iv1,rect1,rect2,rect3, doot, txt);
			stage.setScene(scene);
			stage.sizeToScene(); 
			stage.show();
		}
		else 
		{
			if (point <= 50)
			{
				new Lost (root, scene, stage, Level2.tutorial3, 3.5);
			}
			else
			{
				EnterInfo.u.addPoints(point);
				new EndingScene (root, scene, stage);
			}
		}
	}

	/* randomizes the foods that appear on each level.
	 * 
	 * @param count 	Holds the amount of foods to create an array of
	 * @param orign		Holds the original array of foods to be randomly selected from
	 */
	private String[] randomize (int count, String [] orign, int [] right)
	{
		int [] arr = new int [count];
		String [] newFood = new String [count];
		newRight = new int [count];
		int temp = 0;
		int counter = 0, c = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
			while (true)
			{
				temp = (int) (Math.random () * orign.length -1); // randomly creates a number
				for (int k = 0 ; k < count; k++)
				{
					if (temp == arr [k])
					{
						break;
					}
					else if (temp != arr [k])
					{
						counter++;
					}
				}
				if (counter == 10)
				{
					break;
				}
				counter = 0;
			}
			arr [c] = temp;
			c++;
			counter = 0;
		}
		for (int a = 0; a < 10; a ++) 
		{
			newFood [a]= orign[arr[a]];
			newRight [a] = right [arr[a]];
		}
		return newFood; 
	}

	/* Outputs a message if the answer is wrong
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void wrong (Group root, Scene scene, Stage stage)
	{
		ImageView iv = new ImageView(); // creates a new imageview
		Image image2 = new Image("WRONG.png"); // creates an image
		iv.setImage(image2);
		iv.setX(250);
		iv.setY(100);
		PauseTransition pt = new PauseTransition(); // creates a pausetransition
		pt.setDuration(new Duration(2000));
		pt.setOnFinished(e ->
		{
			level3 (root, scene, stage);
		});
		FadeTransition ft = new FadeTransition();
		ft.setNode(iv);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.play(); // plays a fadetransition
		root.getChildren().add(iv);
		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
		pt.play(); // plays a pausetransition

	}

	/* Outputs a message if the answer is correct
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void right (Group root, Scene scene, Stage stage)
	{
		ImageView iv = new ImageView(); // creates a new imageview
		Image image2 = new Image("RIGHT.png"); // creates a new image
		iv.setImage(image2);
		iv.setX(250);
		iv.setY(100);
		PauseTransition pt = new PauseTransition(); // creates a pausetransition
		pt.setDuration(new Duration(2000));
		pt.setOnFinished(e ->
		{
			level3 (root, scene, stage);
		});
		FadeTransition ft = new FadeTransition(); // creates a fadetransition
		ft.setNode(iv);
		ft.setDuration(new Duration(2000));
		ft.setFromValue(1.0);
		ft.setToValue(0.0);
		ft.setCycleCount(1);
		ft.play(); // plays a fadetransition
		root.getChildren().add(iv);
		stage.setScene(scene);
		stage.sizeToScene(); 
		stage.show();
		pt.play(); // plays a pausetransition

	}


}
