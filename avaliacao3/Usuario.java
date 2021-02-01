package avaliacao3;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Usuario {
    
    static Scanner input = new Scanner(System.in);

    // Recibe los datos de email y clave y realiza una consulta al método "conexion" con los datos dados.
    public static void login(String email, String senha) throws SQLException {

        final String sql = "SELECT * FROM usuarios WHERE email LIKE \""+email+"\" AND senha LIKE \""+senha+"\"";
        Avaliacao3.conexion(sql, 0);

    }

    // Comprueba que haya recibido datos de la consulta.
    public static void login(ResultSet resultSet) throws SQLException {

        ResultSet datos = resultSet;
        // Si recibió datos, está "logueado" y redirige al Menú de la app.
        if (datos.next() == true) {
            Avaliacao3.menu();
        } else {
            // Caso contrario, redirige al inicio de la app dónde se volverá a pedir los datos.
            System.out.println("Datos de login erroneos, intente nuevamente.\n");
            Avaliacao3.main(null);
        }

    }

    // Solicita nombre de Usuario, y envía consulta
    public static void buscarUsuario() throws SQLException {
        String nombreUsuario;
        
        System.out.println("Consultando Usuario:");
        System.out.println("---------------------");

        System.out.print("Nombre del Usuario: ");
        input = new Scanner(System.in);
        nombreUsuario = input.nextLine();

        final String sql = "SELECT id, nome, email FROM usuarios WHERE nome LIKE \"" + nombreUsuario +"\"";
        Avaliacao3.conexion(sql, 7);
    }

    // Recibe datos de la consulta y los muestra
	public static void buscarUsuario(ResultSet resultSet) throws SQLException {
        ResultSet datos = resultSet;
        ResultSetMetaData metaData = datos.getMetaData();
        int nCol = metaData.getColumnCount();
        System.out.println("Mostrando Usuario:");
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

    // Usuario ingresa datos, y envía comando SQL para registrar usuario
    public static void registrarUsuario() throws SQLException {
        String nombre, email, clave;

        System.out.println("Registrando Usuario:");
        System.out.println("---------------------");
        
        System.out.print("Nombre: ");
        input = new Scanner(System.in);
        nombre = input.nextLine();
        
        System.out.print("Email: ");
        input = new Scanner(System.in);
        email = input.nextLine();
        
        System.out.print("Contraseña: ");
        input = new Scanner(System.in);
        clave = input.nextLine();

        final String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (\"" + nombre + "\", \"" + email + "\", \"" + clave + "\")";
        Avaliacao3.conexion(sql, 8);
    }

    // Método de listar usuarios. Envía consulta
    public static void listarUsuarios() throws SQLException {
        final String sql = "SELECT id, nome, email FROM usuarios";
        Avaliacao3.conexion(sql, 80);
    }

    // Recibe datos de la consulta y los muestra
	public static void listarUsuarios(ResultSet resultSet) throws SQLException {
        ResultSet datos = resultSet;
        ResultSetMetaData metaData = datos.getMetaData();
        int nCol = metaData.getColumnCount();
        System.out.println("Listando Usuarios:");
        System.out.println("------------------");
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

}