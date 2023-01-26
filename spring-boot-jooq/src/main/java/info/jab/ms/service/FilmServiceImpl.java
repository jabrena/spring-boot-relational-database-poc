package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import info.jab.ms.model.Film;

import java.util.List;

import static info.jab.ms.jooq.tables.Film.FILM;

@Service
public class FilmServiceImpl implements FilmService {

    private final DSLContext dsl;

    public FilmServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<FilmDto> getFilms() {
        return dsl.select(FILM.FILM_ID, FILM.TITLE)
                .from(FILM)
                .where(FILM.TITLE.like("A%"))
                .fetchInto(Film.class).stream()
                .map(f -> {
                    FilmDto film = new FilmDto();
                    film.setFilmId(Long.parseLong(f.FILM_ID().toString()));
                    film.setTitle(f.TITLE());
                    return film;
                })
                .toList();
    }
}
