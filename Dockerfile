FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ADD /build/libs/telegram-opencart-0.0.1-SNAPSHOT.jar "spring-boot-docker-1.0.jar"

ENTRYPOINT ["java","-jar","spring-boot-docker-1.0.jar"]