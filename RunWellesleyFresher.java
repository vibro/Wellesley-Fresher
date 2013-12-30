/**
 * @author Victoria Brown
 * @author Lulu Ye
 * LAST MODIFIED: 12/15/12
 * CS 230 FINAL PROJECT 
 * RunWellesleyFresher.java
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class RunWellesleyFresher{

    /**
     * Creates a Dining Hall array by reading in the menu from Wellesley Fresh's webpage
     * Dining halls are in alphabetical order
     *
     * @return a DiningHall[] containing 5 dining hall instances with menus for each day
     */
    public static DiningHall[] makeDiningHalls(){
	DiningHall[] diningHalls = new DiningHall[5];

	//read in BaePaoLuChow
	String bae = readInWebPage("http://www.wellesleyfresh.com/menu_baepaoluchow_w1.html");
	bae = extractTable(bae);
	diningHalls[0] = initDiningHall2("Bae Pao Lu Chow", bae);
	
	//read in Bates
	String bates = readInWebPage("http://www.wellesleyfresh.com/menu_bates_w1.html");
	bates = extractTable(bates);
	diningHalls[1] = initDiningHall2("Bates",bates);
	
	//read in Pomeroy
	String pom = readInWebPage("http://www.wellesleyfresh.com/menu_pomeroy_w1.html");
	pom = extractTable(pom);
	diningHalls[2] = initDiningHall2("Pomeroy", pom);
	
	//read in Stone Davis
	String stone = readInWebPage("http://www.wellesleyfresh.com/menu_stone_davis_w1.html");
       	stone = extractTable(stone);
       	diningHalls[3] = initStoneDavis(stone);
	
	//read in Tower
	String tower = readInWebPage("http://www.wellesleyfresh.com/menu_tower_w4.html");
	tower = extractTable(tower);
	diningHalls[4] =initDiningHall2("Tower", tower);
	
	return diningHalls;    
    }

    /**
     * Initializes the a dining hall by parsing the data from the HTML table
     * Data is read vertically
     *
     * @param String name, a name of the Dining hall
     * @param String table, a table parsed from the HTML file
     * @return DiningHall, a fully realized dining hall with menus per day
     */
    public static DiningHall initDiningHall2(String name, String table){
	MealPerDay[] mpd = new MealPerDay[7];
	DiningHall d = new DiningHall(name);

	//account for first row of days of the week.
	//initialize mealperdays 
	String[] rows = getRowsinTable(table);
	String[] columns = getColumnsinRow(rows[0]);
	for(int i = 0;i<columns.length;i++){
	    columns[i] = removeTags(columns[i]);
	    mpd[i] = new MealPerDay(columns[i]);
	}
	
	Meal m = null;
	for(int j=0; j<columns.length;j++){
	    for(int k=1;k<rows.length;k++){
		columns = getColumnsinRow(rows[k]);
		if(columns[j].contains("format")||columns[j].contains("meal")){
		    if(m!=null)
			mpd[j].addMeal(m);
		    columns[j] = removeTags(columns[j]);
		    m = new Meal(columns[j]);
		}else{
		    columns[j] = removeTags(columns[j]);
		    m.addFood(new Food(columns[j]));
		}
	    }
	}

	d.addMealPerDays(mpd);
	return d;		   
    }

    /**
     * Initializes the a dining hall by parsing the data from the HTML table
     * Data is read horizontally, but the menus are stored vertically
     * Replaced by better method initDiningHall2
     *
     * @param String name, a name of the Dining hall
     * @param String table, a table parsed from the HTML file
     * @return DiningHall, a fully realized dining hall with menus per day
     */
    public static DiningHall initDiningHall(String name, String table){
	MealPerDay[] mpd = new MealPerDay[7];
	DiningHall d = new DiningHall(name);

	//account for first row of days of the week.
	//initialize mealperdays 
	String[] rows = getRowsinTable(table);
	String[] columns = getColumnsinRow(rows[0]);
	for(int i = 0;i<columns.length;i++){
	    columns[i] = removeTags(columns[i]);
	    mpd[i] = new MealPerDay(columns[i]);
	}
	Meal[] m = new Meal[7];
	for(int k =1; k<rows.length;k++){
	    columns = getColumnsinRow(rows[k]);
	    if(columns[0].contains("format")||columns[0].contains("meal")){
		if(m[0]!=null){
		    
		    //a new meal is reached, add meal array to meal per day
		    for(int h=0;h<m.length;h++)
			mpd[h].addMeal(m[h]);
		}
		//make new meal with next line
		for(int j=0;j<columns.length;j++){
		    columns[j]=removeTags(columns[j]);
		    m[j] = new Meal(columns[j]);
		}
	    }else{
		for(int p=0;p<columns.length;p++){
		    columns[p] = removeTags(columns[p]);
		    m[p].addFood(new Food(columns[p]));
		}
	    }
	}
	
	d.addMealPerDays(mpd);
	return d;
    }

    /**
     * Initializes Stone Davis because its menu is only for 5 days, not 7
     *
     * @param String table, a table parsed from the HTML file
     * @return DiningHall, a fully realized dining hall with menus per day
     */
    //because Stone Davis is special and needs extra help. 
    public static DiningHall initStoneDavis(String table){
	MealPerDay[] mpd = new MealPerDay[5];
	DiningHall d = new DiningHall("Stone Davis");
	
	//Stone D isnt open on Sunday or Saturday, so days 0 and 6 are empty


	String[] rows = getRowsinTable(table);
	String[] columns = getColumnsinRow(rows[0]);
	for(int i = 0;i<columns.length;i++){
	    columns[i] = removeTags(columns[i]);
	    mpd[i] = new MealPerDay(columns[i]);
	}

	Meal[] m = new Meal[5];
	for(int k =1; k<rows.length;k++){
	    columns = getColumnsinRow(rows[k]);
	    if(columns[0].contains("format")||columns[0].contains("meal")){
		if(m[0]!=(null)){
		    //a new meal is reached, add meal array to meal per day
		    for(int h=0;h<m.length;h++){
			mpd[h].addMeal(m[h]);
		    }
		}
		//make new meal with next line
		for(int j=0;j<columns.length;j++){
		    columns[j]=removeTags(columns[j]);
		    m[j] = new Meal(columns[j]);
		}
	    }else{
		for(int p=0;p<columns.length;p++){
		    columns[p] = removeTags(columns[p]);
		    m[p].addFood(new Food(columns[p]));
		}
	    }
	}

	MealPerDay[] mpd7 = new MealPerDay[7];


	
	Meal meal1 = new Meal("Breakfast: Closed");
	Meal meal2 = new Meal("Lunch: Closed");
	Meal meal3 = new Meal("Dinner: Closed");
	meal1.addFood(new Food("closed"));
	meal2.addFood(new Food("closed"));
	meal3.addFood(new Food("closed"));

	mpd7[5] = new MealPerDay("Sunday");
       	mpd7[5].addMeal(meal1);
      	mpd7[5].addMeal(meal2);
      	mpd7[5].addMeal(meal3
);
	mpd7[6] = new MealPerDay("Saturday");
	mpd7[6].addMeal(meal1);
	mpd7[6].addMeal(meal2);
	mpd7[6].addMeal(meal3);

	for(int q=0;q<mpd.length;q++){
	    mpd7[q] = mpd[q];
	}
	
	
	d.addMealPerDays(mpd7);
	return d;
    }


    /**
     * Reads in a webpage and stores the data in a string
     *
     * @param String url, the URL of the website
     * @return String representation of the website
     */
    public static String readInWebPage(String url){
	String s = "";
	try{
	    URL u = new URL(url);
	    Scanner reader = new Scanner(u.openStream());
	    while(reader.hasNext()){
		s = s + reader.nextLine();
	    }
	    reader.close();

	}catch (IOException ex){
	    System.out.println(ex);
	}
	return s;
    }
    

    /**
     * Extracts the table from the HTML string parsed from the webpage
     * Splits the data around the table and /table tags
     *
     * @param String webpage, a string version of the HTML file
     * @return String representation of the table
     */
    public static String extractTable(String webPage){
	int start = webPage.indexOf("<table class=\"menu\">");
	int secondStart = webPage.indexOf("<tr>", start);
	int end = webPage.indexOf("</table>");
	String s = webPage.substring(secondStart, end);
	return s;
    }


    /**
     * Splits the table around the /tr tag, which gives a string array of the rows in the table
     *
     * @param String table, the table from the HTML file
     * @return String[] of rows in the table
     */
    public static String[] getRowsinTable(String table){
	String[] s = table.split("</tr>");
	return s;
    }


    /**
     * Splits the table around the /td tag, which gives a string array of the items in a row
     *
     * @param String row, the row of a table
     * @return String[] of items in the row
     */
    public static String[] getColumnsinRow(String row){
	String[] s = row.split("</td>");
	return s;
    }


    /**
     * Cleans the string of all HTML tags and replaces them with blank spaces
     *
     * @param s, a dirty string with HTML tags
     * @return String, a clean string with no HTML tags
     */
    public static String removeTags(String s){
	String clean = s.replaceAll("\\<.*?>"," ");
	clean = clean.trim();
	return clean;
    }
	
     
    /**
     * Creates the main frame for the GUI
     * class method
     */
    
    public static void createAndShowGUI(){
	//creating the GUI and setting it to visible
	JFrame.setDefaultLookAndFeelDecorated(true);

	JFrame frame = new JFrame("Wellesley Fresher");
	frame.setSize(1000, 500);

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	DiningHall[] hall = makeDiningHalls();
	//	hall.init();

	FresherGUI applet = new FresherGUI();
	applet.init();
	
	frame.add(applet, BorderLayout.CENTER);
	
	frame.setVisible(true);

	
    }
    

    /**
     * Runs the program
     * class method
     */
    public static void main(String[] args){
	//MAIN METHOD
	// running the GUI and the program
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() { createAndShowGUI(); }
		    });
		
    }

} 