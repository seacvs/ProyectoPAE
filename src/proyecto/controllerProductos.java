package proyecto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by leo_c on 01/12/2018.
 */
public class controllerProductos implements Initializable {

    //Lista de productos (Solo se buscara su nombre)
    @FXML private TableColumn<Producto, String> nombre_table;

    //id, Descripcion, stock y precio
    @FXML private TextField id_txt;
    @FXML private TextField descripcion_txt;
    @FXML private TextField stock_txt;
    @FXML private TextField precio_txt;

    //agregar, remover y comprar
    @FXML private Button add_btn;
    @FXML private Button remove_btn;
    @FXML private Button comprar_btn;
    @FXML private Button borrarTotal_btn;

    //TextField de compra total
    @FXML private TextField calculo_txt;
    @FXML private TextField iva_txt;
    @FXML private TextField descuento_txt;
    @FXML private TextField total_txt;

    //Carro de compra
    @FXML private TableColumn<Producto, Float> carrito_table;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
