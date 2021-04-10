package SignUp;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpViewController {
 Connection con;
 PreparedStatement stmt;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblResults;

    @FXML
    private TextField txtuid;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtPwd;

    @FXML
    void doSignUp(ActionEvent event) {
    	String uid=txtuid.getText();
    	String pwd=txtPwd.getText();
    	String mobile=txtMobile.getText();
    	try
    	{
    		stmt=con.prepareStatement("insert into dashboard values(?,?,?)");
    		
    		stmt.setString(1, uid);
			stmt.setString(2, pwd);
			stmt.setString(3, mobile);
			
			stmt.executeUpdate();//eating-went in pate of table
			lblResults.setText("Record Saved");
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lblResults.setText(e.toString());
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

