package info.jab.ms.repository;

import info.jab.ms.model.Country;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    String sql = "SELECT COUNT(*) FROM country";

    @Query(sql)
    Integer getCountryCountry();
}
