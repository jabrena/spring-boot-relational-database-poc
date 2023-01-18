# Spring Boot - Relational Database - POC

[![CI Builds](https://github.com/jabrena/spring-boot-postgresql/actions/workflows/build.yaml/badge.svg)](https://github.com/jabrena/spring-boot-postgresql/actions/workflows/build.yaml)

A POC to review different ways to implement
the data access layer for a relational database.

## Entity Relational Diagram (ERD)

![](docs/erd.png)

## Feature 1: List movies starting by A

```sql
SELECT *
FROM film
WHERE title LIKE 'A%'
```

**Note:** The query will return 46 rows.

This feature will be implemented with the following alternatives:

- [ ] Spring Boot + JOOQ
- [ ] Spring Boot + JDBC
- [ ] Spring Data JDBC
- [ ] Spring Data JPA

## How to run in local

```
mvn verify
```

# Other commands

```
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## References

- https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data.sql.jooq
- https://github.com/spring-projects/spring-data-examples
- https://hub.docker.com/_/postgres
- https://github.com/jOOQ/sakila
- https://www.pgadmin.org/
- https://just.maciejwalkowiak.com/
