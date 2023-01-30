package info.jab.ms.service;

import info.jab.ms.model.City;
import info.jab.ms.model.Country;
import info.jab.ms.repository.CityRepository;
import info.jab.ms.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Integer getCountryCounter() {
        return countryRepository.getCountryCountry();
    }

    @Override
    public Integer getCityCounter() {
        return cityRepository.getCityCountry();
    }

    @Transactional
    @Override
    public void addCountryAndCity(Boolean flag) {

        Country newCountry = new Country(null,"Tabarnia", LocalDateTime.now());
        newCountry = countryRepository.save(newCountry);

        try {
            var countryId = (flag == Boolean.FALSE) ? newCountry.country_id() : 999L;
            City newCity = new City(null,"TabarniaCity", countryId, LocalDateTime.now());
            newCity = cityRepository.save(newCity);

            System.out.println(newCity.city_id());
        } catch (Exception ex) {
            System.out.println("Katakroker");
            throw new RuntimeException("Katakroker");
        }
    }
}
