package info.jab.ms.service;

public interface CountryService {

    Integer getCountryCounter();
    Integer getCityCounter();
    void addCountryAndCity(Boolean flag);
}
