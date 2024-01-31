FROM openjdk:13-alpine
EXPOSE 8081
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t user-service .
# docker run -d -p 8082:8082 --name="user-service" user-service
