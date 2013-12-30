/**
 * @author Lulu Ye
 * @author Victoria Brown
 * LAST MODIFIED: 12/15/12
 * CS 230 FINAL PROJECT 
 * MealPerDay.java
 **/

import java.util.*;

public class MealPerDay {
    //instance variables
    private LinkedList<Meal> meals;
    private String day;
    

    /**
     * Constructs a new MealPerDay object that has a day and a LinkedList
     * Meal objects called meals
     *
     * @param meals, a LinkedList of Meal objects, representing the day's 
     * collection of meals.
     * @param day, a String day identifying the meal
     */
    public MealPerDay(LinkedList<Meal> meals, String day) {
	//constructor: assigns the LinkedList<Meal> meals
	//instance variable meals, and the day given to the
	//instance variable day
	this.meals = meals;
	this.day = day;
    }


    /**
     * A second constructors that constructs a new MealPerDay object with only 
     * day parameter.
     * 
     * @param day, a String day identifying the meal
     */
    public MealPerDay(String day) {
	this.meals = new LinkedList<Meal>();
	this.day = day;
    }


    /**
     * Adds a meal to the LinkedList of meals
     *
     * instance method
     * @param m
     */
    public void addMeal(Meal m) {
	//adds a meal to the LinkedList<Meal> meals
	meals.add(m);
    }


    /**
     * Retrieves the meals during a given time, ie 'breakfast'
     * for that day.
     *
     * instance method
     * @param mealName, the name of the meal wanted
     * @return Meal, the meal for the mealName given.
     */ 
    public Meal getMeal(String mealName) {
	// The method loops through the instance variable LinkedList<Meal> meals 
	// for the matching name of the meal. 
	// If the meal does not exist, the method returns null.
	mealName = mealName.toLowerCase();

	Meal meal = null;
	Boolean found = false;

	for (int i = 0; i < meals.size(); i++) { //starts at 1 because of the way our LinkedList
	    //has a null item for the first thing, which messes up our subsequent getMeal method

	    String name = meals.get(i).getName().toLowerCase();

	    if (name.contains(mealName)) {
		meal = meals.get(i);
		found = true;
	    }
	}
	
	if (found == false){
	    Meal m = new Meal ("Meal Not Found");
	    Food f = new Food("Menu Data Unavailable");
	    m.addFood(f);
	    meal = m;
	}

	return meal;
	
    }


    /**
     * A string representation of MealPerDay
     *
     * instance method
     * @return a String representation
     */
    public String toString() {
	//String method

	String s = "****" + day + "**** ";
	s += meals.toString();
	return s;
    }


    /*
    //testing method for MealPerDay
    public static void main (String [] args) {

	//let's get some meals
	
	//making breakfast
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

	System.out.println("Breakfast!" + myBreakfast); 


	//making lunch
	Food pizza = new Food("pizza");
	Food fries = new Food("fries");
	Food milk = new Food("milk");

	Meal myLunch = new Meal("lunch", "11-2");
	myLunch.addFood(pizza);
	myLunch.addFood(fries);
	myLunch.addFood(milk);
	myLunch.addFood(fruit);

	System.out.println("Lunch!" + myLunch);

	//making a meal per day

	MealPerDay monday = new MealPerDay("Monday");
	monday.addMeal(myBreakfast);
	System.out.println(monday);
	
	monday.addMeal(myLunch);
	System.out.println(monday);

	System.out.println(monday.getMeal("breakfast"));
	System.out.println(monday.getMeal("brunch"));
	
       

    }
*/

}