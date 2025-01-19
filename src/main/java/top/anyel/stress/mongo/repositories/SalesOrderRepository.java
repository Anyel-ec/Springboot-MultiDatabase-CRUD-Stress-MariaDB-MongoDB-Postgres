package top.anyel.stress.mongo.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import top.anyel.stress.mongo.models.SalesOrderMongo;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Repository
public interface SalesOrderRepository extends MongoRepository<SalesOrderMongo, String> {
}
