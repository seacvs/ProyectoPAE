package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class controllerAgregarCliente implements Initializable {
	public static ResourceBundle rb;

	@FXML private Button listoBtn;
	@FXML private Button cancelarBtn;
	
	@FXML private FlowPane id_label;
	@FXML private TextField text_nc_nombre;
	@FXML private TextField text_nc_apellido;
	@FXML private TextField text_nc_id;
	@FXML private TextField text_nc_tipocuenta;
	@FXML private DatePicker text_nc_fi;
	@FXML private DatePicker text_nc_ff;
	@FXML private TextField  text_nc_mail;
	@FXML private RadioButton  checkbox_nc_mujer;
	@FXML private RadioButton  checkbox_nc_hombre;
	@FXML private TextField  text_nc_fechanacimiento;
	@FXML private TextField  text_nc_telefono;
	
	@FXML private Label nc_nombre_label;
	@FXML private Label tipoPlan_label;
	@FXML private Spinner<String> spinner_plan;
	@FXML private Label apellido_label;
	@FXML private Label fechaInicio_label;
	@FXML private Label fechaFin_label;
	@FXML private Label mail_label;
	@FXML private Label sexo_label;
	@FXML private Label fechaNacimiento_label;
	@FXML private Label telefono_label;
	@FXML private Label clasesEscalada_label;
	@FXML private Label lunes_label;
	@FXML private Label martes_label;
	@FXML private Label miercoles_label;
	@FXML private Label jueves_label;
	@FXML private Label viernes_label;
	@FXML private Label agregarCliente_label;
	
	@FXML private CheckBox nc_hlu16, nc_hlu17, nc_hlu18, nc_hlu19, nc_hlu20;
	@FXML private CheckBox nc_hmi16,nc_hmi17,nc_hmi18,nc_hmi19,nc_hmi20;
	@FXML private CheckBox nc_hma16,nc_hma17,nc_hma18, nc_hma19,nc_hma20;
	@FXML private CheckBox nc_hju16,nc_hju17,nc_hju18, nc_hju19,nc_hju20;
	@FXML private CheckBox nc_hvi16,nc_hvi17,nc_hvi18, nc_hvi19,nc_hvi20;
	
	public controllerAgregarCliente() throws IOException {
		super();
		FileInputStream fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
		 rb = new PropertyResourceBundle(fis);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		nc_nombre_label.setText(rb.getString("nombre_label"));
		tipoPlan_label.setText(rb.getString("tipoPlan_label"));
		
		ObservableList<String> planes = FXCollections.observableArrayList(//
	               "clases", "macroplan", "membresia", "visita", "becados");
		  // Value factory.
	       SpinnerValueFactory<String> valueFactory = //
	               new SpinnerValueFactory.ListSpinnerValueFactory<String>(planes);
	       // Default value
	       valueFactory.setValue("visita");
	    spinner_plan.setValueFactory(valueFactory);
	    
		apellido_label.setText(rb.getString("apellido_label"));
		fechaInicio_label.setText(rb.getString("fechaInicio_label"));
		fechaFin_label.setText(rb.getString("fechaFin_label"));
		mail_label.setText(rb.getString("mail_label"));
		sexo_label.setText(rb.getString("sexo_label"));
		fechaNacimiento_label.setText(rb.getString("nacimiento_label"));
		telefono_label.setText(rb.getString("telefono_label"));
		clasesEscalada_label.setText(rb.getString("clasesEscalada_label"));
		lunes_label.setText(rb.getString("lunes"));
		martes_label.setText(rb.getString("martes"));
		miercoles_label.setText(rb.getString("miercoles"));
		jueves_label.setText(rb.getString("jueves"));
		viernes_label.setText(rb.getString("viernes"));
		agregarCliente_label.setText(rb.getString("agregarCliente_label"));
		listoBtn.setText(rb.getString("listoBtn"));
		cancelarBtn.setText(rb.getString("cancelarBtn"));
		checkbox_nc_mujer.setText(rb.getString("mujer"));
		checkbox_nc_hombre.setText(rb.getString("hombre"));
		
	}
	
	@FXML 
	private void cancelar(){
		HBox listado = null;
		try {
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void listo(){
		HBox listado = null;
		try {
			//Cliente client = crearCliente();
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void rbHombre(){
		if(checkbox_nc_mujer.isSelected()){
			checkbox_nc_mujer.setSelected(false);
			checkbox_nc_hombre.setSelected(true);
		}else
			checkbox_nc_hombre.setSelected(true);

	}
	
	@FXML 
	private void rbMujer(){
		if(checkbox_nc_hombre.isSelected()){
			checkbox_nc_hombre.setSelected(false);
			checkbox_nc_mujer.setSelected(true);
		}else
			checkbox_nc_mujer.setSelected(true);

	}
	
	private String getSexClient(){
		if(checkbox_nc_hombre.isSelected()){
			return rb.getString("hombre");
		}
		else
		return rb.getString("mujer");
	}
	

	private int getHours(){
		if(nc_hlu16.isSelected()||nc_hma16.isSelected()||nc_hmi16.isSelected()||nc_hju16.isSelected()||nc_hvi16.isSelected()){
			return 16;
		}else if(nc_hlu17.isSelected()||nc_hma17.isSelected()||nc_hmi17.isSelected()||nc_hju17.isSelected()||nc_hvi17.isSelected()){
			return 17;
		}else if(nc_hlu18.isSelected()||nc_hma18.isSelected()||nc_hmi18.isSelected()||nc_hju18.isSelected()||nc_hvi18.isSelected()){
			return 18;
		}else if(nc_hlu19.isSelected()||nc_hma19.isSelected()||nc_hmi19.isSelected()||nc_hju19.isSelected()||nc_hvi19.isSelected()){
			return 19;
		}else if(nc_hlu20.isSelected()||nc_hma20.isSelected()||nc_hmi20.isSelected()||nc_hju20.isSelected()||nc_hvi20.isSelected()){
			return 20;
		}
		return 0;
	}
	
	private String [] getDays(){
		String[] days=new String [5];
		int contador=0;
		if(nc_hlu16.isSelected()||nc_hlu17.isSelected()||nc_hlu18.isSelected()||nc_hlu19.isSelected()||nc_hlu19.isSelected()){
			days[contador]="Lunes";
			contador++;
		}
		if(nc_hlu17.isSelected()||nc_hma17.isSelected()||nc_hmi17.isSelected()||nc_hju17.isSelected()||nc_hvi17.isSelected()){
			days[contador]="Martes";
			contador++;
		}
		if(nc_hlu18.isSelected()||nc_hma18.isSelected()||nc_hmi18.isSelected()||nc_hju18.isSelected()||nc_hvi18.isSelected()){
			days[contador]="Miercoles";
			contador++;
		}
		if(nc_hlu19.isSelected()||nc_hma19.isSelected()||nc_hmi19.isSelected()||nc_hju19.isSelected()||nc_hvi19.isSelected()){
			days[contador]="Jueves";
			contador++;
		}
		if(nc_hlu20.isSelected()||nc_hma20.isSelected()||nc_hmi20.isSelected()||nc_hju20.isSelected()||nc_hvi20.isSelected()){
			days[contador]="Viernes";
			contador++;
		}
		
		String goodDays [] = new String[contador];
		for(String s : days){
			int i=0;
			if(days[i]==null)
				break;
			else{
				goodDays[i] = s;
				i++;
			}
		}
		return goodDays;
	}
	
	private void crearCliente(){
		String name = text_nc_nombre.getText();
		String lastname = text_nc_apellido.getText();
		String type = text_nc_tipocuenta.getText();
		String startDate = LocalDate.now().toString();
		String mail = text_nc_mail.getText();
		String sex = getSexClient();
		String phone = text_nc_telefono.getText();
		String birthDate = text_nc_fechanacimiento.getText(); 
		String days[] = getDays();
		int hour = getHours();
		//int idplan = spinner_plan
		//Cliente escalador = new Cliente(name,lastname,type,startDate,mail,sex,phone,birthDate, days, hour); 
	}
	
}
