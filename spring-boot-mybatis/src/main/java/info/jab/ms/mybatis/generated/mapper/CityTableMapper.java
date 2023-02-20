package info.jab.ms.mybatis.generated.mapper;

import static info.jab.ms.mybatis.generated.mapper.CityTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import info.jab.ms.mybatis.generated.model.CityTable;
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
public interface CityTableMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CityTable>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(cityId, city, countryId, lastUpdate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CityTableResult", value = {
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.SMALLINT),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CityTable> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CityTableResult")
    Optional<CityTable> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer cityId_) {
        return delete(c -> 
            c.where(cityId, isEqualTo(cityId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(CityTable row) {
        return MyBatis3Utils.insert(this::insert, row, cityTable, c ->
            c.map(cityId).toProperty("cityId")
            .map(city).toProperty("city")
            .map(countryId).toProperty("countryId")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<CityTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cityTable, c ->
            c.map(cityId).toProperty("cityId")
            .map(city).toProperty("city")
            .map(countryId).toProperty("countryId")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CityTable row) {
        return MyBatis3Utils.insert(this::insert, row, cityTable, c ->
            c.map(cityId).toPropertyWhenPresent("cityId", row::getCityId)
            .map(city).toPropertyWhenPresent("city", row::getCity)
            .map(countryId).toPropertyWhenPresent("countryId", row::getCountryId)
            .map(lastUpdate).toPropertyWhenPresent("lastUpdate", row::getLastUpdate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CityTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CityTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CityTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CityTable> selectByPrimaryKey(Integer cityId_) {
        return selectOne(c ->
            c.where(cityId, isEqualTo(cityId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cityTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CityTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(cityId).equalTo(row::getCityId)
                .set(city).equalTo(row::getCity)
                .set(countryId).equalTo(row::getCountryId)
                .set(lastUpdate).equalTo(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CityTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(cityId).equalToWhenPresent(row::getCityId)
                .set(city).equalToWhenPresent(row::getCity)
                .set(countryId).equalToWhenPresent(row::getCountryId)
                .set(lastUpdate).equalToWhenPresent(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CityTable row) {
        return update(c ->
            c.set(city).equalTo(row::getCity)
            .set(countryId).equalTo(row::getCountryId)
            .set(lastUpdate).equalTo(row::getLastUpdate)
            .where(cityId, isEqualTo(row::getCityId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CityTable row) {
        return update(c ->
            c.set(city).equalToWhenPresent(row::getCity)
            .set(countryId).equalToWhenPresent(row::getCountryId)
            .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
            .where(cityId, isEqualTo(row::getCityId))
        );
    }
}