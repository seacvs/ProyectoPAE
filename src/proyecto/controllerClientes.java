package proyecto;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class controllerClientes implements Initializable {
	
	@FXML private Button editarBtn;
	@FXML private Button agregarBtn;
	@FXML private Button buscarBtn;
	@FXML private TextField buscar_textField;
	
	@FXML private TableColumn<?, ?> id_table;
	@FXML private TableColumn<?, ?> apellido_table;
	@FXML private TableColumn<?, ?> nombre_table;
	@FXML private TableColumn<?, ?> estatus_table;
	@FXML private TableColumn<?, ?> plan_table;
	@FXML private TableColumn<?, ?> sexo_table;
	
	@FXML private Label nombre_label;
	@FXML private Label estatus_label;
	@FXML private Label tipoPlan_label, label_plan;
	@FXML private Label fechaInicio_label, label_fi;
	@FXML private Label fechaFin_label, label_ff;
	@FXML private Label mail_label, label_mail;
	@FXML private Label sexo_label, label_sexo;
	@FXML private Label nacimiento_label,label_nacimiento;
	@FXML private Label telefono_label,label_telefono;
	@FXML private Label horario_label;
	@FXML private Label lunes,martes,miercoles,jueves,viernes;
	
	public Label getNombre_label() {
		return nombre_label;
	}

	public void setNombre_label(Label nombre_label) {
		this.nombre_label = nombre_label;
	}

	public Label getEstatus_label() {
		return estatus_label;
	}

	public void setEstatus_label(Label estatus_label) {
		this.estatus_label = estatus_label;
	}

	public Label getLabel_plan() {
		return label_plan;
	}

	public void setLabel_plan(Label label_plan) {
		this.label_plan = label_plan;
	}

	public Label getLabel_fi() {
		return label_fi;
	}

	public void setLabel_fi(Label label_fi) {
		this.label_fi = label_fi;
	}

	public Label getLabel_ff() {
		return label_ff;
	}

	public void setLabel_ff(Label label_ff) {
		this.label_ff = label_ff;
	}

	public Label getLabel_mail() {
		return label_mail;
	}

	public void setLabel_mail(Label label_mail) {
		this.label_mail = label_mail;
	}

	public Label getLabel_sexo() {
		return label_sexo;
	}

	public void setLabel_sexo(Label label_sexo) {
		this.label_sexo = label_sexo;
	}

	public Label getLabel_nacimiento() {
		return label_nacimiento;
	}

	public void setLabel_nacimiento(Label label_nacimiento) {
		this.label_nacimiento = label_nacimiento;
	}

	public Label getLabel_telefono() {
		return label_telefono;
	}

	public void setLabel_telefono(Label label_telefono) {
		this.label_telefono = label_telefono;
	}

	@FXML private CheckBox hlu16, hlu17, hlu18, hlu19, hlu20;
	@FXML private CheckBox hmi16,hmi17,hmi18,hmi19,hmi20;
	@FXML private CheckBox hma16,hma17,hma18, hma19,hma20;
	@FXML private CheckBox hju16,hju17,hju18, hju19,hju20;
	@FXML private CheckBox hvi16,hvi17,hvi18, hvi19,hvi20;
	
	@FXML private FlowPane flowPaneDatos;
	@FXML private HBox hboxBotones;

	
// nombre_label es el titulo del campo 
// label_nombre_ es el campo a llenar
	public static ResourceBundle rb;

	
	public controllerClientes() throws IOException {
		super();
		FileInputStream fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
		rb = new PropertyResourceBundle(fis);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {		
		buscarBtn.setText(rb.getString("buscarBtn"));
		editarBtn.setText(rb.getString("editarBtn"));
		agregarBtn.setText(rb.getString("agregarBtn"));
		buscar_textField.setPromptText(rb.getString("buscar_textField"));
		id_table.setText(rb.getString("id_table"));
		apellido_table.setText(rb.getString("apellido_table"));
		nombre_table.setText(rb.getString("nombre_table"));
		estatus_table.setText(rb.getString("estatus_table"));
		plan_table.setText(rb.getString("plan_table"));
		sexo_table.setText(rb.getString("sexo_table"));
		nombre_label.setText(rb.getString("nombre_label"));
		estatus_label.setText(rb.getString("estatus_label"));
		
		tipoPlan_label.setText(rb.getString("tipoPlan_label"));
		fechaInicio_label.setText(rb.getString("fechaInicio_label"));
		fechaFin_label.setText(rb.getString("fechaFin_label"));
		mail_label.setText(rb.getString("mail_label"));
		sexo_label.setText(rb.getString("sexo_label"));
		nacimiento_label.setText(rb.getString("nacimiento_label"));
		telefono_label.setText(rb.getString("telefono_label"));
		horario_label.setText(rb.getString("horario_label"));
		lunes.setText(rb.getString("lunes"));
		martes.setText(rb.getString("martes"));
		miercoles.setText(rb.getString("miercoles"));
		jueves.setText(rb.getString("jueves"));
		viernes.setText(rb.getString("viernes"));
		flowPaneDatos.setStyle("-fx-background-color: #FFFFFF");
		hboxBotones.setStyle("-fx-background-color: #FFFFFF");
		
	}
	
	@FXML 
	private void agregarCliente(){
		HBox agregarNuevo = null;
		try {
			agregarNuevo = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));
			ameyalli.getInstance().setCenter(agregarNuevo);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@FXML 
	private void editarCliente(){
		HBox editarCliente = null;
		try {
			editarCliente = FXMLLoader.load(getClass().getResource("editarCliente.fxml"));
			ameyalli.getInstance().setCenter(editarCliente);
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
}
