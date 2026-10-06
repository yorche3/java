# Data Structures Basics — Java

Implementación de la especificación [06_Data_Structures_Basics](https://yorche3.github.io/programming_languages/core/algorithms/06_Data_Structures_Basics/) en **Java**, con un enfoque manual y minimalista.

**ES:** Implementa `Node`, `LinkedList`, `Stack` y `Queue` desde cero sobre un único tipo `Node`, sin colecciones de la biblioteca estándar. Se construye y prueba con **Maven** y **JUnit 5 (Jupiter)**.

**EN:** Implements `Node`, `LinkedList`, `Stack` and `Queue` from scratch over a single `Node` type, with no standard-library collections. Built and tested with **Maven** and **JUnit 5 (Jupiter)**.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directory | Propósito / Purpose |
|---|---|
| [`src/main/java/data_structures_basics/Node.java`](src/main/java/data_structures_basics/Node.java) | Celda enlazada compartida / Shared linked cell |
| [`src/main/java/data_structures_basics/LinkedList.java`](src/main/java/data_structures_basics/LinkedList.java) | Lista enlazada con `head`, `tail` y `count` / Linked list with `head`, `tail` and `count` |
| [`src/main/java/data_structures_basics/Stack.java`](src/main/java/data_structures_basics/Stack.java) | Pila LIFO con `top` y `count` / LIFO stack with `top` and `count` |
| [`src/main/java/data_structures_basics/Queue.java`](src/main/java/data_structures_basics/Queue.java) | Cola FIFO con `front`, `rear` y `count` / FIFO queue with `front`, `rear` and `count` |
| [`src/test/java/data_structures_basics/DataStructuresBasicsTest.java`](src/test/java/data_structures_basics/DataStructuresBasicsTest.java) | Suite JUnit 5 (23 pruebas) / JUnit 5 suite (23 tests) |
| [`pom.xml`](pom.xml) | Configuración Maven / Maven build configuration |
| [`.gitignore`](.gitignore) | Ignora `target/` / Ignores `target/` |

**Nota de desviación / Deviation note:**

**ES:** La especificación propone `src/data_structures_basics.ext` y `test/` con `run_tests.ext`. Este módulo usa el layout estándar de Maven (`src/main/java/` y `src/test/java/`), un fichero por tipo (`Node`, `LinkedList`, `Stack`, `Queue`) en el paquete `data_structures_basics`, y no tiene `run_tests`: `mvn test` descubre y ejecuta la suite.

**EN:** The specification proposes `src/data_structures_basics.ext` and `test/` with `run_tests.ext`. This module uses the standard Maven layout (`src/main/java/` and `src/test/java/`), one file per type (`Node`, `LinkedList`, `Stack`, `Queue`) in package `data_structures_basics`, and has no `run_tests`: `mvn test` discovers and runs the suite.

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Proyecto Maven creado manualmente, con el mismo patrón que [`numbers`](../../foundations/numbers/): layout estándar y JUnit 5. No se ejecutó ningún comando de inicialización. La forma del contrato es la API pública de cada clase; no se declara `interface` porque hay una sola implementación por estructura.

**EN:** Maven project created by hand, following the same pattern as [`numbers`](../../foundations/numbers/): standard layout and JUnit 5. No initialization command was run. The contract form is each class's public API; no `interface` is declared because there is a single implementation per structure.

## 📄 Configuración clave / Key Configuration

| Archivo / File | Contenido / Contents |
|---|---|
| [`pom.xml`](pom.xml) | `maven.compiler.release` = `25`; dependencia de test `org.junit.jupiter:junit-jupiter` `5.11.3`; `maven-surefire-plugin` `3.5.2` / `maven.compiler.release` = `25`; test dependency `org.junit.jupiter:junit-jupiter` `5.11.3`; `maven-surefire-plugin` `3.5.2` |

## 🚀 Compilación y ejecución / Build & Run

```bash
mvn -B clean test
```

**ES:** El módulo es una biblioteca: no tiene punto de entrada, así que no hay comando de ejecución distinto de las pruebas.

**EN:** The module is a library: it has no entry point, so there is no run command other than the tests.

**Salida real / Actual output:**

```text
[INFO] --- compiler:3.15.0:compile (default-compile) @ data_structures_basics ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 4 source files with javac [debug release 25] to target/classes
[INFO] --- compiler:3.15.0:testCompile (default-testCompile) @ data_structures_basics ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug release 25] to target/test-classes
[INFO] --- surefire:3.5.2:test (default-test) @ data_structures_basics ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]  T E S T S
[INFO] Running data_structures_basics.DataStructuresBasicsTest
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.059 s -- in data_structures_basics.DataStructuresBasicsTest
[INFO] Results:
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

**ES:** Salida copiada de la última ejecución real (líneas relevantes). `javac -Xlint:all` sobre `src/main` termina sin warnings ni errores.

**EN:** Output copied from the last real run (relevant lines). `javac -Xlint:all` over `src/main` finishes with no warnings or errors.

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `new Node(value)` / `getValue` / `getNext` / `setNext` | `int → Node`; `→ int`; `→ Node`; `Node → void` | `O(1)` | `init` = constructor; `setNext` muta |
| `new LinkedList()` / `isEmpty` / `size` | `→ LinkedList`; `→ boolean`; `→ int` | `O(1)` | Contador `count` |
| `LinkedList.getHead` | `→ int` | `O(1)` | `-1` si vacía |
| `LinkedList.insertHead` / `insertTail` | `int → void` | `O(1)` | `tail` mantenido |
| `LinkedList.delete` | `int → boolean` | `O(n)` | Primera aparición; actualiza `head` y `tail` |
| `new Stack()` / `isEmpty` / `size` | `→ Stack`; `→ boolean`; `→ int` | `O(1)` | Contador `count` |
| `Stack.push` | `int → void` | `O(1)` | Nuevo nodo sobre `top` |
| `Stack.pop` / `peek` | `→ int` | `O(1)` | `-1` si vacía; `peek` no muta |
| `new Queue()` / `isEmpty` / `size` | `→ Queue`; `→ boolean`; `→ int` | `O(1)` | Contador `count` |
| `Queue.enqueue` | `int → void` | `O(1)` | Enlaza tras `rear` |
| `Queue.dequeue` / `peek` | `→ int` | `O(1)` | `-1` si vacía; `dequeue` anula `rear` al vaciar |

**ES:** Una fila por grupo de operaciones del contrato; no hay varios enfoques del mismo algoritmo.

**EN:** One row per group of contract operations; there are no several approaches to the same algorithm.

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Valores `int` y `-1` como indicador de fallo | `Integer` anulable u `Optional<Integer>` | Evita cajas y un tipo opcional que la especificación no fuerza; el lector ve el fallo en la firma `int` / Avoids boxing and an optional type the specification does not force; the reader sees failure in the plain `int` signature |
| `Stack` y `Queue` gestionan sus propios punteros sobre `Node` | Envolver `LinkedList` | Exigido por el contrato (sin delegación) / Required by the contract (no delegation) |
| Una sola prueba parametrizada por estructura (`assert*Cases`) invocada desde una prueba por operación | Un test por paso de la tabla | Mantiene los pasos sucesivos sobre una misma instancia, como pide la especificación / Keeps successive steps on one instance, as the specification requires |

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| `init(...)` como operación explícita | Constructor: `new Node(value)`, `new LinkedList()`, `new Stack()`, `new Queue()` | En Java no existe una instancia sin inicializar; el constructor es el `init` y se ejecuta una vez / In Java there is no uninitialized instance; the constructor is `init` and runs once |
| `Node.init` devuelve `this`; `set_next` devuelve `this` | `setNext` devuelve `void` | `Node` es mutable; el valor observable (enlace) es el mismo / `Node` is mutable; the observable value (link) is the same |
| `absent` | `null` en `Node.next`, `head`, `tail`, `top`, `front`, `rear` | Representación nativa de ausencia de referencia / Native reference absence |
| `get_head`, `pop`, `peek`, `dequeue` devuelven `failure` | `-1` | Valores de prueba positivos; no colisiona con el dominio de prueba / Positive test values; no collision with the test domain |
| `delete` devuelve `success`/`failure` | `boolean` (`true`/`false`) | Indicador natural y no ambiguo / Natural, unambiguous indicator |
| `delete` con `previous`/`current` y comparación `tail == current` | Recorre con `current.getNext()` y trata la cabeza aparte; actualiza `tail` si el último nodo se elimina | Mismo comportamiento y `O(n)`; evita guardar `previous` / Same behaviour and `O(n)`; avoids storing `previous` |
| `insert_head` fija `tail` si está ausente | Rama `head == null` asigna `head` y `tail` | Equivalente observable / Observably equivalent |

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `Node.getNext` | Sin enlace / No link | `null` | `new Node(10).getNext()` → `null` |
| `LinkedList.getHead` | Lista vacía / Empty list | `-1` | `getHead()` → `-1` |
| `LinkedList.delete` | Valor ausente o lista vacía / Absent value or empty list | `false` | `delete(99)` → `false` |
| `LinkedList.insertHead` / `insertTail` | Sin fallo: no hay capacidad / No failure: no capacity | `void` | — |
| `Stack.pop` / `peek` | Pila vacía / Empty stack | `-1` | `pop()` → `-1` |
| `Stack.push` | Sin fallo / No failure | `void` | — |
| `Queue.dequeue` / `peek` | Cola vacía / Empty queue | `-1` | `dequeue()` → `-1` |
| `Queue.enqueue` | Sin fallo / No failure | `void` | — |
| `isEmpty` / `size` | Sin fallo (solo tras construir) / No failure (after construction only) | `boolean` / `int` | `size()` → `0` |
| Entrada nula / Null input | No aplica: los parámetros son `int` primitivo / Not applicable: parameters are primitive `int` | No representable / Not representable | — |

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|---|---|
| `Node`: inicializar y observar valor/enlace | Sí / Yes | `assertNodeCases` (`DataStructuresBasicsTest.java:56-60`) | Invocado por `testNodeInit`, `testNodeGetValue`, `testNodeGetNext`, `testNodeSetNext` |
| `Node`: inicializar otro, enlazar y recorrer | Sí / Yes | `assertNodeCases` (`:62-67`) | — |
| `LinkedList`: estado vacío | Sí / Yes | `assertLinkedListCases` (`:71-76`) | Siete pruebas, una por operación |
| `LinkedList`: insertar por ambos extremos | Sí / Yes | `assertLinkedListCases` (`:78-85`) | Verifica `size` y `getHead`; el orden completo se comprueba tras los `delete` |
| `LinkedList`: eliminar primera aparición | Sí / Yes | `assertLinkedListCases` (`:87-92`) | — |
| `LinkedList`: valor ausente | Sí / Yes | `assertLinkedListCases` (`:94-99`) | — |
| `LinkedList`: vaciar | Sí / Yes | `assertLinkedListCases` (`:101-111`) | — |
| `Stack`: estado vacío y extracción fallida | Sí / Yes | `assertStackCases` (`:115-122`) | Seis pruebas, una por operación |
| `Stack`: LIFO y `peek` no mutante | Sí / Yes | `assertStackCases` (`:124-130`) | — |
| `Stack`: extracción y reutilización | Sí / Yes | `assertStackCases` (`:132-143`) | — |
| `Stack`: vacío tras extracción | Sí / Yes | `assertStackCases` (`:145-148`) | — |
| `Queue`: estado vacío y extracción fallida | Sí / Yes | `assertQueueCases` (`:152-159`) | Seis pruebas, una por operación |
| `Queue`: FIFO y `peek` no mutante | Sí / Yes | `assertQueueCases` (`:161-167`) | — |
| `Queue`: extracción y reutilización | Sí / Yes | `assertQueueCases` (`:169-180`) | — |
| `Queue`: vacío tras extracción | Sí / Yes | `assertQueueCases` (`:182-185`) | — |

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| `-1` no distingue fallo de un valor `-1` almacenado | Solo si se almacenan enteros negativos; los valores de prueba son positivos | La especificación fija valores positivos; fases posteriores pueden usar otro indicador / The specification fixes positive values; later phases may use another indicator |
| Las pruebas observan el recorrido de la lista solo mediante `getHead` | No se asevera el orden completo `5, 10, 20, 10` con un recorrido | El orden se comprueba indirectamente con `delete` y `getHead` / Order is checked indirectly through `delete` and `getHead` |

## 📝 Notas de implementación / Implementation Notes

**ES:**
- `Node` es la única celda: `LinkedList`, `Stack` y `Queue` la usan directamente y ninguna delega en otra. No hay imports de otros módulos ni de `java.util`.
- `Node.value` es `final`; solo `next` es mutable.
- Caso nulo: la ausencia de enlace es `null` (`Node.next`, `head`, `tail`, `top`, `front`, `rear`). Las operaciones públicas no reciben referencias, por lo que no existe entrada nula.
- `Queue.dequeue` anula `rear` al vaciarse; `LinkedList.delete` actualiza `tail` al eliminar el último nodo.
- Las tres estructuras no tienen límite de capacidad y la recursión no se usa (sin riesgo de desbordamiento de pila ni necesidad de TCO).

**EN:**
- `Node` is the only cell: `LinkedList`, `Stack` and `Queue` use it directly and none delegates to another. No imports from other modules or `java.util`.
- `Node.value` is `final`; only `next` is mutable.
- Null case: link absence is `null` (`Node.next`, `head`, `tail`, `top`, `front`, `rear`). Public operations take no references, so there is no null input.
- `Queue.dequeue` clears `rear` on emptying; `LinkedList.delete` updates `tail` when the last node is removed.
- The three structures have no capacity limit and recursion is not used (no stack overflow risk and no TCO needed).

**ES:** Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

**EN:** This project is also implemented in other languages. Explore the main repository to see the other versions.

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_.
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

**EN:** The full list, per artefact, lives in `WORKFLOW.md` of the monorepo; these seven points are the minimum for the module README.

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`06_Data_Structures_Basics`](https://yorche3.github.io/programming_languages/core/algorithms/06_Data_Structures_Basics/) |
| Módulo homologado del lenguaje / Homologated module | [`java/core/foundations/numbers/`](../../foundations/numbers/) |
| Documentación oficial del lenguaje / Language official docs | [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) |

**ES:** Solo referencias consultadas de verdad.

**EN:** Only references actually consulted.
