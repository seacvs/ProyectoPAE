package proyecto;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by leo_c on 01/12/2018.
 */
public class Producto {

    private int id_Producto;
    private int id_Categoria;
    private int stock;
    private float precio;
    private String nombre;


    public Producto(int id_Producto, int id_Categoria, int stock, float precio, String nombre) {

        this.id_Producto = id_Producto;
        this.id_Categoria = id_Categoria;
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;

    }



}
