# Use an official OpenJDK 8 runtime as a parent image
#FROM openjdk:8-jre-alpine

# Set the working directory in the container
#WORKDIR /app

# Copy the application JAR file into the container
#COPY target/crudoperationRestApi.jar /app/crudoperationrestapi.jar

# Expose the port that the application will run on
#EXPOSE 8080

# Specify the command to run on container startup
#CMD ["java", "-jar", "crudoperationrestapi.jar"]



###########################################################################
FROM maven:3.5-jdk-8-slim AS build
WORKDIR /home/app
COPY src /home/app/src
COPY pom.xml /home/app/

RUN mvn clean package -DskipTests
FROM openjdk:8-alpine
COPY --from=0 /home/app/target/crudoperationRestApi-0.0.1-SNAPSHOT.jar /temp/crudoperationrestapi.jar
EXPOSE 80/tcp
ENTRYPOINT ["java","-jar","/temp/crudoperationrestapi.jar"]