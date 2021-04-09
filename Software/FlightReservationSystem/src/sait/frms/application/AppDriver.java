package sait.frms.application;
import java.io.*;        // Standard import for all classes in the java.io package.
import sait.frms.gui.*;  // Standard import for all classes in the GUI package.

/**
 * Travel agency - Application program that:
 *        implement a flight reservation management system by using Front-End GUI
 *        to improve the productivity and services for the agency. The program break
 *        down into two major parts: 1. Functional Back-End. 2. Functional Front-End GUI. 
 *        
 * @author ( Prince Bansal )
 * @version ( March, 2021 )
 */
public class AppDriver 
{ // class begin

	public static void main(String[] args) throws IOException{
		MainWindow mainWindow = new MainWindow(); // create a MainWindow object.
		mainWindow.display();  // display the window to the user.
	}
} // class end
