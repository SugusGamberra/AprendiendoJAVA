# 🧮 Refactorización de una Calculadora

Hemos creado una **calculadora sencilla** y luego la mejoramos y refactorizamos para que el código sea:

- ✨ más limpio
- ♻️ más reutilizable
- 🧠 más fácil de entender

---

## [🧱 Aplicación 1 | Todo junto](./menu/src/aplicacion1/main.java)

Hemos hecho una calculadora funcional pero muy **acoplada**.

Lo que hace la app es mostrar un menú en consola, pedir una opción al usuario, ejecutar la operación elegida y repetir esto hasta que el usuario elija la opción de salir. Se usa un `do...while` porque queremos que el menú se muestre al menos una vez **sí o sí** al ejecutarlo! Por ende mostramos, preguntamos (o damos opciones para que el user elija) y solo después de que el user decida salir, se sale. Es ideal para menús, apps interactivas y programas que "viven" hasta que el usuario lo mate.

Hemos hecho uso de `switch` para el manejo de casos: cada opción llama un método distinto y cada método hace una sola cosa (buenas prácticas).

Usamos métodos pequeños y claros, aunque todo esté arrejuntao, la lógica está bien separada, muestra mensaje, pide al usuario que se introduzcan datos y hace su calculito. Esto evita repetir codigo y es muy legible.

⚠️ **Problema de esta app**
- Toda la **interacción con el usuario** está mezclada con la lógica del programa y las operaciones matemáticas.
- Si mañana quisieras cambiar la consola por ventanas o cómo se piden los datos tendrías que toquetear **TODO** el código. Por eso refactorizamos!

---

## [🧩 Aplicación 2 | Refactorizado](./menu/src/aplicacion2/)

No se cambia lo que hace la app, se cambia la organización! El **objetivo** es separar lo que hace el programa de cómo se comunica con el user.

### [💻 Clase `main`](./menu/src/aplicacion2/main.java)

Ahora aquí controlamos el **flujo del programa**, decide qué operación se ejecuta y **NO** se preocupa de si el mensaje va por consola o por ventana, ni cómo se piden los datos.

### [👩🏻‍💻 Calse `interfazUsuario`](./menu/src/aplicacion2/interfazUsuario.java)

Aquí está la magia de la refactorización ✨

- Centraliza **toda la comunicación con el user**
- Es la única que muestra mensajes, pide valores y decide si se usa consola o message box!!

> 💡 Una sola responsabilidad = **código sano**

### 🎚️ `TIPO_INTERFAZ`

Creamos una variable que define **cómo se habla con el user**:

- `"C"`: Consola
- `"D"`: Desktop (Ventanita)

Así el resto del programa **ni sabe ni le importa** cómo se muestran los mensajes, tan solo llama a `muestraMensaje()` y listo! Esto es **abstracción** y es MUY importante.

---

## 🧠 Ventaja de este enfoque

- Si mañana cambias consola a ventanas, ventanas a web, lo que quieras, **NO** se toca la lógica de la calculadora sino la **interfaz del user**!!
- Código **escalable, reutilizable** y **profesional**.

**🪄 Refactorizar NO es:**
- Añadir nuevas funciones
- Complicar el código
- Hacer magia (por magico que parezca 🫦)
**✅Refactorizar es:**
- Hacer lo mismo pero mejor organizado
- Pensar en la escalabilidad

---

> 👩🏻‍💻 Esta es la continuación de lo nuevo que se ha hecho y las cosas toqueteadas del código ^^

## 📥 Entrada de datos y diseño de la aplicación

En esta sesión aprendemos **cómo pedir datos al usuario** y, sobre todo, **cómo estructurar bien una aplicación Java** para que sea mantenible y escalable 

### 🧠 Separación de responsabilidades (idea clave)

La aplicación se divide en **tres partes bien diferenciadas**:

* 🖥️ **Interfaz de usuario** → comunicación con el usuario
* ⚙️ **Lógica** → funcionamiento interno de la aplicación
* 🚀 **Main** → punto de arranque del programa

Esto es una **buena práctica fundamental** en programación.

### 🎨 Interfaz de usuario configurable

Toda la comunicación con el usuario se centraliza en una única clase:
👉 `interfazUsuario`

Desde aquí decidimos **cómo interactúa el usuario** con la aplicación:

* `C` → Consola
* `D` → Ventanas (Desktop)

Con solo cambiar **un valor**, toda la app cambia de interfaz sin tocar la lógica 😍

Esto nos permite:

* Código más limpio
* Menos duplicación
* Fácil mantenimiento
* Preparar el proyecto para otros entornos (por ejemplo, web 🌐)

### 💬 Mostrar mensajes al usuario

La aplicación usa **un único método** para mostrar mensajes, que decide internamente si:

* imprime por consola
* o muestra una ventana gráfica

👉 La lógica **no sabe ni le importa** cómo se muestra el mensaje. Eso es diseño limpio ✔️

### ✍️ Pedir datos al usuario

Aprendemos a pedir datos usando métodos reutilizables:

* 📌 Pedir **enteros**
* 📌 Pedir **decimales**

Según el tipo de interfaz:

* En consola se lee desde teclado
* En desktop se usan ventanas emergentes

Además, vemos algo muy importante:
🔁 **Conversión de texto a número**
Los datos introducidos por el usuario llegan como texto y deben transformarse para poder operar con ellos.

#### 🧮 Ejemplo práctico: calculadora

La lógica de la aplicación:

* Muestra un **menú**
* Pide una **opción**
* Ejecuta la operación correspondiente:

  * Sumar
  * Restar
  * Multiplicar
  * Dividir
  * Obtener el resto

Cada operación:

* Pide los valores al usuario
* Realiza el cálculo
* Muestra el resultado

Todo usando la **interfaz de usuario centralizada** 💡

### 🏗️ Conceptos importantes que nos llevamos

✅ Separación frontend / backend
✅ Código reutilizable
✅ Refactorización bien aplicada
✅ Aplicaciones preparadas para crecer

En proyectos pequeños ya estamos trabajando **como en proyectos profesionales** 🚀