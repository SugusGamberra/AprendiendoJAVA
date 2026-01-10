# 📝 ARRAYS

Un **Array** es como una estantería con un número fijo de huecos. Sirve para guardar una colección de datos del **mismo tipo** seguidos en la memoria.

> **Nota:** Piensa en un pastillero semanal. Tiene 7 huecos fijos (Lunes a Domingo). No puedes meterle mágicamente un octavo día (tamaño fijo) y normalmente guardas lo mismo en todos (pastillas).

---

## Características Principales

1.  **Tamaño Fijo:** Nacen con un tamaño y mueren con ese tamaño. Si creas uno de 3 huecos y necesitas 4... mala suerte, toca crear uno nuevo.
2.  **Homogéneos:** Todo lo que guardes dentro debe ser del mismo tipo (todo `int`, o todo `String`, etc.). *La excepción son los arrays de tipo `Object`, que veremos abajo.*
3.  **Indexación Base-0:** El primer elemento siempre es la posición `0`.
    * Si el array mide 5, los índices van del `0` al `4` (`longitud - 1`).

---

## Declaración e Inicialización

Hay dos formas principales de crear la "estantería":

### A. Declarar y luego dimensionar (en dos pasos)

```java
// 1. Declaramos (decimos de qué tipo será)
int[] runasEncontradas; 

// 2. Inicializamos (reservamos espacio en memoria con 'new')
// Aquí ya se crean 5 huecos rellenos de ceros por defecto.
runasEncontradas = new int[5];
```

### B. Todo en una linea (directo)

```java
// Creamos un array de doubles de 10 posiciones
double[] precios = new double[10];
```

### C. Con valores ya conocidos (literal)

Si ya sabes que vas a guardarle dentro no hace falta ponerle el tamaño, ya java lo cuenta solito e.e

```java
String[] misRunas = { "Fehu", "Uruz", "Thurisaz" };
// Tamaño: 3
// Índices: 0, 1, 2
```

---

## Valores por defecto

La "nada" de java xd Cuando haces un `new` Java no deja la basura que hubiera en la memoria. Rellena los huecos con valores "vacíos" según el tipo:

| Tipo de dato | Valor por defecto |
| :--- | :--- |
| `int`, `byte`, `short`, `long` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `\u000` (es como caracter nulo) |
| Objetos (`String`, etc) | `null` |

---

## Acceder y modificar datos

Usaremos los `[]` con el numero del índice:

```java
int[] puntuaciones = new int[3]; // [0, 0, 0]

// Asignar valor (set)
puntuaciones[0] = 10;
puntuaciones[2] = 50; 
// Ahora el array es: [10, 0, 50]

// Leer valor (get)
System.out.println(puntuaciones[0]); // Imprime: 10
```

> ⚠️ **El error mas comun!!**: `ArrayIndexOutOfBoundsException`
> Si intentas acceder a una posición que no existe (por ejemplo el indice 4 del array anterior) JAVA lanzara esta excepcion.
> Basicamente significa "tas salio de los limites porrita".+

---

## Arrays de Objetos (polimorfismo vaya)

En java **TODO** hereda de una clase madre llamada `Object`. Igual que un alumno y un profe tienen roles distintos, pero ambos son humanos. Un `String` y un `Int` son distintos pero ambos son `Object`.

Este tipo de array es el único que puedes mezclar "tipos" mientras estén bajo el abanico de `Object`:

```java
Object[] cajonDesastre = new Object[3];

cajonDesastre[0] = "Hola pish";  // String
cajonDesastre[1] = 87;            // Integer (número)
cajonDesastre[2] = true;          // Boolean
```

---

## Recorrer arrays con Bucles

Para leer el array de una sin tener que estar poniendo 20 veces un `System.out.println(arrayObjetos[0]);`, `System.out.println(arrayObjetos[1]);`, etc, usamos bucles:

### `for`

Es el más usado porque puedes controlar el índice:

```java
String[] elementos = {"Agua", "Fuego", "Tierra", "Aire"};

for (int i = 0; i < elementos.length; i++) {
    System.out.println("Elemento " + i + ": " + elementos[i]);
}
```

### `for-each`

Con este **solo** leemos tooodos los datos, en caso de que nos importe un pito la posición numérica.

```java
for (String elemento : elementos) {
    System.out.println(elemento);
}
```

### `while`

Menos comun porque tienes que andar creando y aumentando el índice de forma manual fuera del bucle:

```java
int i = 0;
while (i < elementos.length) {
    System.out.println(elementos[i]);
    i++;
}
```

---

> Esto ha sido la clase de hoy, yo la he completado con mis conocimientos (los buclers y tal) 🫦
> El próximo día según continuamos, no sé si el profe añadira mas cosicas
> Un abruzoooo!! 🫂🫂