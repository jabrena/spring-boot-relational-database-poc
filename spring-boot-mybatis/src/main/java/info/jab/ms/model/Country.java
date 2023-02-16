package info.jab.ms.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Country {

    private Long country_id;
    private String country;
    private LocalDateTime last_update;

    public Country(Long country_id, String country, LocalDateTime last_update) {
        this.country_id = country_id;
        this.country = country;
        this.last_update = last_update;
    }

    public Country() {}

    public Long getCountry_id() {
        return country_id;
    }

    public String getCountry() {
        return country;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(country_id, country1.country_id) && Objects.equals(country, country1.country) && Objects.equals(last_update, country1.last_update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country_id, country, last_update);
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country='" + country + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
