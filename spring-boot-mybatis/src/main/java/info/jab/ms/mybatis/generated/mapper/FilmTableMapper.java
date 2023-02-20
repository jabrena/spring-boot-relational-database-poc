package info.jab.ms.mybatis.generated.mapper;

import static info.jab.ms.mybatis.generated.mapper.FilmTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import info.jab.ms.mybatis.generated.model.FilmTable;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface FilmTableMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<FilmTable>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating, lastUpdate, specialFeatures, fulltext);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FilmTableResult", value = {
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_year", property="releaseYear", jdbcType=JdbcType.DISTINCT),
        @Result(column="language_id", property="languageId", jdbcType=JdbcType.SMALLINT),
        @Result(column="original_language_id", property="originalLanguageId", jdbcType=JdbcType.SMALLINT),
        @Result(column="rental_duration", property="rentalDuration", jdbcType=JdbcType.SMALLINT),
        @Result(column="rental_rate", property="rentalRate", jdbcType=JdbcType.NUMERIC),
        @Result(column="length", property="length", jdbcType=JdbcType.SMALLINT),
        @Result(column="replacement_cost", property="replacementCost", jdbcType=JdbcType.NUMERIC),
        @Result(column="rating", property="rating", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="special_features", property="specialFeatures", jdbcType=JdbcType.ARRAY),
        @Result(column="fulltext", property="fulltext", jdbcType=JdbcType.OTHER)
    })
    List<FilmTable> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FilmTableResult")
    Optional<FilmTable> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer filmId_) {
        return delete(c -> 
            c.where(filmId, isEqualTo(filmId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(FilmTable row) {
        return MyBatis3Utils.insert(this::insert, row, filmTable, c ->
            c.map(filmId).toProperty("filmId")
            .map(title).toProperty("title")
            .map(description).toProperty("description")
            .map(releaseYear).toProperty("releaseYear")
            .map(languageId).toProperty("languageId")
            .map(originalLanguageId).toProperty("originalLanguageId")
            .map(rentalDuration).toProperty("rentalDuration")
            .map(rentalRate).toProperty("rentalRate")
            .map(length).toProperty("length")
            .map(replacementCost).toProperty("replacementCost")
            .map(rating).toProperty("rating")
            .map(lastUpdate).toProperty("lastUpdate")
            .map(specialFeatures).toProperty("specialFeatures")
            .map(fulltext).toProperty("fulltext")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<FilmTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, filmTable, c ->
            c.map(filmId).toProperty("filmId")
            .map(title).toProperty("title")
            .map(description).toProperty("description")
            .map(releaseYear).toProperty("releaseYear")
            .map(languageId).toProperty("languageId")
            .map(originalLanguageId).toProperty("originalLanguageId")
            .map(rentalDuration).toProperty("rentalDuration")
            .map(rentalRate).toProperty("rentalRate")
            .map(length).toProperty("length")
            .map(replacementCost).toProperty("replacementCost")
            .map(rating).toProperty("rating")
            .map(lastUpdate).toProperty("lastUpdate")
            .map(specialFeatures).toProperty("specialFeatures")
            .map(fulltext).toProperty("fulltext")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(FilmTable row) {
        return MyBatis3Utils.insert(this::insert, row, filmTable, c ->
            c.map(filmId).toPropertyWhenPresent("filmId", row::getFilmId)
            .map(title).toPropertyWhenPresent("title", row::getTitle)
            .map(description).toPropertyWhenPresent("description", row::getDescription)
            .map(releaseYear).toPropertyWhenPresent("releaseYear", row::getReleaseYear)
            .map(languageId).toPropertyWhenPresent("languageId", row::getLanguageId)
            .map(originalLanguageId).toPropertyWhenPresent("originalLanguageId", row::getOriginalLanguageId)
            .map(rentalDuration).toPropertyWhenPresent("rentalDuration", row::getRentalDuration)
            .map(rentalRate).toPropertyWhenPresent("rentalRate", row::getRentalRate)
            .map(length).toPropertyWhenPresent("length", row::getLength)
            .map(replacementCost).toPropertyWhenPresent("replacementCost", row::getReplacementCost)
            .map(rating).toPropertyWhenPresent("rating", row::getRating)
            .map(lastUpdate).toPropertyWhenPresent("lastUpdate", row::getLastUpdate)
            .map(specialFeatures).toPropertyWhenPresent("specialFeatures", row::getSpecialFeatures)
            .map(fulltext).toPropertyWhenPresent("fulltext", row::getFulltext)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FilmTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FilmTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FilmTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FilmTable> selectByPrimaryKey(Integer filmId_) {
        return selectOne(c ->
            c.where(filmId, isEqualTo(filmId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, filmTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(FilmTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(filmId).equalTo(row::getFilmId)
                .set(title).equalTo(row::getTitle)
                .set(description).equalTo(row::getDescription)
                .set(releaseYear).equalTo(row::getReleaseYear)
                .set(languageId).equalTo(row::getLanguageId)
                .set(originalLanguageId).equalTo(row::getOriginalLanguageId)
                .set(rentalDuration).equalTo(row::getRentalDuration)
                .set(rentalRate).equalTo(row::getRentalRate)
                .set(length).equalTo(row::getLength)
                .set(replacementCost).equalTo(row::getReplacementCost)
                .set(rating).equalTo(row::getRating)
                .set(lastUpdate).equalTo(row::getLastUpdate)
                .set(specialFeatures).equalTo(row::getSpecialFeatures)
                .set(fulltext).equalTo(row::getFulltext);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FilmTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(filmId).equalToWhenPresent(row::getFilmId)
                .set(title).equalToWhenPresent(row::getTitle)
                .set(description).equalToWhenPresent(row::getDescription)
                .set(releaseYear).equalToWhenPresent(row::getReleaseYear)
                .set(languageId).equalToWhenPresent(row::getLanguageId)
                .set(originalLanguageId).equalToWhenPresent(row::getOriginalLanguageId)
                .set(rentalDuration).equalToWhenPresent(row::getRentalDuration)
                .set(rentalRate).equalToWhenPresent(row::getRentalRate)
                .set(length).equalToWhenPresent(row::getLength)
                .set(replacementCost).equalToWhenPresent(row::getReplacementCost)
                .set(rating).equalToWhenPresent(row::getRating)
                .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
                .set(specialFeatures).equalToWhenPresent(row::getSpecialFeatures)
                .set(fulltext).equalToWhenPresent(row::getFulltext);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(FilmTable row) {
        return update(c ->
            c.set(title).equalTo(row::getTitle)
            .set(description).equalTo(row::getDescription)
            .set(releaseYear).equalTo(row::getReleaseYear)
            .set(languageId).equalTo(row::getLanguageId)
            .set(originalLanguageId).equalTo(row::getOriginalLanguageId)
            .set(rentalDuration).equalTo(row::getRentalDuration)
            .set(rentalRate).equalTo(row::getRentalRate)
            .set(length).equalTo(row::getLength)
            .set(replacementCost).equalTo(row::getReplacementCost)
            .set(rating).equalTo(row::getRating)
            .set(lastUpdate).equalTo(row::getLastUpdate)
            .set(specialFeatures).equalTo(row::getSpecialFeatures)
            .set(fulltext).equalTo(row::getFulltext)
            .where(filmId, isEqualTo(row::getFilmId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(FilmTable row) {
        return update(c ->
            c.set(title).equalToWhenPresent(row::getTitle)
            .set(description).equalToWhenPresent(row::getDescription)
            .set(releaseYear).equalToWhenPresent(row::getReleaseYear)
            .set(languageId).equalToWhenPresent(row::getLanguageId)
            .set(originalLanguageId).equalToWhenPresent(row::getOriginalLanguageId)
            .set(rentalDuration).equalToWhenPresent(row::getRentalDuration)
            .set(rentalRate).equalToWhenPresent(row::getRentalRate)
            .set(length).equalToWhenPresent(row::getLength)
            .set(replacementCost).equalToWhenPresent(row::getReplacementCost)
            .set(rating).equalToWhenPresent(row::getRating)
            .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
            .set(specialFeatures).equalToWhenPresent(row::getSpecialFeatures)
            .set(fulltext).equalToWhenPresent(row::getFulltext)
            .where(filmId, isEqualTo(row::getFilmId))
        );
    }
}