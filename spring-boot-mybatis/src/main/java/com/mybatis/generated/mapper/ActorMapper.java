package com.mybatis.generated.mapper;

import com.example.generated.model.Actor;
import com.example.generated.model.ActorExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    long countByExample(ActorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int deleteByExample(ActorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer actorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int insert(Actor row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int insertSelective(Actor row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    List<Actor> selectByExample(ActorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    Actor selectByPrimaryKey(Integer actorId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") Actor row, @Param("example") ActorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") Actor row, @Param("example") ActorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Actor row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.actor
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Actor row);
}