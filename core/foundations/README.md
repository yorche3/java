# 🚀 Fundamentos / Foundations — Java

Implementación de los ejercicios de la sección [Fundamentos / Foundations](https://yorche3.github.io/programming_languages/core/foundations/) del repositorio principal en **Java (JDK 17+)**.

---

## 📖 Descripción / Description

**ES:** Esta sección reúne los conceptos esenciales para empezar a trabajar con **Java**. Cubre desde los programas más básicos (`Hello, World!` y `Hello, User!`) hasta la implementación de una calculadora con pruebas unitarias y algoritmos numéricos en tres enfoques progresivos (recursivo directo, recursivo con acumulador e iterativo).

**EN:** This section brings together the essential concepts to start working with **Java**. It covers everything from the most basic programs (`Hello, World!` and `Hello, User!`) to the implementation of a calculator with unit tests and numerical algorithms in three progressive approaches (direct recursion, accumulator recursion, and iterative).

---

## 📁 Estructura / Structure

```text
java/
└── core/
    └── foundations/
        ├── README.md              # Este archivo / This file
        ├── helloworld/            # 01_Hello_World — Primer programa
        │   ├── HelloWorld.java
        │   └── README.md
        ├── hellouser/             # 02_Hello_User — Entrada y salida
        │   ├── HelloUser.java
        │   └── README.md
        ├── unit_test/
        │   └── calculator/        # 03_Unit_Test_Calculator — Pruebas unitarias
        │       ├── pom.xml
        │       ├── src/main/java/calculator/
        │       │   └── Calculator.java
        │       ├── src/test/java/calculator/
        │       │   └── CalculatorTest.java
        │       └── README.md
        └── numbers/               # 04_Numbers — Algoritmos numéricos
            ├── pom.xml
            ├── src/main/java/numbers/
            │   └── Numbers.java
            ├── src/test/java/numbers/
            │   ├── NumbersRecursiveTest.java
            │   └── NumbersIterativeTest.java
            └── README.md
```

---

## 🔢 Progresión / Progression

| Especificación | Proyecto | Conceptos | Dependencias externas |
| -------------- | -------- | --------- | :-------------------: |
| [`01_Hello_World`](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) | [`helloworld/`](helloworld/) | Clase pública, `public static void main`, `System.out.println` | ❌ Solo stdlib |
| [`02_Hello_User`](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) | [`hellouser/`](hellouser/) | Variables, `Scanner`, `System.in` | ❌ Solo stdlib |
| [`03_Unit_Test_Calculator`](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) | [`unit_test/calculator/`](unit_test/calculator/) | Maven, JUnit 5, `@Test`, `assertEquals` | ✅ JUnit 5 |
| [`04_Numbers`](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) | [`numbers/`](numbers/) | Recursión, iteración, acumuladores, helpers privados, TCO | ✅ JUnit 5 |

---

## 🛠️ Enfoque general / General Approach

**ES:** Los proyectos en esta sección siguen un patrón progresivo:

1. **Hello World** y **Hello User**: Programas de un solo archivo, compilados con `javac` y ejecutados con `java`, sin Maven/Gradle. Usan exclusivamente la biblioteca estándar.
2. **Calculator**: Primer proyecto con dependencia externa (**JUnit 5**). Introduce **Maven** (`pom.xml`), el layout estándar `src/main/java` + `src/test/java` y el ecosistema `mvn test`.
3. **Numbers**: Expande el patrón de Calculator a múltiples clases de prueba (una por enfoque probado). La versión con acumulador (`_acc`) se conserva en el fuente como puente didáctico: la JVM no garantiza TCO, por lo que solo se prueban los enfoques recursivo e iterativo (22 casos).

**EN:** The projects in this section follow a progressive pattern:

1. **Hello World** and **Hello User**: Single-file programs, compiled with `javac` and run with `java`, without Maven/Gradle. Use only the standard library.
2. **Calculator**: First project with an external dependency (**JUnit 5**). Introduces **Maven** (`pom.xml`), the standard `src/main/java` + `src/test/java` layout, and the `mvn test` ecosystem.
3. **Numbers**: Expands the Calculator pattern to multiple test classes (one per tested approach). The accumulator version (`_acc`) is kept in source as an educational bridge: the JVM does not guarantee TCO, so only the recursive and iterative approaches are tested (22 cases).

---

## 🚀 Ejecución rápida / Quick Start

### Hello World

```bash
cd java/core/foundations/helloworld
javac HelloWorld.java && java HelloWorld
```

### Hello User

```bash
cd java/core/foundations/hellouser
javac HelloUser.java && java HelloUser
```

### Calculator (pruebas)

```bash
cd java/core/foundations/unit_test/calculator
mvn test
```

### Numbers (pruebas)

```bash
cd java/core/foundations/numbers
mvn test
```

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
