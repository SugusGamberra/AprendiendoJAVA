# 🔁 BUCLES

Guía completa + control interno (`break`, `continue`).

Cada tipo sirve para una cosa pero todos comparten la idea de **repetir código mientras se cumpla una condición** O **mientras queden elementos que recorrer**.

---

## 🟦 [`while`](../M0485.PRG.P007.Bucles/bucles/src/bucles/ejemplo01While.java)

Evalúa una condición **antes** de entrar al bloque. Si la condición empieza en `false`, **no se ejecuta ni una sola vez**.

**Úsalo cuando no sabes cuántas interacciones habrán** pero necesitas repetir algo mientras algo siga siendo `true`.

**Notas:**

- Se suele actualizar la variable **dentro** del propio cuerpo del bucle.
- Si no actualizas la condición → bucle infinito 😨.

---

## 🟨 [`do…while`](../M0485.PRG.P007.Bucles/bucles/src/bucles/ejemplo02DoWhile.java)

Aquí la cosa cambia: **el bloque se ejecuta al menos una vez** y ya se comprueba **después**. Si en esa comprobación es `true` el bucle sigue, si resulta que es `false` se para.

**Ùsalo cuando necesitas que el user o el programa hagan algo una primera vez**, por ejemplo:

- Pedir la contraseña
- Mostrar un menú
- Realizar un intento inicial antes de validar

---

## 🟩 [`for`](../M0485.PRG.P007.Bucles/bucles/src/bucles/ejemplo03For.java)

Bucle estructurado en tres partes:

> for (inicialización; condición; actualización)

Ideal cuando sabes **exactamente** cuántas iteraciones habrán, trabajas con contadores o recorres rangos.

**Notas:**
- Es el bucle más usado para repeticiones clásicas
- Muy compacto y fácil de leer
- La actualización está integrada (i++, i--...)

--- 

## 🟪 [`for-each`](../M0485.PRG.P007.Bucles/bucles/src/bucles/ejemplo04ForEach.java)

Pensado para recorrer **arrays o colecciones** sin preocuparte de los índices.

Forma general:

> for (tipo elemento: array) {...}

Ideal para listas de números o cadenas, o cuando solo queires "cada elemento" sin manejar posiciones.

**Notas**:
- **NO** sirve para modificar el array, **SOLO LECTURA**
- Lo usaremos mucho cuando extraigamos datos de BBDD

---

## 🧠 Resumen rápido

| Bucle        | Cuándo se evalúa               | Se ejecuta mínimo una vez | Uso típico                                           |
| ----------- | ------------------------------ | ------------------------- | ---------------------------------------------------- |
| **`while`**    | Antes del bloque               | ❌ No                      | Repetir mientras se cumpla una condición desconocida |
| **`do…while`** | Después del bloque             | ✔️ Sí                      | Menús, validaciones iniciales                        |
| **`for`**      | Antes, dentro de la estructura | ❌ No                      | Contadores, iteraciones controladas                  |
| **`for-each`** | Depende del iterador           | ❌ No                      | Recorrer arrays y colecciones                        |

---

## 📝 Importante!!

- Los bucles necesitan **una condición que cambie**, o el programa se quedará atrapado.  
- `limite++`, `limite--` y variantes ayudan a avanzar la condición.  
- En arrays:  
  - Puedes acceder por índice (`array[0]`, `array[3]`, `array[9]`).  
  - Puedes recorrerlos enteros con `for-each`, mucho más cómodo.  
- Más adelante, al sacar datos de BBDD, usaremos patrones muy parecidos al `for-each`.

---

# ➿ Control de bucles

Vamos a aprender a **gestionar lo que ocurre dentro de cada vuelta de un bucle**:

- cómo terminar antes de tiempo,
- cómo saltarnos una iteración,
- cómo optimizar el flujo interno.

Estos pequeños controles mejoran el rendimiento y nos dan más **poder** sobre la lógica de nuestro código

---

## 🟦 Control básico de una iteración

Hemos visto la estructura típica: un contador que avanza mientras no supere un límite. La idea clave es quie en **cada vuelta** comprueba la condición del bucle. Si es `true` → ejecuta el bloque. Si es `false` → sale del bucle. Esto es la base para entender `break` y `continue` ;3

1. **Evaluacion de la condición** del bucle (excepto `dowhile` que lo hace despues de la 1ª vuelta)
2. **Ejecución del cuerpo** del bucle
3. **Actualización del contador** si existe (`for`) o tu lo haces (`while`)
4. **Vuelta al punto 1**

Entender ese orden es **CLAVE** para saber **dónde** colocar **incrementos**, cuándo usar `break` y por qué `continue` puede **romperte** un bucle si no lo controlas!

### 🙂‍↕️ `continue`

> **Salta la iteración actual y pasa directamente a la siguiente vuelta del bucle**

Sirve cuando **NO** te interesa ejecutar el resto del código de esa vuelta en particular.

Ejemplo: "Solo quiero mostrar números pares", pues si el número es **impar** → me lo salto → paso a la siguiente vuelta. Lo que ocurre internamente es:

1. Entra al bucle.
2. JAVA encuentra `continue` e **ignora** todo el código restante de esa iteracion
3. Pasa directamente a:
   1. la **actualización** (en `for`)
   2. la **evaluacion de la condicion** (en `while` y `dowhile`)

Esto ahorra trabajo al programa y tb de paso evita usar `else`s innecesarios 💀

#### ❗ El orden importa!!!

Si usas un contador manual y haces:

```java
if (condicion) continue;
```
sin haber actualizado antes...

⚠️la variable **NO** avanza
⚠️la condición **NO** cambia
⚠️**BUCLE INFINITO**

Por eso **SIEMPRE** debes colocar el incremento **ANTESSSSS** del `continue` cuando dependes de él 😡

### 💔 `break`

> **Rompe el bucle por completo, sin esperar a que la condición natural se cumpla**

Ideal para encontrar un valor concreto, detectar un error o terminar antes de tiempo porque ya no haga falta seguir.

Ejemplo: "Si el contador es divisible entre 5, me salgo del bucle". En cuanto esto ocurre → adios mu wenas xd → el bucle termina.

Es una salida **INMEDIATA** e **incodicional** del bucle!

---

## 🟩 Aplicado a todos los tipos de bucle!

### 🔵 `while`

Perfecto para ver como `continue` y `break` afectan a una estructura donde la condicion se comprueba al inicio.

Como evalua la condición al inicio con [`continue`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test01WhileContinue.java) se salta la vuelta y **reevalúa** la condición. Si no actualizas antes la variable pues... ⚠️bucle infinito :3

Con [`break`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test01WhileBreak.java) sale inmediatamente sin reevaluar nada más

### 🟢 `for`

Aquí es muy natural usar ambos: [`continue`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test02ForContinue.java) salta directamente a la parte de actualización (`contador++`) y luego lo vuelve a comprobar. 

[`break`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test02ForBreak.java) corta el bucle de golpe.

### 🟡 `do...while`

Este bucle **SIEMPRE** ejecuta una vuelta **ANTES** de comprobar. Esto influye independientemente del número inicial que le pongas al contador, la primera vuelta se ejecuta sí o también!!

[`continue`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test03DoWhileContinue.java) vuelve directamente a la **comprobación**.

[`break`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test03DoWhileBreak.java) corta el bucle incluso aun estando en la primera vuelta.

Muy útil si quieres ejecutar algo almenos una vez pero controlar las siguientes.

### 🟣 `for each`

Aunque no haya contador visible [`continue`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test04ForEachContinueYBreak.java) pasa al **siguiente elemento**.

[`break`](../M0485.PRG.P007.Bucles/bucles/src/bucles2/test04ForEachContinueYBreak.java) rompe todo el recorrido del array, lo cual es especialmente util para cortar dichos recorridos de arrays o colecciones tipo para detener la búsqueda al encontrar un valor concreto, saltarte ciertos elementos, limitar la lectura al user...

---

## 🧠 Importante!!!

### 🔹 1. El orden importa  
Controlar bien si incrementas antes o después del `continue` evita bucles infinitos.

### 🔹 2. `continue` no sale del bucle  
Solo evita ejecutar el resto del código de esa vuelta y mira si tiene que seguir otra vez.

### 🔹 3. `break` ignora condición, contador y todo lo demás  
Termina el bucle **por completo** al instante.

### 🔹 4. En `for-each`, aunque no hay contador visible, sigue siendo válido usar `continue` y `break`

### 🔹 5. Podemos combinar límites externos con condiciones internas  
Puedes diseñar logica compleja sin tener varios bucles anidados

**🧠 Resumen rápido**:

| Acción | Qué hace | Cuándo usarla |
|-------|----------|----------------|
| **continue** | Salta la iteración actual y pasa a la siguiente | Cuando NO quieres ejecutar todo el código de esa vuelta |
| **break** | Rompe el bucle completamente | Cuando ya no hace falta seguir iterando |
| **incrementos dentro del bucle** | Evitan estancarse | Obligatorio antes de `continue` si dependes del contador |
| **validación en cada vuelta** | Decide si seguir o salir | Es lo que desencadena o detiene el bucle |
| **validación en cada vuelta** | Decide si seguir o salir | Es lo que desencadena o detiene el bucle |

---
