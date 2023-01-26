package info.jab.ms.service;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static info.jab.ms.jooq.Tables.CITY;
import static info.jab.ms.jooq.Tables.COUNTRY;
import static info.jab.ms.jooq.tables.Actor.ACTOR;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private DSLContext dsl;

    @Override
    public Integer getCountryCounter() {
        return dsl.fetchCount(dsl.selectFrom(COUNTRY));
    }

    @Override
    public Integer getCityCounter() {
        return dsl.fetchCount(dsl.selectFrom(CITY));
    }

    @Transactional
    @Override
    public void addCountryAndCity(Boolean flag) {

        var result = dsl.insertInto(COUNTRY, COUNTRY.COUNTRY_, COUNTRY.LAST_UPDATE)
                .values("Tabarnia", LocalDateTime.now())
                .returningResult(COUNTRY.COUNTRY_ID)
                .execute();

        try {

            var countryId = (flag == Boolean.TRUE) ? result : 999L;
            var result2 = dsl.insertInto(CITY, CITY.CITY_, CITY.COUNTRY_ID, CITY.LAST_UPDATE)
                    .values("TabarniaCity", countryId, LocalDateTime.now())
                    .returningResult(CITY.CITY_ID)
                    .execute();

            System.out.println(result2);
        } catch (DataAccessException | DataIntegrityViolationException ex) {
            System.out.println("Katakroker");
        }
    }
}
