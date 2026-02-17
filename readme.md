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
