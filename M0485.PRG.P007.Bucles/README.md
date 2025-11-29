# 🔁 BUCLES

Tenemos varios tipos de bucles, en la clase de hoy se han dado 4.

Cada tipo sirve para una cosa pero todos comparten la idea de **repetir código mientras se cumpla una condición** O **mientras queden elementos que recorrer**.

---

## 🟦 `while`

Evalúa una condición **antes** de entrar al bloque. Si la condición empieza en `false`, **no se ejecuta ni una sola vez**.

**Úsalo cuando no sabes cuántas interacciones habrán** pero necesitas repetir algo mientras algo siga siendo `true`.

**Notas:**

- Se suele actualizar la variable **dentro** del propio cuerpo del bucle.
- Si no actualizas la condición → bucle infinito 😨.

---

## 🟨 `do…while`

Aquí la cosa cambia: **el bloque se ejecuta al menos una vez** y ya se comprueba **después**. Si en esa comprobación es `true` el bucle sigue, si resulta que es `false` se para.

**Ùsalo cuando necesitas que el user o el programa hagan algo una primera vez**, por ejemplo:

- Pedir la contraseña
- Mostrar un menú
- Realizar un intento inicial antes de validar

---

## 🟩 `for`

Bucle estructurado en tres partes:

> for (inicialización; condición; actualización)

Ideal cuando sabes **exactamente** cuántas iteraciones habrán, trabajas con contadores o recorres rangos.

**Notas:**
- Es el bucle más usado para repeticiones clásicas
- Muy compacto y fácil de leer

--- 

## 🟪 `for-each`

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
| ------------ | ------------------------------ | ------------------------- | ---------------------------------------------------- |
| **`while`**    | Antes del bloque               | ❌ No                      | Repetir mientras se cumpla una condición desconocida |
| **`do…while`** | Después del bloque             | ✔️ Sí                      | Menús, validaciones iniciales                        |
| **`for`**      | Antes, dentro de la estructura | ❌ No                      | Contadores, iteraciones controladas                  |
| **`for-each`** | Depende del iterador           | ❌ No                      | Recorrer arrays y colecciones                        |

---

## 📝 Cosas importantes que hemos visto hoy

- Los bucles necesitan **una condición que cambie**, o el programa se quedará atrapado.  
- `limite++`, `limite--` y variantes ayudan a avanzar la condición.  
- En arrays:  
  - Puedes acceder por índice (`array[0]`, `array[3]`, `array[9]`).  
  - Puedes recorrerlos enteros con `for-each`, mucho más cómodo.  
- Más adelante, al sacar datos de BBDD, usaremos patrones muy parecidos al `for-each`.

---

> El próximo día se seguirán viendo más cosas de los bucles, puede ser que actualice este doc y los códigos o los cree desde 0
> Sea lo que sea, ya sabes que se entiende dpm :P
> Y que está todo bien puesto en el mapa del [README](../README.md) ^^