package info.jab.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getCountryCounter() {
        var sql = "SELECT COUNT(*) FROM country";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {});
    }

    @Override
    public Integer getCityCounter() {
        var sql = "SELECT COUNT(*) FROM city";
        return jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {});
    }

    @Transactional
    @Override
    public void addCountryAndCity(Boolean flag) {

        var sql = "INSERT INTO country (country, last_update) VALUES (?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(conn -> {

            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set parameters
            preparedStatement.setString(1, "Tabarnia");
            preparedStatement.setObject(2, LocalDateTime.now());

            return preparedStatement;

        }, generatedKeyHolder);

        Long result = Long.parseLong(generatedKeyHolder.getKeys().get("country_id").toString());

        try {
            var countryId = (flag == Boolean.TRUE) ? result : 999L;
            var sql2 = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql2, "TabarniaCity", countryId, LocalDateTime.now());

        } catch (DataAccessException ex) {
            System.out.println("Katakroker");
            throw new RuntimeException("Katakroker");
        }

    }
}
