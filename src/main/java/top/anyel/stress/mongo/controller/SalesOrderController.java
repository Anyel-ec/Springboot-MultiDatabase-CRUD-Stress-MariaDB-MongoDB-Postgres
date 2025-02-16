package top.anyel.stress.mongo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.anyel.stress.mongo.models.SalesOrderMongo;
import top.anyel.stress.mongo.services.SalesOrderService;

import java.util.List;
import java.util.Optional;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/mongodb/orders")
public class SalesOrderController {

    private final SalesOrderService orderService;

    public SalesOrderController(SalesOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<SalesOrderMongo>> getAllOrders() {
        List<SalesOrderMongo> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrderMongo> getOrderById(@PathVariable String id) {
        log.info("Fetching order with ID: {}", id);
        Optional<SalesOrderMongo> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SalesOrderMongo> createOrder(@RequestBody SalesOrderMongo order) {
        log.info("Creating new order in MongoDB");
        SalesOrderMongo savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable String id, @RequestBody SalesOrderMongo order) {
        log.info("Updating order with ID: {}", id);
        try {
            SalesOrderMongo updatedOrder = orderService.updateOrder(id, order);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            log.error("Error updating order: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        log.info("Deleting order with ID: {}", id);
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            log.error("Error deleting order: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
