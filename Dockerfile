
# ==========================================
# STAGE 1: BUILD
# Maven + JDK 17
# ==========================================

FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven configuration
COPY pom.xml .

# Copy source code
COPY src ./src

# Download dependencies
RUN mvn dependency:go-offline -B

# Run JUnit tests and create JAR file
RUN mvn clean package


# ==========================================
# STAGE 2: RUNTIME
# JDK 17
# ==========================================

FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy generated JAR from build stage
COPY --from=build /app/target/jarfile-1.0-SNAPSHOT.jar app.jar

# Execute Calculator JAR
CMD ["java", "-jar", "app.jar"]
