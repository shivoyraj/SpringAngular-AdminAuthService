# Use a base image with Java 11
FROM openjdk:11-jre-slim
ARG build_version=project.version
ARG app_name=project.name

# Created a directory inside the container to hold application
WORKDIR /container

# Add the Spring Boot executable JAR to the container's app directory
COPY ${app_name}-${build_version}.jar /container/app.jar
COPY pom.xml /container/pom.xml

# Exposed the port where Spring Boot application runs on
EXPOSE 8080

# Command to run application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
