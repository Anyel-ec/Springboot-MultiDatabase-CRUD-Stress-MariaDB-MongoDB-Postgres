package top.anyel.stress;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StressCrudMongoMariaPostgresApplication {

    public static void main(String[] args) {
        // Cargar variables desde .env
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing() // Ignorar si el archivo .env no está presente
                .load();

        // Establecer las propiedades necesarias desde .env
        System.setProperty("MYSQL_URL", dotenv.get("MYSQL_URL", ""));
        System.setProperty("MYSQL_USERNAME", dotenv.get("MYSQL_USERNAME", ""));
        System.setProperty("MYSQL_PASSWORD", dotenv.get("MYSQL_PASSWORD", ""));

        System.setProperty("POSTGRES_URL", dotenv.get("POSTGRES_URL", ""));
        System.setProperty("POSTGRES_USERNAME", dotenv.get("POSTGRES_USERNAME", ""));
        System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD", ""));

        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI", ""));

        // Iniciar la aplicación Spring Boot
        SpringApplication.run(StressCrudMongoMariaPostgresApplication.class, args);
    }
}
