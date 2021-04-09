package sait.frms.gui;
import javax.swing.*;

/**
 * TableBase - is an abstract class that will create a JPanel called BasePanel and from there we will create the TableBase 
 *             in the JFrame that will contains two table view "Flight view and Reservation view".
 * @author ( Prince Bansal)
 * @version ( March, 2021 )
 */
public abstract class TableBase 
{//start of class.
	
	protected JPanel BasePanel; //create a JPanel attribute.
	/**
	 * TableBase - is a default constructor will assigned the new JPanel to the BasePanel. 
	 */
	protected TableBase() 
	{
		this.BasePanel = new JPanel();
	}
	
	/**
	 * getPanel - is a method that will return all the components for the BasePanel.
	 * @return JPanel with all components.
	 */
	public JPanel getPanel() {
		return this.BasePanel;
	}
}//end of class.
