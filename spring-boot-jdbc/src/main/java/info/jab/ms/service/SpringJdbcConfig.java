package info.jab.ms.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

@Configuration
class SpringJdbcConfig {

    @Bean
    JdbcClient jdbcClient(JdbcTemplate jdbcTemplate) {
        return JdbcClient.create(jdbcTemplate);
    }

}
