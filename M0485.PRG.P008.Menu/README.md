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

> 👩🏻‍💻 El Sábado se termina esto según! Así que paciencia :P