FROM eclipse-temurin:17.0.11_9-jdk-alpine AS build

WORKDIR /app

# Copiar documentación de la API para OpenAPI Generator
COPY api-sid.yml .

WORKDIR /app/backend

# Copiar los archivos necesarios para instalar las dependencias
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn .mvn
COPY api-sid.yml .

# Descargar todas las dependencias sin construir el archivo JAR final
RUN ./mvnw dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar, testear y empaquetar la aplicación
RUN ./mvnw clean package



# Crear una imagen con la aplicación empaquetada
FROM eclipse-temurin:17.0.11_9-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/backend/target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]