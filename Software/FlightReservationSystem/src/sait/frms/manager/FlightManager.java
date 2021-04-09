package sait.frms.manager;
import java.io.*;    // Standard import for all classes in the java.io package. 
import java.util.*;  // Standard import for the Scanner class.
import sait.frms.problemdomain.Flight;

/**
 * FlightManager - a class that will read the Flights and Airports file from the pathname. ALso, have a methods that will help 
 *                 the user to find a flight by searching for the code of the flights. 
 * @author ( Prince Bansal )
 * @version ( March, 2021 )
 */
public class FlightManager 
{//start of the class.
	//assign all the week day to a specific variable to help the user choose which day need to find the flight.
	public static final String ANY="ANY";
	public static final String SUNDAY="SUNDAY";
	public static final String MONDAY="MONDAY";
	public static final String TUESDAY="TUESDAY";
	public static final String WEDNESDAY="WEDNESDAY";
	public static final String THURSDAY="THURSDAY";
	public static final String FRIDAY="FRIDAY";
	public static final String SATURDAY="SATURDAY";
	//create two ArrayList to hold the information for the flights and airports.
	private ArrayList<Flight> flights = new ArrayList<>();
	private ArrayList<String> airports = new ArrayList<>();
	
	/**
	 * populateAirports - a method will read the airports Excel file from the pathname and add all information 
	 *                    to the airports ArrayList, then close the file. Otherwise, will throw an exception if the file not found.
	 */
	private void populateAirports()  
	{ 
		try{
			File readAirport = new File(System.getProperty("user.dir")+"/res/airports.csv"); // Read the file from the pathname.
	        Scanner inFile = new Scanner(readAirport);  // Scanner the file while using the delimiter.
	        while(inFile.hasNextLine()) 
	        { 
	        	String airport = inFile.nextLine(); //read the whole line and signed to the airport variable.
	            airports.add(airport); //add the value of the airport to the ArrayList. 
	        }//end while
	        inFile.close(); //close the file after we read all the lines.
		}//end try.
		catch(IOException e) {
			e.printStackTrace();
		}//end catch.
	}//end of the method.
	
	/**
	 * populateFlights - a method will read the flights Excel file from the pathname and add all information 
	 *                   to the flights ArrayList, then close the file. Otherwise, will throw an exception if the file not found.
	 */
	private void populateFlights ()
	{
		try
		{
			File readFlight = new File(System.getProperty("user.dir")+"/res/flights.csv"); // Read the file from the pathname.
			Scanner inFile = new Scanner(readFlight);  // Scanner the file while using the delimiter.
			while(inFile.hasNextLine())
			{
				String code = inFile.nextLine();
				//read the line and check the flight code which airlines belong to.
				if( ("" + code.charAt(0) + code.charAt(1)).equals("OA") ||
			        ("" + code.charAt(0) + code.charAt(1)).equals("CA") ||
			        ("" + code.charAt(0) + code.charAt(1)).equals("TB") ||
		            ("" + code.charAt(0) + code.charAt(1)).equals("VA")   ) 
				{ 
					// assigned all the information to the specific index for the flights.  
					String[] temp=code.split(",");
      			    String _code=temp[0];
      			    String _from=temp[1];
      			    String _to=temp[2];
      			    String _weekday=temp[3];
      			    String _time=temp[4];
      			    int _seats=Integer.parseInt(temp[5]);
      			    double _costPerSeat =Double.parseDouble(temp[6]);
      			    //create a Flight object for a specific constructor in the FLight class and assigned to flights ArrayList. 
      			    flights.add(new Flight(_code, _from, _to,_weekday,_time, _seats,_costPerSeat ));
      			}//end of if statement.
     		}//end of while loop.
			    inFile.close(); //close the file after we read all the lines.
		}//end of try block.
		catch(IOException e) {
			e.printStackTrace();
		}
	}//end of "populateFlight" method.
	
	/**
	 * FlightManager - a constructor will called two method to do some action.
	 */
	public FlightManager() {
		populateAirports();
		populateFlights();
	}

	/**
	 * getFlights - an ArrayList method that will return the flights.
	 * @return the flight information.
	 */
	public ArrayList<Flight> getFlights() {
		return this.flights;
	}

	/**
	 * getAirports - an ArrayList method that will return the airports. 
	 * @return the airport information.
	 */
	public ArrayList<String> getAirports() {
		return this.airports;
	}
	
	/**
	 * findAirportsByCode - a method that receive a parameter called code will return the airports by searching by the code.
	 * @param code - have the value of the code.
	 * @return the airport information.
	 */
	public String findAirportByCode (String code) 
	{
		//for loop to search for the equal code.
		for(String i : airports) {
			//if the code match will return the information.
			if(i.substring(0, 3).equals(code)) {
				return i;
			}//end if statements.
		}//end for loop.
		return null;	
	}//end method.
	
	/**
	 * findFlightByCode - a method that receive a parameter called code and will return the flight by searching by the code.
	 * @param code - have the value of the code.
	 * @return the flight information. 
	 */
	public Flight findFlightByCode (String code) 
	{
		//for loop to search for the equal code.
		for(Flight i : flights) {
			//if the code match will return the information.
			if(i.getCode().equals(code)) {
				return i;
			}//end if statement.
		}//end for loop.
		return null;
	}//end method.
	
	/**
	 * findFlight - a method that receive three parameter and search for the flight based on the value that received and return the result.
	 * @param from    - hold the value of which airport departure from.
	 * @param to      - hold the value of which airport arrive to.
	 * @param weekday - hold the value of which day you select to travel.
	 * @return the flight on that day. 
	 */
	public ArrayList<Flight> findFlights (String from, String to, String weekday) 
	{
		//create an ArrayList to assign the result into it.
		ArrayList<Flight> flightOnDay = new ArrayList<Flight>();
		//for loop to search for the flight if it is matched the value of the parameters/
		for(Flight i : flights) {
			//if equal to any day, so will add the flight into the ArrayList.
			if ( weekday.equals("ANY") )
			{
				if(i.getForm().equals(from) && i.getTo().equals(to)) {
					flightOnDay.add(i);
				}
			}//end if statement.
			//otherwise, the day won't be any, so they will start search and add the flights into the ArrayList.
			else{
				if(i.getForm().equals(from) && i.getTo().equals(to) && i.getWeekday().equalsIgnoreCase((weekday))) {
					flightOnDay.add(i);
				}//end if statement.
			}//end else.
		}//end for loop.
		return flightOnDay;
	}//method end.
}//class end.
