package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FilmDto> getFilms() {
        String sql =
"""
SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
""";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    FilmDto film = new FilmDto();
                    film.setFilmId(rs.getLong("FILM_ID"));
                    film.setTitle(rs.getString("TITLE"));
                    return film;
                });
    }
}
