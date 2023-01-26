package info.jab.ms.service;

import java.util.List;
import com.jab.ms.openapi.film.gen.model.FilmDto;

public interface FilmService {

    List<FilmDto> getFilms();
}
