# Use a base image with Java 8 and Maven pre-installed
FROM maven:3.8.4-openjdk-8-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project definition
COPY pom.xml .

# Resolve dependencies and cache them
RUN mvn dependency:go-offline

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Create a new stage for running the application
FROM openjdk:8-jre-slim AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=build /app/target/siiu-seguimproyectos-back-0.0.1-SNAPSHOT.jar .

# Expose the port your application runs on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "siiu-seguimproyectos-back-0.0.1-SNAPSHOT.jar"]
