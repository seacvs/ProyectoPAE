package proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by leo_c on 01/12/2018.
 */
public class controllerProductos implements Initializable {

    public static ResourceBundle rb;
    public controllerProductos() throws IOException {
        super();
        FileInputStream fis = new FileInputStream("src/resources/i18n/ameyalli_en.properties");
        rb = new PropertyResourceBundle(fis);
    }

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
        final ObservableList<Producto> data = FXCollections.observableArrayList(//Aqui es el select de los productos
                new Producto(1,1,5, 80.9f, "Arnes"));


        //Select para asignar desde la base de datos (falta)

        id_txt.setText(rb.getString(""));
        descripcion_txt.setText(rb.getString(""));
        stock_txt.setText(rb.getString(""));
        precio_txt.setText(rb.getString(""));

        if(carrito_table != null)
        {
            calculo_txt.setText(rb.getString(""));
            iva_txt.setText(rb.getString(""));
            descuento_txt.setText(rb.getString(""));
            total_txt.setText(rb.getString(""));
        }

    }



    public void borrar(){

    }
    public void Comprar(){

    }


}
