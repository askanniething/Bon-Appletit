/**
 * 
 */
package application;

/** This program represents a user in the game Bon Appletit
 * @version 5
 * @author Grace Xu and Annie Chen
 * Due date: June 8th, 2018
 * Time Spent: 20 minutes
 * 
 */
public class User {
	//age range of the user
	private String age;
	//level that the user is on
	private String level;
	//user name
	private String name;
	//number of points the user has
	private  int points;

	/* User class constructor
	 * 
	 * @param a The age of the user
	 * @param l The level the user is on
	 * @param n The name of the user
	 */
	public User (String a, String l, String n) {
		this.age = a;
		this.level = l;
		this.name = n;
	}

	/* Accessor method that returns the value of age
	 * 
	 * @return the value of age
	 */
	public String getAge() {
		return age;
	}

	/* Accessor method that returns the value of level
	 * 
	 * @return the value of level
	 */
	public String getLevel() {
		return level;
	}

	/* Accessor method that returns the value of name
	 * 
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}

	/* Accessor method that returns the value of points
	 * 
	 * @return the value of points
	 */
	public int getPoints() {
		return points;
	}

	/* Mutator method to set the value of age
	 * 
	 * @param a The value of age to be set
	 */
	public void setAge(String a) {
		this.age = a;
	}

	/* Mutator method to set the value of level
	 * 
	 * @param l The value of level to be set
	 */
	public void setLevel(String l) {
		this.level = l;
	}

	/* Mutator method to set the value of name
	 * 
	 * @param n The value of name to be set
	 */
	public void setName (String n) {
		this.name = n;
	}

	/*increment the user's points by 10
	 */
	public void increment () {
		points +=10; 
	}

	/*Add the specified number of points to the user's points
	 * 
	 * @param poin The number of points to add
	 */
	public void addPoints (int poin) {
		points += poin;
	}

	/* Mutator method to set the value of points
	 * 
	 * @param poin The value of points to be set
	 */
	public void setPoints (int poin) {
		points = poin; 
	}

}
