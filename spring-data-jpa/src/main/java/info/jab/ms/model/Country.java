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
 * CREATE TABLE country (
 *     country_id integer DEFAULT nextval('country_country_id_seq'::regclass) NOT NULL,
 *     country character varying(50) NOT NULL,
 *     last_update timestamp without time zone DEFAULT now() NOT NULL
 * );
 */
@Entity
@Table(name="country")
public class Country {
	@Column(name = "country_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long country_id;

	@Column(name = "country")
	private String country;
	@Column(name = "last_update")
	private LocalDateTime last_update;

	public Country(Long country_id, String country, LocalDateTime last_update) {
		this.country_id = country_id;
		this.country = country;
		this.last_update = last_update;
	}

	public Country() {
	}

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
}

