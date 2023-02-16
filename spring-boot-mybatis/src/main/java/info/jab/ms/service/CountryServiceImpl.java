package info.jab.ms.service;

import info.jab.ms.model.City;
import info.jab.ms.model.Country;
import info.jab.ms.repository.CityMapperRepository;
import info.jab.ms.repository.CountryMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CountryMapperRepository countryMapperRepository;

    @Autowired
    private CityMapperRepository cityMapperRepository;

    @Override
    public Integer getCountryCounter() {
        return countryMapperRepository.select();
    }

    @Override
    public Integer getCityCounter() {
        return cityMapperRepository.select();
    }

    @Transactional
    @Override
    public void addCountryAndCity(Boolean flag) {

        Country countryToAdd = new Country();
        countryToAdd.setCountry("Tabarnia");
        countryToAdd.setLast_update(LocalDateTime.now());
        countryMapperRepository.save(countryToAdd);

        System.out.println(countryToAdd);

        var id = countryToAdd.getCountry_id();

        try {
            var countryId = (flag == Boolean.FALSE) ? id : 999L;

            City cityToAdd = new City();
            cityToAdd.setCity("TabarniaCity");
            cityToAdd.setCountry_id(countryId);
            cityToAdd.setLast_update(LocalDateTime.now());

            cityMapperRepository.save(cityToAdd);

            System.out.println(cityToAdd);

        } catch (DataAccessException ex) {
            System.out.println("Katakroker");
            throw new RuntimeException("Katakroker");
        }
    }
}
