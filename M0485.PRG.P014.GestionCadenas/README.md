# ⛓️‍💥 Gestión de cadenas

Este proyecto es una prueba de concepto para demostrar la enorme diferencia de rendimiento al concatenar texto en Java usando `String` tradicional frente a la clase `StringBuilder`.

---

## 🧠 Cuál es el problema real?

En Java, los objetos `String` son **inmutables** (no se pueden modificar una vez creados). Imaginemos que esto es la memoria:

| Instrucción | Memoria | Valor |
| :-- | :-- | :-- |
| `String cadena = "";` | `Dirección10` | "" |
| `cadena = cadena + "A";` | La `Dirección10` se pierde y se crea un contenido nuevo en `Dirección11` | "A" |
| `cadena = cadena + "B";` | Las direcciones anteriores se pierden y se crea contenido nuevo en `Dirección12`. Esto pasa porque los strings son inmutables, JAVA busca otra casilla de la memoria y le pone el valor que corresponde. | "AB" |

> Esta concatenación en un bucle devora la memoria
> Para cosas grandes como bucles o cargando líneas de un ficheros que no sabemos la cantidad de elementos que tiene, es mejor el **String Builder**

Cuando usas el operador `+` para unir cadenas dentro de un bucle grande (como en el método `cadenasString`), Java tiene que crear un objeto nuevo en la memoria en cada iteración, copiar el texto que ya tenías y añadirle el nuevo trozo. Hacer esto miles de veces satura la memoria y hace que el proceso sea muy lento.

Por el contrario, `StringBuilder` es **mutable**. Actúa como un contenedor al que le puedes seguir metiendo texto con el método `.append()`, modificando el objeto original sin necesidad de crear uno nuevo cada vez. Esto optimiza muchísimo el uso de la memoria y la velocidad.

---

## ⚙️ Qué hace el [código](./GestionCadenas/src/ejemplo/Cadenas.java)

El script realiza 200.000 iteraciones añadiendo números separados por comas a una cadena de texto, y mide el tiempo de ejecución usando `LocalDateTime` y `Duration`.

* **`cadenasString()`**: Concatena usando `cadena = cadena + i`. Es tan ineficiente que el tiempo de ejecución se llega a medir en **segundos**.
* **`cadenasStringBuilder()`**: Concatena usando `cadena.append(i)`. Está tan optimizado que su tiempo de ejecución es casi inmediato y se mide en **nanosegundos**.

---

## 💡 Cuándo usar cada uno

* **Usa `String` (+):** Para concatenaciones simples de unas pocas variables (ej. `System.out.println("Hola " + nombre);`).
* **Usa `StringBuilder` (.append):** Siempre que vayas a concatenar texto dentro de un bucle (`for`, `while`) o si no sabes de antemano la cantidad exacta de elementos que vas a unir.