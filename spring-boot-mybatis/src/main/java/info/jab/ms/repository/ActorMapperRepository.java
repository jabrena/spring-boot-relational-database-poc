package info.jab.ms.repository;

import info.jab.ms.model.Actor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ActorMapperRepository {

    String sqlSelect =
            """
            SELECT actor_id, first_name, last_name, last_update
            FROM actor
            """;

    @Select(sqlSelect)
    List<Actor> findAll();

    String sqlSelect2 =
            """
            SELECT actor_id, first_name, last_name, last_update
            FROM actor
            WHERE actor_id = #{id}
            """;

    @Select(sqlSelect2)
    Actor findById(long id);

    String sqlDelete =
            """
            DELETE
            FROM actor
            WHERE actor_id = #{id}
            """;

    @Delete(sqlDelete)
    void deleteById(long id);

    String sqlInsert =
            """
            INSERT INTO actor (first_name, last_name, last_update)
            VALUES (#{first_name}, #{last_name}, #{last_update})
            """;

    @Insert(sqlInsert)
    @Options(useGeneratedKeys = true, keyProperty = "actor_id")
    void save(Actor employee);

    String sqlUpdate =
            """
            UPDATE actor
            set first_name = #{first_name}, last_name = #{last_name}, last_update = #{last_update}
            WHERE actor_id = #{actor_id}
            """;

    @Update(sqlUpdate)
    void update(Actor employee);
}
