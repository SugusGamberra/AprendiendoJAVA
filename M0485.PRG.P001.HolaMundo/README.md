# 🌟 Proyecto: Hola Mundo en Java

> Nuestro primer contacto con Java 🥳  
> Aquí aprenderemos la estructura básica de un programa, cómo se ejecuta y cómo organizarlo correctamente en **packages**.  

---

## 🧩 Estructura de Carpetas

| Carpeta / Archivo | Descripción | Rol |
|--------------------|-------------|-----|
| `M0485.PRG.P001.HolaMundo/` | Contiene la clase principal del proyecto. | 🧠 Punto de entrada |
| `M0485.PRG.P002.HolaMundo2/` | Contiene el Ejemplo usando Packages! | 😎 Uso de Packages |
| `Inicio/` | Package de inicio donde arranca la ejecución del programa. | 🚀 Control del flujo |
| `Calculo/` | Package auxiliar donde se agrupan métodos de cálculo. | 📐 Lógica funcional |

---

## 🖥️ Clase Principal: `HolaMundo.java`

El **punto de entrada** en Java siempre es el método `main`.  
Aquí le decimos al programa **por dónde empezar a ejecutar** 🏁.

Puedes ver el código completo en este enlace: [HolaMundo.java](./HolaMundo/src/HolaMundo/HolaMundo.java)

```java
public static void main(String[] args) {
    System.out.println("Hola mundo!");
    System.out.println("Este es nuestro primer programa en JAVA!");

    otraFuncion();
    System.out.println("Fin de la ejecución");

    otraFuncion2();
}
```

---

## 💡 Explicación rápida

- `public static void main` → Indica el punto de entrada del programa.
- `void` → No devuelve ningún valor (si devolviera, usaríamos return).
- `String[] args` → Son los parámetros que podemos pasar al programa.
- `System.out.println()` → Muestra mensajes por consola.

El código se ejecuta de **arriba a abajo**, salvo que lo desviemos con estructuras de control.

---

## 🧱 Modularización con Métodos

Agrupar el código en **métodos** hace que sea más limpio, reutilizable y fácil de mantener ✨

```java
public static void otraFuncion() {
    System.out.println("Otra función");
}

public static void otraFuncion2() {
    System.out.println("Así vemos cómo funciona en cascada!");
    otraFuncion();
}
```

🔸 Cada método se ejecuta solo si lo llamamos.
🔸 El orden es importante: todo programa debe tener un flujo claro y ordenado.

---

# 📦 Packages (Paquetes)

Los **packages** son carpetas que organizan el código.
Sirven para evitar el “**código espagueti** 🍝” y seguir el principio DRY (Don’t Repeat Yourself).

Ejemplo de estructura:

```bash
src/
 ├── Inicio/
 │   └── Iniciar.java
 └── Calculo/
     └── areaRectangulo.java
```

--- 

## 📐 Ejemplo: Cálculo del Área de un Rectángulo

Clase en `Calculo/areaRectangulo.java`(mira el código completo en este enlace: [areaRectangulo.java](./M0485.PRG.P002.HolaMundo2/src/Calculo/areaRectangulo.java)):

```java
package Calculo;

public class areaRectangulo {

    public static void calculaArea(int base, int altura) {
        int area = base * altura;
        System.out.println("El área es: " + area);
    }
}
```

Clase en `Inicio/Iniciar.java`(mira el código completo en este enlace: [Iniciar.java](./M0485.PRG.P002.HolaMundo2/src/Inicio/Iniciar.java)):

```java
package Inicio;

import Calculo.areaRectangulo;

public class Iniciar {
    public static void main(String[] args) {
        System.out.println("Inicio de la ejecución: ");
        areaRectangulo.calculaArea(10, 50);
        System.out.println("Fin de la ejecución.");
    }
}
```

> 👉 Aquí vemos cómo importar una clase desde otro package. El flujo sigue el orden:
> - Se ejecuta el `println` inicial.
> - Llama al método `calculaArea` (va al package `Calculo`).
> - Vuelve para terminar con el `println` final.

---

# 🧠 En resumen

| Concepto                 | Descripción                                       | Ejemplo                                  |
| ------------------------ | ------------------------------------------------- | ---------------------------------------- |
| **main()**               | Punto de inicio de todo programa Java.            | `public static void main(String[] args)` |
| **Método**               | Bloque de código que se ejecuta solo si se llama. | `public static void otraFuncion()`       |
| **Package**              | Carpeta que organiza el código.                   | `package Calculo;`                       |
| **Import**               | Permite usar clases de otros packages.            | `import Calculo.areaRectangulo;`         |
| **System.out.println()** | Muestra texto en la consola.                      | `System.out.println("Hola!");`           |

---

> 💬 **Consejito**:
> Cuando empieces a crear proyectos grandes, divide siempre tu código en packages y métodos.
> Java es orden, estructura y claridad. 🌱

> 🧑‍💻 Proyecto trabajado con Eclipse IDE como parte de Programación: JAVA.