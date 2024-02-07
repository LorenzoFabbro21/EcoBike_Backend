FROM openjdk:13-alpine
RUN addgroup -S spring && adduser -S spring -G spring
VOLUME /tmp
EXPOSE 8082
ARG DEPENDENCY=target
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t recensione-service .
# docker run -d -p 8082:8082 --name="recensione-service" recensione-service
