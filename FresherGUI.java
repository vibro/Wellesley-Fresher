/**
 * @author Lulu Ye
 * @author Victoria Brown
 * LAST MODIFIED: 12/13/12
 * CS 230 FINAL PROJECT 
 * FresherGUI.java
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FresherGUI extends JApplet implements ActionListener, ItemListener{
    //instance variables
    //categorized by top, left, or main panel.
    

    private JPanel topPanel;
    private JButton goButton;
    private JLabel dayLabel, mealTimeLabel;
    private JComboBox days, mealTimes;
    private JCheckBox vegBox;

    private JPanel leftPanel;
    private JLabel diningLabel;
    private JCheckBox allCheckBox, luluCheckBox, batesCheckBox,
	pomCheckBox, stoneCheckBox, towerCheckBox;

    
    private JPanel mainPanel, labelPanel, panel2;
    private JLabel diningHallName, timesOpen, mealsAvail;
    private JLabel lulu, bates, pomeroy, stone, tower;

    private DiningHall[] halls;
    
    private JScrollPane mainScroll;
    private JScrollPane panel2Scroll;

    private Color newBlue = new Color(88, 133, 237); //a color used in the GUI


    /**
     * Constructs a new instance of FresherGUI.
     * Creates the labels, comboBoxes, checkboxes.
     * Creates the diningHalls data structure.
     *
     * instance method
     */
    public FresherGUI() {
	//constructor
	makeButtons();
	makeLabels();
	makeComboBox();
	makeCheckBoxes();

	halls = RunWellesleyFresher.makeDiningHalls(); //initializing the data structure

    }

    /**
     * Constructor helper method: creates and instantiates the buttons for GUI
     * instance method
     */
    private void makeButtons() {
	goButton = new JButton("Go!");
	goButton.addActionListener(this);
    }

    /**
     * Constructor helper method: creates and instantiates the all the labels for GUI
     * instance method
     */
    private void makeLabels() {
	dayLabel = new JLabel("DAY");
	mealTimeLabel =  new JLabel("MEAL TIME");
	diningLabel = new JLabel("DINING HALL");

	diningHallName = new JLabel("DINING HALL");
	timesOpen = new JLabel("TIMES OPEN");
	mealsAvail = new JLabel("MEALS AVAILABLE");

	lulu = new JLabel("Bae Pao Lu Chow");
	bates = new JLabel("Bates");
	pomeroy = new JLabel("Pomeroy");
	stone = new JLabel("Stone-Davis");
	tower = new JLabel("Tower");


    }

    /**
     * Constructor helper method: creates and instantiates the comboBoxes for GUI
     * instance method
     */
    private void makeComboBox() {
	days = new JComboBox();
	days.addItem("Monday");
	days.addItem("Tuesday");
	days.addItem("Wednesday");
	days.addItem("Thursday");
	days.addItem("Friday");
	days.addItem("Saturday");
	days.addItem("Sunday");
	days.addActionListener(this);
     
	mealTimes = new JComboBox();
	mealTimes.addItem("Breakfast");
	mealTimes.addItem("Lunch");
	mealTimes.addItem("Dinner");
	mealTimes.addActionListener(this);
   
    }

    /**
     * Constructor helper method: creates and instantiates the checkBoxes for GUI
     * instance method
     */
    private void makeCheckBoxes() {

	 //Vegetarian feature: To Be Added Later
	vegBox = new JCheckBox("Vegetarian? ", false);
	vegBox.addActionListener(this);
	vegBox.setOpaque(false);
	

	allCheckBox = new JCheckBox("All ", true);
	allCheckBox.addActionListener(this);
	allCheckBox.addItemListener(this); //the only JCheckbox that responds
	//to user interaction 
	allCheckBox.setOpaque(false);
	
	luluCheckBox = new JCheckBox("Bae Pao Lu Chow", true);
	luluCheckBox.addActionListener(this);
	luluCheckBox.setOpaque(false);

	batesCheckBox = new JCheckBox("Bates ", true);
	batesCheckBox.addActionListener(this);
	batesCheckBox.setOpaque(false);

	pomCheckBox = new JCheckBox("Pomeroy ", true);
	pomCheckBox.addActionListener(this);
	pomCheckBox.setOpaque(false);

	stoneCheckBox = new JCheckBox("Stone-Davis ", true);
	stoneCheckBox.addActionListener(this);
	stoneCheckBox.setOpaque(false);
	
	towerCheckBox = new JCheckBox("Tower ", true);
	towerCheckBox.addActionListener(this);
	towerCheckBox.setOpaque(false);
    }


    /**************** INIT ***********************/

    /**
     * Lays out the GUI appropriately
     * instance method
     */
    public void init() {
	setLayout(new BorderLayout(0,0));
	
	//calling on methods that lays out the GUI
	layTopPanel(); 
	layLeftPanel();
	layMainPanel();

    }

    /***************** PANELS **********************/

    //Top panel contains the logo (hopefully)
    //and the options for the day and meal

    /**
     * init() helper method: lays out the top panel, which
     * contains the day, meal, and vegetarian options, as well as the go button.
     *
     */
    private void layTopPanel() {
	
	topPanel = new JPanel();

	topPanel.setBackground(newBlue); 

	topPanel.setLayout(new GridLayout(1, 4, 0, 0));

	topPanel.add(dayLabel); //adding day of the week option
	topPanel.add(days);

	topPanel.add(mealTimeLabel); //adding mealtime option
	topPanel.add(mealTimes); 


	topPanel.add(vegBox); //adding the vegetarian option

	topPanel.add(goButton); //adding the thing that will make everything run

	topPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3)); 

	add(topPanel, BorderLayout.NORTH); //adding this panel to the GUI

    }
  
    /**
     * init() helper method: lays out the left panel, which
     * contains the checkboxes for the user to choose which
     * dining hall to look at.
     *
     */

  //Left panel is where all of the dining hall options are available
    private void layLeftPanel() {
	leftPanel = new JPanel();
	leftPanel.setBackground(newBlue); 

	leftPanel.setLayout(new GridLayout(0, 1, 0, 0));

	leftPanel.add(diningLabel);
	
	//checkboxes
	leftPanel.add(allCheckBox);	
	leftPanel.add(luluCheckBox);
	leftPanel.add(batesCheckBox);
	leftPanel.add(pomCheckBox);
	leftPanel.add(stoneCheckBox);
	leftPanel.add(towerCheckBox);	


	leftPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
	//it's 3 pixels all around

	add(leftPanel, BorderLayout.WEST);
    }


    
    /**** MODIFY THIS CODE BELOW ****/
    /*
    //I want to be able to always be able to add it to a panel.
    // I need to add it main panel and the second panel.
    public void layLabelPanel(JPanel p) {
	labelPanel = new JPanel();
	labelPanel.setLayout(new GridLayout(0, 1));

	labelPanel.add(diningHallName);
	labelPanel.add(timesOpen);
	labelPanel.add(mealsAvail);
	p.add(labelPanel); //problem line

	/*** notes **/
	//FURTHER WORK: alignment of this might come into question 
	//we add in the data

    // } 


    /**
     * init() helper method: This lays out the main panel where
     * the data will be displayed. This creates and initializes the initial pane
     * and sets up for the panel that replaces the initial pane.
     *
     */
    private void layMainPanel() { 
    //laying out the main panel.
    //Contains both the main panel at the beginning
    //and the initialization of the second panel later.
    //this is where the dining hall meal info actually goes

	//This is our first panel
	mainPanel = new JPanel(); //initialization
	
	mainPanel.setBackground(Color.ORANGE); 
	mainPanel.setLayout(new GridLayout(0, 7, 0, 0)); 
	
	//	layLabelPanel(mainPanel); //insert label panel
	mainPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
	mainPanel.add(new JLabel("Welcome to Wellesley Fresher!"));
       

	//create a scroll pane. 
	mainScroll = new JScrollPane(mainPanel); 

	add(mainScroll, BorderLayout.CENTER); 


	
	/*** panel 2! ***/

	panel2 = new JPanel();
	panel2.setBackground(Color.WHITE);
	panel2.setLayout(new GridLayout(1, 0));

	panel2Scroll = new JScrollPane(panel2);

    }



    /************* ACTION PERORMED EVENTS ****************/


    /**
     * Updates the GUI when user pushes "Go" according her specifications.
     * Removes and creates new panels to be displayed in the main panel.
     * instance method
     *
     * @param ActionEvent event that listens for user interaction
     */
    public void actionPerformed(ActionEvent event) {
	Object source = event.getSource();

	if (source.equals(goButton)) {

	    //replace the initial pane.
	    remove(mainScroll);

	    panel2.removeAll(); //clear the current panel

	    // We modify panel 2 and add to GUI
	    LinkedList<Integer> userInputs = this.getUserDiningHallInput();
	    String day = days.getSelectedItem().toString();
	    String mealTime = mealTimes.getSelectedItem().toString();
	    Boolean veg = vegBox.isSelected();
	    
	    makeAllPanels(halls, userInputs, mealTime, day, veg); //create the panel
	    
	    add(panel2Scroll); //add the panel
	    
	    validate();
	    repaint();
	    
	}
    }


    /**
     * Toggles the dining hall checkboxes when "All" is checked.
     * instance method
     *
     * @param ItemEvent event that listens for user interaction with the
     * the "All" checkbox
     */
    public void itemStateChanged(ItemEvent event) {
	Object source = event.getItemSelectable();

	if (source.equals(allCheckBox)) {
	    if (allCheckBox.isSelected()) {
		//set all dining hall checkboxesto true
		luluCheckBox.setSelected(true);
		batesCheckBox.setSelected(true);
		pomCheckBox.setSelected(true);
		stoneCheckBox.setSelected(true);
		towerCheckBox.setSelected(true);
	    } else {
		//set all dining hall checkboxes to false
		luluCheckBox.setSelected(false);
		batesCheckBox.setSelected(false);
		pomCheckBox.setSelected(false);
		stoneCheckBox.setSelected(false);
		towerCheckBox.setSelected(false);
		
	    }
	} 
    }



    /**************** RETRIEVING THE DATA *********************/


    /**
     * A helper instance method that keeps track of the user's
     * choices of dining hall. Returns a linked list<Integer> that corresponds
     * to the DiningHall[] halls that will later be used to get meal information.
     *
     * @return LinkedList<Integer> of DiningHalls activated
     */
    private LinkedList<Integer> getUserDiningHallInput() {
	LinkedList<Integer> q = new LinkedList<Integer>();

	if (luluCheckBox.isSelected()) {
	    q.add(0);
	}
	if (batesCheckBox.isSelected()) {
	    q.add(1);
	}
	if (pomCheckBox.isSelected()) {
	    q.add(2);
	}
	if(stoneCheckBox.isSelected()) {
	    q.add(3);
	}
	if(towerCheckBox.isSelected()) {
	    q.add(4);
	}
	return q;
    }



    /**
     * A helper instance method that retrieves the meal info for a hall,
     * creates a panel, and adds it to the GUI
     *
     * @param diningHalls, a DiningHall[]
     * @param hallID, a number assigned to each dining hall
     * @param mealTime, a String of the meal requested
     * @param day, a String of the day requested
     * @param veg, whether user is requesting vegetarian
     *
     */
    private void makePanel(DiningHall[] diningHalls, int hallID, 
			   String mealTime, String day, Boolean veg) {
	String name = diningHalls[hallID].getName();
	
	MealPerDay mpd = diningHalls[hallID].getMealForDay(day);
	
	Meal m = mpd.getMeal(mealTime);

	//putting in the name info
	JPanel namePanel = new JPanel();
	namePanel.setBackground(Color.ORANGE);
	namePanel.setLayout(new GridLayout(0, 1));
	JLabel nameLabel = new JLabel(name.toUpperCase());
	namePanel.add(nameLabel);

	//putting in the meal info
	JPanel mealPanel = new JPanel();
	mealPanel.setBackground(Color.WHITE);
	mealPanel.setLayout(new GridLayout(0, 1));

	formatMeal(mealPanel, m);

	JPanel onePanel = new JPanel();
	onePanel.setLayout(new GridLayout(2, 0));
	
	onePanel.add(namePanel);
	onePanel.add(mealPanel);

	onePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	
	panel2.add(onePanel);

	//Add this information to the panel.
	
    }


    /**
     * A helper instance method that calls upon makePanel() and creates
     * all the panels.
     *
     * Also creates a label panel and displays a message when the user has
     * neglected to select any dining halls
     *
     * @param diningHalls, a DiningHall[]
     * @param userInput, a LinkedList<Integer> containing the hallIDS of 
     * the dining halls requested
     * @param mealTime, a String of the meal requested
     * @param day, a String of the day requested
     * @param veg, whether user is requesting vegetarian
     *
     */
    private void makeAllPanels (DiningHall[] diningHalls, LinkedList<Integer> userInput, 
				String mealTime, String day, Boolean veg) {

	if (userInput.isEmpty()) { //if nothing is checked, display this message
	    JPanel errorPanel = new JPanel();
	    errorPanel.setLayout(new GridLayout(2, 0));
	    errorPanel.setBackground(Color.WHITE);
	    errorPanel.add(new JLabel("You need to select some dining halls!"));

	    panel2.add(errorPanel);

	} else {

	    labelPanel = new JPanel(); //creating another panel
	    labelPanel.setLayout(new GridLayout(2, 0));
	    
	    diningHallName = new JLabel("DINING HALL NAME");
	    mealsAvail = new JLabel("MEALS AVAILABLE");
	    
	    JPanel diningHallNamePanel = new JPanel();
	    diningHallNamePanel.setLayout(new GridLayout(0, 1));
	    diningHallNamePanel.add(diningHallName);
	    diningHallNamePanel.setBackground(Color.ORANGE);
	    
	    JPanel mealsAvaiPanel = new JPanel();
	    mealsAvaiPanel.setLayout(new GridLayout(0, 1));
	    mealsAvaiPanel.add(mealsAvail);
	    mealsAvaiPanel.setBackground(Color.WHITE);
	    
	    labelPanel.add(diningHallNamePanel);
	    labelPanel.add(mealsAvaiPanel);
	    
	    labelPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	    
	    panel2.add(labelPanel);
	    
	    for (int i = 0; i < userInput.size(); i++) {
		makePanel(diningHalls, userInput.get(i), mealTime, day, veg);
	    }
	}
    }



    /**
     * A helper instance method that takes in a meal and JPanel and 
     * changes the format into vertical alignment
     * by creating individual labels and adding them to mealPanel.
     *
     * @param panel to add the meal info to
     * @param m, the Meal containing the data to be displayed
     */
    private void formatMeal(JPanel panel, Meal m) {
	if (!m.isEmpty()) { //only works if the Meal is not empty
	    LinkedList<Food> f = new LinkedList<Food>(m.getMeal()); 	    //create a new LinkedList<Food>
	    while(!f.isEmpty()) {
		Food food2 = f.remove();
		if (food2 != null) {
		    JLabel food = new JLabel(food2.toString());
		    panel.add(food);
		}
	    }
	}
    }


}