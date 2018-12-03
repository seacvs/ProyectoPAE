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
    @FXML private TableColumn<Producto,String> id_table_Tienda;
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

        ArrayList<Producto> productos = ameyalli.dbConnection.getAllProducts();
        final ObservableList<Producto> data = FXCollections.observableArrayList();

        for (Producto producto : productos) {
            data.add(new Producto(producto.getId_Producto(), producto.getNombre(),
                    producto.getPrecio()));
        }

        id_table_Tienda.setCellValueFactory(new PropertyValueFactory<Producto, String>("id_Producto"));
        name_table.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        price_table.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));

        tableView_table.setItems(data);

        remove_btn.setText(rb.getString("remove_btn"));
        comprar_btn.setText(rb.getString("comprar_btn"));
        cancelar_btn.setText(rb.getString("cancelar_btn"));
        buscar_btn.setText(rb.getString("buscar_btn"));
        id_table_Tienda.setText(rb.getString("id_table_Tienda"));
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

    @FXML public void clickItem(MouseEvent event){
        if (event.getClickCount() == 2)
        {
            String id_Product = tableView_table.getSelectionModel().getSelectedItem().getId_Producto();
            Producto producto = ameyalli.dbConnection.getDetail(Integer.valueOf(id_Product));

            descripcion_txt.setText(producto.getDescripcion());
            System.out.println(producto.getDescripcion());
            stock_txt.setText(producto.getStock());
            precio_txt.setText(producto.getPrecio());

        }
    }

    public void borrar(){

    }
    
    public void comprar(){

    }
    @FXML
    public void buscarProducto(){
        String nombre = txt_nombreDeProducto.getText();
        ArrayList<Producto> productos;
        productos = ameyalli.dbConnection.getList(nombre);
        final ObservableList<Producto> productoObservableList = FXCollections.observableArrayList();

        for (Producto producto : productos) {
            productoObservableList.add(new Producto(producto.getId_Producto(), producto.getNombre(),
                    producto.getPrecio()));
        }

        id_table_Tienda.setCellValueFactory(new PropertyValueFactory<>("id_Producto"));
        name_table.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        price_table.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tableView_table.setItems(productoObservableList);
    }
    
    


}
