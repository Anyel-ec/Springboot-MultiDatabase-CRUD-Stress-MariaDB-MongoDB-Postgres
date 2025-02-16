package top.anyel.stress.mongo.services;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.anyel.stress.mongo.models.SalesOrderMongo;
import top.anyel.stress.mongo.repositories.SalesOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository orderRepository;

    public List<SalesOrderMongo> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<SalesOrderMongo> getOrderById(String id) {
        return ObjectId.isValid(id)
                ? orderRepository.findById(new ObjectId(id))
                : Optional.empty();  // 🔹 Verifica si el ID es válido antes de buscar
    }

    public SalesOrderMongo createOrder(SalesOrderMongo order) {
        return orderRepository.save(order);
    }

    public SalesOrderMongo updateOrder(String id, SalesOrderMongo updatedOrder) {
        if (!ObjectId.isValid(id)) {
            throw new RuntimeException("Invalid ObjectId format");
        }

        ObjectId objectId = new ObjectId(id);
        return orderRepository.findById(objectId)
                .map(order -> {
                    updatedOrder.setId(objectId); // 🔹 Pasamos ObjectId en lugar de String
                    return orderRepository.save(updatedOrder);
                })
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteOrder(String id) {
        if (!ObjectId.isValid(id)) {
            throw new RuntimeException("Invalid ObjectId format");
        }
        orderRepository.deleteById(new ObjectId(id)); // 🔹 Convertimos el id antes de eliminar
    }
}
