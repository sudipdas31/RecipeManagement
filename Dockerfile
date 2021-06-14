FROM openjdk:8-jdk-alpine
ARG JAR=target/*.jar
COPY ${JAR} /app/myRecipe.jar
RUN mkdir -p /app/import
WORKDIR /app
CMD ["java", "-jar", "myRecipe.jar"]