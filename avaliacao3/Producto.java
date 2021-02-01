package avaliacao3;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Producto {
    
    static Scanner input = new Scanner(System.in);

    // Funcionar de listar productos. Envía consulta
    public static void listarProdutos() throws SQLException {
        final String sql = "SELECT * FROM produtos";
        Avaliacao3.conexion(sql, 1);
    }

    // Recibe datos de la consulta y los muestra
	public static void listarProductos(ResultSet resultSet) throws SQLException {
        ResultSet datos = resultSet;
        ResultSetMetaData metaData = datos.getMetaData();
        int nCol = metaData.getColumnCount();
        System.out.println("Listando Productos:");
        System.out.println("-------------------");
        for (int i = 1; i <= nCol; i++) {
            System.out.printf("%-8s\t",
            metaData.getColumnName(i));
        }
        System.out.println();
        while(resultSet.next()) {
            for (int i = 1; i <= nCol; i++) {
                System.out.printf("%-8s\t",
                resultSet.getObject(i));
            }
            System.out.println();
        }
    }
    
    // Usuario ingresa datos, y envía comando SQL para registrar producto
    public static void registrarProducto() throws SQLException {
        String nombreProducto;
        int cant;
        Float valor;

        System.out.println("Registrando Producto:");
        System.out.println("---------------------");
        
        System.out.print("Nombre del Producto: ");
        input = new Scanner(System.in);
        nombreProducto = input.nextLine();
        
        System.out.print("\nCantidad en Stock: ");
        input = new Scanner(System.in);
        cant = input.nextInt();
        
        System.out.print("\nValor unitario: ");
        input = new Scanner(System.in);
        valor = input.nextFloat();

        final String sql = "INSERT INTO produtos (nome, quantidade, preco) VALUES (\"" + nombreProducto + "\", " + cant + ", " + valor + ")";
        Avaliacao3.conexion(sql, 2);
    }

    // Solicita id de Producto, y envía consulta
    public static void reducirStock() throws SQLException {
        int idProducto;
        
        System.out.println("Retirando de Stock:");
        System.out.println("-------------------");

        System.out.print("Id del Producto: ");
        input = new Scanner(System.in);
        idProducto = input.nextInt();

        final String sql = "SELECT * FROM produtos WHERE id = " + idProducto;
        Avaliacao3.conexion(sql, 3);
        
    }

    // Recibe la consulta y envía el comando para actualizar stock del producto
    public static void reducirStock(ResultSet resultSet) throws SQLException {
        int cant, idProducto, stock, aux;

        System.out.print("\nCantidad a retirar: ");
        input = new Scanner(System.in);
        cant = input.nextInt();

        ResultSet datos = resultSet;
        while(datos.next()) {
            idProducto = datos.getInt("id");
            stock = datos.getInt("quantidade");
            aux = (stock-cant);
            final String sql = "UPDATE produtos SET quantidade = " + aux + " WHERE id = " + idProducto;
            Avaliacao3.conexion(sql, 30);
        }        
    }

    // Solicita id de Producto, y envía consulta
    public static void aumentarStock() throws SQLException {
        int idProducto;
        
        System.out.println("Agregando en Stock:");
        System.out.println("-------------------");

        System.out.print("Id del Producto: ");
        input = new Scanner(System.in);
        idProducto = input.nextInt();

        final String sql = "SELECT * FROM produtos WHERE id = " + idProducto;
        Avaliacao3.conexion(sql, 4);
    }

    // Recibe la consulta y envía el comando para actualizar stock del producto
    public static void aumentarStock(ResultSet resultSet) throws SQLException {
        int cant, idProducto, stock, aux;

        System.out.print("\nCantidad a agregar: ");
        input = new Scanner(System.in);
        cant = input.nextInt();

        ResultSet datos = resultSet;
        while(datos.next()) {
            idProducto = datos.getInt("id");
            stock = datos.getInt("quantidade");
            aux = (stock+cant);
            final String sql = "UPDATE produtos SET quantidade = " + aux + " WHERE id = " + idProducto;
            Avaliacao3.conexion(sql, 40);
        }
    }

    // Solicita nombre de Producto, y envía consulta
    public static void buscarProducto() throws SQLException {
        String nombreProducto;
        
        System.out.println("Consultando Producto:");
        System.out.println("---------------------");

        System.out.print("Nombre del Producto: ");
        input = new Scanner(System.in);
        nombreProducto = input.nextLine();

        final String sql = "SELECT * FROM produtos WHERE nome LIKE \"" + nombreProducto +"\"";
        Avaliacao3.conexion(sql, 5);
    }

    // Recibe datos de la consulta y los muestra
	public static void buscarProducto(ResultSet resultSet) throws SQLException {
        ResultSet datos = resultSet;
        ResultSetMetaData metaData = datos.getMetaData();
        int nCol = metaData.getColumnCount();
        System.out.println("Mostrando Producto:");
        System.out.println("-------------------");
        for (int i = 1; i <= nCol; i++) {
            System.out.printf("%-8s\t",
            metaData.getColumnName(i));
        }
        System.out.println();
        while(resultSet.next()) {
            for (int i = 1; i <= nCol; i++) {
                System.out.printf("%-8s\t",
                resultSet.getObject(i));
            }
            System.out.println();
        }
    }

    // Solicita id de Producto, y envía comando
    public static void eliminarProducto() throws SQLException {
        int idProducto;
        
        System.out.println("Eliminando Registro:");
        System.out.println("--------------------");

        System.out.print("Id del Producto: ");
        input = new Scanner(System.in);
        idProducto = input.nextInt();

        final String sql = "DELETE FROM produtos WHERE id = " + idProducto;
        Avaliacao3.conexion(sql, 6);
    }
    
}