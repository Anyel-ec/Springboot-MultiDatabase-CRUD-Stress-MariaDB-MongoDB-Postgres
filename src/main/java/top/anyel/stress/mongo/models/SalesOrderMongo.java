package top.anyel.stress.mongo.models;

import jakarta.persistence.Id;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 18/01/2025
 */
@Data
@Document(collection = "salesOrder")
public class SalesOrderMongo {
    @Id
    private ObjectId id;
    private double freight;
    private int entityId;
    private String shipCity;
    private String shipName;

    private String orderDate;
    private String shippedDate;
    private String requiredDate;

    private int shipperId;
    private int customerId;
    private int employeeId;
    private String shipRegion;
    private String shipAddress;
    private String shipCountry;
    private String shipPostalCode;

    public String getId() {
        return id != null ? id.toHexString() : null;
    }

    // 🔹 Setter acepta ObjectId directamente
    public void setId(ObjectId id) {
        this.id = id;
    }

}
