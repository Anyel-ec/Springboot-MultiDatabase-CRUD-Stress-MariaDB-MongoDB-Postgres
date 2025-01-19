package top.anyel.stress.mysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;
import top.anyel.stress.mysql.services.SalesOrderMariaDbService;

import java.util.List;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@RestController
@RequestMapping("/api/v1/mariadb/orders")
public class SalesOrderMariaDbController {
    @Autowired
    private SalesOrderMariaDbService orderService;

    @GetMapping
    public List<SalesOrderMariaDb> getAllOrders() {
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
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOrderMariaDb> updateOrder(@PathVariable Integer id, @RequestBody SalesOrderMariaDb order) {
        try {
            return ResponseEntity.ok(orderService.updateOrder(id, order));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
