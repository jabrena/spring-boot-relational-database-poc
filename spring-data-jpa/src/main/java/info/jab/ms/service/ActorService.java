package info.jab.ms.service;

import info.jab.ms.model.Actor;
import info.jab.ms.service.dto.ActorDTO;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    List<ActorDTO> getAll();
    ActorDTO add(ActorDTO newActor);
    Optional<ActorDTO> get(Long actorId);
    void delete(Long actorId);
    ActorDTO update(Long actorId, ActorDTO newActorData);
}
