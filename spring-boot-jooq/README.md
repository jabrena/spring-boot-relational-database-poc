# Spring Boot JOOQ Testcontainers Example

[![Java CI](https://github.com/jabrena/spring-boot-jooq-testcontainers-example/actions/workflows/build.yml/badge.svg)](https://github.com/jabrena/spring-boot-jooq-testcontainers-example/actions/workflows/build.yml)

This example shows how to run jOOQ's code generation against a Testcontainers managed PostgreSQL database,
which gets its schema installed using Testcontainer's TC_INITSCRIPT.

## How to run the example?

```
./mvnw clean verify
```

The example should run right away.

## Other commands

```
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## References

### Documentation

- https://www.jooq.org/doc/3.16/manual-single-page/
- https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data.sql.jooq

### Articles

- https://www.petrikainulainen.net/using-jooq-with-spring/
- https://www.baeldung.com/jooq-with-spring

### Examples

- https://github.com/jOOQ/jOOQ/tree/main/jOOQ-examples/jOOQ-testcontainers-example

