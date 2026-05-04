# Etapa 1: Construcción
FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Cambiamos la imagen que falló)
FROM amazoncorretto:17-alpine
WORKDIR /app
# El nombre del JAR debe coincidir con tu pom.xml
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]