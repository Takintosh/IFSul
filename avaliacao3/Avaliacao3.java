package avaliacao3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Avaliacao3 {
    
    static Scanner input = new Scanner(System.in);
    public static int opcion;

    //Función principal de la app, recibe los datos de login y los envía al método correspondiente
    public static void main(String[] args) throws SQLException {

        System.out.print("Email: ");
        input = new Scanner(System.in);
        String email = input.nextLine();

        System.out.print("\nSenha: ");
        input = new Scanner(System.in);
        String senha = input.nextLine();
        
        Usuario.login(email, senha);

    }

    // Menu de la aplicación, es ejecutado luego de validar los datos de login.
    public static void menu() throws SQLException {

        Boolean fechar = false, done = false;
        while (!fechar) {
            done = false;
            System.out.println("-------- Menu --------");
            System.out.println("1 - Listar Productos");
            System.out.println("2 - Registrar Producto");
            System.out.println("3 - Salida de Producto");
            System.out.println("4 - Entrada de Producto");
            System.out.println("5 - Buscar Producto");
            System.out.println("6 - Eliminar Producto");
            System.out.println("7 - Buscar Usuario");
            System.out.println("8 - Registrar Usuario");
            System.out.println("9 - Salir");
            System.out.println("----------------------");
    
            while(!done) {
                try {
                    System.out.print("Opción: ");
                    input = new Scanner(System.in);
                    opcion = input.nextInt();
                    done = true;
                } catch (InputMismatchException e) {
                    System.out.print("Formato erroneo, intente nuevamente.");
                }
            }

            switch(opcion) {
                case 1:
                    Producto.listarProdutos();
                    break;
                case 2:
                    Producto.registrarProducto();
                    break;
                case 3:
                    Producto.reducirStock();
                    break;
                case 4:
                    Producto.aumentarStock();
                    break;
                case 5:
                    Producto.buscarProducto();
                    break;
                case 6:
                    Producto.eliminarProducto();
                    break;
                case 7:
                    Usuario.buscarUsuario();
                    break;
                case 8:
                    Usuario.registrarUsuario();
                    break;
                case 9:
                    System.out.println("Cerrando aplicación...");
                    fechar = true;
                    break;
                default:
                    System.out.print("Opción erronea, seleccione otra opción.");
                    break;
            }

        }

    }

    // Función que realiza la conexión con la base de datos
    public static ResultSet conexion(String query, int metodo) throws SQLException {
        final String obrigatorio = "?autoReconnect=true&useSSL=false&&serverTimezone=UTC";
        final String url = "jdbc:mysql://localhost/trabJDBC"+obrigatorio;
        final String sql = query;
        int funcion = metodo;
        
        try (
            Connection conexion = DriverManager.getConnection(url,"root", "");
            Statement statement = conexion.createStatement();
            ) {
                ResultSet resultSet = null;

                // Dependiendo del método recibido, realiza una consulta o una actualización en la BD.
                if((funcion == 0) || (funcion == 1) || (funcion == 3) || (funcion == 4) || (funcion == 5) || (funcion == 7) || (funcion == 80)) {
                    resultSet = statement.executeQuery(sql);
                } else {
                    statement.executeUpdate(sql);
                }
                
                // Switch auxiliar, ejecuta un método correspondiente, luego de ejecutar el comando SQL
                switch(funcion) {
                    case 0:
                        Usuario.login(resultSet);
                        break;
                    case 1:
                        Producto.listarProductos(resultSet);
                        break;
                    case 2:
                        System.out.println("Producto registrado.");
                        Producto.listarProdutos();
                        break;
                    case 3:
                        Producto.reducirStock(resultSet);
                        break;
                    case 30:
                        System.out.println("Producto actualizado.");
                        Producto.listarProdutos();
                        break;
                    case 4:
                        Producto.aumentarStock(resultSet);
                        break;
                    case 40:
                        System.out.println("Producto actualizado.");
                        Producto.listarProdutos();
                        break;
                    case 5:
                        Producto.buscarProducto(resultSet);
                        break;
                    case 6:
                        System.out.println("Producto eliminado.");
                        Producto.listarProdutos();
                        break;
                    case 7:
                        Usuario.buscarUsuario(resultSet);
                        break;
                    case 8:
                        System.out.println("Usuario registrado.");
                        Usuario.listarUsuarios();
                        break;
                    case 80:
                        Usuario.buscarUsuario(resultSet);
                        break;
                }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}