FROM openjdk:17
EXPOSE 8888
ADD target/tripMangement-0.0.1-SNAPSHOT.jar tripMangement.jar

ENTRYPOINT ["java", "-jar", "tripMangement.jar"]