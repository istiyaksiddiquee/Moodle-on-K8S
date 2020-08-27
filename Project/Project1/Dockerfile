FROM adoptopenjdk/openjdk13:x86_64-alpine-jre-13.0.2_8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar","/app.jar"]


# Multi Stage build for accelarating maven packaging

#FROM maven:3.6.3-adoptopenjdk-14 AS maven
#COPY ./pom.xml ./pom.xml
#COPY ./src ./src
#RUN mvn package
#
#FROM adoptopenjdk/openjdk13:x86_64-alpine-jre-13.0.2_8
#WORKDIR /my-project
#COPY --from=maven target/*.jar ./app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "./app.jar"]