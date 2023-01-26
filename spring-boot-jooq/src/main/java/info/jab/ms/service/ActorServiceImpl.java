package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import info.jab.ms.jooq.tables.pojos.JooqActor;
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
        return dsl.select(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                .from(ACTOR)
                .fetchInto(ActorDto.class).stream()
                .map(a -> {
                    var actor = new ActorDto();
                    actor.setActorId(a.getActorId());
                    actor.setFirstName(a.getFirstName());
                    actor.setLastName(a.getLastUpdate());
                    actor.setLastUpdate(a.getLastUpdate().toString());
                    return actor;
                })
                //.peek(System.out::println)
                .toList();
    }

    @Override
    public ActorDto add(ActorDto newActor) {

        org.jooq.Record result = dsl.insertInto(ACTOR, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                        .values(newActor.getFirstName(), newActor.getLastName(), LocalDateTime.now())
                        .returningResult(ACTOR.ACTOR_ID)
                        .fetchOne();

        var actorResponse = new ActorDto();
        actorResponse.setActorId(result.getValue(ACTOR.ACTOR_ID));
        actorResponse.setFirstName(newActor.getFirstName());
        actorResponse.setLastName(newActor.getLastName());
        actorResponse.setLastUpdate(newActor.getLastUpdate().toString());
        return actorResponse;
    }

    @Override
    public Optional<ActorDto> get(Long actorId) {
        //TODO Refactor
        var result = dsl.select(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME, ACTOR.LAST_UPDATE)
                .from(ACTOR)
                .where(ACTOR.ACTOR_ID.eq(actorId))
                .fetchInto(JooqActor.class);

        if( (result.size() == 1) && (result.get(0).getActorId() != null)) {
            var actorResponse = new ActorDto();
            actorResponse.setActorId(result.get(0).getActorId());
            actorResponse.setFirstName(result.get(0).getFirstName());
            actorResponse.setLastName(result.get(0).getLastName());
            actorResponse.setLastUpdate(result.get(0).getLastUpdate().toString());
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

        ActorRecord actorRecord = new ActorRecord();
        actorRecord.setFirstName(newActorData.getFirstName());
        actorRecord.setLastName(newActorData.getLastName());
        actorRecord.setLastUpdate(LocalDateTime.now());
        dsl.executeUpdate(actorRecord, ACTOR.ACTOR_ID.eq(actorId));

        var actorResponse = new ActorDto();
        actorResponse.setActorId(actorId);
        actorResponse.setFirstName(actorRecord.getFirstName());
        actorResponse.setLastName(actorRecord.getLastName());
        actorResponse.setLastUpdate(actorRecord.getLastUpdate().toString());
        return actorResponse;
    }
}
