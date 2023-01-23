package info.jab.ms.controller;

import info.jab.ms.service.ActorDTO;
import info.jab.ms.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1", produces = APPLICATION_JSON_VALUE)
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping(value = "/actors")
    public List<ActorDTO> getData() {
        return actorService.getActors();
    }
}
