package info.jab.ms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * CREATE TABLE country (
 *     country_id integer DEFAULT nextval('country_country_id_seq'::regclass) NOT NULL,
 *     country character varying(50) NOT NULL,
 *     last_update timestamp without time zone DEFAULT now() NOT NULL
 * );
 */
@Table("country")
public
record Country(
	@Column("country_id") @Id Long country_id,
	@Column("country") String country,
	@Column("last_update") LocalDateTime last_update
){ }

