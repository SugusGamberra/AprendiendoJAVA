# 🪣 Colecciones en JAVA

## ✏️ ArrayList

### 🧑🏻‍🏫 Qué es?

Es una colección dinámica que pertenece al framework `Collections` de JAVA. Los arrays son estáticos, es decir, una vez definidos los elementos esa dimensión no se podrá cambiar.

Un `ArrayList` permite almacenar **objetos** del mismo tipo y crece o se reduce **automáticamente**. Esto implica que una vez definida la dimensión no significa que no pueda crecer. 

Esta clase se usa con `import java.util.ArrayList;`.

### 🩵 Características principales

- **Tamaño dinámico**: El tamaño no es fijo.
- **Tipo genérico**: `ArrayList<String`. Permite indicarle el tipo de dato a almacenar como hacíamos con el array.
- **Indexado desde 0**: Podemos trabajar los índices como los arrays.
- **No admite tipos primitivos**: Usa **wrappers** (Integer, Character, Double...), que son clases envolventes que almacenan todos estos tipos de datos primitivos que los almacena como objetos:

| Tipo primitivo | Clase envolvente |
| :--- | :--- |
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `char` | `Character ` |
| `boolean` | `Boolean` |

```java
// error
ArrayList<int> listaInts;
// bien
ArrayList<Integer> listaEnteros;
```

- **Muchos métodos útiles**: `add`, `remove`, `contains`, etc.

### ✍🏻 Declaración e inicialización de la arrayList:

Una arraylist no tiene dimensión acotada.

En caso de declarar un `ArrayList` con ausencia de valor (sin inicializarlo o poniéndole `null`), significa que no está en memoria, es decir si intento acceder a esta me va a dar error. No se pueden invocar métodos en array lists nulos!! A las listas null **NO SE LES PUEDE AÑADIR ELEMENTOS**!!

Para evitar esto podríamos usar un condicional:

```java
if (listaString != null) {
    System.out.println("LS3: " + listaString.size());
}

```java
import java.util.ArrayList;
import java.util.List;

ArrayList<String> listaStrings = new ArrayList<String> ();
ArrayList<Integer> listaEnteros = new ArrayList<Integer> (
	List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
```

### 🦍 Métodos útiles

- **add**:
```java
listaStrings.add("A");
listaEnteros.add(10);
```

- **size**: 
```java
listaStrings.size();
System.out.println(listaEnteros.size());
```

- **get**:
```java
for(int posicion = 0; posicion < lista.size(); posicion++) {
	System.out.println(posicion + ": " + lista.get(posicion));
}
```

- **isEmpty**:
```java
if (lista.isEmpty()) {
    //bloque de codigo
}
```

### 🫦 Recorrer un Array List

El mejor método es usar un for each.

```java
// teniendo en cuenta q ya esta declarado e inicializado lo llamamos aki y creamos un metodo privado para q haga el recorrido
recorrerArrayListEnteros(listaEnteros);

private static void recorrerArrayListEnteros(ArrayList<Integer> lista) {
	System.out.println("----foreach----");
	
	for(int numero : lista) {
		System.out.println(numero);
	}
}
```

Se puede recorrer con un for y con un while también.

```java
System.out.println("----For----");

for(int posicion = 0; posicion < lista.size(); posicion++) {
	System.out.println(posicion + ": " + lista.get(posicion));
}
```

```java
System.out.println("---While----");
		
int posicion = 0;
		
while (posicion < lista.size()) {
	System.out.println(posicion + ": " + lista.get(posicion));
	posicion++;
}
```

> 🧑🏻‍🏫 **IMPORTANTE**: A la hora de recorrer listas, sería importante añadir un control con un condicional para asegurarse que las listas no están vacias ( `if (lista != null) { // recorrido con el bucle que sea } else { System.out.println("La lista es null"); }` ).
> Podríamos controlar esto de mejor forma si tenemos en cuenta ambos casos: null y listas vacías: `if (lista == null) { System.out.println("lista null"); } else if (lista.isEmpty()) { System.out.println("Lista vacia"); } else { // que ejecute el bloque de codigos }`.

### 🔢 Ordenacion

- *Orden ascendente*:
```java
Collections.sort(lista);

System.out.println("---Lista ordenada ascendente----");

for (String cadena : lista) {
	System.out.println(cadena);
}
```

- *Orden descendente*:
```java
Collections.reverse(lista);

System.out.println("---Lista ordenada descendente----");

for (String cadena : lista) {
	System.out.println(cadena);
}
```

> Sigo el miercoles :3