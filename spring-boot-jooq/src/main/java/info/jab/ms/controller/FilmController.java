package info.jab.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.jab.ms.model.Film;
import info.jab.ms.service.FilmService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1", produces = APPLICATION_JSON_VALUE)
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping(value = "/films")
    public List<Film> getData() {
        return filmService.getFilms();
    }
}
