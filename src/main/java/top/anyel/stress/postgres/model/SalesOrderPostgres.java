package top.anyel.stress.postgres.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

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

    // Con @JsonFormat le indicamos a Jackson el formato esperado en el JSON.
    @Column(name = "orderdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @Column(name = "requireddate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requiredDate;

    @Column(name = "shippeddate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shippedDate;

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
