# Feature 3: Transactions with @Transactional

- Insert a new COUNTRY
- Insert a new CITY

As a Transaction and force in the test a `Rollback`

```sql
CREATE TABLE city (
    city_id integer DEFAULT nextval('city_city_id_seq'::regclass) NOT NULL,
    city character varying(50) NOT NULL,
    country_id smallint NOT NULL,
    last_update timestamp without time zone DEFAULT now() NOT NULL
);

CREATE TABLE country (
    country_id integer DEFAULT nextval('country_country_id_seq'::regclass) NOT NULL,
    country character varying(50) NOT NULL,
    last_update timestamp without time zone DEFAULT now() NOT NULL
);
```

This feature will be implemented with the following alternatives:

- [x] Spring Boot + JDBC
- [x] Spring Boot + JOOQ
- [x] Spring Boot + MyBatis
- [ ] Spring Data JDBC
- [ ] Spring Data JPA

