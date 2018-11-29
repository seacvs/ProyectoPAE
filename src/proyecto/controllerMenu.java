package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class controllerMenu implements Initializable {
	
	@FXML private Button gymBtn;
	@FXML private Button estBtn;
	@FXML private Button ajustesBtn;
	@FXML private Button tiendaBtn;

	
	
	public controllerMenu() {
		super();
		
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
			ResourceBundle  rb = new PropertyResourceBundle(fis);
			gymBtn.setText(rb.getString("gymBtn"));
			estBtn.setText(rb.getString("estBtn"));
			ajustesBtn.setText(rb.getString("ajustesBtn"));
			tiendaBtn.setText(rb.getString("tiendaBtn"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		HBox ventas = null;
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
			listado = FXMLLoader.load(getClass().getResource("ajustes.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	

	
	
}
