package proyecto;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by leo_c on 01/12/2018.
 */
public class Producto {

    private SimpleIntegerProperty id_Producto;
    private SimpleIntegerProperty id_Categoria;
    private SimpleIntegerProperty stock;
    private SimpleFloatProperty precio;
    private SimpleStringProperty nombre;


    public Producto(SimpleIntegerProperty id_Producto, SimpleIntegerProperty id_Categoria, SimpleIntegerProperty stock, SimpleFloatProperty precio, SimpleStringProperty nombre) {

        this.id_Producto = id_Producto;
        this.id_Categoria = id_Categoria;
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;

    }



}
