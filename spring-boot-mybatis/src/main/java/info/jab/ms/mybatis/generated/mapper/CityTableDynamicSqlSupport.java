package info.jab.ms.mybatis.generated.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CityTableDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final CityTable cityTable = new CityTable();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> cityId = cityTable.cityId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> city = cityTable.city;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Short> countryId = cityTable.countryId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> lastUpdate = cityTable.lastUpdate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class CityTable extends AliasableSqlTable<CityTable> {
        public final SqlColumn<Integer> cityId = column("city_id", JDBCType.INTEGER);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<Short> countryId = column("country_id", JDBCType.SMALLINT);

        public final SqlColumn<LocalDateTime> lastUpdate = column("last_update", JDBCType.TIMESTAMP);

        public CityTable() {
            super("public.city", CityTable::new);
        }
    }
}