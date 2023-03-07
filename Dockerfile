# Use a base image with Java and necessary dependencies
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/your-application.jar .

# Expose the desired port
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-application.jar"]
