package top.anyel.stress.postgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 26/01/2025
 */
@Service
public class SQLExecutionService {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public SQLExecutionService(@Qualifier("postgresJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void executeSQLFromFile(String filePath) throws Exception {
        // Cargar el archivo SQL desde resources
        ClassPathResource resource = new ClassPathResource(filePath);
        if (!resource.exists()) {
            throw new FileNotFoundException("Archivo SQL no encontrado en la ruta: " + filePath);
        }

        Path path = resource.getFile().toPath();
        String sql = Files.readString(path);

        // Dividir y ejecutar sentencias SQL
        String[] sqlStatements = sql.split(";");
        for (String statement : sqlStatements) {
            if (!statement.trim().isEmpty()) {
                jdbcTemplate.execute(statement.trim());
            }
        }
    }
}
