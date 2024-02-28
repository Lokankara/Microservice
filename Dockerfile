FROM maven:3.8.4-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /dao/target/dao-1.0.jar dao.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "dao.jar"]
