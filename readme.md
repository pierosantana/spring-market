# Spring Market API

## Descripción

Proyecto desarrollado con Spring Boot que simula el funcionamiento de un mercado, 
gestionando entidades como clientes, productos y categorías.

La aplicación expone una API REST que permite realizar operaciones CRUD y consultar información relacionada 
con la gestión del negocio.

Este proyecto fue realizado como parte de un curso de Java con Spring, aplicando buenas prácticas de desarrollo backend y principios de arquitectura limpia.

---

## Stack Tecnológico

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Gradle 
- MapStruct

---

## Arquitectura

Arquitectura en capas orientada al dominio:

Controller → Service → Repository → Entity → Database

- **Controller**: expone endpoints REST.
- **Service**: contiene la lógica de negocio.
- **Repository**: abstrae el acceso a la base de datos.
- **Entity**: representa tablas con JPA.
- **DTO / Domain Model**: desacopla la API de la persistencia.

Se aplica el patrón **Data Mapper** para traducir entre entidades de base de datos y modelos de dominio.

---

## Qué demuestra este proyecto

- Construcción de APIs REST con Spring Boot.
- Persistencia con Spring Data JPA.
- Relaciones entre entidades (`@OneToMany`, `@ManyToOne`).
- Inyección de dependencias (DI) e Inversión de Control (IoC).
- Uso de Query Methods para consultas dinámicas.
- Separación de responsabilidades y diseño limpio de backend.
- Configuración automática de base de datos con **H2** y **PostgreSQL**.
- Gestión de perfiles de Spring Boot para entornos de desarrollo y producción.
- Automatización de la creación de usuarios, bases de datos y datos de ejemplo.
- Preparación de la aplicación para ser ejecutada inmediatamente sin pasos manuales complejos.

## Ejecución

### H2 por defecto

Por defecto, la aplicación utiliza **H2** como base de datos en memoria, con tablas y datos de ejemplo ya cargados. Para ejecutar:

```bash
./gradlew build
```
```bash
java -jar build/libs/spring-market-1.0.jar
````

Esto levantará la aplicación y permitirá probar los endpoints inmediatamente.

### Cambio a PostgreSQL

Si deseas usar **PostgreSQL**, debes tenerlo instalado y el servicio iniciado. La aplicación creará datos por defecto, pero antes debes crear:

* Usuario: `market_user`
* Contraseña: `1234`
* Base de datos: `market_db`

Esto se puede hacer automáticamente ejecutando:

```bash
psql postgres -f init-db.sql
```

El entorno de **producción** apunta a esta base de datos con el usuario y contraseña indicados. Para iniciar la aplicación en producción, utiliza:

```bash
./gradlew build
```
```bash
java -jar -Dspring.profiles.active=pdn build/libs/spring-market-1.0.jar
```

**Notas importantes:**

* Podría surgir un error si el host de PostgreSQL no es `localhost` o el puerto no es `5432`. En ese caso, ajusta la configuración en `application-pdn.properties`.
* Cada vez que se inicia la aplicación en **producción**, se borran las tablas y datos anteriores si existieran, y se crean nuevamente con los datos por defecto.


