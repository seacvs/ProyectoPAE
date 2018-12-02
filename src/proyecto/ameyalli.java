  package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//hola a todos, soy leo
//hola sebas 
//hola alex
//comete el pan 

public class ameyalli extends Application {
	private static ameyalli instancia;
	public static ResourceBundle rb;
	public static DBConnection dbConnection;
	
	public Scene scene; 
	public Stage primaryStage = new Stage();
	public BorderPane pane_root;
	public static FileInputStream fis;
	public static String strIdioma ="es";
	public static String fileNamei18;
	public static String actualCenter;
	
	public static ameyalli getInstance() {
		if(instancia==null)
			instancia = new ameyalli();
		return instancia;
	}
	
	private void setRootPane(BorderPane bp) {
		pane_root = bp;
	}
	
	public void setCenter(Node node) {
		pane_root.setCenter(node);
	}
	
	public void setTempCenterName(String name) {
		actualCenter=name;
	}
	public String getTempCenterName() {
		return actualCenter;
	}
	
	public void setLenguage() throws Exception {
		if(strIdioma.equals("en")){
		 fis = new FileInputStream("src/resources/i18n/ameyalli.properties");
		 rb = new PropertyResourceBundle(fis);
		 fileNamei18 = "src/resources/i18n/ameyalli.properties";
		 strIdioma="es";
		}else{
			 fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
			 rb = new PropertyResourceBundle(fis);
			 strIdioma="en";
			 fileNamei18 = "src/resources/i18n/ameyalli_en.properties";
		}	
	}
	
	
	public String getLenguage() {
		return fileNamei18;
	}
	
	
	@Override
	public void init() throws Exception{
		super.init();
		ameyalli.instancia = this;
		dbConnection = new DBConnection();
		setLenguage();
	}
	
	public void setScene(Pane node) {
		scene = new Scene(node);
		primaryStage.setScene(scene);
	}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			setRootPane(FXMLLoader.load(getClass().getResource("menu.fxml")));
			HBox listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			pane_root.setCenter(listado);
			setTempCenterName("gym");
			
			setScene(pane_root);
			scene.getStylesheets().add("proyecto/styles.css");
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rocodromo Ameyalli");
			primaryStage.setMaximized(true);
			primaryStage.show();
		}
	
		
		
		public static void main(String[] args) throws IOException {
			 fis = new FileInputStream("src/resources/i18n/ameyalli.properties");
			 strIdioma="es";
			 fileNamei18 = "src/resources/i18n/ameyalli.properties";

			 rb = new PropertyResourceBundle(fis);
			launch(args);
		}
		
	}
