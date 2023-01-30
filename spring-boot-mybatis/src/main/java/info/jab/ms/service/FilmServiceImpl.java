package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.repository.FilmMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapperRepository filmMapperRepository;

    @Override
    public List<FilmDto> getFilms() {
        return filmMapperRepository.select().stream().map(f -> {
            FilmDto filmDto = new FilmDto();
            filmDto.setFilmId(f.FILM_ID());
            filmDto.setTitle(f.TITLE());
            return filmDto;
        })
        .toList();
    }
}
