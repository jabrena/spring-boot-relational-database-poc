package info.jab.ms.controller;

import com.jab.ms.openapi.gen.api.ApiApi;
import com.jab.ms.openapi.gen.model.ActorDto;
import info.jab.ms.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ActorController implements ApiApi{
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
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            return ResponseEntity.ok().body(actorService.get(actorId).get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            var actorUpdated = actorService.update(actorId, actorData);
            return ResponseEntity.ok().body(actorUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
