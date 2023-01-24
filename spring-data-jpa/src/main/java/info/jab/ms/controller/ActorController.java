package info.jab.ms.controller;

import info.jab.ms.service.dto.ActorDTO;
import info.jab.ms.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1", produces = APPLICATION_JSON_VALUE)
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping(value = "/actors")
    public List<ActorDTO> getActors() {
        return actorService.getAll();
    }

    @PostMapping(value = "/actors")
    public ActorDTO addActor(@RequestBody ActorDTO newActor) {
        return actorService.add(newActor);
    }

    @GetMapping(value = "/actors/{id}")
    public ResponseEntity<ActorDTO> getActor(@PathVariable("id") Long actorId) {
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            return ResponseEntity.ok().body(actorService.get(actorId).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/actors/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable("id") Long actorId) {
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            actorService.delete(actorId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/actors/{id}")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable("id") Long actorId, @RequestBody ActorDTO actorData) {
        var result = actorService.get(actorId);
        if(result.isPresent()) {
            var actorUpdated = actorService.update(actorId, actorData);
            return ResponseEntity.ok().body(actorUpdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
