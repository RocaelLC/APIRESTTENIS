# Base image
FROM openjdk:17-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Install dependencies
RUN apt-get update && \
    apt-get install -y maven

# Build the project
RUN mvn clean package

# Expose port
EXPOSE 8080


CMD ["java", "-jar", "gestiondetenis.jar"]
