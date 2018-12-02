package proyecto;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DBConnection {

    private static Connection connection = null;

    private final static String DB_NAME = "pae";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "password";

    public DBConnection() {
        createConnection();
    }

    private static boolean tableExists(String tableName) {
        try {
            DatabaseMetaData dbm = connection.getMetaData();
            // check if "tableName" table is there
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (tables.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /*
        cumpleaños en formato yyyy-mm-dd
     */
    protected void addClient(String lastName, String firstName, String email, String birthday, Long phone) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente(id_Plan, apellido, nombre, mail, fecha_nac, telefono) VALUES((SELECT id_plan FROM plan ORDER BY id_plan DESC LIMIT 1), ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, lastName);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, birthday);
            preparedStatement.setLong(5, phone);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void addProduct(Integer idCategory, Integer stock, Double price, String name) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO producto(id_categoria, stock, precio, nombre) VALUES(?, ?, ?, ?)");
            preparedStatement.setInt(1, idCategory);
            preparedStatement.setInt(2, stock);
            preparedStatement.setDouble(3, price);
            preparedStatement.setString(4, name);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void addCategory(String name, String description) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categoria(nombre, descripcion) VALUES(?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     Agregar la hora ne formato hh:mm
     */
    private void addClass(String dia, String hora) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clase(dia, hora) VALUES(?, ?)");
            preparedStatement.setString(1, dia);
            preparedStatement.setString(2, hora);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
        Hora en formato hh:mm
     */
    protected void addPlan(String planName, String time) {
        int sumDays = 0;
        switch (planName.toLowerCase()) {
            case "clases":
            case "macroplan":
            case "membresia":
                sumDays = 30;
                break;
            case "visita":
                sumDays = 1;
                break;
            case "becados":
                sumDays = 365;
                break;
        }

        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String startDate = formatter.format(now);

        Calendar c=new GregorianCalendar();
        c.add(Calendar.DATE, sumDays);
        Date end = c.getTime();
        SimpleDateFormat formatter2 = new SimpleDateFormat(pattern);
        String endDate = formatter2.format(end);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO plan(tipo_plan, fecha_in, fecha_fn, estatus) VALUES((SELECT id_clase FROM clase WHERE hora = ? ), ?, ?, ?, ?)");
            preparedStatement.setString(1, time);
            preparedStatement.setString(2, planName);
            preparedStatement.setString(3, startDate);
            preparedStatement.setString(4, endDate);
            preparedStatement.setBoolean(5, true);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void addInvoice(Integer idCliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO factura(id_Cliente, fecha) VALUES(?, current_date())");
            preparedStatement.setInt(1, idCliente);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void addProductInvoice(Integer idProduct, Integer idInvoice, Integer quantity, Double price) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO producto_factura(id_Producto, id_Factura, cantidad, precio) VALUES(?, ?, ?, ?)");
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setInt(2, idInvoice);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setDouble(4, price);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updateClient(Integer idPlan, String lastName, String firstName, String email, String birthday, Long phone) {
        String updateClient = "UPDATE cliente" +
                "        SET id_plan = " + idPlan + ", apellido = '" + lastName + "', nombre = '" + firstName + "', mail = '" +
                email + "', fecha_nac = '" + birthday + "', telefono = " + phone + "," +
                "        WHERE nombre = '" + firstName + "'";

        executeQuery(updateClient);
    }

    private static void createTables() {
        String tableClass = "CREATE TABLE clase(\n" +
                "    id_Clase    int not null primary key auto_increment,\n" +
                "    dia         varchar(20),\n" +
                "    hora        time\n" +
                "    )";

        String tablePlan = "CREATE TABLE plan(\n" +
                "    id_Plan     int not null primary key auto_increment,\n" +
                "    id_Clase    int not null,\n" +
                "    tipo_plan   char(10),\n" +
                "    fecha_in    date,\n" +
                "    fecha_fn    date,\n" +
                "    estatus     bool,\n" +
                "    foreign key (id_Clase) references Clase(id_Clase)\n" +
                "    )";

        String tableClient = "CREATE TABLE cliente(\n" +
                "    id_Cliente  int not null primary key auto_increment,\n" +
                "    id_Plan     int not null ,\n" +
                "    apellido    varchar(30),\n" +
                "    nombre      varchar(20),\n" +
                "    mail        varchar (25),\n" +
                "    fecha_nac   date,\n" +
                "    telefono    numeric(10,0),\n" +
                "    foreign key (id_Plan) references Plan(id_Plan)\n" +
                "    )";

        String tableCategory = "CREATE TABLE categoria(\n" +
                "    id_Categoria    int not null primary key auto_increment,\n" +
                "    nombre          varchar(20),\n" +
                "    descripcion     varchar(30)\n" +
                ")";

        String tableProduct = "CREATE TABLE producto(\n" +
                "    id_Producto int not null primary key auto_increment,\n" +
                "    id_Categoria int not null,\n" +
                "    stock       int,\n" +
                "    precio      decimal (19,4),\n" +
                "    nombre      varchar(20),\n" +
                "    foreign key (id_Categoria) references Categoria(id_Categoria)\n" +
                "    )";

        String tableInvoice = "CREATE TABLE factura(\n" +
                "    id_Factura  int not null primary key auto_increment,\n" +
                "    id_Cliente  int not null,\n" +
                "    fecha       date,\n" +
                "    foreign key (id_Cliente) references Cliente(id_Cliente)\n" +
                "    )";

        String tableProductInvoice = "CREATE TABLE Producto_Factura(\n" +
                "    id_Producto_Factura int not null primary key auto_increment,\n" +
                "    id_Producto         int not null,\n" +
                "    id_Factura          int not null,\n" +
                "    cantidad            int,\n" +
                "    precio              decimal(19,4)\n" +
                ");";

        executeQuery(tableClass);
        executeQuery(tablePlan);
        executeQuery(tableClient);
        executeQuery(tableCategory);
        executeQuery(tableProduct);
        executeQuery(tableInvoice);
        executeQuery(tableProductInvoice);
    }

    private static void executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME +
                            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    USERNAME, PASSWORD);
            System.out.println("Database Connection Successful");

            if (!tableExists("cliente")) createTables();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeConnection() {
        try {
//            if (rs != null) rs.close();
//            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    protected void getClients() {
//        try {
//            Statement st1 = connection.createStatement();
//            ResultSet rs1 = st1.executeQuery("SELECT * FROM users");
//
//            while (rs1.next()) {
//                String name = rs1.getString("name"); // Se pone el indice de la col o el nombre de esta
//                System.out.println(name);
//            }
//            st1.close();
//            rs1.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


}