package info.jab.ms.mybatis.generated.mapper;

import static info.jab.ms.mybatis.generated.mapper.ActorTableDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import info.jab.ms.mybatis.generated.model.ActorTable;
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
public interface ActorTableMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<ActorTable>, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(actorId, firstName, lastName, lastUpdate);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ActorTableResult", value = {
        @Result(column="actor_id", property="actorId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ActorTable> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ActorTableResult")
    Optional<ActorTable> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer actorId_) {
        return delete(c -> 
            c.where(actorId, isEqualTo(actorId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ActorTable row) {
        return MyBatis3Utils.insert(this::insert, row, actorTable, c ->
            c.map(actorId).toProperty("actorId")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ActorTable> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, actorTable, c ->
            c.map(actorId).toProperty("actorId")
            .map(firstName).toProperty("firstName")
            .map(lastName).toProperty("lastName")
            .map(lastUpdate).toProperty("lastUpdate")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ActorTable row) {
        return MyBatis3Utils.insert(this::insert, row, actorTable, c ->
            c.map(actorId).toPropertyWhenPresent("actorId", row::getActorId)
            .map(firstName).toPropertyWhenPresent("firstName", row::getFirstName)
            .map(lastName).toPropertyWhenPresent("lastName", row::getLastName)
            .map(lastUpdate).toPropertyWhenPresent("lastUpdate", row::getLastUpdate)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ActorTable> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ActorTable> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ActorTable> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ActorTable> selectByPrimaryKey(Integer actorId_) {
        return selectOne(c ->
            c.where(actorId, isEqualTo(actorId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, actorTable, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ActorTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(actorId).equalTo(row::getActorId)
                .set(firstName).equalTo(row::getFirstName)
                .set(lastName).equalTo(row::getLastName)
                .set(lastUpdate).equalTo(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ActorTable row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(actorId).equalToWhenPresent(row::getActorId)
                .set(firstName).equalToWhenPresent(row::getFirstName)
                .set(lastName).equalToWhenPresent(row::getLastName)
                .set(lastUpdate).equalToWhenPresent(row::getLastUpdate);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ActorTable row) {
        return update(c ->
            c.set(firstName).equalTo(row::getFirstName)
            .set(lastName).equalTo(row::getLastName)
            .set(lastUpdate).equalTo(row::getLastUpdate)
            .where(actorId, isEqualTo(row::getActorId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ActorTable row) {
        return update(c ->
            c.set(firstName).equalToWhenPresent(row::getFirstName)
            .set(lastName).equalToWhenPresent(row::getLastName)
            .set(lastUpdate).equalToWhenPresent(row::getLastUpdate)
            .where(actorId, isEqualTo(row::getActorId))
        );
    }
}