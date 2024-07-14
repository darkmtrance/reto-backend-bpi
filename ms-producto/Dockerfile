FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /usr/src/app
COPY pom.xml ./producto/
COPY src ./producto/src
RUN --mount=type=cache,target=/root/.m2 mvn -f producto/pom.xml clean install -P build-springboot-with-dockerfile

FROM eclipse-temurin:17-jre-focal
RUN mkdir -p /opt/app
COPY --from=build /usr/src/app/producto/target/ms-producto-0.0.1-SNAPSHOT.jar /opt/app/ms-producto-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/producto/src/main/resources /opt/app/src/app/producto/src/main/resources
ENTRYPOINT ["java","-jar","/opt/app/ms-producto-0.0.1-SNAPSHOT.jar"]