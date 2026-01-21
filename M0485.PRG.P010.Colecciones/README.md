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
- **No admite tipos primitivos**: Usa **wrappers** (int, double, etc), que son clases envolventes que almacenan todos estos tipos de datos primitivos que los almacena como objetos.
- **Muchos métodos útiles**: `add`, `remove`, `contains`, etc.

### ✍🏻 Declaración de la arrayList:

```java
import java.util.ArrayList;

ArrayList<String> listaStrings = new ArrayList<String> ();
ArrayList<Integer> listaEnteros = new ArrayList<Integer> ();
```

> El sabado se continua esto