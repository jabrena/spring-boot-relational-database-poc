package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<ActorDto> getAll();
    ActorDto add(ActorDto newActor);
    Optional<ActorDto> get(Long actorId);
    void delete(Long actorId);
    ActorDto update(Long actorId, ActorDto newActorData);
}
