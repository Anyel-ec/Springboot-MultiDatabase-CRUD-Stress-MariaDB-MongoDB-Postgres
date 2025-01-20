package top.anyel.stress.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.anyel.stress.postgres.model.SalesOrderPostgres;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Repository
public interface SalesOrderPostgresRepository extends JpaRepository<SalesOrderPostgres, Integer> {


}