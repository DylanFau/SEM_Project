# Pull openjdk image
FROM openjdk:26-ea-22-jdk-bookworm

# Copies our primary working directory from our JAR to /tmp/
COPY ./target/SEM-Project-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp

# Sets our working directory for this container as /tmp/ where our project is located
WORKDIR /tmp

# CLI argument to run our file.
ENTRYPOINT ["java", "-jar", "SEM-Project-1.0-SNAPSHOT-jar-with-dependencies.jar"]