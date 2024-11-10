FROM openjdk:17
VOLUME /tmp
EXPOSE 8078
ADD target/documentmanagment3-0.0.1-SNAPSHOT.jar Document.jar
ENTRYPOINT ["java", "-jar", "Document.jar"]