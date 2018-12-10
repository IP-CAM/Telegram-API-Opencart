# Version 01

FROM openjdk:10.0.2-jdk-slim

WORKDIR "/tmp"

RUN mkdir -p /tmp/app/

WORKDIR "/tmp/app"

COPY app.jar /tmp/app/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/tmp/app/app.jar"]

EXPOSE 3200
