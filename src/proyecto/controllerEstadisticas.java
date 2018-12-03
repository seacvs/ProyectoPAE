package proyecto;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
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
    public static ResourceBundle rb;
    public static FileInputStream fis;
    
    
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
	    	
	          try {
		    	fis = new FileInputStream(ameyalli.getInstance().getLenguage());
				rb = new PropertyResourceBundle(fis);
				Grafica_hora.setTitle(rb.getString("grafica_hora"));
				Edad.setTitle(rb.getString("grafica_edad"));
				Plan.setTitle(rb.getString("grafica_plan"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          
	    	//----------------------LINEChart--------------------------
	    	XYChart.Series horario = new XYChart.Series();
	    	
	    	horario.getData().add(new XYChart.Data("16:00",ameyalli.dbConnection.getHoursCount("16:00")));
	    	horario.getData().add(new XYChart.Data("17:00",ameyalli.dbConnection.getHoursCount("17:00")));
	    	horario.getData().add(new XYChart.Data("18:00",ameyalli.dbConnection.getHoursCount("18:00")));
	    	horario.getData().add(new XYChart.Data("19:00",ameyalli.dbConnection.getHoursCount("19:00")));
	    	horario.getData().add(new XYChart.Data("20:00",ameyalli.dbConnection.getHoursCount("20:00")));

	    	horario.setName(rb.getString("horarios_roco"));

	    	Grafica_hora.getData().addAll(horario);
	    	

	    	//----------------------PIE--------------------------
	    	String[] generos = ameyalli.dbConnection.getGenderCount().split(",");
			 ObservableList<PieChart.Data> pieChartData = 
			    			FXCollections.observableArrayList(
			    					new PieChart.Data(rb.getString("hombre"), Integer.parseInt(generos[1])),
			    					new PieChart.Data(rb.getString("mujer"), Integer.parseInt(generos[0])));
			
			 Edad.setData(pieChartData);
			 
			//----------------------BARRAS--------------------------
			 XYChart.Series PlanData = new XYChart.Series<>();
			 
			 int[]planes = ameyalli.dbConnection.getPlansCount();
		    	
		    	PlanData.getData().add(new XYChart.Data("Clase",planes[0]));
		    	PlanData.getData().add(new XYChart.Data("Macroplan",planes[1]));
		    	PlanData.getData().add(new XYChart.Data("Membresia",planes[2]));
		    	PlanData.getData().add(new XYChart.Data("Visita",planes[3]));
		    	PlanData.getData().add(new XYChart.Data("Becado",planes[4]));
		    	
		    	Plan.getData().addAll(PlanData);
	    
 }
	
}
