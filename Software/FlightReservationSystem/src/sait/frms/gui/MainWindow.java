package sait.frms.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;

/**
 * MainWindow - a class that create the main window and set the dimension for each region (North, South, and Center). 
 * @author ( Prince Bansal )
 * @version ( March, 2021 )
 */
public class MainWindow extends JFrame 
{// class start.
	//create two final variable to hold two different view.
	private static final String TAB_FLIGHTS = "flights";
	private static final String TAB_RESERVATIONS = "reservations";
    private FlightManager flightManager; // hold the flight Manager.
    private ReservationManager reservationManager; // hold the reservation manager.
	private CardLayout cardLayout; // hold the cardLayout to display the content. 
	private JPanel northPanel; // create a JPanel to hold the north panel.
	private JPanel centerPanel; // create a JPanel to hold the center panel.
	private JButton flightsButton; // create a JButton to hold the flight button.
	private JButton reservationsButton; // create a JButton to hold the flight button.
	private TableBase flightsTable; // create flightTable to hold the Flights table.
	private TableBase reservationsTable; // create reservationTable to hold the Reservation table.
	
	/**
	 * MainWindow - a method that will create two view and set the layout for all the components.
	 */
	public MainWindow() 
	{
		// call the class "FlightManager" and "ReservationManager" and assigned to each table view.
		this.flightManager = new FlightManager();
		this.reservationManager = new ReservationManager();
		setTitle("Flight Reservation Management System");  //set the title for the window.
		setLayout(new BorderLayout()); //set the border layout for the window.
		setPreferredSize(new Dimension(850,650)); // set preferred size for the window.
		setResizable(false); // set the re-sizable false, so will stick on the preferred size.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the close button. 
		northPanel = createNorthPanel();       //set the layout for the North region.
		add(northPanel, BorderLayout.NORTH);   //add the northPanel to the North region.
		centerPanel = createCenterPanel();     //set the layout for the Center region.
		add(centerPanel, BorderLayout.CENTER); //add the centerPanel to the Center region.
	}// method end.
	
	/**
	 * createNorthPanel - a method that will create a North panel for the window.
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel(); //create JPanel to set the layout for the center view.
		panel.setLayout(new BorderLayout());     //set the borderLayout for the panel.
		JPanel tabPanel = createTabPanel();      //create a table panel to hold the borderLayout.
		panel.add(tabPanel, BorderLayout.SOUTH); //add the borderLayout to the panel.
		return panel;
	}// method end.
	
	/**
	 * createCenterPanel - a method that will create a Center panel for the window.
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() 
	{
		JPanel panel = new JPanel();    //create JPanel to set the layout for the Flight and Reservation table.
		cardLayout = new CardLayout(); 
		this.flightsTable = new FlightsTable(this.flightManager, this.reservationManager);
		this.reservationsTable = new ReservationsTable(this.reservationManager);
		panel.setLayout(cardLayout);
		panel.add(flightsTable.getPanel(), TAB_FLIGHTS);             //add the Flight table to the panel to display.
		panel.add(reservationsTable.getPanel(), TAB_RESERVATIONS);   //add the Reservation table to the panel to display.
		cardLayout.first(panel);  //set the Flight table as a first view when the program run.
		return panel;
	}// method end.
	
	/**
	 * createTabPanel - a method that will create a button for each table view 
	 *                  and occur action when the user clicked. 
	 * @return JPanel containing tab buttons.
	 */
	private JPanel createTabPanel() 
	{
		JPanel tabPanel = new JPanel();  //create the JPanel to set the layout for the Flight and Reservation table.
		tabPanel.setLayout(new GridLayout(1, 2));	       //set the GridLayout for the button.
		flightsButton = new JButton("Flights");            //create a Flights button and assigned to flightsButton variable.
		reservationsButton = new JButton("Reservations");  //create a Reservation button and assigned to reservationButton variable.
		flightsButton.addActionListener(new TabButtonActionListener()); 
		reservationsButton.addActionListener(new TabButtonActionListener());
		tabPanel.add(flightsButton);      //add the flightButton to the tabPanel.
		tabPanel.add(reservationsButton); //add the reservationButton to the tabPanel.
		return tabPanel;
	}// method end.
	
	/**
	 * display - a method that display the JFrame window to the user.
	 */
	public void display() 
	{
		pack();
		setVisible(true);
	}
	
	/**
	 * TabButtonActionListener - an inner action listener class that listens for a tab button to be clicked.
	 */
    private class TabButtonActionListener implements ActionListener 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//if the user click the Flight button, then will display the Flight table.
			if (e.getSource() == flightsButton) 
			{
				cardLayout.show(centerPanel, TAB_FLIGHTS);
			}
			//otherwise, if the user click the Reservation button, then will display the Reservation table.
			else if (e.getSource() == reservationsButton)
			{
				cardLayout.show(centerPanel, TAB_RESERVATIONS);
			}
		}//end of the actionPerformed action.
	}//end of the inner action listener.
}//end of the class.
