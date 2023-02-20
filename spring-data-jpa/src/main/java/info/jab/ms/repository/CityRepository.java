package info.jab.ms.repository;

import info.jab.ms.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    String sql = "SELECT COUNT(*) FROM city";

    @Query(value = sql, nativeQuery = true)
    Integer getCityCountry();
}
