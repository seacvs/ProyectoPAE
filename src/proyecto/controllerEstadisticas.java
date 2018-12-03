package proyecto;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class controllerEstadisticas implements Initializable {
	
	//----------------------LINEChart--------------------------
	    @FXML
	    private  LineChart<?, ?> Grafica_hora;
	    @FXML
	    private CategoryAxis x;
	    @FXML
	    private NumberAxis y;
	    
	    //----------------------PIE--------------------------
	    @FXML
	     private PieChart Edad;
	    
	  //----------------------BARRAS--------------------------
	    @FXML
	    private BarChart<?, ?> Plan;
	    @FXML
	    private CategoryAxis Barx;

	    @FXML
	    private NumberAxis Bary;
	    
	    @Override
	    public void initialize (URL url, ResourceBundle rb) {
	    	//----------------------LINEChart--------------------------
	    	XYChart.Series horario = new XYChart.Series();
	    	
	    	horario.getData().add(new XYChart.Data("16:00",5));
	    	horario.getData().add(new XYChart.Data("17:00",6));
	    	horario.getData().add(new XYChart.Data("18:00",9));
	    	horario.getData().add(new XYChart.Data("19:00",10));
	    	horario.getData().add(new XYChart.Data("20:00",14));

	    	horario.setName("Horarios Rocodromo");

	    	Grafica_hora.getData().addAll(horario);
	    	

	    	//----------------------PIE--------------------------
	    	
			 ObservableList<PieChart.Data> pieChartData = 
			    			FXCollections.observableArrayList(
			    					new PieChart.Data("Hombre", 80),
			    					new PieChart.Data("Mujer", 20));
			 Edad.setTitle("Género");
			
			 Edad.setData(pieChartData);
			 
			//----------------------BARRAS--------------------------
			 XYChart.Series PlanData = new XYChart.Series<>();
		    	
		    	PlanData.getData().add(new XYChart.Data("Visita",5));
		    	PlanData.getData().add(new XYChart.Data("Membresia",10));
		    	PlanData.getData().add(new XYChart.Data("Clases",7));
		    	PlanData.getData().add(new XYChart.Data("MacroPlan",8));
		    	PlanData.getData().add(new XYChart.Data("Evento Especial",12));
		    	
		    	Plan.getData().addAll(PlanData);
	    
 }
	
}
