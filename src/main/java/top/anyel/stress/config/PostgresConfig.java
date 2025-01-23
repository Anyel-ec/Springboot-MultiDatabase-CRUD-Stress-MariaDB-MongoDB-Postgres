package top.anyel.stress.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 08/01/2025
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "top.anyel.stress.postgres.repositories",
        entityManagerFactoryRef = "postgresEntityManagerFactory",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresConfig {

    @Bean(name = "postgresDataSource")
    @Primary
    public DataSource postgresDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5444/northwind");
        dataSource.setUsername("postgres");
        dataSource.setPassword("anyel");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean(name = "postgresEntityManagerFactoryBuilder")
    public EntityManagerFactoryBuilder postgresEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Bean(name = "postgresEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(
            @Qualifier("postgresDataSource") DataSource dataSource,
            @Qualifier("postgresEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder
                .dataSource(dataSource)
                .packages("top.anyel.stress.postgres.model")
                .persistenceUnit("postgresPU")
                .properties(properties)
                .build();
    }

    @Bean(name = "postgresTransactionManager")
    public JpaTransactionManager postgresTransactionManager(
            @Qualifier("postgresEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    // Método para probar conexión fuera del ciclo de creación del contexto
    public void testConnection() {
        try {
            DataSource dataSource = postgresDataSource();
            Connection connection = dataSource.getConnection();
            System.out.println("PostgreSQL Connection successful: " + connection.getMetaData().getURL());
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}