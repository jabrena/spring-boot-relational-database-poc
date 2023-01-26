package info.jab.ms.service;

import com.jab.ms.openapi.actor.gen.model.ActorDto;
import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.jooq.tables.records.ActorRecord;
import info.jab.ms.jooq.tables.records.FilmRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.jab.ms.model.Film;

import java.util.List;

import static info.jab.ms.jooq.tables.Film.FILM;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private DSLContext dsl;

    @Override
    public List<FilmDto> getFilms() {
        return dsl.selectFrom(FILM)
                .where(FILM.TITLE.like("A%"))
                .fetch().stream()
                .map(this::jooqToDtoMapper)
                .toList();
    }

    private FilmDto jooqToDtoMapper(FilmRecord ar) {
        var film = new FilmDto();
        film.setFilmId(ar.getFilmId());
        film.setTitle(ar.getTitle());
        return film;
    }
}
