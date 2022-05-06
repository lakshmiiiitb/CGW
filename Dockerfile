FROM openjdk:8
COPY ./target/CGW-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "CGW-1.0-SNAPSHOT-jar-with-dependencies.jar"]
