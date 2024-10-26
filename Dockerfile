FROM openjdk:17
EXPOSE 8081
ADD target/VehiculeMicroService-0.0.1-SNAPSHOT.jar Vehicule.jar
ENTRYPOINT ["java", "-jar", "Vehicule.jar"]