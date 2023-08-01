package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("jdbcActorService")
class ActorServiceImplV2 implements ActorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcClient jdbcClient;

    @Override
    public List<ActorDto> getAll() {
        String sql =
        """
        SELECT actor_id, first_name, last_name, last_update
        FROM actor
        """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    ActorDto actor = new ActorDto();
                    actor.setActorId(rs.getLong("actor_id"));
                    actor.setFirstName(rs.getString("first_name"));
                    actor.setLastName(rs.getString("last_name"));
                    actor.setLastUpdate(rs.getString("last_update"));
                    return actor;
                });
    }

    @Override
    public ActorDto add(ActorDto newActor) {
        String sql =
        """
        INSERT INTO actor (first_name, last_name, last_update)
        VALUES (?, ?, ?)
        """;

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(conn -> {

            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set parameters
            preparedStatement.setString(1, newActor.getFirstName());
            preparedStatement.setString(2, newActor.getLastName());
            preparedStatement.setObject(3, LocalDateTime.now());

            return preparedStatement;

        }, generatedKeyHolder);

        Long id = Long.parseLong(generatedKeyHolder.getKeys().get("actor_id").toString());

        var actorResponse = new ActorDto();
        actorResponse.setActorId(id);
        actorResponse.setFirstName(newActor.getFirstName());
        actorResponse.setLastName(newActor.getLastName());
        actorResponse.setLastUpdate(newActor.getLastUpdate().toString());
        return actorResponse;
    }

    @Override
    public Optional<ActorDto> get(Long actorId) {
        String sql =
        """
        SELECT actor_id, first_name, last_name, last_update
        FROM actor
        WHERE actor_id = %s
        """.formatted(actorId);

        System.out.println(sql);
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        //TODO Refactor
        if(rows.size() == 1) {
            var actorResponse = new ActorDto();
            actorResponse.setActorId(Long.parseLong(rows.get(0).get("actor_id").toString()));
            actorResponse.setFirstName(rows.get(0).get("first_name").toString());
            actorResponse.setLastName(rows.get(0).get("last_name").toString());
            actorResponse.setLastUpdate(rows.get(0).get("last_update").toString());
            return Optional.of(actorResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long actorId) {
        String sql =
        """
        DELETE
        FROM actor
        WHERE actor_id = ?
        """;

        jdbcTemplate.update(sql, actorId);
    }

    @Override
    public ActorDto update(Long actorId, ActorDto newActorData) {

        String sql =
        """
        UPDATE actor
        set first_name = ?, last_name = ?, last_update = ?
        WHERE actor_id = ?
        """;

        var now = LocalDateTime.now();
        this.jdbcTemplate.update(
                sql,
                newActorData.getFirstName(),
                newActorData.getLastName(),
                now,
                actorId);

        var actorResponse = new ActorDto();
        actorResponse.setActorId(actorId);
        actorResponse.setFirstName(newActorData.getFirstName());
        actorResponse.setLastName(newActorData.getLastName());
        actorResponse.setLastUpdate(now.toString());
        return actorResponse;
    }
}
