/**
 * @author Victoria Brown
 * @author Lulu Ye
 * LAST MODIFIED: 12/8/12
 * CS 230 FINAL PROJECT 
 * DiningHall.java
 */

import java.util.*;

public class DiningHall{
    
    private String name;
    private MealPerDay[] meals;

    /**
     * Constructs a new Dining hall object that has a name and an array
     * of the meals for the week
     *
     * @param meals, an array of MealPerDay objects, representing the week's
     * menus for the dining hall
     * @param name, a String name for the Dining hall
     */
    public DiningHall(MealPerDay[] meals, String name){
	this.name = name;
	this.meals = meals;
    }


    /**
     * A second constructor. Takes only a name parameter
     * and initializes the meals to a new MealPerDay[] for
     * the meals for the week
     *
     * 
     * @param name, a String name for the Dining hall
     */
    public DiningHall(String name) {
	this.name = name;
	this.meals = new MealPerDay[7];
    }

    /**
     * Retrieves the name of the DiningHall, ie Stone Davis, or Pomeroy
     *
     * instance method
     * @return name, a String for the name of the Dining Hall
     */
    public String getName(){
	return name;
    }

    /**
     * Adds a MealPerDay array to the Dining hall
     *
     * @param meal, a MealPerDay[]
     */
    public void addMealPerDays(MealPerDay[] meal){
	this.meals = meal;
    }
    

    /**
     * Retrieves the meal for the day for the given day
     *   
     * instance method
     * @param day a String for the day for the week
     * @return the MealPerDay for the given day
     */
    public MealPerDay getMealForDay(String day){
	//traverses the array, searching for the meal with the 
	//day header. Returns that meal for the day

	//first, identify the day


	//	MealPerDay m = new MealPerDay(day);
	
	return meals[this.intRepOfDay(day)];
    }


    /**
     * A private helper method that returns an integer
     * that corresponds to a day given.
     * Monday = 0, Tuesday = 1, Wednesday = 2,
     * Thursday = 3, Friday = 4, Saturday = 5, Sunday = 6
     *
     * @param day a String for the day of the week
     * @return int that corresponds to a day
     */
    private int intRepOfDay(String day) {
	String d = day.toLowerCase();

	if (d.equals("monday")) {
	    return 0;
	} else if (d.equals("tuesday")) {
	    return 1;
	} else if (d.equals("wednesday")) {
	    return 2;
	} else if (d.equals("thursday")) {
	    return 3;
	} else if (d.equals("friday")) {
	    return 4;
	} else if (d.equals("saturday")) {
	    return 5;
	} else {
	    return 6;
	}
    }
   

    /**
     * A string representation of the Dining hall
     *
     * instance method
     * @return a String representation
     */
    public String toString(){
	//something will go here
	String s = name+" ";
	for(int i=0;i<meals.length;i++){
	    s = s + meals[i].toString();
	}
	return s;
    }

}
       