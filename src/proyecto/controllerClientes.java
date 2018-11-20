package proyecto;

import java.awt.ScrollPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class controllerClientes implements Initializable {
	
	@FXML private Button editarBtn;
	@FXML private Button agregarBtn;

	
	public controllerClientes() {
		super();
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
