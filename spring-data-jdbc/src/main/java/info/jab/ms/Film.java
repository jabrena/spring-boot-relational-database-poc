package info.jab.ms;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

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
@Table("film")
record Film(
	@Column("film_id") @Id Long film_id,
	@Column("title") String title,
	@Column("description") String description,
	@Column("release_year") Integer release_year,
	@Column("language_id") Integer language_id,
	@Column("original_language_id") Integer original_language_id,
	@Column("rental_duration") Integer rental_duration,
	@Column("rental_rate") BigDecimal rental_rate,
	@Column("length") Integer length,
	@Column("replacement_cost") BigDecimal replacement_cost,
	@Column("rating") String rating,
	@Column("last_update") Long last_update,
	@Column("special_features") String special_features,
	@Column("fulltext") String fulltext
){ }

