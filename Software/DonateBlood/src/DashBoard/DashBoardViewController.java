package DashBoard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashBoardViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Pic1;

    @FXML
    private ImageView Pic3;

    @FXML
    private ImageView Pic2;

    @FXML
    private ImageView Pic5;

    @FXML
    private ImageView Pic4;

    @FXML
    void doPic1(MouseEvent event) {
    	try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("DonorRegistration/RegistrationView.fxml")); 
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
    void doPic2(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Issueblood/IssueBloodView.fxml")); 
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
    void doPic3(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("DonationEntry/DonationEntryView.fxml")); 
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
    void doPic4(MouseEvent event) {
try{
	
	Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("fetchAll/fetchallView3.fxml")); 
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
    void doPic5(MouseEvent event) {
try{
    		
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("AllUnits/CurrentStatus.fxml")); 
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

    }
}
