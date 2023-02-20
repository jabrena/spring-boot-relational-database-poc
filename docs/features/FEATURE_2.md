# Feature 2: CRUD / CRUD for the Entity Actor

```sql
CREATE TABLE actor (
    actor_id integer DEFAULT nextval('actor_actor_id_seq'::regclass) NOT NULL,
    first_name character varying(45) NOT NULL,
    last_name character varying(45) NOT NULL,
    last_update timestamp without time zone DEFAULT now() NOT NULL
);
```

This feature will be implemented with the following alternatives:

- [x] Spring Boot + JDBC
- [x] Spring Boot + JOOQ
- [x] Spring Boot + MyBatis
- [x] Spring Data JDBC
- [x] Spring Data JPA

```
mvn generate-sources -pl spring-data-jpa
mvn generate-sources -pl spring-data-jdbc
mvn generate-sources -pl spring-boot-jooq
mvn generate-sources -pl spring-boot-jdbc
```
