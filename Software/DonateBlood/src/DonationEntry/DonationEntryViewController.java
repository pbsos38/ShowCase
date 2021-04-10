package DonationEntry;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DonationEntryViewController {
 Connection con;
 PreparedStatement stmt;
   
 	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMobile;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtBGroup;

   @FXML
    void DoSearch(ActionEvent event) {
	   boolean search=false;
	   String mobile=txtMobile.getText();
	   try {
		stmt=con.prepareStatement("select* from donors where mobile=?");
		stmt.setString(1, mobile);
		ResultSet table=stmt.executeQuery();
		while (table.next()) {
			search=true;
			String name=table.getString("bGroup");
			txtBGroup.setText(name);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		lblResult.setText(e.toString());
	}
	   
    }

    @FXML
    void DoUpdate(ActionEvent event) {
    	String mobile=txtMobile.getText();
    	String bg=txtBGroup.getText();
    	try
 	   {
 		   stmt=con.prepareStatement("update units set"+bg+"="+bg+"+1");
 		   stmt.executeUpdate();
 	   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 		   lblResult.setText(e.toString());
 	   }
    	try {
			stmt=con.prepareStatement("update donors set count=count+1 where mobile=?");
			
			stmt.setString(1, mobile);
			int count=stmt.executeUpdate();//eating-went in pate of table
			if(count==0)
				lblResult.setText("Invalid id");
			else
				lblResult.setText(count+" Records Updated");
    	} catch (SQLException e) {
			e.printStackTrace();
			lblResult.setText(e.toString());
		}
    }

    @FXML
    
    void initialize() {
    	doConnection();
}

	/* public static */ void doConnection()
   	{
   		try {
   			Class.forName("com.mysql.jdbc.Driver");
   			con=DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
   			System.out.println("Connected.......");
   			
   			
   		} 
   		catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	}
//    public static void main(String arg[]) {
//   	 doConnection();
//    }

}
