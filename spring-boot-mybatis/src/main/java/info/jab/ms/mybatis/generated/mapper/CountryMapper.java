package info.jab.ms.mybatis.generated.mapper;

import static info.jab.ms.mybatis.generated.mapper.CountryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import info.jab.ms.mybatis.generated.model.Country;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
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
public interface CountryMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Country>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(countryId, country.country, lastUpdate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CountryResult", value = {
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Country> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CountryResult")
    Optional<Country> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer countryId_) {
        return delete(c -> 
            c.where(countryId, isEqualTo(countryId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Country row) {
        return MyBatis3Utils.insert(this::insert, row, country, c ->
            c.map(countryId).toProperty("countryId")
            .map(country.country).toProperty("country")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Country> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, country, c ->
            c.map(countryId).toProperty("countryId")
            .map(country.country).toProperty("country")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Country row) {
        return MyBatis3Utils.insert(this::insert, row, country, c ->
            c.map(countryId).toPropertyWhenPresent("countryId", row::getCountryId)
            .map(country.country).toPropertyWhenPresent("country", row::getCountry)
            .map(lastUpdate).toPropertyWhenPresent("lastUpdate", row::getLastUpdate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Country> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Country> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Country> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Country> selectByPrimaryKey(Integer countryId_) {
        return selectOne(c ->
            c.where(countryId, isEqualTo(countryId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, country, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Country row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(countryId).equalTo(row::getCountryId)
                .set(country.country).equalTo(row::getCountry)
                .set(lastUpdate).equalTo(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Country row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(countryId).equalToWhenPresent(row::getCountryId)
                .set(country.country).equalToWhenPresent(row::getCountry)
                .set(lastUpdate).equalToWhenPresent(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Country row) {
        return update(c ->
            c.set(country.country).equalTo(row::getCountry)
            .set(lastUpdate).equalTo(row::getLastUpdate)
            .where(countryId, isEqualTo(row::getCountryId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Country row) {
        return update(c ->
            c.set(country.country).equalToWhenPresent(row::getCountry)
            .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
            .where(countryId, isEqualTo(row::getCountryId))
        );
    }
}