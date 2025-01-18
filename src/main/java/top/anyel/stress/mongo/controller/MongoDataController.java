package top.anyel.stress.mongo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 13/01/2025
 */
@RestController
@RequestMapping("/mongo")
public class MongoDataController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/load-data")
    public ResponseEntity<String> loadData() {
        String dataDirectory = "src/main/resources/mongo/data/";
        List<String> collections = new ArrayList<>(Arrays.asList(
                "category.json", "customer.json", "employee.json", "employeeTerritory.json",
                "orderDetail.json", "product.json", "region.json", "salesOrder.json",
                "shipper.json", "supplier.json", "territory.json"
        ));

        try {
            ObjectMapper mapper = new ObjectMapper();
            StringBuilder result = new StringBuilder();

            for (String collection : collections) {
                String collectionName = collection.replace(".json", "");
                File file = new File(dataDirectory + collection);

                // Leer archivo JSON
                List<Map<String, Object>> data = mapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {});
                mongoTemplate.insert(data, collectionName);
                result.append("✅ Importación exitosa para la colección: ").append(collectionName).append("\n");
            }

            return ResponseEntity.ok(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("❌ Error al cargar los archivos JSON: " + e.getMessage());
        }
    }
}
