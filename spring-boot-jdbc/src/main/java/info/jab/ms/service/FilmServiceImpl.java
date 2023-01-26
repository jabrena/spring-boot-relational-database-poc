package info.jab.ms.service;

import info.jab.ms.service.dto.FilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FilmDTO> getFilms() {
        String sql =
"""
SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
""";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> new FilmDTO(
                        rs.getInt("FILM_ID"),
                        rs.getString("TITLE")));
    }
}
