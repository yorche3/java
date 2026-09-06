# Java

Proyectos en **Java (JDK 17+)**, con gestión de dependencias mediante **Maven** y el framework de pruebas **JUnit 5**.

---

## 📂 Módulos / Modules

| Módulo | Descripción |
| ------ | ----------- |
| [`core/foundations/`](core/foundations/) | **Fase 0 — Fundamentos**: `helloworld`, `hellouser`, `unit_test/calculator`, `numbers` |

---

## ▶️ Comenzar / Getting Started

```bash
# Hello, World!
cd core/foundations/helloworld
javac HelloWorld.java && java HelloWorld

# Hello, User!
cd core/foundations/hellouser
javac HelloUser.java && java HelloUser

# Calculator Tests
cd core/foundations/unit_test/calculator
mvn test

# Numbers Tests
cd core/foundations/numbers
mvn test
```

---

## 📦 Requisitos / Requirements

| Herramienta | Instalación |
| ----------- | ----------- |
| [JDK 17+](https://adoptium.net/) | `sudo apt install openjdk-17-jdk` (Linux) / `winget install Microsoft.OpenJDK.17` (Windows) / [Descargar](https://adoptium.net/) |
| [Maven 3.6+](https://maven.apache.org/download.cgi) | `sudo apt install maven` (Linux) / `winget install Apache.Maven` (Windows) / [Descargar](https://maven.apache.org/download.cgi) |

```bash
# Verificar instalación
java -version
mvn -version
```

---

## 🏗️ Tipos de proyecto / Project Types

### 1. Programa simple (compilación directa con `javac`)

**ES:** Un único archivo fuente, sin dependencias externas, compilado directamente con `javac` y ejecutado con `java`. Ideal para `helloworld` y `hellouser`. No requiere Maven ni Gradle.

**EN:** A single source file, no external dependencies, compiled directly with `javac` and run with `java`. Ideal for `helloworld` and `hellouser`. No Maven or Gradle required.

```bash
javac <Class>.java
java <Class>
```

### 2. Proyecto con pruebas unitarias (Maven + JUnit 5)

**ES:** Para proyectos que requieren pruebas unitarias, se usa **Maven** (`pom.xml`) y **JUnit 5** como dependencia de test. El código fuente se organiza en `src/main/java` y las pruebas en `src/test/java`, con descubrimiento automático de tests mediante `@Test`.

**EN:** For projects that require unit tests, **Maven** (`pom.xml`) and **JUnit 5** are used as a test dependency. Source code goes in `src/main/java` and tests in `src/test/java`, with automatic test discovery via `@Test`.

```bash
mvn test
```

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
