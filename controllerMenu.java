package proyecto;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class controllerMenu extends ameyalli implements Initializable {
	@FXML private Button gymBtn;

	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		
	}
	
	@FXML 
	private void gymInit(){
		super.gymLaunch();
	}
	
	

	
	
}
