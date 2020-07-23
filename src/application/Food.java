/**
 * 
 */
package application;

/** This program represents a food in the game Bon Appletit
 * 
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 45 minutes
 * */

public class Food {
 //food group that the food belongs into
 private String foodGroup;
 //name of the food
 private String name;
 //picture file name of the food
 private String picture;
 //picture file name of food in level 2
 private String level2Pic;
 //amount of the food in picture
 private String amount;
 //number of servings in picture
 private double servings;


 /*Constructor of the Food class which assigns the values passed in to the private instance variables
  * 
  * @param group The food group that the food belongs into
  * @param n The name of the food
  * @param pic The picture file of the food
  * @param l2 The picture file of the food in level 2
  * @param a The amount amount of food in the picture 
  * @param s The amount of the food for one serving
  */
 public Food(String group, String n, String pic, String l2, String a, double s) {
  this.foodGroup = group;
  this.name= n;
  this.picture = pic;
  this.level2Pic = l2;
  this.amount= a;
  this.servings = s;
 }



 /* Accessor method that returns the value of foodGroup
  * 
  * @return the value of foodGroup
  */
 public String getFoodGroup() {
  return foodGroup;
 }

 /* Accessor method that returns the value of name
  * 
  * @return the value of name
  */
 public String getName() {
  return name;
 }

 /* Accessor method that returns the value of picture
  * 
  * @return the value of picture
  */
 public String getPicture() {
  return picture;
 }

 /* Accessor method that returns the value of level2Pic
  * 
  * @return the value of level2Pic
  */
 public String getLevel2Pic () {
  return level2Pic;
 }

 /* Accessor method that returns the value of amount
  * 
  * @return the value of amount
  */
 public String getAmount() {
  return amount;
 }

 /* Accessor method that returns the value of servings
  * 
  * @return the value of servings
  */
 public double getServings() {
  return servings;
 }


}
