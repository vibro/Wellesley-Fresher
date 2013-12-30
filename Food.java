/**
 * @author Victoria Brown
 * @author Lulu Ye
 * LAST MODIFIED: 11/30/12
 * CS 230 FINAL PROJECT 
 * Food.java
 */

public class Food {
    
    private String name;
    private boolean veg;

    /**
     * Constructor that creates a new Food object with a name and a 
     * false vegetarian status
     *
     * @param name a String representation of the food
     */
    public Food(String name){
	this.name = name;
	this.veg = false;
    }


    /**
     * Returns the string represntation of the food
     *
     * instance method
     * @return String the name of the food
     */    
    public String getName(){
	return name;
    }


    /**
     * Tests to see if a food is labeled vegetarian
     *
     * @return true if it is a vegetarian food
     */
    public boolean isVeg(){
	return veg;
    }
    

    /**
     * Sets a food to vegetarian
     */
    public void setVeg(){
	veg = true;
    }


    /**
     * Tests if a food is equal to another by comparing their names
     * Vegetarian status is not considered
     *
     * @return true if the food names are the same
     */
    public boolean isEqual(Food f){
	return (name.equals(f.getName()));
    }


    /**
     * A string representation of the food. If the food is vegetarian,
     * a (V) is added to the string
     *
     * instance method
     * @return String representation of the food
     */
    public String toString(){
	String s = name;

	if(isVeg()){
	    s = s + " (V)";
	}

	return s;
    }

}