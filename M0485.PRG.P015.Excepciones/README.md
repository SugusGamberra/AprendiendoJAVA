# 💣 Excepciones en JAVA

Las **excepciones** son el mecanismo que tiene JAVA para manejar errores en tiempo de ejecución. Su objetivo es evitar que el programa pete y se cierre de forma abrupta, así nos permite reaccionar ante el fallo o registrarlo.

---

## 🤔 Que es una excepcion??

Es un **objeto** que representa un error o un evento inesperado ocurrido durante la ejecución del programa:

```java
int x = 19 / 0; // lanza excepcion aritmética (ArithmeticException)
```

---

## 🎋 Jerarquía de excepciones (herencia)

Todas las excepciones y errores en JAVA heredan de la clase base principal llamada `Throwable`:

```plaintext
Object
└── Throwable
    ├── Error (Fallos críticos del sistema)
    └── Exception (Errores de la aplicación)
        ├── RuntimeException (No comprobadas)
        └── Otras Excepciones (Comprobadas)
```

| Tipo | Se controla obligatoriamente por el compilador? | Ejemplo |
| :--- | :---: | :--- |
| `Error` | ❌ | Fallos graves de la máquina virtual (por ejemplo falta de memoria RAM). No se intentan capturar |
| `RuntimeException` |  ❌ | Errores de lógica del programador (`NullPointerException`, divisiones entre 0) |
| `Exception` (el resto) | ✅ | Acceso a ficheros, bbdd o red (`FileNotFoundException`). Obliga a usar `trycatch` o `throws`. |

---

## 🎫 Tipos de excepciones

### ❌ Excepciones Unchecked

Son las **no comprobadas** que derivan de `RuntimeException`. El compilador **no** te obliga a tratarlas pero si ocurren y no las has previsto, el prgrama falla.

```java
int[] v = new int[3];
System.out.println(v[5]); // peta xk el indice maximo es 2, no 5

String s = null;
System.out.println(s.length()); // peta xk no puedes medir la longitud de algo nulo
```

### ✅ Excepciones Checked

Son las **comprobadas**, derivan directamente de `Exception` (excluyendo a las RuntimeException). El compilador te **obliga** a manejarlas si o si, por webos.

```java
FileReader f = new FileReader("datos.txt"); // o t obliga a encapsularla en trycatch o en throw
```

---

## 💅🏻 Tratamiento de excepciones

### 🗒️ Opcion 1: Proteger con `trycatch-finally`

Capturamos el error en el mismo lugar donde ocurre y decidimos qué hacer. El orden de los `catch` importa!! Hay que ir siempre de la excepción **más específica** a la **más generica**:

```java
try {
    // Código peligroso q puede fallar
    int a = 10 / 0;
} catch (ArithmeticException e) {
    // Tratamiento específico si falla por matemáticas
    System.err.println("Error matemático: " + e.getMessage());
} catch (Exception e) {
    // Tratamiento genérico para CUALQUIER otra excepción que no hayamos previsto
    System.err.println("Error general: " + e.getMessage());
} finally {
    // Se ejecuta SIEMPRE, falle o no (gucci para cerrar ficheros o conexiones)
    System.out.println("Se ejecuta siempre de o no error");
}
```

### 🚮 Opcion 2: Delegar con `throw`s

Si no queremos/podemos tratar errores con `trycatch` dentro del método actual, podemos pasarle la pelota al método que lo invoco. Para ello avisamos en la firma del método usando la palabra reservada `throw`:

```java
// Avisamos de que este método es susceptible de lanzar este error específico
private static void leerArchivo() throws FileNotFoundException {
    
    /* Al usar throws arriba, ya NO es obligatorio poner try-catch aquí abajo.
    Si el archivo no existe, la excepción vuela hacia el método que llamó a leerArchivo().*/
    FileReader f = new FileReader("datos.txt"); 
}
```

> No hemos terminado con las excepciones, falta la alternativa al trycatch que es preveer q un metodo es susceptible de metodo x y que lo trate quien lo llame, pal proximo dia, aunque lo pongo arribita pero es suceptible a correcciones del profe ejej