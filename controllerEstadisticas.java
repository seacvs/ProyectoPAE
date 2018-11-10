package proyecto;


import java.awt.ScrollPane;
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

public class controllerEstadisticas {

	public class GraphicController1 implements Initializable {
	
	    @FXML
	    private  LineChart<?, ?> Hora;
	    @FXML
	    private CategoryAxis x;
	    @FXML
	    private NumberAxis y;
	    
	 
	    @Override
	    public void initialize (URL url, ResourceBundle rb) {
	    	XYChart.Series horario = new XYChart.Series();
	    	
	    	horario.getData().add(new XYChart.Data("4",5));
	    	horario.getData().add(new XYChart.Data("5",6));
	    	horario.getData().add(new XYChart.Data("6",9));
	    	horario.getData().add(new XYChart.Data("7",10));
	    	horario.getData().add(new XYChart.Data("8",14));
	    	horario.getData().add(new XYChart.Data("9",8));
	    	horario.getData().add(new XYChart.Data("10",3));
	    	
	    	Hora.getData().addAll(horario);
	    }
 }
	
	public class GraphicController2 implements Initializable {
		 @FXML
	     private PieChart Edad;
		 
		 @Override
		 public void initialize (URL url, ResourceBundle rb) {
		 ObservableList<PieChart.Data> pieChartData = 
		    			FXCollections.observableArrayList(
		    					new PieChart.Data("18", 15),
		    					new PieChart.Data("17", 10),
		    					new PieChart.Data("20", 20),
		    					new PieChart.Data("22", 25),
		    					new PieChart.Data("24", 30));
		 Edad.setData(pieChartData);
		 }
	}

	public class GraphicController3 implements Initializable{
	    @FXML
	    private BarChart<?, ?> Plan;
	    @FXML
	    private CategoryAxis Barx;

	    @FXML
	    private NumberAxis Bary;
	    
	    @Override
	    public void initialize (URL url, ResourceBundle rb) {
	    	XYChart.Series PlanData = new XYChart.Series<>();
	    	
	    	PlanData.getData().add(new XYChart.Data("Visita",5));
	    	PlanData.getData().add(new XYChart.Data("Membresia",10));
	    	PlanData.getData().add(new XYChart.Data("Clases",7));
	    	PlanData.getData().add(new XYChart.Data("MacroPlan",8));
	    	PlanData.getData().add(new XYChart.Data("Evento Especial",12));
	    	
	    	Plan.getData().addAll(PlanData);
	    	
	    }
	}
}
