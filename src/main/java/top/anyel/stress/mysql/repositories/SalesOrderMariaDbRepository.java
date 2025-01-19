package top.anyel.stress.mysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.anyel.stress.mysql.model.SalesOrderMariaDb;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Repository
public interface SalesOrderMariaDbRepository extends JpaRepository<SalesOrderMariaDb, Integer> {
}