FROM eclipse-temurin:17.0.11_9-jdk-alpine AS build
WORKDIR /app
# Copiar documentación de la API para OpenAPI Generator
COPY api-sid.yml .
WORKDIR /app/backend
# Copiar los archivos necesarios para instalar las dependencias
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve
# Copiar el código fuente
COPY src ./src
# Compilar y ejecutar pruebas unitarias
#RUN ./mvnw clean test
# Compilar y empaquetar la aplicación
RUN ./mvnw clean package -DskipTests


# Crear una imagen con la aplicación empaquetada
FROM eclipse-temurin:17.0.11_9-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/backend/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]