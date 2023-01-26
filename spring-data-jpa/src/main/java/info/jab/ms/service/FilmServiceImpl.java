package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<FilmDto> getFilms() {
        return filmRepository.myQuery().stream()
                .map(f -> {
                    FilmDto film = new FilmDto();
                    film.setFilmId(f.getFilm_id());
                    film.setTitle(f.getTitle());
                    return film;
                }).toList();
    }
}
