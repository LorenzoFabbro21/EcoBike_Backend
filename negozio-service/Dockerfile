FROM openjdk:13-alpine
VOLUME /tmp
EXPOSE 8083
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t negozio-service .
# docker run -d -p 8083:8083 --name="negozio-service" negozio-service
