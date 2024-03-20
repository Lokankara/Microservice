FROM maven:3.8.4-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /rest/target/rest-1.0-exec.jar rest.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "rest.jar"]
