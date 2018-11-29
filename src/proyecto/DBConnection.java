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

    protected static void addClient(Integer idPlan, String lastName, String firstName, String email, String birthday, Long phone) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cliente(id_Plan, apellido, nombre, mail, fecha_nac, telefono) VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, idPlan);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, birthday);
            preparedStatement.setLong(6, phone);
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

    protected static void addCategory(String name, String description) {
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

    protected static void addPlan(String name) {
        int sumDays = 0;
        switch (name.toLowerCase()) {
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
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO plan(tipo_plan, fecha_in, fecha_fn, estatus) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.setBoolean(4, true);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addInvoice(Integer idCliente, String date) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO factura(id_Cliente, fecha) VALUES(?, ?)");
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setString(2, date);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void addProductInvoice(Integer idProduct, Integer idInvoice, Integer quantity, Double price) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO factura(id_Producto, id_Factura, cantidad, precio) VALUES(?, ?, ?, ?)");
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

    protected static void updateClient(Integer idPlan, String lastName, String firstName, String email, String birthday, Long phone) {
        String updateClient = "UPDATE cliente" +
                "        SET id_plan = " + idPlan + ", apellido = '" + lastName + "', nombre = '" + firstName + "', mail = '" + email + "', fecha_nac = '" + birthday + "', telefono = " + phone + "," +
                "        WHERE nombre = '" + firstName + "'";

        executeQuery(updateClient);
    }

    protected static void getUsers() {
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM users");

            while (rs1.next()) {
                String name = rs1.getString("name"); // Se pone el indice de la col o el nombre de esta
                System.out.println(name);
            }
            st1.close();
            rs1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void createTables() {
        String tablePlan = "CREATE TABLE plan(" +
                "    id_plan     int not null primary key AUTO_INCREMENT," +
                "    tipo_plan   char(10)," +
                "    fecha_in    date," +
                "    fecha_fn    date," +
                "    estatus     bool" +
                "    )";

        String tableClient = "CREATE TABLE cliente(" +
                "    id_cliente  int not null primary key AUTO_INCREMENT," +
                "    id_plan     int not null ," +
                "    apellido    varchar(30)," +
                "    nombre      varchar(20)," +
                "    mail        varchar (25)," +
                "    fecha_nac   date," +
                "    telefono    numeric(10,0)," +
                "    foreign key (id_plan) references plan(id_plan)" +
                "    )";

        String tableCategory = "CREATE TABLE categoria(" +
                "    id_categoria    int not null primary key AUTO_INCREMENT," +
                "    nombre          varchar(20)," +
                "    descripcion     varchar(30)" +
                ")";

        String tableProduct = "CREATE TABLE producto(" +
                "    id_producto int not null primary key AUTO_INCREMENT," +
                "    id_categoria int not null," +
                "    stock       int," +
                "    precio      decimal (19,4)," +
                "    nombre      varchar(20)," +
                "    foreign key (id_Categoria) references categoria(id_Categoria)" +
                "    )";

        String tableDay = "CREATE TABLE dia(" +
                "    id_dia      int not null primary key AUTO_INCREMENT," +
                "    dia         varchar(10)," +
                "    hora        time" +
                ")";

        String tableSchedule = "CREATE TABLE horario(" +
                "    id_horario  int not null primary key AUTO_INCREMENT," +
                "    id_dia      int not null," +
                "    id_plan     int not null," +
                "    foreign key (id_dia) references dia(id_dia)," +
                "    foreign key (id_plan) references plan(id_plan)" +
                "    )";

        String tableInvoice = "CREATE TABLE factura(" +
                "    id_factura  int not null primary key AUTO_INCREMENT," +
                "    id_cliente  int not null," +
                "    fecha       date," +
                "    foreign key (id_cliente) references cliente(id_cliente)" +
                "    )";

        String tableProductInvoice = "CREATE TABLE producto_factura(" +
                "    id_producto_Factura int not null primary key AUTO_INCREMENT," +
                "    id_producto         int not null," +
                "    id_factura          int not null," +
                "    cantidad            int," +
                "    precio              decimal(19,4)" +
                ")";

        executeQuery(tablePlan);
        executeQuery(tableClient);
        executeQuery(tableCategory);
        executeQuery(tableProduct);
        executeQuery(tableDay);
        executeQuery(tableSchedule);
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

    private static void closeConnection() {
        try {
//            if (rs != null) rs.close();
//            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}