# Feature 1: Simple Query / List movies starting by A

```sql
SELECT FILM_ID, TITLE
FROM film
WHERE title LIKE 'A%'
```

**Note:** The query returns 46 rows.

This feature will be implemented with the following alternatives:

- [x] Spring Boot + JDBC
- [x] Spring Boot + JOOQ
- [x] Spring Boot + MyBatis
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
