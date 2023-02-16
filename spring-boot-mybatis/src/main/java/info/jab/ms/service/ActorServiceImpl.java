package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import info.jab.ms.model.Actor;
import info.jab.ms.repository.ActorMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorMapperRepository actorRepository;

    @Override
    public List<ActorDto> getAll() {
        return actorRepository.findAll().stream()
                .map(this::mapperToDto)
                //.peek(System.out::println)
                .toList();
    }

    private ActorDto mapperToDto(Actor a) {
        var actor = new ActorDto();
        actor.setActorId(a.getActor_id());
        actor.setFirstName(a.getFirst_name());
        actor.setLastName(a.getLast_name());
        actor.setLastUpdate(a.getLast_update().toString());
        return actor;
    }

    @Override
    public ActorDto add(ActorDto newActor) {
        Actor actor = new Actor();
        actor.setFirst_name(newActor.getFirstName());
        actor.setLast_name(newActor.getLastName());
        actor.setLast_update(LocalDateTime.now());

        actorRepository.save(actor);
        return mapperToDto(actor);
    }

    @Override
    public Optional<ActorDto> get(Long actorId) {
        Optional<Actor> actor = Optional.ofNullable(actorRepository.findById(actorId));

        if (actor.isPresent()) {
            var actorResponse = new ActorDto();
            actorResponse.setActorId(actor.get().getActor_id());
            actorResponse.setFirstName(actor.get().getFirst_name());
            actorResponse.setLastName(actor.get().getLast_name());
            actorResponse.setLastUpdate(actor.get().getLast_update().toString());
            return Optional.of(actorResponse);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long actorId) {
        System.out.println(actorId);
        actorRepository.deleteById(actorId);
    }

    @Override
    public ActorDto update(Long actorId, ActorDto newActorData) {
        Actor actorToUpgrade = new Actor();
        actorToUpgrade.setActor_id(actorId);
        actorToUpgrade.setFirst_name(newActorData.getFirstName());
        actorToUpgrade.setLast_name(newActorData.getLastName());
        actorToUpgrade.setLast_update(LocalDateTime.now());

        actorRepository.update(actorToUpgrade);
        return mapperToDto(actorToUpgrade);
    }
}
