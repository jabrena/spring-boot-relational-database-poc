package info.jab.ms.commons;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresDatabaseContainerInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final DockerImageName myImage = DockerImageName.parse("frantiseks/postgres-sakila")
            .asCompatibleSubstituteFor("postgres");

    private static final PostgreSQLContainer<?> sqlContainer =
            new PostgreSQLContainer<>(myImage)
                    .withDatabaseName("postgres")
                    .withUsername("postgres")
                    .withPassword("postgres");
    static {
        sqlContainer.start();
    }

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                        "spring.datasource.url=" + sqlContainer.getJdbcUrl(),
                        "spring.datasource.username=" + sqlContainer.getUsername(),
                        "spring.datasource.password=" + sqlContainer.getPassword())
                .applyTo(configurableApplicationContext.getEnvironment());
    }
}
