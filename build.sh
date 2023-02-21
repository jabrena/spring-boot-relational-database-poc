#!/bin/sh

echo "Building images"
mvn spring-boot:build-image -pl spring-boot-jdbc
mvn -Pnative spring-boot:build-image -pl spring-boot-jdbc
