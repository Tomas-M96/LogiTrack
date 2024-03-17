# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the jar file into the container at /usr/src/app
COPY target/asset-management-0.0.1-SNAPSHOT.jar /usr/src/app/asset-management-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","asset-management-0.0.1-SNAPSHOT.jar"]
