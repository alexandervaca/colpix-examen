# code-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.

## Provided Code

# Employee Management REST API with AWS Integration

Este proyecto implementa una API RESTful desarrollada con Java 17 y Quarkus 3.17.6, desplegable sobre infraestructura de AWS. Está orientada a la gestión de empleados e incorpora autenticación con JWT, manejo de sesiones temporales, operaciones CRUD básicas y consultas optimizadas de manera asíncrona.

## 🔧 Tecnologías Utilizadas

- **Java 17**
- **Quarkus 3.17.6 (Quarkus, Spring Security, Hibernate)**
- **JWT (JSON Web Token) para autenticación**
- **AWS RDS (PostgreSQL/MySQL)**
- **AWS Lambda (opcional para escalabilidad)**
- **AWS API Gateway**
- **OpenAPI (Swagger) para documentación**
- **Maven**
- **Docker (opcional para despliegue local)**

---

## ✅ Funcionalidades

### 1. Login
- Endpoint: `POST /api/auth/login`
- Permite autenticarse con usuario y contraseña.
- Devuelve un **token JWT** con expiración por defecto de **5 minutos** (parametrizable por configuración).
- Ejemplo de request:
```json
{
  "username": "usuario",
  "password": "clave123"
}

