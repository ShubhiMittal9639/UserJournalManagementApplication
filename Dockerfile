# Use a base image with Java
FROM openjdk:17

# Set the working directory in the container
WORKDIR /UserManagement

# Copy the packaged Spring Boot JAR file into the container
COPY target/UserManagement-0.0.1-SNAPSHOT.jar /UserManagement/

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "UserManagement-0.0.1-SNAPSHOT.jar"]


