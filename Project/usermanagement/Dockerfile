#FROM adoptopenjdk/openjdk13:x86_64-alpine-jre-13.0.2_8
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar","/app.jar"]


# Multi Stage build for accelarating maven packaging

FROM maven:3.6.3-adoptopenjdk-14 AS maven
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B

COPY ./src ./src
RUN mvn clean package

FROM adoptopenjdk:14.0.2_8-jre-hotspot-bionic

ARG PORT
ENV ENV_PORT $PORT

WORKDIR /my-project
COPY --from=maven target/*.jar ./app.jar
EXPOSE $ENV_PORT
CMD ["sh", "-c", "java -Dserver.port=$ENV_PORT -jar /my-project/app.jar"]