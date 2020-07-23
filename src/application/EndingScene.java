/**
 * 
 */
package application;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/** Displays the end of the story to the user 
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 1 hour
 * 
 */
public class EndingScene {
 //counter for the index of the array
 int counter = 1; 
 //picture file names for the ending scenes
 String [] images = {"Signals.jpg", "FinalScreen.jpg", "Certificate.jpg"};
 //image to be displayed
 private Image image;
 //text for the name of the user to be displayed on the certificate
 Text name = new Text (275, 300, "");
 //text for number of points the user ended with, to be displayed on the certificate
 Text endPoints = new Text (522, 505, "");

 /* Displays ending scene images
  * 
  * @param root  Groups each object together on the screen
  * @param scene Holds the current scene on the screen
  * @param stage Holds the stage for all objects to be outputed on 
  */
 public EndingScene (Group root, Scene scene, Stage stage)
 {
  addHighScore();
  image = new Image ("Signals.jpg");
  ImageView iv = new ImageView();
  iv.setImage(image);
  iv.setFitWidth(960);
  iv.setFitHeight(677);

  Button button = new Button ("Continue");
  button.setPrefHeight(50);
  button.setPrefWidth(140);
  button.relocate(410,560);
  button.setStyle("-fx-font: 20 arial; -fx-base: #e2f0fd; ");
  button.setOnAction(new EventHandler<ActionEvent>() { //adds an event handler to the "continue" button
   @Override
   public void handle(ActionEvent event) {
    if (counter >= images.length) {
     new IntroScreen(root, scene, stage); //calls intro screen
    }
    else
    {
     image = new Image (images[counter]);
     if (counter == 2) { //if the image being displayed is the certificate
      name.setText(EnterInfo.u.getName());
      name.setFont(Font.font ("Verdana", 50));
      name.setX(480-(15*(EnterInfo.u.getName().length())));
      endPoints.setText(EnterInfo.u.getPoints()+"");
      endPoints.setFont(Font.font("Cambria", 24));

     }
     counter++;

     iv.setImage(image);
     iv.setPreserveRatio (true);
     iv.fitWidthProperty().bind(stage.widthProperty());
    }
   }
  });
  root.getChildren().addAll(iv, button, name, endPoints);
  stage.setScene(scene);
  stage.sizeToScene();
  stage.show();
 }

 //write's the user's high score to the high scores text file
 public void addHighScore()
 {
  BufferedReader in;
  PrintWriter out;
  int count = 0;
  int holdInt = 0;
  String hold;
  try // first try block
  {
   in = new BufferedReader (new FileReader ("highScores.txt"));
   while (in.readLine () != null) // first while loop
   {
    count ++;
   }
  }
  catch (IOException e)
  {
  }
  count /= 2;
  count ++;
  String arr[] [] = new String [count] [2];
  try // second try block
  {
   in = new BufferedReader (new FileReader ("highScores.txt"));
   for (int b = 0 ; b < count ; b++) // first for loop
   {
    for (int a = 0 ; a < 2 ; a++) // second for loop
    {
     arr [b] [a] = in.readLine ();
    }
   }
   arr [count - 1] [0] = EnterInfo.u.getName();;
   arr [count - 1] [1] = EnterInfo.u.getPoints() + "";
   in.close ();
  }
  catch (IOException e)
  {
  }
  for (int d = 1 ; d < count ; d++) // third for loop
  {
   for (int e = 0 ; e < count - 1 ; e++) // fourth for loop
   {
    if (Integer.parseInt (arr [e] [1]) < Integer.parseInt (arr [e + 1] [1])) // second if statement
    {
     holdInt = Integer.parseInt (arr [e] [1]);
     arr [e] [1] = arr [e + 1] [1];
     arr [e + 1] [1] = holdInt + "";
     hold = arr [e] [0];
     arr [e] [0] = arr [e + 1] [0];
     arr [e + 1] [0] = hold;
    }
   }
  }
  if (count > 10) // third if statement
  {
   count = 10;
  }
  try // third try block
  {
   out = new PrintWriter (new FileWriter ("highScores.txt"));
   for (int w = 0 ; w < count ; w++) // fifth for loop
   {
    for (int p = 0 ; p < 2 ; p++) // sixth for loop
    {
     out.println (arr [w] [p]);
    }
   }
   out.close ();
  }
  catch (IOException e)
  {
  }
 }

}
