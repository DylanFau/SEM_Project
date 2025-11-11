# Pull openjdk image
FROM openjdk:26-ea-22-jdk-bookworm

# Copies our primary working directory from our JAR to /tmp/
COPY ./target/devops-jar-with-dependencies.jar /tmp/devops.jar

# Sets our working directory for this container as /tmp/ where our project is located
WORKDIR /tmp

# CLI argument to run our file.
ENTRYPOINT ["java", "-jar", "devops.jar"]