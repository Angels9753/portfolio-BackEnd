FROM openjdk:17
MAINTAINER acs
COPY /target/cay-0.0.1-SNAPSHOT.jar cay.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cay.jar"]