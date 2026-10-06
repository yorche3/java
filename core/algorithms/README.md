# Algorithms Pure — Java

Implementaciones de la [Fase 1 — Algoritmos Puros](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-) en **Java** sobre la JVM: ordenamientos elementales, estructuras de datos propias (lista enlazada, pila y cola), ordenamientos óptimos y distribuidos, y búsqueda.

Los módulos de esta fase trabajan sobre `int[]`, que en Java **es mutable**, **admite `null`** y se ordena *in-place*.

---

## 📂 Módulos / Modules

| Módulo | Especificación | Enfoque | Tests | Estado |
|--------|---------------|---------|:-----:|:------:|
| [`naive_sort/`](naive_sort/) | [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) | `mvn test` + JUnit 5 | 3 | ✅ |
| [`data_structures_basics/`](data_structures_basics/) | [06_Data_Structures_Basics](https://yorche3.github.io/programming_languages/core/algorithms/06_Data_Structures_Basics/) | `mvn test` + JUnit 5 | 23 | ✅ |

---

## 📁 Estructura / Structure

```text
algorithms/
├── naive_sort/                       # 05_Naive_Sort
    ├── pom.xml
    ├── .gitignore                    # target/
    ├── src/
    │   ├── main/java/naive_sort/
    │   │   └── NaiveSort.java        # selectionSort, bubbleSort, insertionSort
    │   └── test/java/naive_sort/
    │       └── NaiveSortTest.java    # 3 tests × (7 casos + caso nulo)
    └── README.md
└── data_structures_basics/           # 06_Data_Structures_Basics
    ├── pom.xml
    ├── .gitignore                    # target/
    ├── src/
    │   ├── main/java/data_structures_basics/
    │   │   ├── Node.java             # celda enlazada
    │   │   ├── LinkedList.java       # head, tail, count
    │   │   ├── Stack.java            # LIFO
    │   │   └── Queue.java            # FIFO
    │   └── test/java/data_structures_basics/
    │       └── DataStructuresBasicsTest.java  # 23 tests
    └── README.md
```

---

## 🛠️ Patrón común / Common Pattern

| Característica | Descripción |
|---------------|-------------|
| **Runtime** | JVM (JDK 25 en este entorno; `release` se declara por módulo) |
| **CLI** | `mvn compile`, `mvn test` |
| **Build** | Maven, layout estándar `src/main/java` ↔ `src/test/java` |
| **Manifiesto** | `pom.xml` en la raíz del módulo (layout plano, no anidado) |
| **Framework de tests** | JUnit 5 (`junit-jupiter`), con `maven-surefire-plugin` |
| **Descubrimiento** | Surefire ejecuta todos los métodos anotados con `@Test` |
| **Entry point** | No aplica: es una biblioteca, sin `main` |
| **Iteración** | Bucles `for`/`while` explícitos sobre `int[]` |
| **Visibilidad** | Métodos `public static` en la clase del módulo; helpers `private static` |
| **Naming** | `camelCase` (`selectionSort`); clases en `PascalCase`, paquete = nombre del módulo |
| **Indicador de fallo** | `null` en `naive_sort` (se devuelve tal cual); `-1` en `data_structures_basics` (estructura vacía); sin lanzar excepciones |
| **Nivel de Java** | `maven.compiler.release` 25 en todos los módulos del submódulo |
| **Artefactos** | `target/` — ignorado en `.gitignore` |

---

## 🚀 Compilación rápida / Quick Build

```bash
# Naive Sort Tests
cd naive_sort
mvn test

# Data Structures Basics Tests
cd ../data_structures_basics
mvn test
```

---

### 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

## ▶️ Siguiente / Next

👉 Continúa con los módulos pendientes de esta fase en el [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).
👉 Continue with the pending modules of this phase in the [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).

---

*[← Volver a Core](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
