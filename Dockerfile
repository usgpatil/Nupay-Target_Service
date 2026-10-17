
# Stage 1: Build the Target Service
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven Wrapper and configuration
COPY mvnw .
COPY .mvn/ .mvn/
COPY pom.xml .

# Copy application source
COPY src/ src/

# Build the Spring Boot application
RUN chmod +x mvnw && ./mvnw -B clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the generated application JAR
COPY --from=build /app/target/*.jar app.jar

# Dummy NuPay Target Service listens on port 8081
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
