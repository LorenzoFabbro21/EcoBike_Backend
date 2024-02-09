FROM openjdk:13-alpine
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t user-service .
# docker run -d -p 8081:8081 --name="user-service" user-service
