package info.jab.ms.mybatis.generated.mapper;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class FilmTableDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final FilmTable filmTable = new FilmTable();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> filmId = filmTable.filmId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> title = filmTable.title;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = filmTable.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Object> releaseYear = filmTable.releaseYear;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> languageId = filmTable.languageId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> originalLanguageId = filmTable.originalLanguageId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> rentalDuration = filmTable.rentalDuration;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> rentalRate = filmTable.rentalRate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> length = filmTable.length;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<BigDecimal> replacementCost = filmTable.replacementCost;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> rating = filmTable.rating;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lastUpdate = filmTable.lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Object> specialFeatures = filmTable.specialFeatures;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Object> fulltext = filmTable.fulltext;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class FilmTable extends AliasableSqlTable<FilmTable> {
        public final SqlColumn<Integer> filmId = column("film_id", JDBCType.INTEGER);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Object> releaseYear = column("release_year", JDBCType.DISTINCT);

        public final SqlColumn<Short> languageId = column("language_id", JDBCType.SMALLINT);

        public final SqlColumn<Short> originalLanguageId = column("original_language_id", JDBCType.SMALLINT);

        public final SqlColumn<Short> rentalDuration = column("rental_duration", JDBCType.SMALLINT);

        public final SqlColumn<BigDecimal> rentalRate = column("rental_rate", JDBCType.NUMERIC);

        public final SqlColumn<Short> length = column("length", JDBCType.SMALLINT);

        public final SqlColumn<BigDecimal> replacementCost = column("replacement_cost", JDBCType.NUMERIC);

        public final SqlColumn<String> rating = column("rating", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> lastUpdate = column("last_update", JDBCType.TIMESTAMP);

        public final SqlColumn<Object> specialFeatures = column("special_features", JDBCType.ARRAY);

        public final SqlColumn<Object> fulltext = column("fulltext", JDBCType.OTHER);

        public FilmTable() {
            super("public.film", FilmTable::new);
        }
    }
}