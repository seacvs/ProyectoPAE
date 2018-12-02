package proyecto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javafx.scene.control.Button ;
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
    public static FileInputStream fis;
    
    public controllerProductos() throws IOException {
        super();
        fis = new FileInputStream(ameyalli.getInstance().getLenguage());
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
    @FXML private Button remove_btn;
    @FXML private Button comprar_btn;
    @FXML private Button cancelar_btn;
    @FXML private Button buscar_btn;
    
    //Tabla
	@FXML private TableView<Producto> tableView_table;
    @FXML private TableColumn<Producto,String> id_table;
    @FXML private TableColumn<Producto,String> name_table;
    @FXML private TableColumn<Producto,String> price_table;
    @FXML private TextField txt_nombreDeProducto;

    //Carro de compra
    @FXML private TableColumn<Producto, Float> carrito_table;
    @FXML private ListView<String>  listView_carro;
    @FXML private Text lbl_carroDeCompra;

    
    //Compra total
    @FXML private TextField txtCalculado;
    @FXML private TextField txtIVA;
    @FXML private TextField txt_descuento;
    @FXML private TextField txtTotal;
    @FXML private Spinner<String> spinnerFormasDePago;
    //titulos
    @FXML private Text lbl_listaDeProdcutos;
    @FXML private Text lbl_detalleDelProducto;
    @FXML private Text lbl_Descripcion;
    @FXML private Text lbl_stock;
    @FXML private Text lbl_precio;
    @FXML private Text lbl_metodosDePago;
    @FXML private Text lbl_compraTotal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final ObservableList<Producto> data = FXCollections.observableArrayList(//Aqui es el select de los productos
                new Producto(1,1,5, 80.9f, "Arnes"));


        //Select para asignar desde la base de datos (falta)
        
        remove_btn.setText(rb.getString("remove_btn"));
        comprar_btn.setText(rb.getString("comprar_btn"));
        cancelar_btn.setText(rb.getString("cancelar_btn"));
        buscar_btn.setText(rb.getString("buscar_btn"));
        id_table.setText(rb.getString("id_table"));
        name_table.setText(rb.getString("name_table"));
        price_table.setText(rb.getString("price_table"));
        lbl_carroDeCompra.setText(rb.getString("lbl_carroDeCompra"));
        lbl_listaDeProdcutos.setText(rb.getString("lbl_listaDeProdcutos"));
        lbl_detalleDelProducto.setText(rb.getString("lbl_detalleDelProducto"));
        lbl_Descripcion.setText(rb.getString("lbl_Descripcion"));
        lbl_stock.setText(rb.getString("lbl_stock"));
        lbl_precio.setText(rb.getString("lbl_precio"));
        lbl_metodosDePago.setText(rb.getString("lbl_metodosDePago"));
        lbl_compraTotal.setText(rb.getString("lbl_compraTotal"));
        txt_nombreDeProducto.setPromptText(rb.getString("txt_nombreDeProducto"));

      //  if(listView_carro != null)
      //  {
        	txtCalculado.setPromptText(rb.getString("txtCalculado"));
        	txtIVA.setPromptText(rb.getString("txtIVA"));
        	txt_descuento.setPromptText(rb.getString("txt_descuento"));
        	txtTotal.setPromptText(rb.getString("txtTotal"));
       // }

    }



    public void borrar(){

    }
    
    public void comprar(){

    }


}
