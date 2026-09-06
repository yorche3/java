# Calculator — Java

Implementación de la especificación [03_Unit_Test_Calculator](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) en **Java**, usando **Maven** como herramienta de construcción y **JUnit 5 (Jupiter)** como framework de pruebas unitarias.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
| ------- | --------- |
| [`pom.xml`](pom.xml) | Proyecto Maven — declara Java 17 y la dependencia de test `junit-jupiter`. |
| [`src/main/java/calculator/Calculator.java`](src/main/java/calculator/Calculator.java) | Clase `Calculator` con las 5 operaciones aritméticas (métodos estáticos). |
| [`src/test/java/calculator/CalculatorTest.java`](src/test/java/calculator/CalculatorTest.java) | 5 pruebas unitarias con `@Test` y `assertEquals`. |
| [`.gitignore`](.gitignore) | Ignora `target/` (salida de compilación de Maven). |

**Estructura de directorios esperada:**

```text
calculator/
├── pom.xml                              # Proyecto Maven
├── .gitignore                           # Ignora target/
├── src/
│   ├── main/java/calculator/
│   │   └── Calculator.java              # 5 operaciones aritméticas
│   └── test/java/calculator/
│       └── CalculatorTest.java          # 5 tests con JUnit 5
└── target/                              # Generado por Maven (no versionado)
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Este proyecto usa **Maven** con el layout estándar (`src/main/java` para fuentes y `src/test/java` para pruebas) y **JUnit 5 (Jupiter)**:

1. Cada operación de `Calculator` es un método `public static`.
2. Cada prueba se marca con `@Test` y verifica con `assertEquals(expected, actual)`.
3. El descubrimiento de pruebas es automático: `mvn test` ejecuta todas las clases `*Test`.
4. `multiplication`, `division` y `modulus` se implementan con las estrategias educativas de la especificación (sin usar los operadores `*`, `/` ni `%` respectivamente).

**EN:** This project uses **Maven** with the standard layout (`src/main/java` for sources and `src/test/java` for tests) and **JUnit 5 (Jupiter)**:

1. Each `Calculator` operation is a `public static` method.
2. Each test is marked with `@Test` and verified with `assertEquals(expected, actual)`.
3. Test discovery is automatic: `mvn test` runs all `*Test` classes.
4. `multiplication`, `division` and `modulus` are implemented with the educational strategies from the specification (without using the `*`, `/` or `%` operators respectively).

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `pom.xml` — Proyecto Maven

**ES:** Declara el artefacto `calculator`, el nivel de lenguaje Java 17 y la única dependencia externa: `junit-jupiter` (scope `test`). El plugin `maven-surefire-plugin` es el que ejecuta los tests.

**EN:** Declares the `calculator` artifact, Java 17 language level, and the single external dependency: `junit-jupiter` (`test` scope). The `maven-surefire-plugin` runs the tests.

### `Calculator.java` — Módulo principal

| Operación | Implementación educativa |
| --------- | ------------------------ |
| `addition(a, b)` | Suma directa (`a + b`). |
| `subtraction(a, b)` | Resta directa (`a - b`). |
| `multiplication(a, b)` | Suma repetitiva: acumula `a`, `b` veces (no usa `*`). |
| `division(a, b)` | Resta repetitiva: resta `b` de `a` mientras `a >= b` (no usa `/`). |
| `modulus(a, b)` | Construida sobre `division` y `multiplication` (no usa `%`). |

```java
public class Calculator {

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = addition(result, a);
        }
        return result;
    }

    public static int division(int a, int b) {
        int count = 0;
        while (a >= b) {
            a = subtraction(a, b);
            count++;
        }
        return count;
    }

    public static int modulus(int a, int b) {
        int q = division(a, b);
        int p = multiplication(q, b);
        return subtraction(a, p);
    }
}
```

### `CalculatorTest.java` — Pruebas unitarias (JUnit 5)

**ES:** Un `@Test` por operación, con los mismos casos del pseudocódigo de la especificación.

**EN:** One `@Test` per operation, with the same cases as the specification pseudocode.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(5, Calculator.addition(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(3, Calculator.subtraction(5, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(12, Calculator.multiplication(3, 4));
    }

    @Test
    void testDivision() {
        assertEquals(3, Calculator.division(10, 3));
    }

    @Test
    void testModulus() {
        assertEquals(1, Calculator.modulus(10, 3));
    }
}
```

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK 17 o superior** (`javac` y `java`).
- **Maven 3.6+** (`mvn`).

```bash
java -version   # OpenJDK 17+
mvn -version
```

### Ejecutar las pruebas unitarias / Run tests

```bash
cd java/core/foundations/unit_test/calculator
mvn test
```

### Salida esperada / Expected output

```text
[INFO] Running calculator.CalculatorTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 📝 Notas de implementación / Implementation Notes

**ES:** El proyecto no usa `main()`: el "punto de entrada" es el propio runner de JUnit 5 a través de `mvn test`, que descubre y ejecuta la suite automáticamente.

**EN:** The project has no `main()`: the "entry point" is JUnit 5's runner itself through `mvn test`, which discovers and executes the suite automatically.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
