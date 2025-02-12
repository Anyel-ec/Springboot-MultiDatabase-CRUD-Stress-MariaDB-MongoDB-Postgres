package top.anyel.stress.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 08/01/2025
 */
@EnableMongoRepositories(
        basePackages = "top.anyel.stress.mongo.repositories",
        mongoTemplateRef = "mongoTemplate"
)
@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create(mongoUri), "anyel");
    }
}
