/**
 * 
 */
package application;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/** Displays the second level game
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 3 hours
 * 
 */
public class Level2 {

	// holds the new foods that have been randomized
	private Food [] newFood;
	// holds the number of fruit and vegetable servings that have been selected
	private double fruits;
	// holds the number of meat and alternative servings that have been selected
	private double meats;
	// holds the number of milk and alternative servings that have been selected
	private double milks;
	// holds the number of grain product servings that have been selected
	private double grains;
	// holds the current food image that is displayed to the screen
	private int countFood = 0; 
	// holds the amount of points earned in this level
	private int points;
	// holds a string list of tutorial images to be displayed in level 3
	public static String[] tutorial3;
	// determines whether this is the first time the level is being played 
	private boolean first = true; 

	/* Starts the level 2 gameplay
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public Level2 (Group root, Scene scene, Stage stage)
	{
		fruits = 0;
		grains = 0;
		milks = 0;
		meats = 0;
		points = 0;
		newFood = randomize (26, Level1.foods);
		level2(root, scene, stage);
	}



	/* randomizes the foods that appear on each level.
	 * 
	 * @param count 	Holds the amount of foods to create an array of
	 * @param orign		Holds the original array of foods to be randomly selected from
	 */
	private Food [] randomize (int count, Food [] orign)
	{
		for (int i = 0; i < 26; i ++)
		{
			int first = (int) (Math.random() * 26); // chooses the first food to swap
			int second = (int) (Math.random() * 26); // chooses the second food to swap
			Food temp = new Food (orign[first].getFoodGroup(), orign[first].getName(), orign[first].getPicture(), // swaps food
					orign[first].getLevel2Pic(), orign[first].getAmount(), orign[first].getServings());
			orign [first] = new Food (orign[second].getFoodGroup(), orign[second].getName(), orign[second].getPicture(),
					orign[second].getLevel2Pic(), orign[second].getAmount(), orign[second].getServings());
			orign [second] = new Food (temp.getFoodGroup(), temp.getName(), temp.getPicture(),
					temp.getLevel2Pic(), temp.getAmount(), temp.getServings());
		}

		return orign; 
	}

	/* Holds the main gameplay of level 2
	 * 
	 * @param root 		Groups each object together on the screen
	 * @param scene 	Holds the current scene on the screen
	 * @param stage 	Holds the stage as a platform for output
	 */
	public void level2 (Group root, Scene scene, Stage stage)
	{
		tutorial3 = new String [10];
		for (int i = 0; i < tutorial3.length;i++) {
			tutorial3[i] = "3"+ Character.toString((char)(i+97)) + ".jpg";
		}
		if (countFood <= newFood.length -1)
		{
			Image d = new Image (newFood[countFood].getLevel2Pic()); // creates the current food image
			Image image = new Image ("LEVEL2GAME.jpg");
			ImageView iv = new ImageView();
			iv.setImage(image);
			iv.setPreserveRatio (true);
			root.getChildren().add(iv);
			ImageView f = new ImageView();
			f.setY(232);
			f.setX(260);
			if (newFood[countFood].getLevel2Pic().equals("BAGEL.png"))
			{
				f.setX(150);
				f.setY(220);
			}
			f.setImage(d);
			fruits = Math.round(fruits*100.0)/100.0; // outputs number of fruit servings
			grains = Math.round(grains*100.0)/100.0;
			milks = Math.round(milks*100.0)/100.0;
			meats = Math.round(meats*100.0)/100.0;
			Text fAndV = new Text(226, 112, fruits+"");
			fAndV.setFont(Font.font ("Verdana", 17));
			Text g = new Text (195, 135, grains+"");
			g.setFont(Font.font ("Verdana", 17));
			Text mk = new Text (248, 158, milks+"");
			mk.setFont(Font.font ("Verdana", 17));
			Text mt = new Text (259, 183, meats+"");
			mt.setFont(Font.font ("Verdana", 17));
			stage.setScene(scene);
			root.getChildren().addAll(f, fAndV, g, mk, mt);
			stage.show();
			stage.setScene(scene);
			stage.show();
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					switch (event.getCode()) {
					case Y: // if the key y is pressed, to keep the food
						if (newFood[countFood-1].getFoodGroup().equals("Fruits"))
						{
							fruits += newFood [countFood-1].getServings();
							level2 (root, scene, stage);
						}
						else if (newFood[countFood-1].getFoodGroup().equals("Grain"))
						{
							grains += newFood [countFood-1].getServings();
							level2 (root, scene, stage);
						}
						else if (newFood[countFood-1].getFoodGroup().equals("Meat"))
						{
							meats += newFood [countFood-1].getServings();
							level2 (root, scene, stage);
						}
						else 
						{
							milks += newFood [countFood-1].getServings();
							level2 (root, scene, stage);
						}
						break;
					case N: // if the key n is pressed, to dismiss the food
						level2 (root, scene, stage);
						break;
					default:
						break;
					}
				}
			});
			countFood ++;
		}
		else
		{
			if (first == true)
			{
				if (EnterInfo.u.getAge().equals("4-8 years old")) // adds up the food 
				{
					if (fruits == 5)
						points +=2;
					else if (fruits <= 6 && fruits >= 4)
						points ++;
					if (grains == 4)
						points += 2;
					else if (grains <= 5 && grains >= 3)
						points ++;
					if (milks == 2)
						points += 2;
					else if (milks <= 3 && milks >= 1)
						points ++;
					if (meats == 1)
						points +=2;
					else if (meats <=2 && meats >=0)
						points ++;
					if (points >= 6 && points <=8)	
					{
						EnterInfo.u.addPoints(5*points);
						new Tutorials (root, scene, stage, tutorial3);
					}
					else
						new Lost (root, scene, stage, Level1.tutorial2, 2);
				}
				else
				{
					if (fruits == 6) // adds up the food
						points +=2;
					else if (fruits <= 7 && fruits >= 5)
						points ++;
					if (grains == 6)
						points += 2;
					else if (grains <= 7 && grains >= 5)
						points ++;
					if (milks >= 3 && milks <= 4)
						points += 2;
					else if (milks <= 5 && milks >= 2)
						points ++;
					if (meats >= 1 && meats <= 2)
						points +=2;
					else if (meats <=3 && meats >=0)
						points ++;
					if (points >= 6) {
						EnterInfo.u.addPoints(5*points);
						new Tutorials (root, scene, stage, tutorial3);		        	
					}
					else
						new Lost (root, scene, stage, Level1.tutorial2, 2);
				}
				first = false; 
			}
		}
	}

}
