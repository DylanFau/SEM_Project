FROM openjdk:latest
COPY ./src/main/java/com/napier/sem /tmp/
WORKDIR /tmp/
ENTRYPOINT ["java", "App.java"]