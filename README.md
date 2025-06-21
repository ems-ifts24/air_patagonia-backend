# Air Patagonia - Backend

Backend para el sistema de gestión de vuelos de Air Patagonia. Esta aplicación proporciona una API RESTful para la gestión de vuelos, tripulaciones y operaciones relacionadas.

## 🚀 Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.0**
  - Spring Web
  - Spring Data JPA
  - Spring Boot DevTools
- **Base de Datos**: Microsoft SQL Server
- **Lombok** para reducción de código boilerplate
- **SpringDoc OpenAPI** para documentación de la API

## 📚 Documentación de la API

La documentación interactiva de la API está disponible mediante Swagger UI en:
```
http://localhost:8080/swagger-ui.html
```

y en formato OpenAPI (JSON) en:
```
http://localhost:8080/v3/api-docs
```

## 🏗️ Estructura del Proyecto

```
src/main/java/com/airpatagonia/backend/
├── configurations/    # Configuraciones de la aplicación
├── controllers/       # Controladores REST
├── dtos/              # Objetos de Transferencia de Datos
├── enums/             # Enumeraciones
├── exceptions/        # Manejo de excepciones
├── models/            # Entidades del dominio
├── repositories/      # Repositorios de acceso a datos
└── services/          # Lógica de negocio
```

## 🛠️ Requisitos Previos

- Java 17 o superior
- Maven 3.6 o superior
- SQL Server 2019 o superior

## 🚀 Instalación y Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd air_patagonia-backend
   ```

2. Configurar la conexión a la base de datos en `application.properties`

3. Compilar y ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

4. La aplicación estará disponible en `http://localhost:8080`

## 📝 Características Principales

- Gestión de vuelos
- Administración de tripulaciones
- Asignación de personal a vuelos
- Validación de reglas de negocio
- Documentación automática de la API

## 📄 Licencia

Este proyecto está bajo la Licencia [LICENSE].
