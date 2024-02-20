FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["\src\main\java\org\example", "App:run"]