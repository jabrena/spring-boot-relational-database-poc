package info.jab.ms.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FilmMapperRepository {

   String sql =
          """
          SELECT FILM_ID, TITLE
          FROM film
          WHERE title LIKE 'A%'
          """;
    @Select(sql)
    List<Film> select();

    record Film(Long FILM_ID, String TITLE) {
    }
}


