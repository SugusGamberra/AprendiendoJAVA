# MODULACIÓN Y MÉTODOS

En programación la modulación es **dividir** un problema grande en trozos mas chiquitos. En vez de tener un bloque tremebundo de código espagueti dentro de tu `main`, lo separas en bloques independientes y con sentido propio llamados **métodos** (lo que en otros lenguajes serían **funciones**)

## Para qué sirve?

* **Reutilizar código**: Si tienes que calcular el iva de un producto 40 veces no escribes la fórmula 40 veces. Creas un método `calcularIVA()` y lo llamas cada que lo necesites
* **Lectura fluida**: Es más limpio leer un `main` que diga `pedirDatos(); validarUser(); mostrarMenu();` que tener 200 líneas seguidas haciendo cada cosita todo arrejuntao
* **Depuración**: Si algo falla al mostrar el menú sabes a qué bloque tirar sin volverte loco leyendo 1000 líneas en un solo archivo

## Cómo se hace?

Para ejemplificarlo en **Eclipse** haríamos:

1. Crea una carpeta, por eso de tenerlo todo ordenado, y al abrir Eclipse la buscas, abres la carpeta, y arriba como ya sabemos le damos a `File` - `New` - `Project` - `Java Project`. Le ddas el nombre al proyecto y listo!
2. Clic derecho sobre `src` - `New` - `Class` y le pones de nombre lo que tu veas, en mi caso pondré `Ejemplo`. Marca `public static void main(String[] args)`para que tengas ya puesto el punto de entrada, y finish!
3. Y ahora vamos a picar código:
   1. Fuera del punto de entrada vamos a crear un método que sea `saludarUsuario` y otro que sea `sumarNumeros` para llamarlos desde el punto de entrada:

```java
public static void saludarUsuario(String nombre) {
    System.out.println("Hola " + nombre + "! Qué tal?");
}

public static int sumarNumeros(int a, int b) {
    int suma = a + b;
    return suma; //esto devuelve el resultado a quien hiciera la llamada
}
```

   2. Una vez hechos sencillamente en el punto de entrada lo llamamos y le pasamos el `nombre` y los números:

```java
public static void main(String[] args) {
		saludarUsuario("Sugus");

        int resultadoSuma = sumarNumeros(2, 3);
        System.out.println("Resultado: " + resultadoSuma);

	}
```

---

> Yastaria por hoy! Todo facilito, todo sencillito 🙂‍↕️