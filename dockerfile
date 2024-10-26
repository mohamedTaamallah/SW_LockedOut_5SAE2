FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the wait-for-it.sh script into the container
COPY wait-for-it.sh /app/wait-for-it.sh

# Make the script executable
RUN chmod +x /app/wait-for-it.sh

# Copy the JAR file into the container
ADD target/documentmanagment3-0.0.1-SNAPSHOT.jar /app/Document.jar

# Expose the application port
EXPOSE 8082

# Use wait-for-it.sh to wait for MySQL before starting the application
ENTRYPOINT ["/app/wait-for-it.sh", "db-mysql:3306", "--", "java", "-jar", "/app/Document.jar"]
