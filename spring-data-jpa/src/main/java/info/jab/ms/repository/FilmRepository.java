package info.jab.ms.repository;

import info.jab.ms.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
