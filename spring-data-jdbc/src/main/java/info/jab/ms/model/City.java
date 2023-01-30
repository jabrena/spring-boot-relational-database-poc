package info.jab.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * CREATE TABLE city (
 *     city_id integer DEFAULT nextval('city_city_id_seq'::regclass) NOT NULL,
 *     city character varying(50) NOT NULL,
 *     country_id smallint NOT NULL,
 *     last_update timestamp without time zone DEFAULT now() NOT NULL
 * );
 */
@Table("city")
public
record City(
	@Column("city_id") @Id Long city_id,
	@Column("city") String country,

	@Column("country_id") Long country_id,
	@Column("last_update") LocalDateTime last_update
){ }

