package info.jab.ms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * CREATE TABLE film (
 *     film_id integer DEFAULT nextval('film_film_id_seq'::regclass) NOT NULL,
 *     title character varying(255) NOT NULL,
 *     description text,
 *     release_year year,
 *     language_id smallint NOT NULL,
 *     original_language_id smallint,
 *     rental_duration smallint DEFAULT 3 NOT NULL,
 *     rental_rate numeric(4,2) DEFAULT 4.99 NOT NULL,
 *     length smallint,
 *     replacement_cost numeric(5,2) DEFAULT 19.99 NOT NULL,
 *     rating mpaa_rating DEFAULT 'G'::mpaa_rating,
 *     last_update timestamp without time zone DEFAULT now() NOT NULL,
 *     special_features text[],
 *     fulltext tsvector NOT NULL
 * );
 */
@Entity
@Table(name = "film")
class Film {
	@Id
	@Column(name="film_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long film_id;
	@Column(name="title")
	private String title;
	//@Column(name="description") private String description;
	//@Column(name="release_year") Integer release_year,
	//@Column(name="language_id") Integer language_id,
	//@Column(name="original_language_id") Integer original_language_id,
	//@Column(name="rental_duration") Integer rental_duration,
	//@Column(name="rental_rate") BigDecimal rental_rate,
	//@Column(name="length") Integer length,
	//@Column(name="replacement_cost") BigDecimal replacement_cost,
	//@Column(name="rating") String rating,
	//@Column(name="last_update") Long last_update,
	//@Column(name="special_features") String special_features,
	//@Column(name="fulltext") String fulltext

	public Film(Long film_id, String title) {
		this.film_id = film_id;
		this.title = title;
	}

	public Film() {
	}

	public Long getFilm_id() {
		return film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Film film = (Film) o;
		return Objects.equals(film_id, film.film_id) && Objects.equals(title, film.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(film_id, title);
	}

	@Override
	public String toString() {
		return "Film{" +
				"film_id=" + film_id +
				", title='" + title + '\'' +
				'}';
	}
}

