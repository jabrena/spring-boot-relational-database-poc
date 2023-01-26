package info.jab.ms.service;

import info.jab.ms.commons.AbstractIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
public class CountryServiceTest extends AbstractIntegrationTest {

    @Autowired
    private CountryService countryService;

    @Test
    void should_make_the_transaction() {

        //Given
        var countryCounterBefore = countryService.getCountryCounter();
        var cityCounterBefore = countryService.getCityCounter();

        //When
        var forced_to_fail = false;
        countryService.addCountryAndCity(forced_to_fail);

        //Then
        var countryCounterAfter = countryService.getCountryCounter();
        var cityCounterAfter = countryService.getCityCounter();
        then(countryCounterAfter).isEqualTo(++countryCounterBefore);
        then(cityCounterAfter).isEqualTo(++cityCounterBefore);
    }

    @Test
    void should_not_make_the_transaction() {

        //Given
        var countryCounterBefore = countryService.getCountryCounter();
        var cityCounterBefore = countryService.getCityCounter();

        //When
        var forced_to_fail = true;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            countryService.addCountryAndCity(forced_to_fail);
        });
        Assertions.assertEquals("Katakroker", thrown.getMessage());

        //Then
        var countryCounterAfter = countryService.getCountryCounter();
        var cityCounterAfter = countryService.getCityCounter();
        then(countryCounterAfter).isEqualTo(countryCounterBefore);
        then(cityCounterAfter).isEqualTo(cityCounterBefore);
    }

}
