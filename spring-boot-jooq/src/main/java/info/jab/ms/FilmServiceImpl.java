package info.jab.ms;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static info.jab.ms.jooq.tables.Film.FILM;

@Service
class FilmServiceImpl implements FilmService {

    private final DSLContext dsl;

    public FilmServiceImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Film> getFilms() {
        return dsl.select(FILM.FILM_ID, FILM.TITLE)
                .from(FILM)
                .where(FILM.TITLE.like("A%"))
                .fetchInto(Film.class);
    }
}