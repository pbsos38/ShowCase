package AllUnits;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import AllUnits.UnitBean;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CurrentStatusController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<UnitBean> tblRecord;
    
    Connection con;
    PreparedStatement stmt;
    ResultSet rs;


    @FXML
    void btnShow(ActionEvent event) { 
    	
    	TableColumn<UnitBean, String> BC=new TableColumn<UnitBean, String>("B");
     	BC.setCellValueFactory(new PropertyValueFactory<>("B"));
     	BC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> BPC=new TableColumn<UnitBean, String>("BP");
     	BPC.setCellValueFactory(new PropertyValueFactory<>("BP"));
     	BPC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> OC=new TableColumn<UnitBean, String>("O");
     	OC.setCellValueFactory(new PropertyValueFactory<>("O"));
     	OC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> OPC=new TableColumn<UnitBean, String>("OP");
     	OPC.setCellValueFactory(new PropertyValueFactory<>("OP"));
     	OPC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> ANC=new TableColumn<UnitBean, String>("AN");
     	ANC.setCellValueFactory(new PropertyValueFactory<>("AN"));
     	ANC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> APC=new TableColumn<UnitBean, String>("AP");
     	APC.setCellValueFactory(new PropertyValueFactory<>("AP"));
     	APC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> ABC=new TableColumn<UnitBean, String>("AB");
     	ABC.setCellValueFactory(new PropertyValueFactory<>("AB"));
     	ABC.setMinWidth(100);
     	
     	TableColumn<UnitBean, String> ONvC=new TableColumn<UnitBean, String>("ONv");
     	ONvC.setCellValueFactory(new PropertyValueFactory<>("ONv"));
     	ONvC.setMinWidth(100);
     	
     	tblRecord.getColumns().addAll(BC,BPC,OC,OPC,ANC,APC,ABC,ONvC);
     	tblRecord.setItems(getRecords());

    }
    
    ObservableList<UnitBean> getRecords()
    {
    	ObservableList<UnitBean> ary= FXCollections.observableArrayList();   
    	try {
    		stmt=con.prepareStatement("select * from units");
    		rs=stmt.executeQuery();
    		while(rs.next())
    		{
    			String B=rs.getString("B");
    			String BP=rs.getString("BP");
    			String O=rs.getString("O");
    			String OP=rs.getString("OP");
    			String AN=rs.getString("AN");
    			String AP=rs.getString("AP");
    			String AB=rs.getString("AB");
    			String ONv=rs.getString("ONv");
    			
    			UnitBean bean= new UnitBean(B,BP,O,OP,AN,AP,AB,ONv);
    			ary.add(bean);
    		}
    			
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    	return ary;
    }

    void doConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","");
			System.out.println("File Connected.....");
			
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @FXML
    void initialize() {
    	doConnection();
  }
}
