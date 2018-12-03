package proyecto;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by leo_c on 01/12/2018.
 */
public class Producto {

	private SimpleStringProperty id_Producto;
    private SimpleStringProperty id_Categoria;
    private SimpleStringProperty stock;
    private SimpleStringProperty precio;
    private SimpleStringProperty nombre;
    private SimpleStringProperty descripcion;


    public Producto(String id_Producto, String id_Categoria, String stock, String precio, String nombre) {

        this.id_Producto = new SimpleStringProperty(id_Producto);
        this.id_Categoria = new SimpleStringProperty( id_Categoria);
        this.stock =new SimpleStringProperty( stock);
        this.precio =new SimpleStringProperty( precio);
        this.nombre =new SimpleStringProperty( nombre);

    }

    public Producto() {
        //jalar el primer ID
    }
    //detail
    public Producto(int noValido, String stock, String precio, String descripcion) {
        this.stock =new SimpleStringProperty( stock);
        this.precio =new SimpleStringProperty( precio);
        this.descripcion =new SimpleStringProperty( descripcion);
    }

    public Producto(String id, String nombre, String precio) {
        this.id_Producto =new SimpleStringProperty( id);
        this.nombre = new SimpleStringProperty(nombre);
        this.precio =new SimpleStringProperty( precio);
    }

	public String getId_Producto() {
		return id_Producto.get();
	}

	public SimpleStringProperty id_ProductoProperty() {
		return id_Producto;
	}

	public void setId_Producto(String id_Producto) {
		this.id_Producto = new SimpleStringProperty(id_Producto);
	}

	public String getId_Categoria() {
		return id_Categoria.get();
	}

	public SimpleStringProperty id_CategoriaProperty() {
		return id_Categoria;
	}

	public void setId_Categoria(String id_Categoria) {
		this.id_Categoria = new SimpleStringProperty(id_Categoria);
	}

	public String getStock() {
		return stock.get();
	}

	public SimpleStringProperty stockProperty() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = new SimpleStringProperty(stock);
	}

	public String getPrecio() {
		return precio.get();
	}

	public SimpleStringProperty precioProperty() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = new SimpleStringProperty(precio);
	}

	public String getNombre() {
		return nombre.get();
	}

	public SimpleStringProperty nombreProperty() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getDescripcion() {
		return descripcion.get();
	}

	public SimpleStringProperty descripcionProperty() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = new SimpleStringProperty(descripcion);
	}
    

}
