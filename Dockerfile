FROM openjdk:16-slim-bullseye

ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} app.war

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.war"]
