package top.anyel.stress.postgres.model;

import jakarta.persistence.*;
import lombok.Data;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Data
@Entity
@Table(name = "salesorder")
public class SalesOrderPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid") // Mapea a "orderid" en la base de datos
    private Integer orderId;

    @Column(name = "custid") // Mapea a "custid" en la base de datos
    private String custId;

    @Column(name = "empid") // Cambiado a "empid" para coincidir con la base de datos
    private Integer employeeId;

    @Column(name = "orderdate") // Mapea a "orderdate" en la base de datos
    private String orderDate;

    @Column(name = "requireddate") // Mapea a "requireddate" en la base de datos
    private String requiredDate;

    @Column(name = "shippeddate") // Mapea a "shippeddate" en la base de datos
    private String shippedDate;

    @Column(name = "shipperid") // Mapea a "shipperid" en la base de datos
    private Integer shipperId;

    @Column(name = "freight") // Mapea a "freight" en la base de datos
    private Double freight;

    @Column(name = "shipname", length = 40) // Mapea a "shipname" en la base de datos
    private String shipName;

    @Column(name = "shipaddress", length = 60) // Mapea a "shipaddress" en la base de datos
    private String shipAddress;

    @Column(name = "shipcity", length = 15) // Mapea a "shipcity" en la base de datos
    private String shipCity;

    @Column(name = "shipregion", length = 15) // Mapea a "shipregion" en la base de datos
    private String shipRegion;

    @Column(name = "shippostalcode", length = 15) // Mapea a "shippostalcode" en la base de datos
    private String shipPostalCode;

    @Column(name = "shipcountry", length = 15) // Mapea a "shipcountry" en la base de datos
    private String shipCountry;
}
