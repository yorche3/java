# Hello, World! — Java

Implementación de la especificación [01_Hello_World](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) en **Java**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
| ------- | --------- |
| [`HelloWorld.java`](HelloWorld.java) | Código fuente: clase `HelloWorld` con el punto de entrada `main` que imprime `"Hello, World! from Java!"`. |

**Estructura de directorios esperada:**

```text
helloworld/
├── HelloWorld.java   # Código fuente
├── HelloWorld.class  # Bytecode compilado (generado por javac)
└── README.md         # Este archivo
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding (Maven/Gradle), para mantener la máxima sencillez. Un único archivo `.java` con una clase pública cuyo nombre coincide con el del archivo es suficiente para compilar y ejecutar.

**EN:** The project was created manually, without scaffolding tools (Maven/Gradle), to keep it as simple as possible. A single `.java` file with a public class matching the file name is enough to compile and run.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p java/core/foundations/helloworld
   ```

2. Escribir el archivo `HelloWorld.java` con el código fuente.

3. No se necesita ningún paso adicional de construcción o vinculación de dependencias.

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se requieren archivos de configuración de build. El compilador (`javac`) y el lanzador (`java`) se invocan directamente desde línea de comandos.

```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World! from Java!");
    }
}
```

| Elemento | Propósito |
| -------- | --------- |
| `public class HelloWorld` | Clase principal; el archivo debe llamarse `HelloWorld.java`. |
| `public static void main(String[] args)` | Punto de entrada del programa. |
| `System.out.println(...)` | Imprime una línea con salto de línea al final en la salida estándar. |

---

## 🚀 Compilación y ejecución / Build & Run

### Compilar / Compile

```bash
cd java/core/foundations/helloworld
javac HelloWorld.java
```

### Ejecutar / Run

```bash
java HelloWorld
```

### Salida esperada / Expected output

```text
Hello, World! from Java!
```

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
