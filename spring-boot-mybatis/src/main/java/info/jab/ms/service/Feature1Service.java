package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;

import java.util.List;

public interface Feature1Service {

    List<FilmDto> getFilms();
}
