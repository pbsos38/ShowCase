package Login;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

	Connection con;
	PreparedStatement stmt;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUid;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtpwd;

    @FXML
    void doLogin(ActionEvent event) {
    	String uid=txtUid.getText();
    	String pwd=txtpwd.getText();
    	try {
			stmt=con.prepareStatement("select * from dashboard where uid=?and pwd=?");
			stmt.setString(1, uid);
			stmt.setString(2,pwd);
			ResultSet table =stmt.executeQuery();
			lblResult.setText("login successfull");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			lblResult.setText(e.toString());
			
		} 
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("DashBoard/DashBoardView2.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
