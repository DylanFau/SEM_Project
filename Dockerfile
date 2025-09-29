# Pull latest openjdk image
FROM openjdk:latest

# Copies our primary working directory inside com.napier.sem to /tmp/
COPY ./src/main/java/com/napier/sem /tmp/

# Sets our working directory for this container as /tmp/ where our project is located
WORKDIR /tmp/

# CLI argument to run our file.
ENTRYPOINT ["java", "App.java"]