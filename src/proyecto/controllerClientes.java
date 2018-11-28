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

public class controllerClientes implements Initializable {
	
	@FXML private Button editarBtn;
	@FXML private Button agregarBtn;
	public static ResourceBundle rb;

	
	public controllerClientes() throws IOException {
		super();
		FileInputStream fis = new FileInputStream("src/resources/i18n/ameyalli.properties");
		rb = new PropertyResourceBundle(fis);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	}
	
	@FXML 
	private void agregarCliente(){
		HBox agregarNuevo = null;
		try {
			agregarNuevo = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));
			ameyalli.getInstance().setCenter(agregarNuevo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void editarCliente(){
		HBox editarCliente = null;
		try {
			editarCliente = FXMLLoader.load(getClass().getResource("editarCliente.fxml"));
			ameyalli.getInstance().setCenter(editarCliente);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
}
