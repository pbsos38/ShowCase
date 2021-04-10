package Issueblood;

import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IssueBloodViewController {
	Connection con;
	PreparedStatement stmt;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblResults;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtUnits2;

    @FXML
    private TextField txtReason;

    @FXML
    private TextField txtAmount;

    @FXML
    private ComboBox<String> comboBGroup;

    @FXML
    private TextField txtHospital;

    @FXML
    private TextField txtRequiredUnits;
    
    @FXML
    private TextField txtAdhar;

    @FXML
    private DatePicker dateIssue;

    @FXML
    void FindBlood(ActionEvent event) {
    	String loc=comboBGroup.getValue();
    	//int index=comboBGroup.getSelectionModel().getSelectedIndex();
    	{
    		try {
				stmt=con.prepareStatement("select "+loc+" as 'count' from units");// where "+loc+"="+loc+"");
				ResultSet table= stmt.executeQuery();
				
				while(table.next())
				{
					int c1=table.getInt("count");
					txtUnits2.setText(String.valueOf(c1));
				}
				
				
			} 
    		catch (SQLException e) {
				e.printStackTrace();
			}			
			
			
    	}
    }
    @FXML
    void doBill(ActionEvent event) {
    	String required=txtRequiredUnits.getText();
		int amount1=Integer.parseInt(required)*1000;
		txtAmount.setText(String.valueOf(amount1));
    }

    @FXML
    void doGetIssued(ActionEvent event) 
    {
    	String name=txtName.getText();
    	String mobile=txtMobile.getText();
    	String aadhar=txtAdhar.getText();
    	String reason=txtReason.getText();
    	String hospital=txtHospital.getText();
    	//date
    	LocalDate local=dateIssue.getValue();
    	String bloodgrp=comboBGroup.getValue();
    	String availunits=txtUnits2.getText();
    	String amount=txtAmount.getText();
    	String require=txtRequiredUnits.getText();
    	
    	try {
			stmt=con.prepareStatement("insert into needy value(?,?,?,?,?,?,?,?)");
			stmt.setString(1,name);
    		stmt.setString(2,mobile);
    		stmt.setString(3,aadhar);
    		stmt.setString(4,reason);
    		stmt.setString(5,hospital);
    		stmt.setDate(6, java.sql.Date.valueOf(local));
    		stmt.setString(7,bloodgrp); 
    		stmt.setString(9,amount);
    		stmt.setString(8, require);
    		
    		stmt.executeUpdate();
			lblResults.setText("Record Saved");
	
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lblResults.setText(e.toString());
		}
    	String mobile1=txtMobile.getText();
    	String bg=txtRequiredUnits.getText();
    	int bg1=Integer.parseInt(bg);
    	String cg=txtUnits2.getText();
    	int cg2=Integer.parseInt(cg);
    	
    	try
  	   {
  		   stmt=con.prepareStatement("update units set"+bloodgrp+"="+bloodgrp+"-"+bg1+"");
  		   stmt.executeUpdate();
  	   }
  	   catch(Exception e)
  	   {
  		   e.printStackTrace();
  		   lblResults.setText(e.toString());
  	   }
    	
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

