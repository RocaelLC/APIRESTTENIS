# Gestión de Tenis API

## Descripción
Este proyecto es una API RESTful desarrollada en Spring Boot para la gestión de productos de tenis. Proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los productos de tenis en una base de datos.

## Tecnologías Utilizadas
- Java
- Spring Boot
- MongoDB (NoSQL)
- Maven
- JUnit 5
- Docker
- Jenkins

## Estructura del Proyecto
- `src/main/java/com/gestiondetenis`: Contiene el código fuente de la aplicación.
- `src/test/java/com/gestiondetenis`: Contiene las pruebas unitarias de la aplicación.
- `Dockerfile`: Archivo para construir la imagen Docker de la aplicación.
- `Jenkinsfile`: Archivo para configurar el pipeline de Jenkins.
- `pom.xml`: Archivo de configuración de Maven.
- `README.md`: Documentación del proyecto (este archivo).

## Configuración
1. **Clonar el Repositorio**: Clona este repositorio en tu máquina local.
2. **Configurar MongoDB**: Asegúrate de tener MongoDB instalado y configurado localmente o en un servidor remoto. Actualiza la configuración de conexión en `application.properties`.
3. **Compilar el Proyecto**: Ejecuta `mvn clean install` para compilar y construir el proyecto.
4. **Ejecutar la Aplicación**: Ejecuta `java -jar gestiondetenis.jar` para iniciar la aplicación Spring Boot.
5. **Acceder a la API**: La API estará disponible en `http://localhost:8080/api/productos`.

## Endpoints Disponibles
- `GET /api/productos`: Obtener todos los productos de tenis.
- `GET /api/productos/{id}`: Obtener un producto de tenis por ID.
- `POST /api/productos`: Crear un nuevo producto de tenis.
- `PUT /api/productos/{id}`: Actualizar un producto de tenis existente.
- `DELETE /api/productos/{id}`: Eliminar un producto de tenis por ID.

