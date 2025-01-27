package top.anyel.stress.mysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;
import top.anyel.stress.mysql.repositories.SalesOrderMariaDbRepository;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Service
public class SalesOrderMariaDbService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalesOrderMariaDbRepository orderRepository;

    public List<SalesOrderMariaDb> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<SalesOrderMariaDb> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public SalesOrderMariaDb createOrder(SalesOrderMariaDb order) {
        return orderRepository.save(order);
    }

    public SalesOrderMariaDb updateOrder(Integer id, SalesOrderMariaDb updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            updatedOrder.setOrderId(id);
            return orderRepository.save(updatedOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public void executeSQLFromFile(String filePath) throws Exception {
        // Cargar el archivo SQL desde resources
        ClassPathResource resource = new ClassPathResource(filePath);
        if (!resource.exists()) {
            throw new FileNotFoundException("Archivo SQL no encontrado en la ruta: " + filePath);
        }

        Path path = resource.getFile().toPath();
        String sql = Files.readString(path);

        // Limpiar comentarios y líneas vacías
        sql = sql.replaceAll("(?m)^--.*?$", ""); // Eliminar comentarios '--'
        sql = sql.replaceAll("(?s)/\\*.*?\\*/", ""); // Eliminar comentarios '/* */'
        sql = sql.replaceAll("\\s*;\\s*", ";"); // Eliminar espacios alrededor de ';'
        sql = sql.trim(); // Quitar espacios iniciales y finales

        // Dividir y ejecutar sentencias SQL
        String[] sqlStatements = sql.split(";");
        for (String statement : sqlStatements) {
            String cleanStatement = statement.trim(); // Eliminar espacios adicionales
            if (!cleanStatement.isEmpty()) {
                try {
                    jdbcTemplate.execute(cleanStatement);
                } catch (Exception e) {
                    throw new RuntimeException("Error ejecutando la sentencia: " + cleanStatement, e);
                }
            }
        }
    }



}
