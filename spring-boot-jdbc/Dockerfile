#FROM openjdk:17-jdk-slim
FROM gcr.io/distroless/java17-debian11
COPY target/spring-boot-jdbc-0.1.0-SNAPSHOT.jar spring-boot-jdbc.jar
ENTRYPOINT ["java","-jar","/spring-boot-jdbc.jar"]
