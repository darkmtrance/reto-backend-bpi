FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /usr/src/app
COPY pom.xml ./gateway/
COPY src ./gateway/src
RUN --mount=type=cache,target=/root/.m2 mvn -f gateway/pom.xml clean install -P skip-tests

FROM eclipse-temurin:17-jre-focal
RUN mkdir -p /opt/app
COPY --from=build /usr/src/app/gateway/target/spring-gateway-0.0.1-SNAPSHOT.jar /opt/app/spring-gateway-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/gateway/src/main/resources /opt/app/src/app/gateway/src/main/resources
ENTRYPOINT ["java","-jar","/opt/app/spring-gateway-0.0.1-SNAPSHOT.jar"]