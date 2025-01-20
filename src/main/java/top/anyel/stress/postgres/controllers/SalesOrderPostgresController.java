package top.anyel.stress.postgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.stress.postgres.model.SalesOrderPostgres;
import top.anyel.stress.postgres.services.SalesOrderPostgresService;

import java.util.List;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@RestController
@RequestMapping("/api/v1/postgres/orders")
public class SalesOrderPostgresController {
    @Autowired
    private SalesOrderPostgresService orderService;

    @GetMapping
    public List<SalesOrderPostgres> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrderPostgres> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SalesOrderPostgres createOrder(@RequestBody SalesOrderPostgres order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOrderPostgres> updateOrder(@PathVariable Integer id, @RequestBody SalesOrderPostgres order) {
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
