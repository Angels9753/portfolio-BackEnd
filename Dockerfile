FROM openjdk:17
COPY /target/cay-0.0.1-SNAPSHOT.jar cay.jar
ENTRYPOINT ["java","-jar","cay.jar"]
