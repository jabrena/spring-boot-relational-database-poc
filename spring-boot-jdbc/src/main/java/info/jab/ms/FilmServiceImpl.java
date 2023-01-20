package info.jab.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Film> getFilms() {
        String sql = """
SELECT *
FROM film
WHERE title LIKE 'A%'
""";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new Film(
                        rs.getInt("FILM_ID"),
                        rs.getString("TITLE")));    }
}
