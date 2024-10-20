FROM openjdk:17
VOLUME /tmp
EXPOSE 8075
ADD target/vehiculemicroservice-0.0.1-SNAPSHOT.jar Vehicule.jar
ENTRYPOINT ["java", "-jar", "Vehicule.jar"]