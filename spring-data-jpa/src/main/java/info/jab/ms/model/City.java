package info.jab.ms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * CREATE TABLE city (
 *     city_id integer DEFAULT nextval('city_city_id_seq'::regclass) NOT NULL,
 *     city character varying(50) NOT NULL,
 *     country_id smallint NOT NULL,
 *     last_update timestamp without time zone DEFAULT now() NOT NULL
 * );
 */
@Entity
@Table(name = "city")
public class City {
	@Column(name = "city_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long city_id;
	@Column(name = "city")
	private String country;

	@Column(name = "country_id")
	private Long country_id;
	@Column(name = "last_update")
	private LocalDateTime last_update;


	public City(Long city_id, String country, Long country_id, LocalDateTime last_update) {
		this.city_id = city_id;
		this.country = country;
		this.country_id = country_id;
		this.last_update = last_update;
	}

	public City() {
	}

	public Long getCity_id() {
		return city_id;
	}

	public String getCountry() {
		return country;
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

	public void setCountry(String country) {
		this.country = country;
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
		City city = (City) o;
		return Objects.equals(city_id, city.city_id) && Objects.equals(country, city.country) && Objects.equals(country_id, city.country_id) && Objects.equals(last_update, city.last_update);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city_id, country, country_id, last_update);
	}
}

