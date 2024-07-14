FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /usr/src/app
COPY pom.xml ./cliente/
COPY src ./cliente/src
RUN --mount=type=cache,target=/root/.m2 mvn -f cliente/pom.xml clean install -P build-springboot-with-dockerfile

FROM eclipse-temurin:17-jre-focal
RUN mkdir -p /opt/app
COPY --from=build /usr/src/app/cliente/target/ms-cliente-0.0.1-SNAPSHOT.jar /opt/app/ms-cliente-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/cliente/src/main/resources /opt/app/src/app/cliente/src/main/resources
ENTRYPOINT ["java","-jar","/opt/app/ms-cliente-0.0.1-SNAPSHOT.jar"]