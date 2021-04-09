package sait.frms.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

/**
 * ReservationTable - a class that hold all the components for the reservation table view. The user can search for a reservation
 * flight by clicking the "Find Reservation" button and also update the flight that already reserved by
 * clicking the update button.
 *
 * @author (Prince Bansal)
 * @version (March , 2021)
 */
public class ReservationsTable extends TableBase {//class start.
    private ReservationManager reservationManager;           //create an instance of reservation manager. 
    private DefaultListModel<Reservation> reservationsModel; //create a DefaultListModel to hold all the flightsModel.
    private JList<Reservation> reservationsList;             //create a JList to hold all the reservation list.
    private JButton updateButton;
    private JButton findReservationButton;
    private JTextField codeTextField;
    private JTextField flightTextField;
    private JTextField airlineTextField;
    private JTextField costTextField;
    private JTextField nameTextFiled;
    private JTextField citizenshipTextField;
    private JComboBox statusCombo;
    private JTextField codeCombo;
    private JTextField airlineCombo;
    private JTextField nameCombo;
    final int WINDOW_WIDTH = 850; // Window width in pixels

    /**
     * ReservationTable - a method that create the components for reservation table. By creating the BorderLayout to arrange
     * the components in three region (North, South and Center).
     *
     * @param reservationManager - Instance of ReservationManager.
     */
    public ReservationsTable(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
        BasePanel.setLayout(new BorderLayout());         // set the layout for the window by using BorderLayout.
        JPanel northPanel = reservationNorthPanel();     // call the method reservationNorthPanel and assigned to northPanel. 
        BasePanel.add(northPanel, BorderLayout.NORTH);   // add the northPanel to the BasePanel window.
        JPanel centerPanel = CenterView();               // call the method centerView and assigned to centerPanel. 
        BasePanel.add(centerPanel, BorderLayout.CENTER); // add the centerPanel to the BasePanel window.
        JPanel southPanel = createSouthPanel();          // call the method createSouthPanel and assigned to southPanel.
        BasePanel.add(southPanel, BorderLayout.SOUTH);   // add the southPanel to the BasePanel window.
    }//method end.

    /**
     * reservationNorthPanel - a method that create the North panel and through this method we can add the title and set the font size
     * and will appear in the window's title bar when it's display.
     *
     * @return JPanel - that goes in north.
     */
    private JPanel reservationNorthPanel() {
        // create a panel to set the layout of the north window.
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
        title.setFont(new Font("serif", Font.PLAIN, 29));
        panel.add(title);
        return panel;
    }//end of reservationNorthPanel.

    /**
     * CenterView - a method that contains all the components: JLabel an area that will display the flights information,
     * JTextField an area that will get the input from the keyboard, and JButton a button that will cause
     * an action to occur when the user clicked.
     *
     * @return centralPanel - will return all the components to display on the center of the window.
     */
    public JPanel CenterView() {
        // create JPanel object named centerPanel to handle two JPanel object for right and left side.
        JPanel centralPanel = new JPanel();
        JPanel leftCentral = new JPanel();
        // set the dimension for the whole center view.
        centralPanel.setPreferredSize(new Dimension(500, 350));
        // set the dimension for the left side of the center view.
        leftCentral.setPreferredSize(new Dimension(550, 300));
        // create the border area that will contains the flights list.
        reservationsModel = new DefaultListModel();
        reservationsList = new JList(reservationsModel);
        JScrollPane pane = new JScrollPane(reservationsList);
        reservationsList.addListSelectionListener(new MyListSelectionListener());
        pane.setPreferredSize(new Dimension(500, 220));
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
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
        // create the code area.
        JLabel CodeLabel = new JLabel();
        CodeLabel.setText("Code:");
        CodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        CodeLabel.setFont(new Font("Serif", Font.BOLD, 19));
        CodeLabel.setPreferredSize(new Dimension(100, 20));
        // create the code text field area to display the information.
        codeTextField = new JTextField();
        codeTextField.setEditable(false);
        codeTextField.setPreferredSize(new Dimension(140, 20));
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
        JLabel airlineLabel = new JLabel();
        airlineLabel.setText("Airline:");
        airlineLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        airlineLabel.setFont(new Font("Serif", Font.BOLD, 19));
        airlineLabel.setPreferredSize(new Dimension(100, 20));
        // create the airline text field area to display the information.
        airlineTextField = new JTextField();
        airlineTextField.setEditable(false);
        airlineTextField.setPreferredSize(new Dimension(140, 20));
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
        // create the status area.
        JLabel statusLabel = new JLabel();
        statusLabel.setText("Status:");
        statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 19));
        statusLabel.setPreferredSize(new Dimension(100, 20));
        String[] options = {"Active", "Inactive"};
        statusCombo = new JComboBox(options);
        // create the status text field area to display the information
        statusCombo.setPreferredSize(new Dimension(140, 20));
        // create an Update button with a preferred size.
        updateButton = new JButton("Update");
        updateButton.setPreferredSize(new Dimension(240, 30));
        updateButton.setFont(new Font("Serif", Font.BOLD, 20));
        updateButton.addActionListener(new TabButtonActionListener());
        // add all the information to the right center view.
        rightCentral.add(Reserve);
        rightCentral.add(CodeLabel);
        rightCentral.add(codeTextField);
        rightCentral.add(flightLabel);
        rightCentral.add(flightTextField);
        rightCentral.add(airlineLabel);
        rightCentral.add(airlineTextField);
        rightCentral.add(costLabel);
        rightCentral.add(costTextField);
        rightCentral.add(nameLabel);
        rightCentral.add(nameTextFiled);
        rightCentral.add(citizenshipLabel);
        rightCentral.add(citizenshipTextField);
        rightCentral.add(statusLabel);
        rightCentral.add(statusCombo);
        rightCentral.add(updateButton);
        centralPanel.add(leftCentral);
        centralPanel.add(rightCentral);
        return centralPanel;
    }// end of the CenterView method.

    /**
     * createSouthPanel - a method that create the southern area for the window. will set the dimension and the combo boxes,
     * so the user can select from the options.
     *
     * @return southPanel for the southern view for the windows.
     */
    public JPanel createSouthPanel() {
        // create the southPanel that will contains all the text field and the button.
        JPanel southPanel = new JPanel();
        // set the dimension for the southern view.
        southPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 205));
        // create the area that will display a text.
        JLabel SubName = new JLabel();
        SubName.setText("Search");
        SubName.setFont(new Font("Serif", Font.BOLD, 53));
        SubName.setHorizontalAlignment(SwingConstants.CENTER);
        SubName.setPreferredSize(new Dimension(WINDOW_WIDTH, 60));
        // create the first area that will display the reservation code.
        JLabel codeLabel = new JLabel();
        codeLabel.setText("Code:");
        codeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        codeLabel.setFont(new Font("Serif", Font.BOLD, 19));
        codeLabel.setPreferredSize(new Dimension(70, 30));
        codeCombo = new JTextField();
        codeCombo.setPreferredSize(new Dimension(730, 30));
        // create the second area that will display the reservation airline.
        JLabel airlineLabel = new JLabel();
        airlineLabel.setText("Airline:");
        airlineLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        airlineLabel.setFont(new Font("Serif", Font.BOLD, 19));
        airlineLabel.setPreferredSize(new Dimension(70, 30));
        airlineCombo = new JTextField();
        airlineCombo.setPreferredSize(new Dimension(730, 30));
        // create the third area that will display the name's of the reservation.
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 19));
        nameLabel.setPreferredSize(new Dimension(70, 30));
        nameCombo = new JTextField();
        nameCombo.setPreferredSize(new Dimension(730, 30));
        // create the last components to hold the button Find Reservation to do an action.
        findReservationButton = new JButton("Find Reservation");
        findReservationButton.setPreferredSize(new Dimension(WINDOW_WIDTH, 30));
        findReservationButton.setMargin(new Insets(20, 20, 20, 20));
        findReservationButton.setFont(new Font("Serif", Font.BOLD, 20));
        findReservationButton.addActionListener(new TabButtonActionListener());
        // add all the components to the southPanel to display to the user.
        southPanel.add(SubName);
        southPanel.add(codeLabel);
        southPanel.add(codeCombo);
        southPanel.add(airlineLabel);
        southPanel.add(airlineCombo);
        southPanel.add(nameLabel);
        southPanel.add(nameCombo);
        southPanel.add(findReservationButton);
        return southPanel;
    }//end of createSouthPanel method.


    /**
     * MyListSelectionListener - a method called when user select an item from the JList that provided to the user
     * and will set all the text field with information.
     */
    private class MyListSelectionListener implements ListSelectionListener {
        //Called when user selects an item in the JList. 
        @Override
        public void valueChanged(ListSelectionEvent e) {
            Reservation temproray = reservationsList.getSelectedValue();
            // Set all UI components.
            codeTextField.setText(temproray.getCode());
            flightTextField.setText(temproray.getFlightCode());
            airlineTextField.setText(temproray.getAirline());
            costTextField.setText("$" + temproray.getCost());
        }// end of the override valueChanged method.
    }// end of the MyListSelectionListener method.


    /**
     * TabButtonActionListener - a method that take an action based on the button that the user will click. We have two button
     * for two views. If the view on the Flight side then the user will select the components from the
     * combo boxes, then they will display the information into the text area. Otherwise, the other view
     * will be for the Reservation view and the user will provide an information to search for a Flight that already booked.
     */
    private class TabButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // if the user on the reservation view, then they will display all the components related to the reservation view.
            if ( findReservationButton == e.getSource() ) {
                // create an ArrayList from Reservation type and will hold the components.
                ArrayList<Reservation> foundReservations = new ArrayList<Reservation>();
                foundReservations.clear();
                foundReservations = reservationManager.findReservations(codeCombo.getText(), airlineCombo.getText(), nameCombo.getText());
                // add all the elements from the Reservation ArrayList to the reservationsModel.
                for (Reservation i : foundReservations) {
                    reservationsModel.addElement(i);
                }// end of loops.
                // otherwise, if the update button clicked then the reservation list will display.
            } else if ( updateButton == e.getSource() ) {
            	
                if ( nameTextFiled.equals("") || nameTextFiled == null ) {
                    JOptionPane.showMessageDialog(null, "Invalid Name.");
                }
                //check the citizenship if it's null then display the message.
                else if ( citizenshipTextField.equals("") || citizenshipTextField == null ) {
                    JOptionPane.showMessageDialog(null, "Invalid Citizenship.");
                }
                //otherwise, all the condition false, now we can make a new reservation and returned to the user.
                else {
                	
                    reservationsList.getSelectedValue().setName(nameTextFiled.getText());
                    reservationsList.getSelectedValue().setCitizenship(citizenshipTextField.getText());
                    
                    // if the user select Active then will set the Active true.
                    if ( statusCombo.getSelectedItem().equals("Active") ) {
                        reservationsList.getSelectedValue().setActive(true);
                    }
                    //otherwise, will set the active false.
                    else {
                        reservationsList.getSelectedValue().setActive(false);
                    }//end of else statement.
                }
            }//end of if statement.
        }//end of the override "actionPerformed" method. 
    }//end of "TabButtonActionListener" method.
}//class end.
