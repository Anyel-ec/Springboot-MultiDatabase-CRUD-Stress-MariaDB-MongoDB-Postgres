package top.anyel.stress.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.stress.mongo.models.SalesOrderMongo;
import top.anyel.stress.mongo.repositories.SalesOrderRepository;

import java.util.List;
import java.util.Optional;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository orderRepository;

    public List<SalesOrderMongo> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<SalesOrderMongo> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public SalesOrderMongo createOrder(SalesOrderMongo order) {
        return orderRepository.save(order);
    }

    public SalesOrderMongo updateOrder(String id, SalesOrderMongo updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}