package info.jab.ms.service;

import java.util.List;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.model.Film;

public interface FilmService {

    List<FilmDto> getFilms();
}
