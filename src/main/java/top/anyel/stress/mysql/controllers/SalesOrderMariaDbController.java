package top.anyel.stress.mysql.controllers;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.stress.dto.JsonResponseDto;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;
import top.anyel.stress.mysql.services.SalesOrderMariaDbService;

import java.util.List;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/mariadb/orders")
public class SalesOrderMariaDbController {
    @Autowired
    private SalesOrderMariaDbService orderService;

    @PostMapping("/execute")
    public JsonResponseDto executeSQLFile() {
        try {
            orderService.executeSQLFromFile("mysql/northwind.sql");
            return new JsonResponseDto(true, 200, "Archivo SQL ejecutado con éxito.", null);
        } catch (Exception e) {
            log.error("Error al ejecutar el archivo SQL: " + e.getMessage());
            log.error(String.valueOf(e));
            return new JsonResponseDto(false, 500, "Error al ejecutar el archivo SQL: " + e.getMessage(), null);
        }
    }

    @GetMapping
    public List<SalesOrderMariaDb> getAllOrders() {
        log.info("Getting all orders from MariaDB");
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrderMariaDb> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesOrderMariaDb createOrder(@RequestBody SalesOrderMariaDb order) {
        log.info("Creating order in MariaDB");
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOrderMariaDb> updateOrder(@PathVariable Integer id, @RequestBody SalesOrderMariaDb order) {
        try {
            log.info("Updating order in MariaDB");
            return ResponseEntity.ok(orderService.updateOrder(id, order));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        log.info("Attempting to delete order with ID {}", id);
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
