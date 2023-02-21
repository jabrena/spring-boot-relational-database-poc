#!/bin/sh

echo "Building images for spring-boot-jdbc"
mvn spring-boot:build-image -pl spring-boot-jdbc
mvn -Pnative spring-boot:build-image -pl spring-boot-jdbc

echo "Building images for spring-boot-jooq"
mvn spring-boot:build-image -pl spring-boot-jooq
mvn -Pnative spring-boot:build-image -pl spring-boot-jooq

echo "Building images for spring-boot-mybatis"
mvn spring-boot:build-image -pl spring-boot-mybatis
mvn -Pnative spring-boot:build-image -pl spring-boot-mybatis

echo "Building images for spring-data-jdbc"
mvn spring-boot:build-image -pl spring-data-jdbc
mvn -Pnative spring-boot:build-image -pl spring-data-jdbc

echo "Building images for spring-data-jpa"
mvn spring-boot:build-image -pl spring-data-jpa
mvn -Pnative spring-boot:build-image -pl spring-data-jpa

echo "Docker images inventory"
docker images
