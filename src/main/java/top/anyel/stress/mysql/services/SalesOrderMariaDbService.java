package top.anyel.stress.mysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;
import top.anyel.stress.mysql.repositories.SalesOrderMariaDbRepository;

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
}
