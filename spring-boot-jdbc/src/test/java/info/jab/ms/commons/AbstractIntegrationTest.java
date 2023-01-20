package info.jab.ms.commons;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration(initializers = {PostgresDatabaseContainerInitializer.class})
public abstract class AbstractIntegrationTest {
    @Autowired protected MockMvc mockMvc;
}
