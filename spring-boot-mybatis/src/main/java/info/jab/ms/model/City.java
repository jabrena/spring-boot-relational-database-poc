package info.jab.ms.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class City {

    private Long city_id;
    private String city;
    private Long country_id;
    private LocalDateTime last_update;

    public City(Long city_id, String city, Long country_id, LocalDateTime last_update) {
        this.city_id = city_id;
        this.city = city;
        this.country_id = country_id;
        this.last_update = last_update;
    }

    public City() {
    }

    public Long getCity_id() {
        return city_id;
    }

    public String getCity() {
        return city;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(city_id, city1.city_id) && Objects.equals(city, city1.city) && Objects.equals(country_id, city1.country_id) && Objects.equals(last_update, city1.last_update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city_id, city, country_id, last_update);
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city='" + city + '\'' +
                ", country_id=" + country_id +
                ", last_update=" + last_update +
                '}';
    }
}
