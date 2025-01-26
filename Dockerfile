FROM maven:3.9.9-amazoncorretto-23-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk
COPY --from=build /target/*.jar *.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/*.jar"]