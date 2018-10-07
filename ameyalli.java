package proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ameyalli extends Application {
	
	public static void main(String[] args) {
		launch(args);
	
	}
	
		@Override
		public void start(Stage primaryStage) throws Exception {
		
			BorderPane root = FXMLLoader.load(getClass().getResource("menu.fxml"));		// menu inicial con 4 tabs
			HBox listado = FXMLLoader.load(getClass().getResource("listado.fxml"));		// menu inicial con 4 tabs
			VBox agregarCliente = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));		// menu inicial con 4 tabs

			root.getChildren().add(agregarCliente);
			Scene scene = new Scene(root);			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ameyalli");
			primaryStage.show();
		}
	
		
		
	}
