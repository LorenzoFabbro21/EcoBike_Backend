FROM openjdk:13-alpine
EXPOSE 8085
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t annuncio-service .
# docker run -d -p 8085:8085 --name="annuncio-service" annuncio-service
