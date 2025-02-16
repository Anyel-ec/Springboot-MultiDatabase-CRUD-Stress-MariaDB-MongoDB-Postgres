package top.anyel.stress.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Repository
public interface SalesOrderMariaDbRepository extends JpaRepository<SalesOrderMariaDb, Integer> {
    @Modifying
    @Transactional
    @Query("DELETE FROM SalesOrderMariaDb o WHERE o.orderId = :id")
    void forceDeleteById(Integer id);

}