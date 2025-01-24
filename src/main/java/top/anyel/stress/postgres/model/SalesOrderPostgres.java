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
    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "custid")
    private String custId;

    @Column(name = "empid")
    private Integer employeeId;

    @Column(name = "orderdate")
    private String orderDate;

    @Column(name = "requireddate")
    private String requiredDate;

    @Column(name = "shippeddate")
    private String shippedDate;

    @Column(name = "shipperid")
    private Integer shipperId;

    @Column(name = "freight")
    private Double freight;

    @Column(name = "shipname", length = 40)
    private String shipName;

    @Column(name = "shipaddress", length = 60)
    private String shipAddress;

    @Column(name = "shipcity", length = 15)
    private String shipCity;

    @Column(name = "shipregion", length = 15)
    private String shipRegion;

    @Column(name = "shippostalcode", length = 15)
    private String shipPostalCode;

    @Column(name = "shipcountry", length = 15)
    private String shipCountry;
}
