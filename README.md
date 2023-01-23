# Spring Boot - Relational Database - POC

[![CI Builds](https://github.com/jabrena/spring-boot-postgresql/actions/workflows/build.yaml/badge.svg)](https://github.com/jabrena/spring-boot-postgresql/actions/workflows/build.yaml)

A POC to review different ways to implement
the data access layer for a relational database.

## Entity Relational Diagram (ERD)

![](docs/erd.png)

## Feature 1: List movies starting by A

```sql
SELECT SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
```

**Note:** The query returns 46 rows.

This feature will be implemented with the following alternatives:

- [x] Spring Boot + JDBC
- [x] Spring Boot + JOOQ
- [x] Spring Data JDBC
- [x] Spring Data JPA

```shell
docker run -e POSTGRES_PASSWORD=sakila --rm --name sakiladb -p 5432:5432 -d "frantiseks/postgres-sakila"
mvn spring-boot:run -pl spring-boot-jdbc
mvn spring-boot:run -pl spring-boot-jooq
mvn spring-boot:run -pl spring-data-jdbc
mvn spring-boot:run -pl spring-data-jpa
curl http://localhost:8080/api/v1/films
docker stop sakiladb
```

```shell
mvn clean package -pl spring-boot-jdbc
mvn clean package -pl spring-boot-jooq
mvn clean package -pl spring-data-jdbc
mvn clean package -pl spring-data-jpa
docker compose config
docker compose up --build
docker stats
curl http://localhost:8081/api/v1/films
curl http://localhost:8082/api/v1/films
curl http://localhost:8083/api/v1/films
curl http://localhost:8084/api/v1/films
docker compose down
```

```
CONTAINER ID   NAME                                CPU %     MEM USAGE / LIMIT     MEM %     NET I/O           BLOCK I/O     PIDS
c2305a197f88   spring-boot-postgresql-sakiladb-1   0.05%     80.16MiB / 7.764GiB   1.01%     53.3kB / 202kB    0B / 80.1MB   36
73f16a8c3ad4   spring-boot-jdbc                    0.30%     135.1MiB / 7.764GiB   1.70%     1.22kB / 0B       0B / 127kB    37
967f606ef00a   spring-boot-jooq                    0.38%     193.9MiB / 7.764GiB   2.44%     15.9kB / 13.3kB   0B / 123kB    38
9558952476a3   spring-data-jpa                     0.39%     234.4MiB / 7.764GiB   2.95%     175kB / 27.8kB    0B / 143kB    39
357fe0f21c31   spring-data-jdbc                    0.33%     157.5MiB / 7.764GiB   1.98%     15.8kB / 13.3kB   0B / 123kB    38
```

## How to build in local

```
mvn verify
```

# Other commands

```shell
mvn versions:display-dependency-updates
mvn versions:display-plugin-updates
```

## References

- https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data.sql
- https://docs.spring.io/spring-boot/docs/current/reference/html/data.html#data.sql.jooq
- https://www.jooq.org/doc/3.17/manual-single-page/
- https://github.com/spring-projects/spring-data-examples
- https://hub.docker.com/_/postgres
- https://www.testcontainers.org/supported_docker_environment/logging_config/
- https://www.testcontainers.org/modules/databases/jdbc/
- https://docs.docker.com/compose/
- https://github.com/jOOQ/sakila
- https://github.com/fspacek/docker-postgres-sakila
- https://www.pgadmin.org/
- https://just.maciejwalkowiak.com/
