# Feature 2: CRUD for the Entity Actor

```sql
CREATE TABLE actor (
    actor_id integer DEFAULT nextval('actor_actor_id_seq'::regclass) NOT NULL,
    first_name character varying(45) NOT NULL,
    last_name character varying(45) NOT NULL,
    last_update timestamp without time zone DEFAULT now() NOT NULL
);
```

This feature will be implemented with the following alternatives:

- [ ] Spring Boot + JDBC
- [ ] Spring Boot + JOOQ
- [ ] Spring Data JDBC
- [x] Spring Data JPA

```
mvn generate-sources -pl spring-data-jpa
```
