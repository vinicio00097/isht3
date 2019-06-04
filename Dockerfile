FROM java:8
ADD target/Parte_1-1.0-SNAPSHOT.jar Parte_1.jar
ENTRYPOINT ["java","-jar","Parte_1.jar"]