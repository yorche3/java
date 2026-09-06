# Numbers — Java

Implementación de la especificación [04_Numbers](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) en **Java**, usando **Maven** y **JUnit 5 (Jupiter)**.

Tres enfoques de implementación para los mismos 5 algoritmos: **recursivo directo** (`_rec`), **recursivo con acumulador** (`_acc`) e **iterativo** (`_ite`).

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
| ------- | --------- |
| [`pom.xml`](pom.xml) | Proyecto Maven — declara Java 17 y la dependencia de test `junit-jupiter`. |
| [`src/main/java/numbers/Numbers.java`](src/main/java/numbers/Numbers.java) | Clase `Numbers` — 15 métodos (3 enfoques × 5 algoritmos) + 4 helpers `private static`. |
| [`src/test/java/numbers/NumbersRecursiveTest.java`](src/test/java/numbers/NumbersRecursiveTest.java) | 5 pruebas para el enfoque recursivo directo (11 casos). |
| [`src/test/java/numbers/NumbersIterativeTest.java`](src/test/java/numbers/NumbersIterativeTest.java) | 5 pruebas para el enfoque iterativo (11 casos). |
| [`.gitignore`](.gitignore) | Ignora `target/` (salida de compilación de Maven). |

**Estructura de directorios esperada:**

```text
numbers/
├── pom.xml                              # Proyecto Maven
├── .gitignore                           # Ignora target/
├── src/
│   ├── main/java/numbers/
│   │   └── Numbers.java                 # 15 funciones + 4 helpers private
│   └── test/java/numbers/
│       ├── NumbersRecursiveTest.java    # Tests recursivos (11 casos)
│       └── NumbersIterativeTest.java    # Tests iterativos (11 casos)
└── target/                              # Generado por Maven (no versionado)
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Sigue el mismo patrón que [`calculator`](../unit_test/calculator/): proyecto Maven con layout estándar (`src/main/java` y `src/test/java`) y JUnit 5. Las 15 funciones se organizan en 3 grupos por enfoque:

| Enfoque | Sufijo | Ejemplo | ¿Tiene tests directos? |
| ------- | ------ | ------- | :---------------------: |
| Recursivo directo | `...Rec` | `fibonacciRec(n)` | ✅ Sí |
| Recursivo con acumulador | `...Acc` | `fibonacciAcc(n)` | ❌ No (ver nota TCO) |
| Iterativo | `...Ite` | `fibonacciIte(n)` | ✅ Sí |

**EN:** Follows the same pattern as [`calculator`](../unit_test/calculator/): a Maven project with standard layout (`src/main/java` and `src/test/java`) and JUnit 5. The 15 functions are organized into 3 groups by approach:

| Approach | Suffix | Example | Direct tests? |
| -------- | ------ | ------- | :-----------: |
| Direct recursion | `...Rec` | `fibonacciRec(n)` | ✅ Yes |
| Accumulator recursion | `...Acc` | `fibonacciAcc(n)` | ❌ No (see TCO note) |
| Iterative | `...Ite` | `fibonacciIte(n)` | ✅ Yes |

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `Numbers.java` — Implementación

**ES:** Cada algoritmo tiene 3 implementaciones en un único archivo. Los helpers son `private static` (encapsulados en la clase). Por ejemplo, `fibonacci`:

**EN:** Each algorithm has 3 implementations in a single file. Helpers are `private static` (encapsulated in the class). For example, `fibonacci`:

```java
// Enfoque recursivo directo / Direct recursion
public static int fibonacciRec(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacciRec(n - 1) + fibonacciRec(n - 2);
}

// Enfoque con acumulador / Accumulator recursion
public static int fibonacciAcc(int n) {
    return fibonacciAccHelp(n, 0, 1);
}

// Helper privado con acumulador / Private accumulator helper
private static int fibonacciAccHelp(int n, int acc2, int acc1) {
    if (n <= 0) {
        return acc2;
    }
    if (n <= 2) {
        return acc1 + acc2;
    }
    return fibonacciAccHelp(n - 1, acc1, acc1 + acc2);
}

// Enfoque iterativo / Iterative
public static int fibonacciIte(int n) {
    if (n <= 1) {
        return n;
    }
    int acc2 = 0;
    int acc1 = 1;
    for (int i = 2; i <= n; i++) {
        int temp = acc1 + acc2;
        acc2 = acc1;
        acc1 = temp;
    }
    return acc1;
}
```

| Algoritmo | `_rec` | `_acc` | `_ite` |
| --------- | ------ | ------ | ------ |
| `sumOfFirstN` | `n + sumRec(n-1)` | helper con `acc + n` | bucle `1..n` |
| `factorial` | `n * factRec(n-1)` | helper con `acc * n` | bucle `2..n` |
| `fibonacci` | `fibRec(n-1) + fibRec(n-2)` | helper con `acc2, acc1` | bucle de intercambio |
| `greatestCommonDivisor` | Euclides recursivo | Euclides helper | Euclides con `while (b != 0)` |
| `leastCommonMultiple` | `(a*b) / gcdRec` | `(a*b) / gcdAcc` | `(a*b) / gcdIte` |

### `NumbersRecursiveTest.java` y `NumbersIterativeTest.java` — Pruebas

**ES:** Cada método `@Test` agrupa los casos de un algoritmo (11 aserciones por suite, 22 en total).

**EN:** Each `@Test` method groups the cases of one algorithm (11 assertions per suite, 22 in total).

```java
@Test
void testFibonacciRec() {
    assertEquals(0, Numbers.fibonacciRec(0));
    assertEquals(1, Numbers.fibonacciRec(1));
    assertEquals(8, Numbers.fibonacciRec(6));
}
```

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK 17 o superior** (`javac` y `java`).
- **Maven 3.6+** (`mvn`).

### Ejecutar las pruebas unitarias / Run tests

```bash
cd java/core/foundations/numbers
mvn test
```

### Salida esperada / Expected output

```text
[INFO] Running numbers.NumbersRecursiveTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running numbers.NumbersIterativeTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

> **ES:** Surefire cuenta 10 métodos `@Test`; los 22 casos (11 por enfoque) viven como aserciones dentro de ellos.
> **EN:** Surefire counts 10 `@Test` methods; the 22 cases (11 per approach) live as assertions within them.

---

## 🔁 Sobre recursión con acumulador y Tail Call Optimization (TCO)

**ES:**
Tail recursion ocurre cuando la llamada recursiva es la última acción que ejecuta una función/método; después de la llamada no hay más instrucciones. La recursión con acumulador consigue esto pasando el estado previo como parámetro, sin dejar trabajo pendiente en la pila.

En Java, **no se garantiza TCO**: la JVM estándar no optimiza las llamadas de cola, por lo que la versión con acumulador se conserva únicamente con fines educativos, como puente conceptual entre la recursión directa (`_rec`) y la versión iterativa (`_ite`). Como no hay un beneficio práctico de rendimiento garantizado, **no se desarrollan pruebas unitarias específicas para los métodos `_acc`**. Su comportamiento queda validado a través de las suites recursiva e iterativa, que ejercitan los mismos resultados.

**EN:**
Tail recursion occurs when the recursive call is the last action executed by a function/method; after the call there are no more instructions. Accumulator recursion achieves this by passing the previous state as a parameter, leaving no pending work on the stack.

In Java, **TCO is not guaranteed**: the standard JVM does not optimize tail calls, so the accumulator version is kept purely for educational purposes, as a conceptual bridge between direct recursion (`_rec`) and the iterative version (`_ite`). Since there is no guaranteed performance benefit, **no dedicated unit tests are written for the `_acc` methods**. Their behavior is validated through the recursive and iterative suites, which exercise the same results.

---

## 📝 Notas de implementación / Implementation Notes

**ES:** El proyecto no usa `main()`: el "punto de entrada" es el runner de JUnit 5 a través de `mvn test`.

**EN:** The project has no `main()`: the "entry point" is JUnit 5's runner through `mvn test`.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
