package info.jab.ms.controller;

import com.jab.ms.openapi.film.gen.api.ApiApi;
import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class FilmController implements ApiApi {
    @Autowired
    private FilmService filmService;

    @Override
    public ResponseEntity<List<FilmDto>> getFilms() {
        return ResponseEntity.ok().body(filmService.getFilms());
    }
}
