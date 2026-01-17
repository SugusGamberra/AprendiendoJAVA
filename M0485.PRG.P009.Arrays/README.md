# 📝 ARRAYS

Un **Array** es como una estantería con un número fijo de huecos. Sirve para guardar una colección de datos del **mismo tipo** seguidos en la memoria.

> **Nota:** Piensa en un pastillero semanal. Tiene 7 huecos fijos (Lunes a Domingo). No puedes meterle mágicamente un octavo día (tamaño fijo) y normalmente guardas lo mismo en todos (pastillas).

---

## 🩵 Características Principales

1.  **Tamaño Fijo:** Nacen con un tamaño y mueren con ese tamaño. Si creas uno de 3 huecos y necesitas 4... mala suerte, toca crear uno nuevo.
2.  **Homogéneos:** Todo lo que guardes dentro debe ser del mismo tipo (todo `int`, o todo `String`, etc.). *La excepción son los arrays de tipo `Object`, que veremos abajo.*
3.  **Indexación Base-0:** El primer elemento siempre es la posición `0`.
    * Si el array mide 5, los índices van del `0` al `4` (`longitud - 1`).

---

## 🙂‍↕️ [`Declaración`](./arrays/src/ejemplos/C01Declaracion.java) e [`Inicialización`](./arrays/src/ejemplos/C02Inicializacion.java)

Hay varias formas principales de crear la "estantería":

### 1️⃣ Declarar y luego dimensionar (en dos pasos)

```java
// 1. Declaramos (decimos de qué tipo será)
int[] runasEncontradas; 

// 2. Inicializamos (reservamos espacio en memoria con 'new')
// Aquí ya se crean 5 huecos rellenos de ceros por defecto.
runasEncontradas = new int[5];
```

### 2️⃣ Todo en una linea (directo)

```java
// Creamos un array de doubles de 10 posiciones
double[] precios = new double[10];
```

### 3️⃣ Con valores ya conocidos (literal)

Si ya sabes que vas a guardarle dentro no hace falta ponerle el tamaño, ya java lo cuenta solito e.e

```java
String[] misRunas = { "Fehu", "Uruz", "Thurisaz" };
// Tamaño: 3
// Índices: 0, 1, 2
```

---

## ⛓️ Valores por defecto

La "nada" de java xd Cuando haces un `new` Java no deja la basura que hubiera en la memoria. Rellena los huecos con valores "vacíos" según el tipo:

| Tipo de dato | Valor por defecto |
| :--- | :--- |
| `int`, `byte`, `short`, `long` | `0` |
| `double`, `float` | `0.0` |
| `boolean` | `false` |
| `char` | `\u000` (es como caracter nulo) |
| Objetos (`String`, etc) | `null` |

---

## ✍🏻 Acceder y modificar datos

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

## 🐐 Arrays de Objetos (polimorfismo vaya)

En java **TODO** hereda de una clase madre llamada `Object`. Igual que un alumno y un profe tienen roles distintos, pero ambos son humanos. Un `String` y un `Int` son distintos pero ambos son `Object`.

Este tipo de array es el único que puedes mezclar "tipos" mientras estén bajo el abanico de `Object`:

```java
Object[] cajonDesastre = new Object[3];

cajonDesastre[0] = "Hola pish";  // String
cajonDesastre[1] = 87;            // Integer (número)
cajonDesastre[2] = true;          // Boolean
```

---

## ➿ [`Recorrer arrays con Bucles`](./arrays/src/ejemplos/C03Recorrido.java)

Para leer el array de una sin tener que estar poniendo 20 veces un `System.out.println(arrayObjetos[0]);`, `System.out.println(arrayObjetos[1]);`, etc, usamos bucles.

Puedes recorrerlos de atrás hacia adelante y viceversa, en el [archivo](./arrays/src/ejemplos/C03Recorrido.java) puedes visualizarlo!

A la hora de iterar por cada elemento del array se puede poner de 2 formas, ambas son lo mismo:

```java
// forma 1
i < ultimoElemento
// forma 2
i <= ultimoIndice.lenght -1
```

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

## [`Arrays multidimensionales`](./arrays/src/ejemplos/C04ArrayMultidimensional.java)

Hasta ahora hemos visto arryas de una dimensión, pero para ciertas cosas como **matrices**, **matemáticas**... nos puede servir. Pueden ser de tantas dimensiones como queramos.

Las matrices son útiles también en **juegos**. Por ejemplo, tenemos 3 dimensiones en un entorno 3d (`x`, `y` y `z`), pues que en cada pixel según la posición en nuestra pantalla tratemos dicho pixel de una forma concreta.

Hay 2 formas de crearlas:

```java
// forma 1
int[][] matriz = new int[3][4];
matriz[0][0] = 25;
matriz[0][1] = 32;

// forma 2.1
int[][] matriz2 = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// forma 2.2, que es más un formalismo que otra cosa
int[][] matriz3 = new int [3][4] {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};
```

Igual que en las unidimensionales, podemos recorrer estas con bucles.

Si defino una matriz irregular, por ejemplo una de las filas tiene un valor menos (una fila de 4, una de 3, y otra de 4), el recorrido se traba en la fila de 3 elementos porque coge el último elemento de la fila más larga.

---

## 🫦 [`Utilidades`](./arrays/src/ejemplos/C05Utilidades.java)

📖 Si quisiéramos leer directamente un array sin tener que recorrerlo con `bucles`, si ponemos:

```java
System.out.println(arrayObjetos);
```

👆🏻 Eso solo nos mostraría el espacio en memoria.

Si queremos ver el contenido, en java tenemos funciones también. Si le pasamos la clase `Arrays` con el método `.toString` nos convierte el array en un string para que se pueda leer en consola:

```java
System.out.println(Arrays.toString(arrayObjetos));
```

🔢 Si queremos ordenar un array usamos sort!
```java
Arrays.sort(arrayElementos, 1, 6);
System.out.println(Arrays.toString(arrayElementos));
```

✍🏻 Si queremos ver el indice de un elemento en un array lo hacemos con binarySearch, **importante**, debe estar ordenado el array de forma ascendente para que lo refleje de forma lógica y real!! Si el valor que buscamos no está en los rangos dados (se puede buscar por rangos también) te saca número negativo:
```java
//IMPORTANTE: El algoritmo de búsqueda binaria asume que los elementos están ordenados
Arrays.sort(arrayEnteros);
int indice = Arrays.binarySearch(arrayEnteros, 7);
System.out.println("Indice: " + indice);

//buscamos entre los indices 2 y 5
indice = Arrays.binarySearch(arrayEnteros, 2, 5, 7);
		System.out.println("Indice: " + indice);
```

🪣 Para llenar todo el array con un valor específico de forma automática usamos `fill`, si queremos podemos rellenar tambien desde un indice concreto a otro:
```java
// rellenar desde un indice a otro solamente, del indice 3 al 7 concretamente
Arrays.fill(numeros, 3, 8, 10);
System.out.println(Arrays.toString(numeros));

// rellenar todos, esto machaca los valores que hubieran antes
Arrays.fill(numeros, 10);
System.out.println(Arrays.toString(numeros));
```

🔁 Si quisiéramos cambiar un valor en un array y usar sus valores en otro array, a diferencia de los valores primitivos, por ser un objeto el array refleja el cambio , veamos la diferencia en una tablita:

**Valores primitivos**: Trabajamos con valores
| Elemento JAVA | Memoria |
| :--- | :--- |
| `Int valor1` | `10` |
| `Int valor2` | `valor1` |
| `valor1` | `15` |
| Resultado `valor1`: | `15` |
| Resultado `valor2`: | `10` |

**Objetos**: trabajamos con direcciones de memoria
| Elemento JAVA | Memoria |
| :--- | :--- |
| `Int[] enteros1` | `{1, 2, 3, 5, 7}` Dirección de memoria `xx01` |
| `Int[] enteros2` | `enteros1` Se le está asignando la dirección de memoria `xx01` |
| `enteros1` | Cambiamos un valor, por ejemplo el índice 2 a 4, se actualiza `xx01` |
| Resultado: | Mismo contenido en ambos, actualizado en el índice 2 a 4: `{1, 2, 4, 5, 7}` |

> El miércoles veremos como hacer una copia de valor de manera que se cree el objeto y no se almacene en la misma dirección de memoria, que se cree una dirección nueva y tenga valores nuevos
> Los primitivos se pasan x valor y los objetos x referencia en memoria