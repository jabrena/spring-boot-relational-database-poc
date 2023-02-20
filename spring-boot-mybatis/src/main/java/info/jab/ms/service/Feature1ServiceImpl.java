package info.jab.ms.service;

import com.jab.ms.openapi.film.gen.model.FilmDto;
import info.jab.ms.mybatis.generated.mapper.FilmTableMapper;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static info.jab.ms.mybatis.generated.mapper.FilmTableDynamicSqlSupport.filmId;
import static info.jab.ms.mybatis.generated.mapper.FilmTableDynamicSqlSupport.title;
import static org.mybatis.dynamic.sql.SqlBuilder.isLike;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;


import java.util.List;

@Service
public class Feature1ServiceImpl implements Feature1Service {

    @Autowired
    private FilmTableMapper filmTableMapper;

    @Override
    public List<FilmDto> getFilms() {

        SelectStatementProvider selectStatement = select(filmId, title)
                .from(SqlTable.of("film"))
                .where(title, isLike("A%"))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return filmTableMapper.selectMany(selectStatement).stream()
                .map(f -> {
                    FilmDto filmDto = new FilmDto();
                    filmDto.setFilmId(Long.valueOf(f.getFilmId()));
                    filmDto.setTitle(f.getTitle());
                    return filmDto;
                })
                .toList();
    }
}
