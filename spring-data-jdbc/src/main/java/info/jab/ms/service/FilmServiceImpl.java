package info.jab.ms.service;

import com.jab.ms.openapi.gen.model.FilmDto;
import info.jab.ms.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDto> getFilms() {
        return filmRepository.myQuery().stream()
                .map(f -> {
                    FilmDto film = new FilmDto();
                    film.setFilmId(f.FILM_ID());
                    film.setTitle(f.TITLE());
                    return film;
                })
                .toList();
    }
}
