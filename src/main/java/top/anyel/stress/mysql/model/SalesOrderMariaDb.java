package top.anyel.stress.mysql.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Getter
@Setter
@Entity
@Table(name = "SalesOrder")
public class SalesOrderMariaDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer custId;
    private Integer employeeId;

    @Column(length = 20)
    private String orderDate;

    @Column(length = 20)
    private String requiredDate;

    @Column(length = 20)
    private String shippedDate;

    private Integer shipperId;
    private Double freight;

    @Column(length = 40)
    private String shipName;

    @Column(length = 60)
    private String shipAddress;

    @Column(length = 15)
    private String shipCity;

    @Column(length = 15)
    private String shipRegion;

    @Column(length = 15)
    private String shipPostalCode;

    @Column(length = 15)
    private String shipCountry;
}