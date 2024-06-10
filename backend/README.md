# Instalación del Backend

El proyecto está construido en [Spring Boot](https://spring.io/projects/spring-boot) y [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Requisitos
- Java 17 
- Solicitar a un administrador del proyecto, dar de alta en el Tenant **agricultura-dgec** de Microsoft Azure B2C.

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
3. Solicitar a un lider del proyecto dar de alta un usuario en el Tenant **agricultura-dgec** de Microsoft Azure B2C desde el endpoint ```/api/empleados```
4. Solicita a un miembro del proyecto el comando correspodiente para obtener un token de autenticación del servicio de Azure B2C.
5. Abrir el sitio http://localhost:8080/doc
6. Loguearse con el token obtenido en el paso 4.
7. Listo, ya puedes probar los servicios del backend.

# Instalar Frontend
1. Seguir las instrucciones del [README](../frontend/README.md) para iniciar con la instalación.