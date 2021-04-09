package sait.frms.manager;

import java.io.*;
import java.io.IOException;
import java.util.*;  // Standard import for the Scanner class.

import sait.frms.manager.ReservationManager;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

import javax.swing.*;

/**
 * ReservationManager - a class that will generate a reservation code for the user. ALso, we make and find a reservation by searching
 * the code of the reservation. Also, save all reservation objects to a binary file on the hard drive.
 *
 * @author (Prince Bansal)
 * @version (March, 2021)
 */
public class ReservationManager {
    //create an ArrayList to hold all the reservation.
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    /**
     * getAvailableSeats - a method that will search for available seat and return the seat.
     *
     * @param flight - this will hold a flight object
     * @return the available seat.
     */
    private int getAvailableSeats(Flight flight) {
        return flight.getSeats();
    }

    /**
     * generateReservationCoe - a method that will receive a parameter called flight and generate a reservation code based on format:
     * (L meaning letter, D meaning Digit) l.e.: LDDDD. The letter either will be "D" for Domestic
     * or "I" for international and return the generation code.
     *
     * @param flight - this will hold a flight object
     * @return the generation number for the flight.
     */
    private String generateReservationCode(Flight flight) {
        //generate a random number from 0 to 9999.
        int randomNumber = (int) (Math.random() * 9999);
        //check number if it is less than 1000 add 1000 to it.
        if ( randomNumber <= 1000 ) {
            randomNumber = randomNumber + 1000;
        }
        //check if the flight Domestic of International. If Domestic add D letter to the randomNumber, otherwise add I.  
        if ( flight.isDemostic() == false ) {
            return "I" + randomNumber;
        }
        return "D" + randomNumber;
    }//method end.

    /**
     * makeReservatin - a method that receive three parameters to make the reservation.
     *
     * @param flight      - this will hold a flight object
     * @param name        - this will hold name of the traveller
     * @param citizenship - this will hold the citizenship of the traveller
     * @return the new reservation when it made it.
     */
    public Reservation makeReservation(Flight flight, String name, String citizenship) {
        try {
            //check the available seat if it's equal to zero then display the alert message.
            if ( getAvailableSeats(flight) == 0 ) {
                JOptionPane.showMessageDialog(null, "Flight is Full.");
                throw new Exception("Flight is Full!");
            }
            //check the name if it's null then display the message.
            else if ( name.contentEquals("") || name == null ) {
                JOptionPane.showMessageDialog(null, "Invalid Name.");
                throw new Exception("Invalid Name");
            }
            //check the citizenship if it's null then display the message. 
            else if ( citizenship.equals("") || citizenship == null ) {
                JOptionPane.showMessageDialog(null, "Invalid Citizenship.");
                throw new Exception("Invalid Citizenship");
            }
            //otherwise, all the condition false, now we can make a new reservation and returned to the user.
            else {
                Reservation newReservation = new Reservation(generateReservationCode(flight), flight.getCode(), flight.getAirline(), name, citizenship, (double) (flight.getCostPerSeat()), true);
                reservations.add(newReservation);
                persist();
                JOptionPane.showMessageDialog(null, "Reservation Created. Your code is " + newReservation.getCode() + ".");
                return newReservation;
            }
        }//end try block. 
        catch (Exception e) {
            e.printStackTrace();
        }//end catch block.
        return null;
    }//method end.

    /**
     * findReservation -  a method that will find an existing reservation flight and return the result to the user.
     *
     * @param code    - this will hold reservation code
     * @param airline - this will hold the airline name for trip booked
     * @param name    - this will hold the name of the customer
     * @return the reservation flight that found.
     */
    public ArrayList<Reservation> findReservations(String code, String airline, String name) {
        //create an ArrayList to hold any reservation flight found.
        ArrayList<Reservation> reservationsFound = new ArrayList<Reservation>();
        reservationsFound.clear();
        //check the airline and the name if it's null then will call the findReservationCode to find it by the code.
        if ( (airline.equals("") || airline == null) && (name.equals("") || name == null) ) {
            reservationsFound.add(findReservationByCode(code));
        }
        //otherwise, the airline and the name not null, then we will find the reservation.
        else {
            //for loop to search for the reservation flight.
            for (Reservation i : reservations) {
                if ( i.getCode().equals(code) || i.getAirline().equals(airline) || i.getName().equals(name) ) {
                    reservationsFound.add(i);
                }
            }//end of loop.
        }//end of else.
        return reservationsFound;
    }//method end.

    /**
     * findReservationByCode - a method that receive one parameter called code to search for a reservation flight by code.
     *
     * @param code - this will hold the reservation code
     * @return the reservation by the code.
     */
    public Reservation findReservationByCode(String code) {
        //for loop to search for the reservation flight by the code.
        for (Reservation i : reservations) {
            if ( i.getCode().equals(code) ) {
                return i;
            }
        }//end of loop.
        return null;
    }//method end.

    /**
     * persist - a method that saves all Reservation objects to a binary file on the hard drive.
     */
    public void persist() {
        try {
            FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "/res/reservations.txt", true);
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeUTF(reservations.get(reservations.size() - 1).getCode());
            output.writeUTF(reservations.get(reservations.size() - 1).getFlightCode());
            output.writeUTF(reservations.get(reservations.size() - 1).getAirline());
            output.writeUTF(reservations.get(reservations.size() - 1).getName());
            output.writeUTF(reservations.get(reservations.size() - 1).getCitizenship());
            output.writeDouble(reservations.get(reservations.size() - 1).getCost());
            output.writeBoolean(reservations.get(reservations.size() - 1).isActive());
            output.reset();
        }//end try block.
        catch (IOException e) {
            e.printStackTrace();
        }//end catch block.
    }//method end

    /**
     * ReservtionManager - a default constructor for this class will call the populateFromBinary method.
     */
    public ReservationManager() {
        populateFromBinary();
    }

    /**
     * populateFromBinary - a method that provide the reservation list that set inactive and retained when the program run again.
     */
    private void populateFromBinary() {
        boolean attempt = true;

        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/res/reservations.txt");
            ObjectInputStream input = new ObjectInputStream(file);
            while (attempt) {
                String _code = (String) (input.readUTF());
                String _flightCode = input.readUTF();
                String _airline = input.readUTF();
                String _name = input.readUTF();
                String _citizenship = input.readUTF();
                double _cost = input.readDouble();
                boolean _active = input.readBoolean();
                reservations.add(new Reservation(_code, _flightCode, _airline, _name, _citizenship, _cost, _active));
            }
            file.close();
        } catch (Exception w) {
            attempt = false;
        }//end try block.

    }//method end.
}//class end.


