package info.jab.ms.repository;

import info.jab.ms.model.City;
import info.jab.ms.model.Country;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapperRepository {

   String sql =
          """
          SELECT COUNT(*)
          FROM city
          """;
    @Select(sql)
    Integer select();

    String sqlInsert =
            """
            INSERT INTO city (city, country_id, last_update)
            VALUES (#{city}, #{country_id},  #{last_update})
            """;

    @Insert(sqlInsert)
    @Options(useGeneratedKeys = true, keyProperty = "city_id")
    void save(City city);
}


