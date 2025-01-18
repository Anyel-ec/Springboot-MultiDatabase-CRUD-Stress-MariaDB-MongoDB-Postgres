package top.anyel.stress.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.stress.mongo.models.SalesOrder;
import top.anyel.stress.mongo.repositories.SalesOrderRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.engine.messageinterpolation.el.RootResolver.FORMATTER;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository orderRepository;

    public List<SalesOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<SalesOrder> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public SalesOrder createOrder(SalesOrder order) {
        return orderRepository.save(order);
    }

    public SalesOrder updateOrder(String id, SalesOrder updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            updatedOrder.setId(id);
            return orderRepository.save(updatedOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}