package top.anyel.stress.postgres.services;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 23/01/2025
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionTest {
    public static void main(String[] args) {
        // Configura los detalles de conexión aquí
        String jdbcUrl = "jdbc:postgresql://localhost:5444/northwind";
        String username = "postgres";
        String password = "anyel";

        System.out.println("Probando conexión a PostgreSQL...");
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (connection != null) {
                System.out.println("¡Conexión exitosa!");
                System.out.println("URL de conexión: " + connection.getMetaData().getURL());
                System.out.println("Usuario conectado: " + connection.getMetaData().getUserName());
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}
