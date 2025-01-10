package top.anyel.stress.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Security Monitoring",
                version = "1.0",
                description = "CRUD Multi-dabase",
                contact = @Contact(name = "D", email = "xxx@example", url = "www.xxx.xxxx"),
                license = @License(name = "Apache License 2.0", url = "XXXXX")
        ),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfig {
}
