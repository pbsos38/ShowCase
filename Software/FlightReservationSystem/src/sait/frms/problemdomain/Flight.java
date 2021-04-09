package sait.frms.problemdomain;


/**
 * Flight - a class that include all the attribute and the constructor for the Flight.
 * 
 * @author ( Prince Bansal )
 * @version ( March, 2021 )
 */
public class Flight 
{
	//define all the attribute we need for the Flight class.
	private String code="";           //hold the code of the Flight.
	private String airlineName="";    //hold the airline name of the Flight.
	private String from="";           //hold the departure airport for the FLight.
	private String to="";             //hold the arriver airport for the Flight.
	private String weekday="";        //hold the day of the Flight.
	private String time="";           //hold the time of the Flight.
	private int seats=0;              //hold the sear number of the Flight.
	private double costPerSeat=0.0;   //hold the cost of the Flight seat.
	
	/**
	 * Flight - create a Flight constructor with a specific attribute.
	 * 
	 * @param _code        - hold the flight code.
	 * @param _from        - hold the departure airport of the Flight.
	 * @param _to          - hold the arrive airport of the Flight.
	 * @param _weekday     - hold the day of the week of the FLight.
	 * @param _time        - hold the time of the FLight.
	 * @param _seats       - hold the seat number of the Flight.
	 * @param _costPerSeat - hold the cost of the Flight seat.
	 */
	public Flight(String _code, String _from, String _to, String _weekday, String _time, int _seats, double _costPerSeat) 
	{
		this.code = _code;
		this.from = _from;
		this.to = _to;
		this.weekday = _weekday;
		this.time = _time;
		this.seats = _seats;
		this.costPerSeat = _costPerSeat;
		parseCode(_code);

	}//constructor end.
	
	/**
	 * perseCode - a method used to set the code of the Flight.
	 * @param code - assigned to the code.
	 */
	private void parseCode (String code) {
		//check the code of which airline belong to and assign the name of the airline to the airlineName attribute.
		String temp = "" + code.charAt(0) + code.charAt(1);
		switch (temp) {
			case "OA":
				this.airlineName = "Otto Airlines";
				break;
			case "CA":
				this.airlineName = "Conned Air";
				break;
			case "TB":
				this.airlineName = "Try a Bus Airways";
				break;
			case "VA":
				this.airlineName = "Vertical Airways";
				break;
		}
		this.code = code;
	}
	
//	/**
//	 * setCode - a method used to set the code of the Flight.
//	 * @param code - assigned to the code.
//	 */
//	public void setCode(String code) {
//		this.code = code;
//	}
	
	/**
	 * getCode - a method used to get the code of the Flight.
	 * @return the code of the Flight.
	 */
	public String getCode() {
		return code;
	}
	
//	/*8
//	 * setFrom - a method used to set the departure airport of the Flight.
//	 * @param from - hold assigned to the from.
//	 */
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
	/**
	 * getForm - a method used to get the departure airport of the FLight.
	 * @return the departure airport of the Flight.
	 */
	public String getForm() {
		return from;
	}
	
//	/**
//	 * setTo - a method used to set the arrives airport of the Flight.
//	 * @param to - assigned to to variable.
//	 */
//	public void setTo(String to) {
//		this.to = to;
//	}
//
	/**
	 * getTo - a method used to get the arrives airport of the Flight.
	 * @return the arrives airport of the Flight.
	 */
	public String getTo() {
		return to;
	}
	
//	/**
//	 * setWeekday - a method used to set the day of the Flight.
//	 * @param weekday - assigned to weekday.
//	 */
//	public void setWeekday(String weekday) {
//		this.weekday = weekday;
//	}
//
	/**
	 * getWeekday - a method used to get the day of the Flight.
	 * @return the day of the FLight.
	 */
	public String getWeekday() {
		return weekday;
	}
	
//	/**
//	 * setTime - a method used to set the time of the Flight.
//	 * @param time - assigned to time.
//	 */
//	public void setTime(String time) {
//		this.time = time;
//	}
//
	/**
	 * getTime - a method used to get the time of the Flight.
	 * @return the time of the FLight.
	 */
	public String getTime() {
		return time;
	}
	
//	/**
//	 * setSeats     - a method used to set the seat number of the Flight.
//	 * @param seats - assigned to seats.
//	 */
//	public void setSeats(int seats) {
//		this.seats = seats;
//	}
//
	/**
	 * getSeats - a method used to get the seat number of the Flight.
	 * @return the seat number of the Flight.
	 */
	public int getSeats() {
		return seats;
	}
	
//	/**
//	 * setCostPerSeat - a method used to set the code of the Flight seat.
//	 * @param costPerSeat - assigned to costPerSeat.
//	 */
//	public void setCostPerSeat(double costPerSeat) {
//		this.costPerSeat = costPerSeat;
//	}
//
	/**
	 * getCostPerSeat - a method used to get the cost of the Flight seat.
	 * @return the code of the Flight seat.
	 */
	public double getCostPerSeat() {
		return costPerSeat;
	}
//
//	/**
//	 * setAirline - a method used to set the airline of the Flight.
//	 * @param airlineName - assigned to airlineName.
//	 */
//	public void setAirline(String airlineName) {
//		this.airlineName = airlineName;
//	}
	
	/**
	 * getAirline - a method used to get the airline name of the Flight.
	 * @return the airline name of the Flight.
	 */
	public String getAirline() {
		return airlineName;
	}
	
	/**
	 * isDemostic - a method that check the departure or arrive flight if it's Canadian or International.
	 * @return on of the condition. 
	 */
	public boolean isDemostic() 
	{
		return this.from.charAt(0) == 'Y' || this.to.charAt(0) == 'Y';
	}
	
	/**
	 * toString() - an Override the toString method defined in this class. 
	 */
	@Override
	public String toString() {
		return code+", From: "+from+", To: "+to+", Day: "+weekday+", Cost: "+costPerSeat;
	}	
}//end of the class.
