package info.jab.ms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface FilmRepository extends JpaRepository<Film, Long> {

    String sql =
"""
SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
""";

    @Query(value = sql, nativeQuery = true)
    List<Film> myQuery();
}
