FROM openjdk:13-alpine
EXPOSE 8761
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]

# docker build -t service-discovery-server .
# docker run -d -p 8761:8761 --name="service-discovery-server" service-discovery-server
