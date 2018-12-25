FROM openjdk:8-jdk-alpine

COPY src /app/src

COPY build.gradle /app/build.gradle

COPY gradle /app/gradle

COPY .gradle /app/.gradle

COPY gradlew /app/gradlew

WORKDIR /app

CMD sh gradlew bootRun