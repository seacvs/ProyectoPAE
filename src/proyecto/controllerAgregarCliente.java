package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class controllerAgregarCliente implements Initializable {
	
	@FXML private Button listoBtn;
	@FXML private Button cancelarBtn;
	public static ResourceBundle rb;

	
	public controllerAgregarCliente() throws IOException {
		super();
		FileInputStream fis = new FileInputStream("src/resources/i18n/ameyalli.properties");
		 rb = new PropertyResourceBundle(fis);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	}
	
	@FXML 
	private void cancelar(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void listo(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
}
