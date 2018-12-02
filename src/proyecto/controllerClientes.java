package proyecto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class controllerClientes implements Initializable {

    @FXML
    private Button editarBtn;
    @FXML
    private Button agregarBtn;
    @FXML
    private Button buscarBtn;
    @FXML
    private TextField buscar_textField;

    @FXML
    private TableColumn<Cliente, String> id_table;
    @FXML
    private TableColumn<Cliente, String> apellido_table;
    @FXML
    private TableColumn<Cliente, String> nombre_table;
    @FXML
    private TableColumn<Cliente, String> estatus_table;
    @FXML
    private TableColumn<Cliente, String> plan_table;
    @FXML
    private TableColumn<Cliente, String> sexo_table;

    @FXML
    private Label nombre_label;
    @FXML
    private Label estatus_label;
    @FXML
    private Label tipoPlan_label;
    @FXML
    private Label label_plan;
    @FXML
    private Label fechaInicio_label, label_fi;
    @FXML
    private Label fechaFin_label, label_ff;
    @FXML
    private Label mail_label, label_mail;
    @FXML
    private Label sexo_label, label_sexo;
    @FXML
    private Label nacimiento_label, label_nacimiento;
    @FXML
    private Label telefono_label, label_telefono;
    @FXML
    private Label horario_label;
    @FXML
    private Label lunes, martes, miercoles, jueves, viernes;

    @FXML
    private CheckBox hlu16, hlu17, hlu18, hlu19, hlu20;
    @FXML
    private CheckBox hmi16, hmi17, hmi18, hmi19, hmi20;
    @FXML
    private CheckBox hma16, hma17, hma18, hma19, hma20;
    @FXML
    private CheckBox hju16, hju17, hju18, hju19, hju20;
    @FXML
    private CheckBox hvi16, hvi17, hvi18, hvi19, hvi20;

    @FXML
    private FlowPane flowPaneDatos;
    @FXML
    private HBox hboxBotones;

    @FXML
    private TableView<Cliente> tableView_table;

    // nombre_label es el titulo del campo
// label_nombre_ es el campo a llenar
    public static ResourceBundle rb;
    public static FileInputStream fis;

    public controllerClientes() throws IOException {
        super();
        fis = new FileInputStream(ameyalli.getInstance().getLenguage());
        rb = new PropertyResourceBundle(fis);
    }


    public void updateLanguage() throws IOException {
        try {
            fis = new FileInputStream(ameyalli.getInstance().getLenguage());
            rb = new PropertyResourceBundle(fis);
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String whatSex(String name) {
        if (name.substring(name.length() - 1).equals("a")) return "F";
        return "M";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Cliente> clientes = ameyalli.dbConnection.getClients();

        final ObservableList<Cliente> data = FXCollections.observableArrayList();

        for (Cliente cliente : clientes) {
            data.add(new Cliente(cliente.getId(), cliente.getLastname(),
                    cliente.getName(), checkActive(cliente.getFechaFin()), cliente.getPlan(),
                    whatSex(cliente.getName())));
        }

//		final ObservableList<Cliente> data = FXCollections.observableArrayList(
//			new Cliente ("1","Palomero", "Juan","Activo", "Clase", "Hombre"),
//			new Cliente ("2","Perez", "Miguel","Inactivo", "Visita", "Hombre"),
//			new Cliente ("3","Ramirez", "China","Inactivo", "Visita", "Mujer"),
//			new Cliente ("4","Gonzales", "Sebastian","Activo", "Clase", "Hombre"),
//			new Cliente ("5","Romeo", "Juan","Activo", "Membresia", "Hombre"),
//			new Cliente ("6","Kardashan", "Kim","Activo", "Clase", "Mujer")
//		);

        id_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
        apellido_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("lastname"));
        nombre_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("name"));
        estatus_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("estatus"));
        plan_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("plan"));
        sexo_table.setCellValueFactory(new PropertyValueFactory<Cliente, String>("sexo"));

        tableView_table.setItems(data);

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

        nombre_label.setText("China Ramirez");
        label_mail.setText("china@gmail.com");
        label_plan.setText("No aplica");
        label_sexo.setText("Mujer");
        label_nacimiento.setText("29/11/1988");
        label_telefono.setText("331220943");
        label_ff.setText("No aplica");
        label_fi.setText("No aplica");
        estatus_label.setText("Inactivo");

    }

    @FXML
    private void agregarCliente() {
        HBox agregarNuevo = null;
        try {
            agregarNuevo = FXMLLoader.load(getClass().getResource("nuevoCliente.fxml"));
            ameyalli.getInstance().setCenter(agregarNuevo);
            ameyalli.getInstance().setTempCenterName("nuevo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void editarCliente() {
        HBox editarCliente = null;
        try {
            editarCliente = FXMLLoader.load(getClass().getResource("editarCliente.fxml"));
            ameyalli.getInstance().setCenter(editarCliente);
            ameyalli.getInstance().setTempCenterName("editar");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickItem(MouseEvent event) {
        if (event.getClickCount() == 2) //Checking double click
        {
            String clientId = tableView_table.getSelectionModel().getSelectedItem().getId();
            Cliente cliente = ameyalli.dbConnection.getClientByID(clientId);
            label_plan.setText(cliente.getPlan());
            label_ff.setText(cliente.getFechaFin());
            label_fi.setText(cliente.getFechaInicio());
            label_mail.setText(cliente.getMail());
            label_nacimiento.setText(cliente.getFechaNacimiento());
            label_telefono.setText(cliente.getTelefono());
            label_sexo.setText(whatSex(cliente.getName()));
            nombre_label.setText(cliente.getName() + " " + cliente.getLastname());
            estatus_label.setText(checkActive(cliente.getFechaFin()));
            markSchedule(cliente.getHora());
        }
    }

    private void markSchedule(String hour) {
        switch (hour) {
            case "16:00":
                hlu16.setSelected(true);
                hma16.setSelected(true);
                hmi16.setSelected(true);
                hju16.setSelected(true);
                hvi16.setSelected(true);
                break;
            case "17:00":
                hlu17.setSelected(true);
                hma17.setSelected(true);
                hmi17.setSelected(true);
                hju17.setSelected(true);
                hvi17.setSelected(true);
                break;
            case "18:00":
                hlu18.setSelected(true);
                hma18.setSelected(true);
                hmi18.setSelected(true);
                hju18.setSelected(true);
                hvi18.setSelected(true);
                break;
            case "19:00":
                hlu19.setSelected(true);
                hma19.setSelected(true);
                hmi19.setSelected(true);
                hju19.setSelected(true);
                hvi19.setSelected(true);
                break;
            case "20:00":
                hlu20.setSelected(true);
                hma20.setSelected(true);
                hmi20.setSelected(true);
                hju20.setSelected(true);
                hvi20.setSelected(true);
                break;
        }
    }

    private String checkActive(String dayToCompare) {
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String todayString = formatter.format(now);


        Date today = null;
        Date dayCompare = null;
        try {
            today = new SimpleDateFormat(pattern).parse(todayString);
            dayCompare = new SimpleDateFormat(pattern).parse(dayToCompare);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (today.compareTo(dayCompare) > 0 || today.compareTo(dayCompare) == 0) return "Inactivo";

        return "Activo";
    }

}