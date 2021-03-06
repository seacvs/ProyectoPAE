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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class controllerMenu implements Initializable {
	
	@FXML private Button gymBtn;
	@FXML private Button estBtn;
	@FXML private Button ajustesBtn;
	@FXML private Button tiendaBtn;
	@FXML private Label lbl_ameyalli;
	
	FileInputStream fis;
	ResourceBundle  rb;
	
	public controllerMenu() {
		super();
		try {

		 fis = new FileInputStream(ameyalli.getInstance().getLenguage());
		 rb = new PropertyResourceBundle(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
			gymBtn.setText(rb.getString("gymBtn"));
			estBtn.setText(rb.getString("estBtn"));
			ajustesBtn.setText(rb.getString("ajustesBtn"));
			tiendaBtn.setText(rb.getString("tiendaBtn"));
			lbl_ameyalli.setFont(new Font("Copperplate Gothic Bold",22));
	}
	
	
	private void updateLanguage() throws IOException{
		try {

			 fis = new FileInputStream(ameyalli.getInstance().getLenguage());
			 rb = new PropertyResourceBundle(fis);
			 	gymBtn.setText(rb.getString("gymBtn"));
				estBtn.setText(rb.getString("estBtn"));
				ajustesBtn.setText(rb.getString("ajustesBtn"));
				tiendaBtn.setText(rb.getString("tiendaBtn"));
				
				String s= ameyalli.getInstance().getTempCenterName();
				switch (s){
				case "gym": gymInit();
							break;
				case "tienda": tiendaInit();
								break;
				case "nuevo": agregarCliente();
								break;
				case "estadisticas": estadisticasInit();
								break;
				default:  gymInit();
						break;		
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	@FXML 
	private void gymInit(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			ameyalli.getInstance().setTempCenterName("gym");
			
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
			ameyalli.getInstance().setTempCenterName("tienda");
			
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
			ameyalli.getInstance().setTempCenterName("estadisticas");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	


	private void agregarCliente(){
		HBox agregarNuevo = null;
		try {
			agregarNuevo = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));
			ameyalli.getInstance().setCenter(agregarNuevo);
			ameyalli.getInstance().setTempCenterName("nuevo");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void ajustesInit() throws Exception{
		System.out.print("change lenguage from : "+ameyalli.strIdioma);
		ameyalli.getInstance().setLenguage();
		System.out.println(" to "+ameyalli.strIdioma);
		updateLanguage();
		
	}
	
	

	
	
}