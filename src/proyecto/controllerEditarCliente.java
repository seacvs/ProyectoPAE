package proyecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class controllerEditarCliente implements Initializable {
	
	@FXML private Button listoBtn;
	@FXML private Button cancelarBtn;
	public static ResourceBundle rb;
	
	@FXML private FlowPane id_label;
	@FXML private TextField text_nc_nombre;
	@FXML private TextField text_nc_apellido;
	@FXML private TextField text_nc_id;
	@FXML private Spinner<?> text_nc_tipocuenta;
	@FXML private DatePicker text_nc_fi;
	@FXML private DatePicker text_nc_ff;
	@FXML private TextField  text_nc_mail;
	@FXML private RadioButton  checkbox_nc_mujer;
	@FXML private RadioButton  checkbox_nc_hombre;
	@FXML private TextField  text_nc_fechanacimiento;
	@FXML private TextField  text_nc_telefono;
	
	
	@FXML private Label ec_nombre_label;
	@FXML private Label tipoPlan_label;
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
	@FXML private Label editarCliente_label;
	

	@FXML private CheckBox nc_hlu16, nc_hlu17, nc_hlu18, nc_hlu19, nc_hlu20;
	@FXML private CheckBox nc_hmi16,nc_hmi17,nc_hmi18,nc_hmi19,nc_hmi20;
	@FXML private CheckBox nc_hma16,nc_hma17,nc_hma18, nc_hma19,nc_hma20;
	@FXML private CheckBox nc_hju16,nc_hju17,nc_hju18, nc_hju19,nc_hju20;
	@FXML private CheckBox nc_hvi16,nc_hvi17,nc_hvi18, nc_hvi19,nc_hvi20;

	FileInputStream fis;

	public controllerEditarCliente() throws IOException  {
		super();
		fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
		rb = new PropertyResourceBundle(fis);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
	//internacionalizacion	
			ec_nombre_label.setText(rb.getString("nombre_label"));
			tipoPlan_label.setText(rb.getString("tipoPlan_label"));
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
			editarCliente_label.setText(rb.getString("editarCliente_label"));
			listoBtn.setText(rb.getString("listoBtn"));
			cancelarBtn.setText(rb.getString("cancelarBtn"));
	//leer datosd e la BD
			Cliente cliente = obtenerDatos();
			
			
	}
	
	private Cliente obtenerDatos() {
		// query del id del cliente
		return null;
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
			listado = FXMLLoader.load(getClass().getResource("listado.fxml"));
			ameyalli.getInstance().setCenter(listado);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	
	
	
}
