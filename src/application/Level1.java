/**
 * 
 */
package application;

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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Displays the first level game
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 3 hours
 * 
 */
public class Level1 {

	// holds the amount of foods to randomize
	private int count;
	// holds the original array of foods to be randomized
	public static Food [] foods;
	// holds the new foods that have been randomized
	private Food [] newFood; 
	// holds the amount of points earned in this level
	private int point;
	// holds a string of pictures for the second level tutorial
	public static String [] tutorial2;
	private boolean first = true;

	/* Creates an array of food objects
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Level1 (Group root, Scene scene, Stage stage)
	{
		point = 0;
		count = 10;
		foods = new Food [26];
		foods [0] = new Food ("Milk", "Almond Milk", "ALMONDMILK.png", "ALMONDMILK2.png", "1/2 cup", 0.5);
		foods [1] = new Food ("Grain", "Bagel", "BAGEL.png", "BAGEL2.png","1 bagel", 2);
		foods [2] = new Food ("Fruits", "Banana", "BANANA.png", "BANANA2.png","1/2 cup", 1);
		foods [3] = new Food ("Grain", "Bread", "BREAD.png", "BREAD2.png","1 slice", 1);
		foods [4] = new Food ("Fruits", "Carrot", "CARROT.png","CARROT2.png", "1/2 cup", 1);
		foods [5] = new Food ("Grain", "Cereal", "CEREAL.png","CEREAL2.png", "3/4 cup", 1);
		foods [6] = new Food ("Milk", "Cheese", "CHEESE.png", "CHEESE2.png", "1/2 cup", 2);
		foods [7] = new Food ("Meat", "Chicken", "CHICKEN.png","CHICKEN2.png", "1/4 cup", 0.5);
		foods [8] = new Food ("Meat", "Eggs", "EGG.png","EGG2.png", "2 eggs", 1);
		foods [9] = new Food ("Fruits", "Juice", "JUICE.png","JUICE2.png", "1/2 cup", 1);
		foods [10] = new Food ("Fruits", "Kiwi", "KIWI.png", "KIWI2.png","1/2 cup", 1);
		foods [11] = new Food ("Milk", "Milk", "MILK.png","MILK2.png", "2 cups", 2);
		foods [12] = new Food ("Fruits", "Orange", "ORANGE.png","ORANGE2.png", "1 1/2 cups", 3);
		foods [13] = new Food ("Meat", "Peanut Butter", "PEANUT BUTTER.png",  "PEANUT BUTTER2.png","1 tbsp", 0.5);
		foods [14] = new Food ("Meat", "Peanuts", "PEANUT.png", "PEANUT2.png","1/4 cup", 2);
		foods [15] = new Food ("Fruits", "Pear", "PEAR.png", "PEAR2.png","2 cups", 4);
		foods [16] = new Food ("Fruits", "Pepper", "PEPPER.png",  "PEPPER2.png","1 cup", 1);
		foods [17] = new Food ("Fruits", "Pumpkin", "PUMPKIN.png",  "PUMPKIN2.png","1/2 cup", 1);
		foods [18] = new Food ("Grain", "Rice", "RICE.png", "RICE2.png", "1 cup", 2);
		foods [19] = new Food ("Grain", "Spaghetti", "SPAGHETTI.png", "SPAGHETTI2.png", "1/2 cup", 1);
		foods [20] = new Food ("Fruits", "Strawberry", "STRAWBERRY.png",  "STRAWBERRY2.png","1 cup", 2);
		foods [21] = new Food ("Meat", "Tofu", "TOFU.png", "TOFU2.png","1 1/2 cup", 2);
		foods [22] = new Food ("Fruits", "Tomato", "TOMATO.png","TOMATO2.png", "1 cup", 2);
		foods [23] = new Food ("Meat", "Meats", "VARIOUSMEAT.png","VARIOUSMEAT2.png", "1 cup", 2);
		foods [24] = new Food ("Fruits", "Watermelon", "WATERMELON.png",  "WATERMELON2.png", "1 1/2 cups", 3);
		foods [25] = new Food ("Milk", "Yogurt", "YOGURT.png", "YOGURT2.png","3/4 cup", 1);
		newFood = randomize (count, foods);
		level1 (root, scene, stage);
	}

	/* randomizes the foods that appear on each level.
	 * 
	 * @param count 	Holds the amount of foods to create an array of
	 * @param orign		Holds the original array of foods to be randomly selected from
	 */
	private Food[] randomize (int count, Food [] orign)
	{
		int [] arr = new int [count];
		Food [] newFood = new Food [count];
		int temp = 0;
		int counter = 0, c = 0;
		for (int i = 0 ; i < 10 ; i++)
		{
			while (true)
			{
				temp = (int) (Math.random () * orign.length);
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
			newFood[a] = new Food (orign[arr[a]].getFoodGroup(), orign[arr[a]].getName(), orign[arr[a]].getPicture(),
					orign[arr[a]].getLevel2Pic(), orign[arr[a]].getAmount(), orign[arr[a]].getServings());
		}
		return newFood; 
	}


	/* Creates the first game screen that allows the user to classify food groups 
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void level1 (Group root, Scene scene, Stage stage)
	{ 
		Text txt = new Text (590, 25, "");
		int temp = 0; 
		count --; 
		if (count < 0)
		{
			if (point >= 60 && point <= 100)
			{
				EnterInfo.u.addPoints(point);
				tutorial2 = new String [9];
				for (int i = 0; i < tutorial2.length; i++) {
					tutorial2[i] = "2"+ Character.toString((char)(i+97)) + ".jpg";
				}
				if (EnterInfo.u.getAge().equals("4-8 years old")) {
					tutorial2[3] = "2d4-8.jpg";
				}
				else {
					tutorial2[3] = "2d9-13.jpg";
				}
				new Tutorials(root, scene, stage, tutorial2);
			}
			else
			{
				new Lost (root, scene, stage, EnterInfo.tutorial1);
			}
		}
		else
		{
			Image d = new Image (newFood[count].getPicture());
			first = true;
			Image image = new Image ("LEVEL1GAME.jpg");
			ImageView iv = new ImageView();
			iv.setImage(image);
			iv.setPreserveRatio (true);
			root.getChildren().add(iv);
			ImageView f = new ImageView();
			f.setX(180);
			f.setY(100);
			f.setImage(d);
			stage.setScene(scene);
			root.getChildren().add(f);
			ProgressBar progress = new ProgressBar();
			Label lab = new Label("Time Left:"); 
			Timeline timeline = new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(progress.progressProperty(), 0)),
					new KeyFrame(Duration.millis(10000), e-> {
						wrong (root, scene, stage);
					}, new KeyValue(progress.progressProperty(), 1))    
					);
			timeline.setCycleCount(1);
			timeline.play();
			GridPane doot = new GridPane();
			doot.setAlignment(Pos.TOP_LEFT);
			doot.setPadding(new Insets(10));
			doot.setHgap(10);
			doot.add(lab, 0, 1);
			doot.add(progress, 1, 1);
			progress.setPrefWidth(500);
			txt.setFont(Font.font ("Calibri", 17));
			temp = EnterInfo.u.getPoints() + point; 
			txt.setText("Points: " + temp);
			root.getChildren().addAll(doot, txt);
			stage.show();
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					if (first == true)
					{
						switch (event.getCode()) {
						case F: 
							if (newFood[count].getFoodGroup().equals("Fruits"))
							{
								point+=10;

								right (root, scene, stage);
							}
							else 
							{
								wrong (root, scene, stage); 

							}
							timeline.stop();
							first = false;
							break;
						case G:
							if (newFood[count].getFoodGroup().equals("Grain"))
							{
								point+=10;
								right (root, scene, stage); 
							}
							else 
							{
								wrong (root, scene, stage); 
							}
							timeline.stop();
							first = false;
							break;
						case D:
							if (newFood[count].getFoodGroup().equals("Milk"))
							{
								point+=10;
								right (root, scene, stage); 
							}
							else 
							{
								wrong (root, scene, stage); 
							}
							timeline.stop();
							first = false;
							break;
						case S:
							if (newFood[count].getFoodGroup().equals("Meat"))
							{
								point+=10;
								right (root, scene, stage); 
							}
							else 
							{
								wrong (root, scene, stage); 
							}
							timeline.stop();
							first = false;
							break;
						default:
							System.out.println("asdf");
							break;
						}
					}
				}
			});

		}

	}

	/* Outputs a message if the answer is wrong
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void wrong (Group root, Scene scene, Stage stage)
	{
		if (count >=0)
		{
			ImageView iv = new ImageView();
			Image image2 = new Image("WRONG.png");
			iv.setImage(image2);
			iv.setX(100);
			iv.setY(100);
			PauseTransition pt = new PauseTransition();
			pt.setDuration(new Duration(2000));
			pt.setOnFinished(e ->
			{
				level1 (root, scene, stage);
			});
			FadeTransition ft = new FadeTransition();
			ft.setNode(iv);
			ft.setDuration(new Duration(2000));
			ft.setFromValue(1.0);
			ft.setToValue(0.0);
			ft.setCycleCount(1);
			ft.play();
			root.getChildren().add(iv);
			stage.setScene(scene);
			stage.sizeToScene(); 
			stage.show();
			pt.play();
		}
	}

	/* Outputs a message if the answer is correct
	 * 
	 * @param root 	Groups each object together on the screen
	 * @param scene Holds the current scene on the screen
	 * @param stage Holds the stage as a platform for output
	 */
	public void right (Group root, Scene scene, Stage stage)
	{
		if (count >= 0)
		{
			ImageView iv = new ImageView();
			Image image2 = new Image("RIGHT.png");
			iv.setImage(image2);
			iv.setX(100);
			iv.setY(100);
			PauseTransition pt = new PauseTransition();
			pt.setDuration(new Duration(2000));
			pt.setOnFinished(e ->
			{
				level1 (root, scene, stage);
			});
			FadeTransition ft = new FadeTransition();
			ft.setNode(iv);
			ft.setDuration(new Duration(2000));
			ft.setFromValue(1.0);
			ft.setToValue(0.0);
			ft.setCycleCount(1);
			ft.play();
			root.getChildren().add(iv);
			stage.setScene(scene);
			stage.sizeToScene(); 
			stage.show();
			pt.play();
		}
	}


}
