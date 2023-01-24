package info.jab.ms.service;

import com.jab.ms.openapi.gen.model.FilmDto;

import java.util.List;

public interface FilmService {

    List<FilmDto> getFilms();
}
