# Data Structures Advanced — Java

Implementación de la especificación [07_Data_Structures_Advanced](https://yorche3.github.io/programming_languages/core/algorithms/07_Data_Structures_Advanced/) en **Java**, con un enfoque manual y minimalista.

**ES:** Implementa un árbol binario de búsqueda (`BinaryTree`) y un grafo dirigido (`Graph`) sobre una jerarquía de nodos derivada de una clase base abstracta `Node` (`TreeNode` y `GraphNode`), con registro canónico enlazado y sin estructuras de mapas, conjuntos ni índices de la biblioteca estándar. Se construye y prueba con **Maven** y **JUnit 5 (Jupiter)**.

**EN:** Implements a binary search tree (`BinaryTree`) and a directed graph (`Graph`) over a node hierarchy derived from an abstract base class `Node` (`TreeNode` and `GraphNode`), using a canonical linked registry and avoiding standard library maps, sets, or index lookups. Built and tested with **Maven** and **JUnit 5 (Jupiter)**.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directory | Propósito / Purpose |
|---|---|
| [`src/main/java/data_structures_advanced/Node.java`](src/main/java/data_structures_advanced/Node.java) | Clase base abstracta `Node` con el valor encapsulado / Abstract base class `Node` carrying encapsulated value |
| [`src/main/java/data_structures_advanced/TreeNode.java`](src/main/java/data_structures_advanced/TreeNode.java) | Nodo de árbol binario derivado de `Node` con enlaces `left` y `right` / Binary tree node extending `Node` with `left` and `right` links |
| [`src/main/java/data_structures_advanced/BinaryTree.java`](src/main/java/data_structures_advanced/BinaryTree.java) | Árbol binario de búsqueda con operaciones `insert`, `contains`, `isEmpty`, `size` / Binary search tree with `insert`, `contains`, `isEmpty`, `size` operations |
| [`src/main/java/data_structures_advanced/GraphNode.java`](src/main/java/data_structures_advanced/GraphNode.java) | Nodo de grafo derivado de `Node` con adyacencia ordenada y puntero `nextVertex` / Graph node extending `Node` with sorted adjacency and `nextVertex` pointer |
| [`src/main/java/data_structures_advanced/Graph.java`](src/main/java/data_structures_advanced/Graph.java) | Grafo dirigido con registro canónico enlazado y adyacencia ordenada / Directed graph with canonical linked registry and sorted adjacency |
| [`src/test/java/data_structures_advanced/DataStructuresAdvancedTest.java`](src/test/java/data_structures_advanced/DataStructuresAdvancedTest.java) | Suite JUnit 5 (23 pruebas) / JUnit 5 test suite (23 tests) |
| [`pom.xml`](pom.xml) | Configuración Maven / Maven build configuration |
| [`.gitignore`](.gitignore) | Ignora `target/` / Ignores `target/` |

**Nota de desviación / Deviation note:**

**ES:** La especificación propone `src/data_structures_advanced.ext` y `test/` con `run_tests.ext`. Este módulo usa el layout estándar de Maven (`src/main/java/` y `src/test/java/`), un fichero por tipo (`Node`, `TreeNode`, `BinaryTree`, `GraphNode`, `Graph`) en el paquete `data_structures_advanced`, y no tiene `run_tests`: `mvn test` descubre y ejecuta la suite.

**EN:** The specification proposes `src/data_structures_advanced.ext` and `test/` with `run_tests.ext`. This module uses the standard Maven layout (`src/main/java/` and `src/test/java/`), one file per type (`Node`, `TreeNode`, `BinaryTree`, `GraphNode`, `Graph`) in package `data_structures_advanced`, and has no `run_tests`: `mvn test` discovers and runs the suite.

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Proyecto Maven creado manualmente, siguiendo el patrón de [`data_structures_basics`](../data_structures_basics/) y [`numbers`](../../foundations/numbers/): layout estándar y JUnit 5. No se ejecutó ningún comando de inicialización. La forma del contrato es la API pública de cada clase; no se declara `interface` porque hay una sola implementación por estructura.

**EN:** Maven project created by hand, following the pattern of [`data_structures_basics`](../data_structures_basics/) and [`numbers`](../../foundations/numbers/): standard layout and JUnit 5. No initialization command was run. The contract form is each class's public API; no `interface` is declared because there is a single implementation per structure.

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
[INFO] --- compiler:3.15.0:compile (default-compile) @ data_structures_advanced ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 5 source files with javac [debug release 25] to target/classes
[INFO] --- compiler:3.15.0:testCompile (default-testCompile) @ data_structures_advanced ---
[INFO] Recompiling the module because of changed dependency.
[INFO] Compiling 1 source file with javac [debug release 25] to target/test-classes
[INFO] --- surefire:3.5.2:test (default-test) @ data_structures_advanced ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO]  T E S T S
[INFO] Running data_structures_advanced.DataStructuresAdvancedTest
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.054 s -- in data_structures_advanced.DataStructuresAdvancedTest
[INFO] Results:
[INFO] Tests run: 23, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

**ES:** Salida copiada de la última ejecución real (líneas relevantes). `javac -Xlint:all` sobre `src/main` y compilación de tests terminan sin warnings ni errores.

**EN:** Output copied from the last real run (relevant lines). `javac -Xlint:all` over `src/main` and test compilation finish with no warnings or errors.

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node.getValue` | `→ int` | `O(1)` | Base abstracta `Node`; solo almacena valor / Abstract base `Node`; stores value only |
| `new TreeNode(value)` / `getValue` / `getLeft` / `getRight` | `int → TreeNode`; `→ int`; `→ TreeNode`; `→ TreeNode` | `O(1)` | Constructor hereda de `Node`; enlaces iniciales `null` / Constructor calls `super(value)`; links start as `null` |
| `TreeNode.setLeft` / `setRight` | `TreeNode → void` | `O(1)` | Actualiza enlace mutable; admite `null` / Updates mutable link; admits `null` |
| `new BinaryTree()` / `isEmpty` / `size` | `→ BinaryTree`; `→ boolean`; `→ int` | `O(1)` | Raíz `null`, contador `count = 0` / Root `null`, counter `count = 0` |
| `BinaryTree.insert` | `int → boolean` | `O(h)` | Inserción iterativa en ABB; duplicado no incrementa tamaño y retorna `true` / Iterative BST insertion; duplicates do not grow size and return `true` |
| `BinaryTree.contains` | `int → boolean` | `O(h)` | Búsqueda iterativa siguiendo invariante ABB; `false` si ausente / Iterative search following BST invariant; `false` if absent |
| `new GraphNode(label)` | `int → GraphNode` | `O(1)` | Package-private; hereda de `Node`; `nextVertex = null`; vecinos vacíos / Package-private; extends `Node`; `nextVertex = null`; empty neighbours |
| `new Graph()` / `isEmpty` / `vertexCount` / `edgeCount` | `→ Graph`; `→ boolean`; `→ int`; `→ int` | `O(1)` | Registro de vértices vacío (`null`); contadores `0` / Empty vertex registry (`null`); counters `0` |
| `Graph.addVertex` | `int → boolean` | `O(V)` | Búsqueda manual en registro canónico; prepend si es nuevo; duplicado es idempotente / Manual traversal of canonical registry; prepends if new; duplicate is idempotent |
| `Graph.addEdge` | `int, int → boolean` | `O(V + d(u))` | Requiere extremos existentes; inserción ordenada sin duplicados; bucles permitidos / Requires existing endpoints; sorted insertion without duplicates; self-loops allowed |
| `Graph.hasEdge` | `int, int → boolean` | `O(V + d(u))` | Localiza `u` en registro (`O(V)`) y busca `v` en adyacencia ordenada (`O(d(u))`) / Finds `u` in registry (`O(V)`) and searches `v` in sorted adjacency (`O(d(u))`) |
| `Graph.getNeighbors` | `int → List<Integer>` | `O(V + d(u))` | Retorna copia defensiva independiente de la lista ordenada; `null` si `u` no existe / Returns independent defensive copy of sorted list; `null` if `u` is missing |

**ES:** Una fila por grupo de operaciones del contrato; el ABB y el grafo se implementan con algoritmos manuales iterativos.

**EN:** One row per group of contract operations; BST and graph are implemented with iterative manual algorithms.

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| Herencia con clase abstracta `Node` para `TreeNode` y `GraphNode` | Valor embebido (composición sin clase base) | Java soporta herencia directa de clases; modela la base `Node(value)` compartida sin duplicar el campo ni validaciones / Java natively supports class inheritance; models the shared `Node(value)` base without duplicating fields or validations |
| Registro de vértices como lista enlazada canónica propia (`GraphNode.nextVertex`) | `HashMap<Integer, GraphNode>` o array preasignado | La especificación prohíbe delegar el registro en mapas o tablas hash; modela vértices explícitos no indexados con búsqueda manual `O(V)` / Specification forbids delegating vertex registry to maps or hash tables; models explicit unindexed vertices with manual `O(V)` traversal |
| `ArrayList<Integer>` como almacenamiento de vecinos con inserción ordenada manual | Lista enlazada propia `NeighborNode` o `TreeSet<Integer>` | La especificación permite listas estándar para almacenar vecinos pero exige ordenación e inserción manuales sin delegar en colecciones ordenadas / Specification allows standard lists for neighbour storage but requires manual search and sorted insertion without delegating to sorted collections |
| Copia defensiva `new ArrayList<>(vertexU.neighbors)` en `getNeighbors` | Devolver vista inmodificable `Collections.unmodifiableList` o referencia directa | Asegura aislamiento total frente a modificaciones de la copia o mutaciones posteriores del grafo por `addEdge` / Ensures total isolation against copy modifications and subsequent graph mutations via `addEdge` |

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| `init(...)` como operación explícita | Constructores: `new TreeNode(value)`, `new BinaryTree()`, `new GraphNode(label)`, `new Graph()` | En Java no existe una instancia sin inicializar; los constructores ejecutan la inicialización / In Java there is no uninitialized instance; constructors perform initialization |
| `set_left(node)` y `set_right(node)` devuelven `this` | Métodos mutadores devuelven `void` | Convención estándar JavaBeans / mutadores en Java imperativo; el valor observable (enlace) es idéntico / Standard JavaBeans / mutator convention in imperative Java; observable link value is identical |
| `absent` para enlaces de nodos y raíz de árbol | Referencia `null` | Representación nativa y canónica de ausencia de referencia en Java / Native and canonical representation of reference absence in Java |
| `BinaryTree.contains` y `Graph.hasEdge` retornan éxito / fallo | `boolean` (`true` / `false`) | Indicador idiomático no ambiguo de pertenencia en Java / Idiomatic, unambiguous boolean indicator of membership in Java |
| `Graph.get_neighbors(u)` retorna fallo si `u` no existe | Referencia `null` | Distingue un vértice inexistente (`null`) de un vértice aislado con vecinos vacíos (`[]`) / Distinguishes a missing vertex (`null`) from an isolated vertex with empty neighbours (`[]`) |
| `NeighborNode` enlazado en pseudocódigo | `ArrayList<Integer>` con búsqueda e inserción ordenada manual (`insertNeighbor`) | La especificación autoriza expresamente colecciones de biblioteca para almacenamiento de adyacencia siempre que se gestionen manualmente / Specification explicitly permits library collections for adjacency storage provided operations are manual |

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `TreeNode.getLeft` / `getRight` | Subárbol o enlace ausente / Absent link or subtree | `null` | `new TreeNode(10).getLeft()` → `null` |
| `TreeNode.setLeft` / `setRight` | Sin fallo / No failure | `void` | `node.setLeft(null)` |
| `BinaryTree.contains` | Valor ausente en árbol / Value absent from tree | `false` | `tree.contains(99)` → `false` |
| `BinaryTree.insert` | Sin fallo contractual (duplicado es idempotente) / No contractual failure (duplicate is idempotent) | `true` | `tree.insert(50)` → `true` |
| `Graph.addEdge` | Extremo `u` o `v` inexistente / Missing endpoint `u` or `v` | `false` | `graph.addEdge(10, 99)` → `false` |
| `Graph.hasEdge` | Arista inexistente o extremo ausente / Missing edge or missing endpoint | `false` | `graph.hasEdge(10, 30)` → `false` |
| `Graph.getNeighbors` | Vértice `u` inexistente / Missing vertex `u` | `null` | `graph.getNeighbors(99)` → `null` |
| `Graph.addVertex` | Sin fallo contractual (duplicado es idempotente) / No contractual failure (duplicate is idempotent) | `true` | `graph.addVertex(10)` → `true` |
| Entrada nula (primitivos) / Null input (primitives) | No aplica: parámetros de valor y etiqueta son `int` primitivo / Not applicable: value and label parameters are primitive `int` | No representable / Not representable | — |
| Entrada nula (referencias `TreeNode`) | `setLeft(null)` o `setRight(null)` desenlaza el subárbol / unlinks the subtree | `void` | `node.setLeft(null)` |

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| `TreeNode`: crear un nodo de árbol / Create a tree node | Sí / Yes | `treeNodeCreateStoresValue` (`DataStructuresAdvancedTest.java:48-51`) | `TreeNode` hereda valor de `Node` |
| `TreeNode`: enlaces iniciales ausentes / Absent initial links | Sí / Yes | `treeNodeInitialLinksAbsent` (`:54-58`) | Verifica `getLeft() == null` y `getRight() == null` |
| `TreeNode`: enlazar dos hijos / Link two children | Sí / Yes | `treeNodeLinkTwoChildren` (`:61-71`) | Comprueba enlaces y valores 20 y 30 |
| `TreeNode`: recorrer cada enlace / Traverse each link | Sí / Yes | `treeNodeTraverseEachLink` (`:74-88`) | Verifica hijos y enlaces terminales nulos |
| `TreeNode`: desenlazar hijos / Unlink children | Sí / Yes | `treeNodeUnlinkChildren` (`:91-107`) | Desenlaza izquierdo y derecho con `null` |
| `TreeNode`: adaptación inmutable / Immutable adaptation | Omitido / Omitted | No aplica / Not applicable (`:325-327`) | Java usa `TreeNode` mutable estándar |
| `BinaryTree`: crear vacío / Create empty | Sí / Yes | `binaryTreeCreateEmpty` (`:112-117`) | `isEmpty() == true`, `size() == 0`, `contains(50) == false` |
| `BinaryTree`: insertar la raíz / Insert the root | Sí / Yes | `binaryTreeInsertRoot` (`:120-126`) | Éxito, `size() == 1`, `contains(50) == true` |
| `BinaryTree`: insertar menor y mayor / Insert lower and higher | Sí / Yes | `binaryTreeInsertLowerAndHigher` (`:129-136`) | Inserta 50, 30, 70; comprueba tamaño 3 y pertenencia |
| `BinaryTree`: ramas de varios niveles / Multilevel branches | Sí / Yes | `binaryTreeMultilevelBranches` (`:139-147`) | Inserta 50, 30, 70, 20, 40; tamaño 5 |
| `BinaryTree`: valor ausente en árbol no vacío / Missing value in nonempty tree | Sí / Yes | `binaryTreeMissingValueInNonEmptyTree` (`:150-156`) | `contains(99) == false`, tamaño 1 |
| `BinaryTree`: duplicado idempotente / Idempotent duplicate | Sí / Yes | `binaryTreeIdempotentDuplicate` (`:159-167`) | Inserta 50, 30, 70, 30; tamaño 3 y valores conservados |
| `BinaryTree`: inserciones ordenadas / Ordered insertions | Sí / Yes | `binaryTreeOrderedInsertions` (`:170-179`) | Inserta 20, 30, 40, 50, 70; tamaño 5; 99 ausente |
| `Graph`: crear vacío / Create empty | Sí / Yes | `graphCreateEmpty` (`:184-190`) | `isEmpty() == true`, contadores 0, `hasEdge` false, vecinos `null` |
| `Graph`: vértice aislado / Isolated vertex | Sí / Yes | `graphIsolatedVertex` (`:193-199`) | 1 vértice, 0 aristas, vecinos de 10 es lista vacía `[]` |
| `Graph`: etiquetas no consecutivas y arista dirigida / Nonconsecutive labels and directed edge | Sí / Yes | `graphNonconsecutiveLabelsAndDirectedEdge` (`:202-210`) | 10 y 70; `hasEdge(10,70) == true`, `hasEdge(70,10) == false` |
| `Graph`: vértice duplicado conserva adyacencia / Duplicate vertex preserves adjacency | Sí / Yes | `graphDuplicateVertexPreservesAdjacency` (`:213-222`) | Reinsertar 10 conserva 2 vértices, 1 arista y vecinos `[30]` |
| `Graph`: arista duplicada / Duplicate edge | Sí / Yes | `graphDuplicateEdge` (`:225-234`) | `addEdge(10,30)` dos veces; 1 arista, vecinos `[30]` |
| `Graph`: extremo inexistente sin mutación / Missing endpoint without mutation | Sí / Yes | `graphMissingEndpointWithoutMutation` (`:237-258`) | Falla 10->99, 99->10, 98->99, 99->99 sin mutar estado |
| `Graph`: vecinos ordenados y contadores / Sorted neighbours and counts | Sí / Yes | `graphSortedNeighboursAndCounts` (`:261-277`) | Vecinos de 10 son `[30, 50, 70]`; 4 vértices, 4 aristas |
| `Graph`: consulta de arista ausente / Missing-edge query | Sí / Yes | `graphMissingEdgeQuery` (`:280-287`) | `hasEdge(10,30) == false` con 2 vértices y 0 aristas |
| `Graph`: vecinos de vértice inexistente / Neighbours of missing vertex | Sí / Yes | `graphNeighboursOfMissingVertex` (`:290-297`) | `getNeighbors(99) == null`, distinto de `getNeighbors(10) == []` |
| `Graph`: bucle y duplicado / Self-loop and duplicate | Sí / Yes | `graphSelfLoopAndDuplicate` (`:300-308`) | `addEdge(10,10)` dos veces; `hasEdge(10,10) == true`, vecinos `[10]` |
| `Graph`: aislamiento del resultado de vecinos / Neighbour-result isolation | Sí / Yes | `graphNeighbourResultIsolation` (`:311-337`) | Modificar la copia devuelta o agregar aristas no altera el resultado previo |

## ⚠️ Limitaciones conocidas / Known limitations

| Limitación / Limitation | Impacto / Impact | Alternativa o plan / Workaround or plan |
|---|---|---|
| Ninguna / None | No aplica / Not applicable | El módulo cumple íntegramente el contrato de la especificación sin restricciones de capacidad ni dependencias externas / The module fully satisfies the specification contract with no capacity limits or external dependencies |

## 📝 Notas de implementación / Implementation Notes

**ES:**
- `Node` es una clase abstracta que encapsula únicamente el valor primitivo `int` y su getter `getValue()`. No tiene validaciones ni indicadores de fallo.
- `TreeNode` hereda de `Node` e introduce punteros mutables `left` y `right` hacia otros `TreeNode`. La ausencia de hijo se representa con `null`.
- `BinaryTree` implementa un árbol binario de búsqueda sin límite de capacidad. Las operaciones `insert` y `contains` son iterativas, evitando consumo de pila de llamadas (sin riesgo de desbordamiento ni dependencia de TCO).
- `GraphNode` es una clase con visibilidad de paquete que hereda de `Node`. Mantiene el puntero `nextVertex` para encadenar el registro canónico de vértices y una lista interna `neighbors`.
- `Graph` mantiene el registro de vértices mediante una lista enlazada canónica manual iniciada en `this.vertices`. La búsqueda de vértices (`findVertex`) recorre los nodos secuencialmente con coste `O(V)`.
- La adyacencia de cada vértice se mantiene en orden creciente mediante inserción ordenada manual (`insertNeighbor`), verificando duplicados y bucles sin recurrir a colecciones ordenadas (`TreeSet`) ni diccionarios (`Map`).
- Caso nulo: las operaciones públicas reciben primitivos `int`, por lo que no existe entrada nula en valores ni etiquetas. La ausencia de enlace o vértice inexistente se modela con `null` (`TreeNode.getLeft()`, `Graph.getNeighbors()`).
- Aislamiento: `Graph.getNeighbors` retorna una nueva instancia `new ArrayList<>(vertexU.neighbors)`, garantizando que las modificaciones externas no afecten al grafo y que inserciones posteriores no muten listas previamente consultadas.

**EN:**
- `Node` is an abstract class encapsulating only the primitive `int` value and its `getValue()` getter. It has no validations or failure indicators.
- `TreeNode` extends `Node` and introduces mutable `left` and `right` pointers to other `TreeNode` instances. Absence of child is represented as `null`.
- `BinaryTree` implements an unbounded binary search tree. `insert` and `contains` operations are iterative, avoiding call stack consumption (no stack overflow risk and no dependency on TCO).
- `GraphNode` is a package-private class extending `Node`. It holds the `nextVertex` pointer to link the canonical vertex registry and an internal `neighbors` list.
- `Graph` manages the vertex registry via a manual canonical linked list starting at `this.vertices`. Vertex lookup (`findVertex`) traverses nodes sequentially with `O(V)` cost.
- Adjacency for each vertex is kept in ascending order via manual sorted insertion (`insertNeighbor`), checking for duplicates and self-loops without relying on sorted collections (`TreeSet`) or maps (`Map`).
- Null case: public operations accept primitive `int` parameters, so there is no null input for values or labels. Reference absence or missing vertices are modeled with `null` (`TreeNode.getLeft()`, `Graph.getNeighbors()`).
- Isolation: `Graph.getNeighbors` returns a fresh instance `new ArrayList<>(vertexU.neighbors)`, ensuring external modifications do not affect the graph and subsequent edge additions do not alter previously retrieved lists.

**ES:** Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

**EN:** This project is also implemented in other languages. Explore the main repository to see the other versions.

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_ (o `Omitido` con razón).
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`07_Data_Structures_Advanced`](https://yorche3.github.io/programming_languages/core/algorithms/07_Data_Structures_Advanced/) |
| Primera base del lenguaje / First language reference | `data_structures_basics` — [`../data_structures_basics/`](../data_structures_basics/) |
| Segunda base del lenguaje / Second language reference | `numbers` — [`../../foundations/numbers/`](../../foundations/numbers/) |
| Guía de inicialización / Initialisation guide | [`core/00_Project_Initialization_Guide.md`](https://yorche3.github.io/programming_languages/core/00_Project_Initialization_Guide/) |
| Adaptaciones idiomáticas / Idiomatic adaptations | [`AGENT_Template.md`](https://yorche3.github.io/programming_languages/AGENT_Template/) |
| Validación de la documentación / Documentation validation | [`WORKFLOW.md`](https://yorche3.github.io/programming_languages/WORKFLOW/) |
| Documentación oficial del lenguaje / Language official docs | [Java SE 25 Documentation](https://docs.oracle.com/en/java/) |
