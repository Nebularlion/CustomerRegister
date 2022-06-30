FROM maven:3.8-openjdk-17-slim
COPY pom.xml pom.xml
COPY src src
RUN mvn clean install
EXPOSE 8080
CMD ["java", "-jar", "target/CustomerRegister-0.0.1-SNAPSHOT.jar"]