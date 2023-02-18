package info.jab.ms.mybatis.generated.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CountryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Country country = new Country();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> countryId = country.countryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lastUpdate = country.lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Country extends AliasableSqlTable<Country> {
        public final SqlColumn<Integer> countryId = column("country_id", JDBCType.INTEGER);

        public final SqlColumn<String> country = column("country", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> lastUpdate = column("last_update", JDBCType.TIMESTAMP);

        public Country() {
            super("public.country", Country::new);
        }
    }
}