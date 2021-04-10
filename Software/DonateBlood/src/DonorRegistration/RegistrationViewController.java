package DonorRegistration;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegistrationViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtTimes;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtAddress;

    @FXML
    private ComboBox<String> comboBGroup;

    @FXML
    private DatePicker dateDOB;
    
    @FXML
    private Button btnIdClose;

    @FXML
    void doNew(ActionEvent event) {
    	txtAddress.setText("");
    	txtCity.setText("");
    	txtMobile.setText("");
    	txtTimes.setText("");
    	txtName.setText("");
    	Date dateDOB = null;
    }
    Connection con;
    PreparedStatement stmt;
    
    @FXML
    private RadioButton rdoMale;

    @FXML
    private RadioButton rdoFemale;
    
    @FXML
    private Label lblResult;
    
    @FXML
    void doRegister(ActionEvent event) {
		String name=txtName.getText();
		String group=comboBGroup.getValue();
		
		String phone=txtMobile.getText();
		String address=txtAddress.getText();
		String city=txtCity.getText();
		String gender = null;
		//String gender=rdoGender.getValue();
		if(rdoMale.isSelected()==true)
		  gender = "male";
		
		else 
			if(rdoFemale.isSelected()==true)
				gender = "female";
		String counter=txtTimes.getText();
		int count=Integer.parseInt(counter);
		//int count=Integer.parseInt(txtTimes.getText());
		
		//float per=Float.parseFloat(txtPer.getText());
		LocalDate local=dateDOB.getValue();
		try {
			//													      In Parameters
			stmt=con.prepareStatement("insert into donors values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, group);
			stmt.setString(3, phone);
			stmt.setString(4, address);
			stmt.setString(5,city);
			
			stmt.setDate(6, java.sql.Date.valueOf(local));
			stmt.setInt(7, count);
			stmt.setString(8, gender);
			
			stmt.executeUpdate();//eating-went in pate of table
			lblResult.setText("Record Saved");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lblResult.setText(e.toString());
		}

    }

    @FXML
    void doUpdate(ActionEvent event) {
    	String name=txtName.getText();
    	String group=comboBGroup.getValue();
    	String mobile=txtMobile.getText();
    	String address=txtAddress.getText();
    	String city=txtCity.getText();
    	LocalDate local=dateDOB.getValue();
    	String gender=null;
    	int count=Integer.parseInt(txtTimes.getText());
    	if(rdoMale.isSelected()==true)
  		  gender = "male";
  		
  		else 
  			if(rdoFemale.isSelected()==true)
  				gender = "female";
    	try
    	{
    		stmt=con.prepareStatement("update donors set dname=?,bgroup=?,address=?,city=?,dob=?,count=?,gender=? where mobile=?");
    		stmt.setString(1, name);
			stmt.setString(2, group);
			
			stmt.setString(3, address);
			stmt.setString(4,city);
			
			stmt.setDate(5, java.sql.Date.valueOf(local));
			stmt.setInt(6, count);
			stmt.setString(7, gender);
			stmt.setString(8, mobile);
			stmt.executeUpdate();//eating-went in paste of table
			lblResult.setText("Record Updated");
			
    	}
    	catch(Exception e)
    	{
    		
    		e.printStackTrace();
			lblResult.setText(e.toString());
    	}    	
    }

    @FXML
    void doSearch(ActionEvent event) {
    	boolean search = false;
    	String mobile=txtMobile.getText();
    	try
    	{
    		stmt=con.prepareStatement("select * from donors where mobile=?");
			stmt.setString(1, mobile);
			
			ResultSet table= stmt.executeQuery();
			lblResult.setText("Record Updated");
			while(table.next())
			{
				search=true;
				String dname=table.getString("dname");
				String sbgroup=table.getString("bgroup");
				String smobile=table.getString("mobile");
				String saddress=table.getString("address");
				String scity=table.getString("city");
				Date sdob=table.getDate("dob");
				int scount=table.getInt("count");
				String sgender=table.getString("gender");
		//System.out.print(sgender);
				txtName.setText(dname);
				comboBGroup.setPromptText(sbgroup);
				txtMobile.setText(smobile);
				txtAddress.setText(saddress);
				txtCity.setText(scity);
				txtTimes.setText(String.valueOf(scount));
				
				if(sgender=="male")
				{
					rdoMale.setSelected(true);
				}
				if(sgender=="female")
				{
					rdoFemale.setSelected(true);
				}
				else 
				{
					rdoFemale.setSelected(false);
					rdoMale.setSelected(false);
				}
				
				
				LocalDate localdate = ((java.sql.Date) sdob).toLocalDate();
				dateDOB.setValue(localdate);
		
			}
		} 
    	catch (SQLException e) {
			e.printStackTrace();
			lblResult.setText(e.toString());
		}
    	if(search==false) 
    		System.out.println("Invalid rollno");
			
    	}
			
    

    @FXML
    void doClose(ActionEvent event) {
    						
    	Scene scene1=(Scene)btnIdClose.getScene();
		   scene1.getWindow().hide();
    	

    }
     
    @FXML
    
    void initialize() {
    	doConnection();
    	
    	 ArrayList<String> item=new ArrayList<String>(Arrays.asList("B","BP","O","OP","AN","AP","AB","ONv"));
         comboBGroup.getItems().addAll(item);
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
