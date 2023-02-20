package info.jab.ms.mybatis.generated.mapper;

import static info.jab.ms.mybatis.generated.mapper.CountryTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import info.jab.ms.mybatis.generated.model.CountryTable;
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
public interface CountryTableMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CountryTable>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(countryId, country, lastUpdate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CountryTableResult", value = {
        @Result(column="country_id", property="countryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CountryTable> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CountryTableResult")
    Optional<CountryTable> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer countryId_) {
        return delete(c -> 
            c.where(countryId, isEqualTo(countryId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(CountryTable row) {
        return MyBatis3Utils.insert(this::insert, row, countryTable, c ->
            c.map(countryId).toProperty("countryId")
            .map(country).toProperty("country")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<CountryTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, countryTable, c ->
            c.map(countryId).toProperty("countryId")
            .map(country).toProperty("country")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(CountryTable row) {
        return MyBatis3Utils.insert(this::insert, row, countryTable, c ->
            c.map(countryId).toPropertyWhenPresent("countryId", row::getCountryId)
            .map(country).toPropertyWhenPresent("country", row::getCountry)
            .map(lastUpdate).toPropertyWhenPresent("lastUpdate", row::getLastUpdate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CountryTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CountryTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<CountryTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<CountryTable> selectByPrimaryKey(Integer countryId_) {
        return selectOne(c ->
            c.where(countryId, isEqualTo(countryId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, countryTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(CountryTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(countryId).equalTo(row::getCountryId)
                .set(country).equalTo(row::getCountry)
                .set(lastUpdate).equalTo(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CountryTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(countryId).equalToWhenPresent(row::getCountryId)
                .set(country).equalToWhenPresent(row::getCountry)
                .set(lastUpdate).equalToWhenPresent(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(CountryTable row) {
        return update(c ->
            c.set(country).equalTo(row::getCountry)
            .set(lastUpdate).equalTo(row::getLastUpdate)
            .where(countryId, isEqualTo(row::getCountryId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(CountryTable row) {
        return update(c ->
            c.set(country).equalToWhenPresent(row::getCountry)
            .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
            .where(countryId, isEqualTo(row::getCountryId))
        );
    }
}