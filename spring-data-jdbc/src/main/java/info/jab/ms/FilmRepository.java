package info.jab.ms;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {

    String sql =
"""
SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
""";

    @Query(sql)
    List<FilmDTO> myQuery();
}
