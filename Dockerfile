FROM openjdk:17
VOLUME /tmp
EXPOSE 8093
ADD target/Gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java", "-jar", "gateway.jar"]