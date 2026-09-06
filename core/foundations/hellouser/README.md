# Hello, User! — Java

Implementación de la especificación [02_Hello_User](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) en **Java**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
| ------- | --------- |
| [`HelloUser.java`](HelloUser.java) | Código fuente: solicita el nombre del usuario mediante `Scanner`, lo guarda en `name` y saluda. |

**Estructura de directorios esperada:**

```text
hellouser/
├── HelloUser.java   # Código fuente
└── README.md        # Este archivo
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding (Maven/Gradle). Un único archivo `.java` con una clase pública cuyo nombre coincide con el del archivo es suficiente para compilar y ejecutar.

**EN:** The project was created manually, without scaffolding tools (Maven/Gradle). A single `.java` file with a public class matching the file name is enough to compile and run.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p java/core/foundations/hellouser
   ```

2. Escribir el archivo `HelloUser.java` con el código fuente.

3. No se necesita ningún paso adicional de construcción o vinculación de dependencias.

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se requieren archivos de configuración de build. El compilador (`javac`) y el lanzador (`java`) se invocan directamente desde línea de comandos.

```java
// HelloUser.java
import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
    }
}
```

| Elemento | Propósito |
| -------- | --------- |
| `Scanner scanner = new Scanner(System.in)` | Crea un lector de la entrada estándar (`stdin`). |
| `System.out.print(...)` | Imprime el mensaje de solicitud sin salto de línea al final. |
| `scanner.nextLine()` | Lee la línea de texto ingresada por el usuario y la almacena en `name`. |
| `System.out.println(...)` | Imprime el saludo con salto de línea al final. |

---

## 🚀 Compilación y ejecución / Build & Run

### Compilar / Compile

```bash
cd java/core/foundations/hellouser
javac HelloUser.java
```

### Ejecutar / Run

```bash
java HelloUser
```

### Salida esperada / Expected output

```text
Enter your name: John
Hello, John!
```

> **ES:** Reemplaza `John` por cualquier nombre que ingrese el usuario.
> **EN:** Replace `John` with whatever name the user enters.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
