/**
 * 
 */
package application;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Displays the high scores to the screen
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 1 hour
 * 
 */
public class HighScores {
 // adds all the high scoring names to the screen
 private Text[] text = new Text [10];
 // adds all the high scores to the screen
 private Text[] scores = new Text [10];
 // adds the place of the user to the screen
 private Text[] number = new Text [10];
 // counts the amount of users who have played the game
 private int count; 

 /* Outputs high scores to the screen
  * 
  * @param root   Groups each object together on the screen
  * @param scene  Holds the current scene on the screen
  * @param stage  Holds the stage as a platform for output
  */
 public HighScores (Group root, Scene scene, Stage stage)
 {
  Image image = new Image ("Highscores.jpg");
  ImageView iv = new ImageView();
  iv.setImage(image);
  iv.setPreserveRatio (true);
  for (int i= 0; i < 10; i ++)
  {
   text [i] = new Text (400 , 100 + i * 20, "");
   text [i].setFont(Font.font ("Calibri", 17)); // sets the text
   scores[i] = new Text (630, 100 + i * 20, "");
   scores[i].setFont(Font.font ("Calibri", 17)); // sets the scores
   number[i] = new Text (300, 100 + i * 20, "");
   number[i].setFont(Font.font ("Calibri", 17)); // sets the number
  }
  BufferedReader in;
  try
  {
   in = new BufferedReader (new FileReader ("highScores.txt")); // accesses the file
   while (in.readLine() != null)
   {
    count ++;
   }
   count /=2;
   in.close();
   in = new BufferedReader (new FileReader("highScores.txt")); // accesses the file
   for (int i = 1 ; i <= count ; i++)
   {    
    number[i-1].setText(i + ".");
    text[i-1].setText (in.readLine());
    scores[i-1].setText(in.readLine());
   }
   in.close();
  }
  catch (IOException e)
  {
  }
  Rectangle rect = new Rectangle (); // creates a new rectangle object
  rect.setX(47);
  rect.setY(183);
  rect.setWidth(179);
  rect.setHeight(80);
  rect.setFill(Color.TRANSPARENT);
  EventHandler <MouseEvent> eventHandler = new EventHandler <MouseEvent>() { // creates an eventhandler
   private PrintWriter out;
   @Override 
   public void handle(MouseEvent e) { 
    for (int i = 0; i < 10; i ++) {
     text [i].setText("");
     scores [i].setText("");
     number [i].setText("");
    }
    try
    {
     out = new PrintWriter (new FileWriter ("highScores.txt"));
     out.println("");
    }
    catch (IOException d)
    {
    }
   } 
  };  
  Rectangle menu = new Rectangle (); // creates a new rectangle object 
  menu.setX(746);
  menu.setY(183);
  menu.setWidth(179);
  menu.setHeight(80);
  menu.setFill(Color.TRANSPARENT);
  EventHandler <MouseEvent> eventHandler2 = new EventHandler <MouseEvent>() { // creates an eventhandler
   @Override 
   public void handle(MouseEvent e) { 
    new IntroScreen(root, scene, stage);
   } 
  };  
  rect.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
  menu.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
  root.getChildren().addAll (iv);
  root.getChildren().addAll (text);
  root.getChildren().addAll (scores);
  root.getChildren().addAll (number);
  root.getChildren().addAll(rect, menu);
  stage.setScene(scene);
  stage.show();
 }
}
