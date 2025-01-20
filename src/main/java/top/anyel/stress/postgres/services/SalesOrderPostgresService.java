package top.anyel.stress.postgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;
import top.anyel.stress.postgres.model.SalesOrderPostgres;
import top.anyel.stress.postgres.repositories.SalesOrderPostgresRepository;

import java.util.List;
import java.util.Optional;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Service
public class SalesOrderPostgresService {

    @Autowired
    private SalesOrderPostgresRepository orderRepository;

    public List<SalesOrderPostgres> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<SalesOrderPostgres> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    public SalesOrderPostgres createOrder(SalesOrderPostgres order) {
        return orderRepository.save(order);
    }

    public SalesOrderPostgres updateOrder(Integer id, SalesOrderPostgres updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            updatedOrder.setOrderId(id);
            return orderRepository.save(updatedOrder);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}