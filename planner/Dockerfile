FROM maven:3.6.3-openjdk-11 as builder
WORKDIR /project
COPY pom.xml /project/
COPY src /project/src
RUN mvn clean verify
RUN mvn package -o

FROM openjdk:11-jre-slim
WORKDIR /usr/src/app/
COPY --from=builder /project/target/*.jar /usr/src/app/server.jar
EXPOSE 8080
CMD [ "java", "-jar", "server.jar" ]