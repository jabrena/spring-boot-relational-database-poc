package info.jab.ms.service;

import info.jab.ms.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorDTO> getActors() {
        return actorRepository.findAll().stream()
                .map(a -> new ActorDTO(a.getActor_id(), a.getFirst_name(), a.getLast_name(), a.getLast_update()))
                .toList();
    }
}
