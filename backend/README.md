# Instalación del Backend

El proyecto está construido en [Spring Boot](https://spring.io/projects/spring-boot) y [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Requisitos
- Java 17 
- Solicitar a un administrador del proyecto, dar de alta en el Tenant **agricultura-dgec** de Microsoft Azure B2C. 
- Instalar [Azure CLI](https://learn.microsoft.com/es-es/cli/azure/install-azure-cli) para la autenticación de usuarios. 
  - Iniciar sesión en Azure CLI con el comando `auth0 login` con el correo dado de alta en el Tenant **agricultura-dgec**.

## Instrucciones
El proceso de instalación se realiza en la carpeta `ProyectoSID/backend`

1. Instalar las dependencias del proyecto con el comando
```bash
./mvnw install
```
2. Ejecutar el proyecto con el comando 
```bash
./mvnw spring-boot:run
```
3. Abrir el sitio http://localhost:8080/swagger-ui/index.html#/

# Instalar Frontend
1. Seguir las instrucciones del [README](../frontend/README.md) para iniciar con la instalación.