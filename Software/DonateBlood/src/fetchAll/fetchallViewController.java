package fetchAll;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class fetchallViewController {
	Connection con;
	PreparedStatement stmt;
    @FXML
    private ResourceBundle resources;

    @FXML
    private ComboBox<String> Sort;
    
    @FXML
    private URL location;

    @FXML
    private TableView<userbean> showtable;

    @FXML
    void doshowall(ActionEvent event)
    {
    	
    	TableColumn<userbean, String> col1=new TableColumn<userbean, String>("dname");//name to be shown
    	col1.setCellValueFactory(new PropertyValueFactory<>("dname"));//name of bean property
    	col1.setMinWidth(100);
    	
    	TableColumn<userbean, String> col2=new TableColumn<userbean, String>("bgroup");
    	col2.setCellValueFactory(new PropertyValueFactory<>("bgroup"));
    	col2.setMinWidth(100);
    	
    	TableColumn<userbean, String> col3=new TableColumn<userbean, String>("mobile");
    	col3.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    	col3.setMinWidth(100);
    	
    	TableColumn<userbean, String> col4=new TableColumn<userbean, String>("address");
    	col4.setCellValueFactory(new PropertyValueFactory<>("address"));
    	col4.setMinWidth(100);
    	
    	TableColumn<userbean, String> col5=new TableColumn<userbean, String>("city");
    	col5.setCellValueFactory(new PropertyValueFactory<>("city"));
    	col5.setMinWidth(100);
    	
    	TableColumn<userbean, String> col6=new TableColumn<userbean, String>("dob");
    	col6.setCellValueFactory(new PropertyValueFactory<>("dob"));
    	col6.setMinWidth(100);
    	
    	TableColumn<userbean, String> col7=new TableColumn<userbean, String>("count");
    	col7.setCellValueFactory(new PropertyValueFactory<>("count"));
    	col7.setMinWidth(100);
    	
    	TableColumn<userbean, String> col8=new TableColumn<userbean, String>("gender");
    	col8.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	col8.setMinWidth(100);
    	
    	showtable.getColumns().addAll(col1,col2,col3,col4,col5,col6,col7,col8);
    	showtable.setItems(getRecords());
    	
    }
     
    ObservableList<userbean> getRecords()
    {
    	ObservableList<userbean> ary=FXCollections.observableArrayList();
    	String bgroup1=Sort.getValue();
    	try {
			stmt=con.prepareStatement("select * from donors where bgroup=?");
			stmt.setString(1, bgroup1);
			
    		//stmt=con.prepareStatement("select * from donors");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String dname=rs.getString("dName");
				String bgroup=rs.getString("bGroup");
				String mobile=rs.getString("mobile");
				String address=rs.getString("address");
				String city=rs.getString("city");
				String dob=rs.getString("dob");
				String count=rs.getString("count");
				String gender=rs.getString("gender");
				
				System.out.println(dname+"   "+bgroup);
				userbean bean=new userbean(dname, bgroup, mobile, address, city, dob, count, gender);
				ary.add(bean);
			}		
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ary;
    }
    

    void doConnection()
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
    @FXML
    void doSort(ActionEvent event) {

    }

    @FXML
    void initialize()
    {
    	doConnection();
    	ArrayList<String> item=new ArrayList<String>(Arrays.asList("B","BP","O","OP","AN","AP","AB","ONv"));
        Sort.getItems().addAll(item);

    }
}