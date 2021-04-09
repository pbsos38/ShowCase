package sait.frms.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;

import sait.frms.manager.FlightManager;
import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * FlightTable - a class that hold all the components for the flight table view. The user can select, click and choose a flight 
 *               by clicking the find flight button and also reserve the flight by clicking the reserve button.
 * @author ( Prince Bansal)
 * @version ( March, 2021 )
 */
public class FlightsTable extends TableBase 
{// class start    
    private FlightManager flightManager; //create an instance of flight manager. 
    private ReservationManager reservationManager; // create an instance of flight manager.
    private JList<Flight> flightsList; // create a JList to hold all the flight list.
    private DefaultListModel<Flight> flightsModel; // create a DefaultListModel to hold all the flightsModel.
    private JTextArea textArea;
    private static final int TextBoxWidth = 500;
    private static final int TextBoxHeight = 200;
    private JButton reserveButton;
    private JButton findFlightButton;
    private JTextField flightTextField;
    private JTextField airlineTextField;
    private JTextField dayTextField;
    private JTextField timeTextField;
    private JTextField costTextField;
    private JTextField nameTextFiled;
    private JTextField citizenshipTextField;
    private JComboBox fromCombo;
    private JComboBox toCombo;
    private JComboBox dayCombo;
    final int WINDOW_WIDTH = 850; // Window width in pixels


    /**
     * FlightTable - a method that create the components for flights table. by creating the BorderLayout to arrange the components 
     *               in three region (North, South and Center).
     * @param flightManager      - Instance of FlightManager.
     * @param reservationManager - Instance of ReservationManager.
     */
    public FlightsTable(FlightManager flightManager, ReservationManager reservationManager) 
    {
        this.flightManager = flightManager;
        this.reservationManager = reservationManager;
        BasePanel.setLayout(new BorderLayout());         // set the layout for the window by using BorderLayout.
        JPanel northPanel = flightNorthPanel();          // call the method flightNorthPanel and assigned to JPanel north. 
        BasePanel.add(northPanel, BorderLayout.NORTH);   // add the northPanel to the basePanel window.
        JPanel centerPanel = flightCenterPanel();        // call the method flightCenterPanel and assigned to JPanel center.
        BasePanel.add(centerPanel, BorderLayout.CENTER); // add the centerPanel to the basePanel window.
        JPanel southPanel = createSouthPanel();          // call the method createSouthPanel and assigned to JPanel center.
        BasePanel.add(southPanel, BorderLayout.SOUTH);   // add the southPanel to the basePanel window.
    }

    /**
     * flightNorthPanel - a method that create the North panel and through this method we can add the title and set the font size
     *                    and will appear in the window's title bar when it's display.
     * @return JPanel - that goes in north.
     */
    private JPanel flightNorthPanel() 
    {
    	// create a northPanel to set the layout of the north window.
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("Flights", SwingConstants.CENTER);
        title.setFont(new Font("serif", Font.PLAIN, 29));
        northPanel.add(title);
        return northPanel;
    }// end of the flightNorthPanel method.

    /**
     * flightCenterPanel - a method that create the Center panel and through this method will provide the user with the list 
     *                     of the flights that s/he selected from the selection bottoms and displayed through the center view.
     * @return centerPanel that goes in the center of the window.
     */
    private JPanel flightCenterPanel() 
    {
    	// create a centePanel to set the layout of the center window.
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        flightsModel = new DefaultListModel<>();
        flightsList = new JList<>(flightsModel);
        // User can only select one item at a time.
        flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Wrap JList in JScrollPane so it is scalable.
        JScrollPane scrollPane = new JScrollPane(this.flightsList);
        flightsList.addListSelectionListener(new MyListSelectionListener());
        centerPanel.add(scrollPane);
        centerPanel.add(CenterView());
        return centerPanel;
    }// end of the flightCenterPanel method.

    /**
     * fromFlights - a method that create an ArrayList and contain all the flights that departs from a specific Airport 
     *               and will return the flights that is selected.
     * @return temporary - will return the flights department information.
     */
    public String[] fromFlights() 
    {	
        ArrayList recieveData = new ArrayList(); // create an ArrayList to hold the departure Flights.
        // for loop to search for a specific flights from the flight manager.
        for (int i = 0; i < flightManager.getFlights().size(); i++)
        {
        	if ( !recieveData.contains(flightManager.getFlights().get(i).getForm()) )
                 recieveData.add(flightManager.getFlights().get(i).getForm());
        }// end of the for loop.
        // create an array named temporary String typed and will hold the received data.
        String[] temporary = new String[recieveData.size()];
        // for loop to get all the data received from the flight manager and assigned to the temporary array.
        for (int i = 0; i < recieveData.size(); i++) {
        	temporary[i] = recieveData.get(i).toString();
        }// end of the loop.
        Arrays.sort(temporary); // sort the String array named temporary to the Arrays.
        return temporary;
    }// end of the fromFlight method.

    /**
     * toFlights - a method that create an ArrayList and contain all the flights that arrives to a specific Airport 
     *             and will return the flights that is selected.
     * @return temporary - will return the flights arrives information.
     */
    public String[] toFlights() 
    {
        ArrayList recieveData = new ArrayList(); // create an ArrayList to hold the arrive Flights.
        // for loop to search for a specific flights from the flight manager.
        for (int i = 0; i < flightManager.getFlights().size(); i++)
        {
            if ( !recieveData.contains(flightManager.getFlights().get(i).getTo()) )
                recieveData.add(flightManager.getFlights().get(i).getTo());
        }// end of the for loop.
        String[] temporary = new String[recieveData.size()]; // create an array named temporary String typed and will hold the received data.
        // for loop to get all the data received from the flight manager and assigned to the temporary array.
        for (int i = 0; i < recieveData.size(); i++)
        {
        	temporary[i] = recieveData.get(i).toString();
        }// end of the loop.
        Arrays.sort(temporary);// sort the String array named temporary to the Arrays.
        return temporary;
    }// end of the toFlights method.

    /**
     * CenterView - a method that contains all the components: JLabel an area that will display the flights information, 
     *              JTextField an area that will get the input from the keyboard, and JButton a button that will cause an action to occur
     *              when the user clicked.
     * @return centralPanel - will return all the components to display on the center of the window.
     */
    public JPanel CenterView() 
    {
    	// create JPanel object named centerPanel to handle two JPanel object for right and left side.
        JPanel centralPanel = new JPanel();
        JPanel leftCentral = new JPanel();
        // set the dimension for the whole center view.
        centralPanel.setPreferredSize(new Dimension(500, 350));
        // set the dimension for the left side of the center view.
        leftCentral.setPreferredSize(new Dimension(550, 300));
        // create the border area that will contains the flights list.
        flightsModel = new DefaultListModel();
        flightsList = new JList(flightsModel);
        JScrollPane pane = new JScrollPane(flightsList);
        flightsList.addListSelectionListener(new MyListSelectionListener());
        pane.setPreferredSize(new Dimension(500, 220));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        pane.setBorder(border);
        leftCentral.add(pane);
        // set the dimension for the right side of the center view.
        JPanel rightCentral = new JPanel();
        rightCentral.setPreferredSize(new Dimension(250, 350));
        // create the Reserve button to take an action.
        JLabel Reserve = new JLabel();
        Reserve.setText("Reserve");
        Reserve.setFont(new Font("Serif", Font.BOLD, 35));
        Reserve.setPreferredSize(new Dimension(170, 60));
        // create the flight area.
        JLabel flightLabel = new JLabel();
        flightLabel.setText("Flight:");
        flightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        flightLabel.setFont(new Font("Serif", Font.BOLD, 19));
        flightLabel.setPreferredSize(new Dimension(100, 20));
        // create the flight text field area to display the information.
        flightTextField = new JTextField();
        flightTextField.setEditable(false);
        flightTextField.setPreferredSize(new Dimension(140, 20));
        // create the airline area.
        JLabel airLineLabel = new JLabel();
        airLineLabel.setText("Airline:");
        airLineLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        airLineLabel.setFont(new Font("Serif", Font.BOLD, 19));
        airLineLabel.setPreferredSize(new Dimension(100, 20));
        // create the airline text field area to display the information.
        airlineTextField = new JTextField();
        airlineTextField.setEditable(false);
        airlineTextField.setPreferredSize(new Dimension(140, 20));
        // create the day area.
        JLabel dayLabel = new JLabel();
        dayLabel.setText("Day:");
        dayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dayLabel.setFont(new Font("Serif", Font.BOLD, 19));
        dayLabel.setPreferredSize(new Dimension(100, 20));
        // create the day text field area to display the information.
        dayTextField = new JTextField();
        dayTextField.setEditable(false);
        dayTextField.setPreferredSize(new Dimension(140, 20));
        // create the time area.
        JLabel timeLabel = new JLabel();
        timeLabel.setText("Time:");
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timeLabel.setFont(new Font("Serif", Font.BOLD, 19));
        timeLabel.setPreferredSize(new Dimension(100, 20));
        // create the time text field area to display the information.
        timeTextField = new JTextField();
        timeTextField.setEditable(false);
        timeTextField.setPreferredSize(new Dimension(140, 20));
        // create the cost area.
        JLabel costLabel = new JLabel();
        costLabel.setText("Cost:");
        costLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        costLabel.setFont(new Font("Serif", Font.BOLD, 19));
        costLabel.setPreferredSize(new Dimension(100, 20));
        // create the cost text field area to display the information.
        costTextField = new JTextField();
        costTextField.setEditable(false);
        costTextField.setPreferredSize(new Dimension(140, 20));
        // create the name area.
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 19));
        nameLabel.setPreferredSize(new Dimension(100, 20));
        // create the name text field area to display the information.
        nameTextFiled = new JTextField();
        nameTextFiled.setPreferredSize(new Dimension(140, 20));
        // create the citizenship area.
        JLabel citizenshipLabel = new JLabel();
        citizenshipLabel.setText("CitizenShip:");
        citizenshipLabel.setFont(new Font("Serif", Font.BOLD, 19));
        citizenshipLabel.setPreferredSize(new Dimension(105, 20));
        // create the citizenship text field area to display the information.
        citizenshipTextField = new JTextField();
        citizenshipTextField.setPreferredSize(new Dimension(135, 20));
        // create the reserve button.
        reserveButton = new JButton("Reserve");
        reserveButton.setPreferredSize(new Dimension(240, 30));
        reserveButton.setMargin(new Insets(20, 20, 20, 20));
        reserveButton.setFont(new Font("Serif", Font.BOLD, 20));
        reserveButton.addActionListener(new TabButtonActionListener());
        // add all the information to the right center view.
        rightCentral.add(Reserve);
        rightCentral.add(flightLabel);
        rightCentral.add(flightTextField);
        rightCentral.add(airLineLabel);
        rightCentral.add(airlineTextField);
        rightCentral.add(dayLabel);
        rightCentral.add(dayTextField);
        rightCentral.add(timeLabel);
        rightCentral.add(timeTextField);
        rightCentral.add(costLabel);
        rightCentral.add(costTextField);
        rightCentral.add(nameLabel);
        rightCentral.add(nameTextFiled);
        rightCentral.add(citizenshipLabel);
        rightCentral.add(citizenshipTextField);
        rightCentral.add(reserveButton);
        centralPanel.add(leftCentral);
        centralPanel.add(rightCentral);
        return centralPanel;
    }// end of the CenterView method. 

    /**
     * MyListSelectionListener - a method called when user select an item from the JList that provided to the user
     *                           and will set all the text field with information.
     */
    private class MyListSelectionListener implements ListSelectionListener 
    {
    	//Called when user selects an item in the JList. 
        @Override
        public void valueChanged(ListSelectionEvent e) {
            Flight temproray = flightsList.getSelectedValue();
            // will set all UI components.
            try
            {
                flightTextField.setText(temproray.getCode());
                airlineTextField.setText(temproray.getAirline());
                dayTextField.setText(temproray.getWeekday());
                timeTextField.setText(temproray.getTime());
                costTextField.setText("$" + temproray.getCostPerSeat());
            }
            catch (Exception ignored){	
            }// end of the catch.
        }// end of the override valueChanged method.
    }// end of the MyListSelectionListener method.

    /**
     * createSouthPanel - a method that create the southern area for the window. will set the dimension and the combo boxes, so the user
     *                    can select from the options.
     * @return southPanel for the southern view for the windows.
     */
    public JPanel createSouthPanel() 
    {
    	// create the southPanel that will contains all the combo boxes and the button. 
        JPanel southPanel = new JPanel();
        // set the dimension for the southern view.
        southPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 205));
        // create the area that will display a text.
        JLabel SubName = new JLabel();
        SubName.setText("Flight Finder");
        SubName.setFont(new Font("Serif", Font.BOLD, 53));
        SubName.setHorizontalAlignment(SwingConstants.CENTER);
        SubName.setPreferredSize(new Dimension(WINDOW_WIDTH, 60));
        // create a four variable to hold the UI components. 
        fromCombo = new JComboBox(fromFlights());
        toCombo = new JComboBox<>(toFlights());
        String[] days = {FlightManager.ANY, FlightManager.SUNDAY, FlightManager.MONDAY, FlightManager.TUESDAY,
                            FlightManager.WEDNESDAY, FlightManager.THURSDAY, FlightManager.FRIDAY, FlightManager.SATURDAY};
        dayCombo = new JComboBox<>(days);
        // create the first combo box for the departure airports. 
        JLabel fromLabel = new JLabel();
        fromLabel.setText("From:");
        fromLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        fromLabel.setFont(new Font("Serif", Font.BOLD, 19));
        fromLabel.setPreferredSize(new Dimension(53, 30));
        fromCombo.setPreferredSize(new Dimension(747, 30));
        fromCombo.setEditable(true);
        //create the second combo box for the arrived airports.
        JLabel toLabel = new JLabel();
        toLabel.setText("To:");
        toLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        toLabel.setFont(new Font("Serif", Font.BOLD, 19));
        toLabel.setPreferredSize(new Dimension(50, 30));
        toCombo.setPreferredSize(new Dimension(750, 30));
        toCombo.setEditable(true);
        // create the third combo box 
        JLabel dayLabel = new JLabel();
        dayLabel.setText("Day:");
        dayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dayLabel.setFont(new Font("Serif", Font.BOLD, 19));
        dayLabel.setPreferredSize(new Dimension(50, 30));
        dayCombo.setPreferredSize(new Dimension(750, 30));
        dayCombo.setEditable(true);
        // create the last components to hold the button Find Flight to do an action.
        findFlightButton = new JButton("Find Flight");
        findFlightButton.setPreferredSize(new Dimension(WINDOW_WIDTH, 30));
        findFlightButton.setMargin(new Insets(20, 20, 20, 20));
        findFlightButton.setFont(new Font("Serif", Font.BOLD, 20));
        findFlightButton.addActionListener(new TabButtonActionListener());
        // add all the components to the southPanel to display to the user.
        southPanel.add(SubName);
        southPanel.add(fromLabel);
        southPanel.add(fromCombo);
        southPanel.add(toLabel);
        southPanel.add(toCombo);
        southPanel.add(dayLabel);
        southPanel.add(dayCombo);
        southPanel.add(findFlightButton);
        return southPanel;
    }// end of the createSouthPanel method.

    /**
     * TabButtonActionListener - a method that take an action based on the button that the user will click. We have two button 
     *                         for two views. If the view on the Flight side then the user will select the components from the combo boxes,
     *                         then they will display the information into the text area. Otherwise, the other view will be for the 
     *                         Reservation view and the user will provide an information to search for a Flight that already booked.
     */
    private class TabButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
        	// if the user on the Flight view, then they will display all the components related to the Flight view.
            if ( findFlightButton == e.getSource() ) 
            {
                flightTextField.setText("");
                airlineTextField.setText("");
                dayTextField.setText("");
                timeTextField.setText("");
                costTextField.setText("");
                flightsModel.clear();
                // create an ArrayList from Flight type and will hold the components.
                ArrayList<Flight> temproray = flightManager.findFlights(fromCombo.getSelectedItem().toString(),
                        toCombo.getSelectedItem().toString(),
                        dayCombo.getSelectedItem().toString());
                // add all the elements from the Flight ArrayList to the flightModel.
                for (Flight i : temproray) {
                    flightsModel.addElement(i);
                }// end of loops.
            // otherwise, the Reservation view will display to the user.    
            } else if ( e.getSource() == reserveButton ) {
                Reservation reserved = null;
                // will try to find the reservation flight information, if not will catch an exception and will display a message.
                try {
                    reserved = reservationManager.makeReservation(flightsList.getSelectedValue(), nameTextFiled.getText(), citizenshipTextField.getText());
                }
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }// end of catch.
            }// end of the else statement.
        }// end of the override "actionPerformed" method.
    }// end of the TableButtonActionListener method. 
}// end class
