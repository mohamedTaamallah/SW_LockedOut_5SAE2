FROM openjdk:17
EXPOSE 8079
ADD target/SW_Vehicule-0.0.1-SNAPSHOT.jar Maintenance.jar
ENTRYPOINT ["java","-jar","Maintenance.jar"]