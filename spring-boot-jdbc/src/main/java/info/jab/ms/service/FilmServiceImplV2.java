package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jdbcFilmService")
class FilmServiceImplV2 implements FilmService {

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<FilmDto> getFilms() {
        String sql =
        """
        SELECT FILM_ID, TITLE
        FROM film
        WHERE title LIKE 'A%'
        """;

        RowMapper<FilmDto> filmDtoRowMapper = (rs, rowNum) -> {
            FilmDto film = new FilmDto();
            film.setFilmId(rs.getLong("FILM_ID"));
            film.setTitle(rs.getString("TITLE"));
            return film;
        };

        return jdbcClient
            .sql(sql)
            .query(filmDtoRowMapper)
            .list();
    }
}
