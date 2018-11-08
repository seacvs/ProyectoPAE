package proyecto;

import java.io.IOException;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ameyalli extends Application {
	private static ameyalli instancia;
	
	
	private Scene scene; 
	private Stage primaryStage = new Stage();
	private BorderPane pane_root;
	
	
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
	
	@Override
	public void init() throws Exception{
		super.init();
		ameyalli.instancia = this;
	}
	
	public void setScene(Pane node) {
		scene = new Scene(node);
		primaryStage.setScene(scene);
	}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			//pane_root = FXMLLoader.load(getClass().getResource("menu.fxml"));		// menu inicial con 4 tabs
			setRootPane(FXMLLoader.load(getClass().getResource("menu.fxml")));
			HBox listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			pane_root.setCenter(listado);
			
			setScene(pane_root);
			scene.getStylesheets().add("proyecto/styles.css");
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rocódromo Ameyalli");
			primaryStage.show();
		}
	
		public void gymLaunch() {
			HBox listado = null;
			
			try {
				listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
				pane_root.setCenter((Parent)(listado));
				Scene scene = new Scene(pane_root);			
				scene.getStylesheets().add("proyecto/styles.css");
				
			} catch (IOException e) {
				e.printStackTrace();
			}		// menu inicial con 4 tabs
		}
		
		public static void main(String[] args) {
			launch(args);
		}
		
	}
