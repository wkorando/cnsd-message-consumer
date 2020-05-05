FROM adoptopenjdk/openjdk8-openj9:alpine-slim

COPY target/message-consumer-service.jar /

ENTRYPOINT ["java", "-jar", "message-consumer-service.jar" ]
