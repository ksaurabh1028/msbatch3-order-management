FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order-management.jar
ENTRYPOINT ["java","-jar","/order-management.jar"]

EXPOSE 2222
