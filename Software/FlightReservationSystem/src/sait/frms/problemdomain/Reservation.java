package sait.frms.problemdomain;

/**
 * Reservation - a class that include all the attribute and the constructor for the Reservation.
 * @author ( Prince Bansal)
 * @version ( March, 2021 )
 */
public class Reservation 
{	
	//define all the attribute we need for the Flight class.
	private String code="";          //hold the code of the Reservation.
	private String flightCode="";    //hold the code of the Flight.
	private String airline="";       //hold the airline name of the Reservation.
	private String name="";          //hold the name of the customer.
	private String citizenship="";   //hold the citizenship of the customer.
	private double cost=0.0;         //hold the cost of the Reservation flight.
	private boolean active=true;     //hold the type of the reservation Active or Inactive.
	
	/**
	 * Reservation - create a Reservation constructor with a specific attribute.
	 * 
	 * @param code        - hold the Reservation code.
	 * @param flightCode  - hold the flight code.
	 * @param airline     - hold the airline name of the reservation.
	 * @param name        - hold the name of the customer who made the reservation.
	 * @param citizenship - hold the citizenship of the customer.
	 * @param cost        - hold the cost of the reservation.
	 * @param active      - hold the type of the reservation active or inactive. 
	 * 
	 */
	public Reservation(String code, String flightCode, String airline, String name, String citizenship, double cost,boolean active)
	{	
		this.code = code;
		this.flightCode = flightCode;
		this.airline = airline;
		this.name = name;
		this.citizenship = citizenship;
		this.cost = cost;
		this.active = active;
	}
	
	/**
	 * getName - a method used to get the name of the customer.
	 * @return the name of the customer.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * setName - a method used to set the customer name for this reservation.
	 * @param name - assigned to the name. 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getCitizenship - a method used to get the citizenship of the customer.
	 * @return the citizenship of the customer.
	 */
	public String getCitizenship() {
		return citizenship;
	}
	
	/**
	 * setCitizenship - a method used to set the citizenship of the customer.
	 * @param citizenship - assigned to the citizenship.
	 */
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	
	/**
	 * isActive - a method used to check if the reservation is Active or not.
	 * @return true if the reservation Active otherwise false (Inactive). 
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * setAvtive - a method used to set the type of the reservation.
	 * @param active - assigned to the active. 
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * getCode - a method used to get the code of the reservation.
	 * @return the code of the reservation.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * getFlightCode - a method used to get the code of the Flight.
	 * @return the code of the Flight.
	 */
	public String getFlightCode() {
		return flightCode;
	}
	
	/**
	 * getAirline - a method used to get the name of the Airline.
	 * @return the name of the airline.  
	 */
	public String getAirline() {
		return airline;
	}
	
	/**
	 * getCost - a method used to get the cost of the reservation.
	 * @return the cost of the reservation.
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * toString() - an Override the toString method defined in this class. 
	 */
	@Override
	public String toString() {
		return "Reservation Code= "+code+", Flight Code= "+flightCode+", Airline= "+airline+", Name= "+name
				+", Citizenship= "+citizenship+", Cost= "+cost;	
	}
}//end of the class.
