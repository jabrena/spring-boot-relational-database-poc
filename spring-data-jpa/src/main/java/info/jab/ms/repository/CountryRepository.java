package info.jab.ms.repository;

import info.jab.ms.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    String sql = "SELECT COUNT(*) FROM country";

    @Query(value = sql, nativeQuery = true)
    Integer getCountryCountry();
}
