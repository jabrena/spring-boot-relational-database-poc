package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import info.jab.ms.jooq.tables.records.ActorRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static info.jab.ms.jooq.tables.Actor.ACTOR;

@Service
class ActorServiceImpl implements ActorService {

    @Autowired
    private DSLContext dsl;

    @Override
    public List<ActorDto> getAll() {
        return dsl.selectFrom(ACTOR)
                .fetch().stream()
                .map(this::mapperToDto)
                .toList();
    }

    private ActorDto mapperToDto(ActorRecord ar) {
        return mapperToDto(
                ar.getActorId(),
                ar.getFirstName(),
                ar.getLastName(),
                ar.getLastUpdate());
    }

    private ActorDto mapperToDto(
            Long actorId, String firstName, String lastName, LocalDateTime lastUpdate) {
        var actor = new ActorDto();
        actor.setActorId(actorId);
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(lastUpdate.toString());
        return actor;
    }

    @Override
    public ActorDto add(ActorDto newActor) {

        org.jooq.Record result = dsl.insertInto(ACTOR, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                        .values(newActor.getFirstName(), newActor.getLastName(), LocalDateTime.now())
                        .returningResult(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                        .fetchOne();

        return mapperToDto(
                result.getValue(ACTOR.ACTOR_ID),
                result.getValue(ACTOR.FIRST_NAME),
                result.getValue(ACTOR.LAST_NAME),
                result.getValue(ACTOR.LAST_UPDATE));
    }

    @Override
    public Optional<ActorDto> get(Long actorId) {

        Optional<ActorRecord> result = dsl.selectFrom(ACTOR)
                .where(ACTOR.ACTOR_ID.eq(actorId))
                .fetchOptional();

        if(result.isPresent()) {
            var actorResponse = mapperToDto(
                    result.get().getValue(ACTOR.ACTOR_ID),
                    result.get().getValue(ACTOR.FIRST_NAME),
                    result.get().getValue(ACTOR.LAST_NAME),
                    result.get().getValue(ACTOR.LAST_UPDATE));
            return Optional.of(actorResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long actorId) {
        dsl.delete(ACTOR)
           .where(ACTOR.ACTOR_ID.eq(actorId))
           .execute();
    }

    @Override
    public ActorDto update(Long actorId, ActorDto newActorData) {

        org.jooq.Record result = dsl.update(ACTOR)
           .set(ACTOR.FIRST_NAME, newActorData.getFirstName())
           .set(ACTOR.LAST_NAME, newActorData.getLastName())
           .set(ACTOR.LAST_UPDATE, LocalDateTime.now())
           .where(ACTOR.ACTOR_ID.eq(actorId))
           .returningResult(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
           .fetchOne();

        return mapperToDto(
                result.getValue(ACTOR.ACTOR_ID),
                result.getValue(ACTOR.FIRST_NAME),
                result.getValue(ACTOR.LAST_NAME),
                result.getValue(ACTOR.LAST_UPDATE));
    }
}
