package info.jab.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MainController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    record Film(Integer FILM_ID, String TITLE) {}

    @GetMapping(value = "/api/v1/", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public List<Film> getData() {
        String sql = """
SELECT *
FROM film
WHERE title LIKE 'A%'
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Film(
                        rs.getInt("FILM_ID"),
                        rs.getString("TITLE")));

    }
}
