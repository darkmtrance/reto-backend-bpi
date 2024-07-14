FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /usr/src/app
COPY pom.xml ./oauth/
COPY src ./oauth/src
RUN --mount=type=cache,target=/root/.m2 mvn -f oauth/pom.xml clean install

FROM eclipse-temurin:17-jre-focal
RUN mkdir -p /opt/app
COPY --from=build /usr/src/app/oauth/target/oauth-server-0.0.1-SNAPSHOT.jar /opt/app/oauth-server-0.0.1-SNAPSHOT.jar
COPY --from=build /usr/src/app/oauth/src/main/resources /opt/app/src/app/oauth/src/main/resources
ENTRYPOINT ["java","-jar","/opt/app/oauth-server-0.0.1-SNAPSHOT.jar"]