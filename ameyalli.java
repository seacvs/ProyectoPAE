package proyecto;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ameyalli extends Application {
	BorderPane root;
	public static void main(String[] args) {
		launch(args);
	
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
		
			root = FXMLLoader.load(getClass().getResource("menu.fxml"));		// menu inicial con 4 tabs
		
			//VBox listado = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));
			//root.setCenter((Parent)(listado));
			Scene scene = new Scene(root);			
			scene.getStylesheets().add("proyecto/styles.css");
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Rocódromo Ameyalli");
			primaryStage.show();
		}
	
		public void gymLaunch() {
			HBox listado = null;
			try {
				listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
				root.setCenter((Parent)(listado));
				Scene scene = new Scene(root);			
				scene.getStylesheets().add("proyecto/styles.css");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		// menu inicial con 4 tabs
		}
		
	}
