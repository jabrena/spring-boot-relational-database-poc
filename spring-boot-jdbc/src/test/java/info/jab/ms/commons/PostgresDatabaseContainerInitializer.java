package info.jab.ms.commons;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;

public class PostgresDatabaseContainerInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final PostgreSQLContainer<?> sqlContainer =
            new PostgreSQLContainer<>("postgres:15.1-alpine")
                    .withDatabaseName("postgres")
                    .withUsername("postgres")
                    .withPassword("postgres");
    static {
        sqlContainer.start();

        var containerDelegate = new JdbcDatabaseDelegate(sqlContainer, "");
        ScriptUtils.runInitScript(containerDelegate, "postgres-sakila-db/postgres-sakila-schema.sql");
        ScriptUtils.runInitScript(containerDelegate, "postgres-sakila-db/postgres-sakila-insert-data.sql");
    }

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                        "spring.datasource.url=" + sqlContainer.getJdbcUrl(),
                        "spring.datasource.username=" + sqlContainer.getUsername(),
                        "spring.datasource.password=" + sqlContainer.getPassword())
                .applyTo(configurableApplicationContext.getEnvironment());
    }
}
