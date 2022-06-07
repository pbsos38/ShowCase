/**
 * 
 * Written on:5th October,2021
 * @author Ashesh Handa, Prince Bansal
 */
public class TestUnit {

	/**
	 * Description: This is the application runner.
	 * @param args- Receives a list of arguments which will be further be used for detecting the file name, sort type and compare type 
	 */
	public static void main(String[] args) {
		validateArgs(args);		
	}
	
	/**
	 * Description: - Just passes on the list of all arguments to verify sufficient arguments.
	 * @param args 
	 */

	private static void validateArgs(String[] args) {
		if(args.length<3) {
			System.out.println("Not enough arguments.");
		}else {
			prepareData(args);
		}
		
	}
	/**
	 * Description: prepareData functions separate all the data and call the AppDriver while passing all the appropriate Parameters
	 * @param args
	 */
	private static void prepareData(String[] args) {
		String fileName = null;
		String sort = null;
		String type = null;
		for(String arg: args) {
			if(Character.toLowerCase(arg.charAt(1))=='f') {
				fileName = arg.substring(2);
			}else if(Character.toLowerCase(arg.charAt(1))=='t') {
				type = arg.substring(2).toLowerCase();
			}else if(Character.toLowerCase(arg.charAt(1))=='s') {
				sort = arg.substring(2).toLowerCase();
			}
		}
		AppDriver run = new AppDriver(fileName,type,sort);
	}


}
