FROM openjdk:17
VOLUME /tmp
EXPOSE 8076
ADD target/VehiculeMicroService-0.0.1-SNAPSHOT.jar Vehicule.jar
ENTRYPOINT ["java", "-jar", "Vehicule.jar"]