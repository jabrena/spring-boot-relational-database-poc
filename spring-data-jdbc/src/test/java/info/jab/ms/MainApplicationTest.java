package info.jab.ms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:15.1-alpine://tag",
        "spring.datasource.username=postgres",
        "spring.datasource.password=postgres"
})
class MainApplicationTest {

    @Test
    void contextLoads() {
    }

}
