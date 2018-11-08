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

public class controllerMenu implements Initializable {
	
	
	
	
	public controllerMenu() {
		super();
	}
	@FXML private Button gymBtn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	}
	
	@FXML 
	private void gymInit(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void tiendaInit(){
		VBox ventas = null;
		try {
			ventas = FXMLLoader.load(getClass().getResource("puntoVenta.fxml"));
			ameyalli.getInstance().setCenter(ventas);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@FXML 
	private void estadisticasInit(){
		Node estadisticas = null;
		try {
			estadisticas = FXMLLoader.load(getClass().getResource("estadisticas.fxml"));
			ameyalli.getInstance().setCenter(estadisticas);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	@FXML 
	private void ajustesInit(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	

	
	
}
