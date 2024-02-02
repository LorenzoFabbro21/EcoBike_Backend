FROM openjdk:13-alpine
EXPOSE 8084
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t gestore_ordini-service .
# docker run -d -p 8084:8084 --name="gestore_ordini-service" gestore_ordini-service
