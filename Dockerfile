FROM openjdk:8-jre-alpine

WORKDIR /usr/app
COPY ./src/server.jar ./

CMD ["java", "-jar", "server.jar"]
