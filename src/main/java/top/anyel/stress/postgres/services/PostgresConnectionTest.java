package top.anyel.stress.postgres.services;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 23/01/2025
 */
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Slf4j
public class PostgresConnectionTest {
    public static void main(String[] args) {
        // Configura los detalles de conexión aquí
        String jdbcUrl = "jdbc:postgresql://localhost:5444/northwind";
        String username = "postgres";
        String password = "anyel";

       log.info("Probando conexión a PostgreSQL...");
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            if (connection != null) {
               log.info("¡Conexión exitosa!");
               log.info("URL de conexión: " + connection.getMetaData().getURL());
               log.info("Usuario conectado: " + connection.getMetaData().getUserName());
            } else {
               log.info("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}
