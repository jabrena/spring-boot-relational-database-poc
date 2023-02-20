package info.jab.ms.mybatis.generated.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CountryTableDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final CountryTable countryTable = new CountryTable();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> countryId = countryTable.countryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> country = countryTable.country;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lastUpdate = countryTable.lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class CountryTable extends AliasableSqlTable<CountryTable> {
        public final SqlColumn<Integer> countryId = column("country_id", JDBCType.INTEGER);

        public final SqlColumn<String> country = column("country", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> lastUpdate = column("last_update", JDBCType.TIMESTAMP);

        public CountryTable() {
            super("public.country", CountryTable::new);
        }
    }
}