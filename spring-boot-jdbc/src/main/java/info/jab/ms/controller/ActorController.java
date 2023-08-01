package info.jab.ms.controller;


import com.jab.ms.openapi.actor.gen.api.ApiApi;
import com.jab.ms.openapi.actor.gen.model.ActorDto;
import info.jab.ms.service.ActorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController implements ApiApi {

    @Qualifier("jdbcActorService")
    @Autowired
    private ActorService actorService;

    @Override
    public ResponseEntity<List<ActorDto>> getActors() {
        return ResponseEntity.ok().body(actorService.getAll());
    }

    @Override
    public ResponseEntity<ActorDto> addActor(@RequestBody ActorDto newActor) {
        return ResponseEntity.ok().body(actorService.add(newActor));
    }


    @Override
    public ResponseEntity<ActorDto> getActor(@PathVariable("id") Long actorId) {
        Optional<ActorDto> actor = actorService.get(actorId);
        return actor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteActor(@PathVariable("id") Long actorId) {
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            actorService.delete(actorId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ActorDto> updateActor(@PathVariable("id") Long actorId, @RequestBody ActorDto actorData) {
        Optional<ActorDto> actor = actorService.get(actorId);
        return actor.map(a -> {
            ActorDto updatedActor = actorService.update(actorId, actorData);
            return ResponseEntity.ok().body(updatedActor);
        }).orElse(ResponseEntity.notFound().build());
    }

}
