/**
 * @author Victoria Brown
 * @author Lulu Ye
 * LAST MODIFIED: 12/8/12
 * CS 230 FINAL PROJECT 
 * Meal.java
 */

import java.util.*;

public class Meal{
    //instance variables
    private LinkedList<Food> foods;
    private String name;
    private String times;

    /**
     * Constructs a new Meal instance with a name, a list of foods
     * and a time when the meal is served, ie breakfast, lunch, dinner
     *    
     * @param foods, a LinkedList of foods for the meal
     * @param name, a String name for the meal, ie Breakfast
     * @param time, a String time for the meal, ie "9AM - 2 PM"
     */
    public Meal(LinkedList<Food> foods, String name, String time){
	this.foods = foods;
	this.name = name;
	this.times = time;
    }

    /**
     * Constructs a new Meal instance with just a name and time. Creates a 
     * new blank list of foods
     *
     * @param name, a String name for the meal
     * @param time, a String time for the meal, ie Breakfast
     */
    public Meal(String name, String time){
	foods = new LinkedList<Food>();
	this.name = name;
	this.times = time;
    }
 
    /**
     * Constructs a new Meal instance with just a name. Creates a 
     * new blank list of foods and no time
     *
     * @param name, a String name for the meal
     */
   public Meal(String name){
       	foods = new LinkedList<Food>();
	this.name = name;
	this.times = "";
     }

   /**
     * Constructs a new Meal instance with a name and linked List of foods
     * no time is given
     *
     * @param name, a String name for the mea
     * @param f, a LinkedList of foods for the meal
     */

    public Meal(String name, LinkedList<Food> f){
       	foods = f;
	this.name = name;
	this.times = "";
   }






    /**
     * Adds a new food to the LinkedList of meals
     *
     * instance method
     * @param food to be added to the list
     */
    public void addFood(Food f){
	foods.add(f);
    }

    /**
     * Retrieve the time when this meal is served
     *
     * instance method
     * @return the specific meal time
     */
    public String getTimes(){
	return times;
    }
    
    /**
     * Retrieve the name of the meal
     *
     * instance method
     * @return  name, String name of this meal
     */
    public String getName(){
	return name;
    }

    /**
     * Remove a food from the meal
     *
     * instance method
     * @param food to be removed
     */
    public void removeFood(Food f){
	foods.remove(f);
    }

    /**
     * Retrieves the foods marked "true" for vegetarian in
     * a new LinkedList<Food> meals
     *
     * instance method
     * @return LinkedList<Food> of vegetarian options
     */
    public LinkedList<Food> getVegetarian() {
	//goes through the instance variable foods
	// and creates and returns a new LinkedList<Food>
	//of vegetarian foods. Constructive method.

	LinkedList<Food> vegFoods = new LinkedList<Food>();
	
	for (int i = 0; i < foods.size(); i++) {
	    if (foods.get(i).isVeg()) { 
		//if the food is vegetarian then add it
		//to the LinkedList<Food> vegFood
		vegFoods.add(foods.get(i));
	    }
	}
       
	return vegFoods;
    }
    
    /**
     * returns the LinkedList<Food> of the meal
     *
     * @return LinkedList<Food> meal
     */
    public LinkedList<Food> getMeal() {
	return foods;
    }

    /**
     *
     *
     */
    public boolean isEmpty() {
	return foods.isEmpty();
    }


    /**
     * A String representation of the meal, returns a vertical list of 
     * the foods line by line
     *
     * instance method
     * @return String representing the meal
     */
    public String toString(){
	//	String s = getName() + ": ";
	String s = foods.toString();

	/*	for(int i = 0; i < foods.size(); i++){
	    s = s + foods.get(i) + "\n";
	}
	*/

	return s;
    }


       
    //A main method
    //for testing purposes only
    //to get vegetarian and the methods to work properly
    public static void main(String[] args) {
	//let's get some food

	Food coffee = new Food("coffee");
	Food bagel = new Food("bagel");
	Food fruit = new Food("fruit");
	Food broccoli = new Food("broccoli");
	fruit.setVeg();
	broccoli.setVeg();

	

	Meal myBreakfast = new Meal("breakfast", "7-10");
	myBreakfast.addFood(coffee);
	myBreakfast.addFood(bagel);
	myBreakfast.addFood(fruit);
	myBreakfast.addFood(broccoli);

	System.out.println(myBreakfast);

	myBreakfast.removeFood(bagel);
       	System.out.println(myBreakfast);

	System.out.println(myBreakfast.getVegetarian());




    }
    


}