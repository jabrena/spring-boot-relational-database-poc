package info.jab.ms.service;

import info.jab.ms.model.Actor;
import info.jab.ms.repository.ActorRepository;
import info.jab.ms.service.dto.ActorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorDTO> getAll() {
        return actorRepository.findAll().stream()
                .map(a -> new ActorDTO(a.getActor_id(), a.getFirst_name(), a.getLast_name(), a.getLast_update().toString()))
                .peek(System.out::println)
                .toList();
    }

    @Override
    public ActorDTO add(ActorDTO newActor) {
        Actor actor = new Actor();
        actor.setFirst_name(newActor.first_name());
        actor.setLast_name(newActor.last_name());
        actor.setLast_update(LocalDateTime.now());

        actor = actorRepository.save(actor);

        return new ActorDTO(
                actor.getActor_id(),
                actor.getFirst_name(),
                actor.getLast_name(),
                actor.getLast_update().toString());
    }

    @Override
    public Optional<ActorDTO> get(Long actorId) {
        Optional<Actor> actor = actorRepository.findById(actorId);

        if (actor.isPresent()) {
            return Optional.of(new ActorDTO(
                    actor.get().getActor_id(),
                    actor.get().getFirst_name(),
                    actor.get().getLast_name(),
                    actor.get().getLast_update().toString()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    @Override
    public ActorDTO update(Long actorId, ActorDTO newActorData) {
        Actor actorToUpgrade = new Actor();
        actorToUpgrade.setActor_id(actorId);
        actorToUpgrade.setFirst_name(newActorData.first_name());
        actorToUpgrade.setLast_name(newActorData.last_name());
        actorToUpgrade.setLast_update(LocalDateTime.now());

        Actor actorUpdated = actorRepository.save(actorToUpgrade);
        return new ActorDTO(
                actorUpdated.getActor_id(),
                actorUpdated.getFirst_name(),
                actorUpdated.getLast_name(),
                actorUpdated.getLast_update().toString());
    }
}
