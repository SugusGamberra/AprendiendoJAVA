# 🧸 POO

Antes de meternos en código, hay que entender la filosofía. La Programación Orientada a Objetos intenta trasladar la vida real al código. Todo en la vida son objetos con características y comportamientos.

Lo que más confunde al principio es la diferencia entre `clase` vs `objeto`! Vamos a visualizarlo como **"La Idea" vs. "La Manifestación"**:

* **📜 La Clase (`Class`):** Es el plano, el molde, el arquetipo. Es algo abstracto. Define cómo *debería ser* algo, pero no existe físicamente.
    * *Ejemplo:* La idea de "Ser Humano" (sabemos que tienen nombre, corazón y respiran).
* **✨ El Objeto (`Object`):** Es la instancia, la materialización de esa clase. Es algo concreto que ocupa memoria.
    * *Ejemplo:* Tú eres un objeto de la clase "Ser Humano". Tu vecino es *otro* objeto de la misma clase. Cada uno es independiente.

Cuando creamos ese "molde" (el archivo `.java`), definimos dos cosas:

1.  **Atributos (Datos/Estado):** Son las características.
    * *En código:* Son las variables (`dni`, `nombre`, `nota`).
    * *En la vida:* Color de ojos, signo del zodiaco, edad.
2.  **Métodos (Comportamiento):** Son las acciones que puede hacer.
    * *En código:* Son las funciones (`calcularNota()`, `hablar()`).
    * *En la vida:* Dormir, comer, esperar que tu ex te envie un mensaje 👀.

> **Resumen rapido:**
> * **Clase** = El molde de galletas.
> * **Objeto** = La galleta ya horneada (puedes comértela).
> * **Instanciar** = La acción de usar el molde para crear la galleta (`new`).
> * **Dominio de la aplicación** = Se refiere a aquellas clases o partes del código que representan entidades de la aplicación. En nuestro ejemplo01 donde trabajamos con datos de una escuela como clases de alumnos, profesores, asignaturas...

Veremos **clases de procesos** donde tenemos métodos, variables, propiedades y demás en ellas.

Veremos también **clases de tipo entidad** que muestran datos estructurados que tienen que ver con el **dominio de la aplicación**.

---

## 🔒 Private vs Public (Encapsulamiento)

- **Atributos `private`**: Son sagrados. Nadie de fuera puede tocarlos directamente. Es como tu intimidad o tus calcetines de debajo d la cama (gorrino 👀), no dejas que cualquiera las manosee.
- **Métodos `public`**: Son la ventanilla de atención al público. Si quieren algo del atributo, tienen que pedírselo al método.

---

## 🚦 Getters y Setters

Para acceder a los datos privados usamos estos intermediarios. Aquí es donde **ponemos las normas**. Yo los imagino como los porteros d la discoteca xd

- **GET (Dame)**: Para leer el valor.
- **SET (Toma/Modifica)**: Para cambiar el valor. ¡Aquí validamos!
- **this.**: Distingue el parámetro del nombre de la propiedad de la clase.

```java
public void setNotaAcceso(float notaAcceso) {
    // Solo dejamos pasar si cumple la norma (0 a 10)
    if (notaAcceso >= 0 && notaAcceso <= 10) {
        this.notaAcceso = notaAcceso;
    } else {
        System.err.println("❌ Error: La nota debe estar entre 0 y 10.");
    }
}
```

> **CUIDAO**: Me he dado cuenta que en la explicación de mi profe, en el código, hay un error (probablemente lo depuremos el proximo dia). Si pones `this.variable = variable` fuera de la lógica del condicional (`else`) va a almacenar el dato erroneo de todas formas!! Te pongo aquí para que lo veas lo que estaba mal y como deberia de ser:

**MAL**:

```java
if (notaAcceso >= 0 && notaAcceso <= 10) {
    this.notaAcceso = notaAcceso;
} else {
    System.err.println("El rango valido es de 0 a 10");
}
this.notaAcceso = notaAcceso; // <--- Esto sobreescribe todo lo anterior!
```

**BIEN**:

```java
if (notaAcceso >= 0 && notaAcceso <= 10) {
    this.notaAcceso = notaAcceso;
} else {
    System.err.println("El rango valido es de 0 a 10");
}
// NO asignamos nada, protegemos el dato original
```

---

## 🔨 Instanciar

Con esto creamos el objeto, le damos vida, y usamos `new` para ello.

```java
Alumno pepe = new Alumno(); // Nace Pepe
pepe.setNombre("Pepe");     // Le damos nombre usando el Setter (con validación)
```

---

## 📧 @Override

Damos contenido a un metodo que existe en una clase de la cual heredamos (extends Object). Todos los metodos publicos es como si formaran parte de la clase profesor aunque no esten definidos. Esto lo encontramos cuando hacemos clic derecho en el IDE **Eclipse** y le damos a `Source` - `Generate` - `toString()`.

---

## 🧬 Herencia

La herencia en JAVA es **simple**: no podemos heredar de más de una clase a la vez. Un alumno hereda todo lo de persona y a su vez todo lo que persona herede.

---

## 👷🏻‍♀️ Constructor

Esto es como el "trámite de nacimiento" de un objeto.  Cuando creamos un objeto nuevo (con `new`), java necesita saber "como mondá quiere q nazca este objeto?". El constructor es ese bloquecito de código que **prepara** el objeto para que este ready pa usarse.

Para no confundirnos con otros metodos, el constructor siempre cumple con:
1. Se llama **IGUAL** que la clase, case sensitive.
2. **NO** devuelve nada (ni `void`, ni `int`, ni na de na)
3. Se **ejecuta automaticamente** en cunato usas `new`.

```java
public class Personaje {
    /* por ejemplo, una clase pa crear pjs de videojuegos
    aqui tenemos atributos y caracteristicas
    */

    String nombre;
    int nivel;

    // CONSTRUCTOR
    // Fíjate: se llama igual que la clase y no tiene 'void'
    public Personaje(String nombreRecibido, int nivelRecibido) {
        this.nombre = nombreRecibido; // Asignamos el nombre
        this.nivel = nivelRecibido;   // Asignamos el nivel
    }
}
```

Y cuando vas pal `main` lo llamamos al cosntructor asi:

```java
Personaje miSacerdote = new Personaje("Aeryndra", 11);
```

Y es aqui donde java dice enga, creado el **espacio en memoria** pa tu pj. Ejecuto el constructor pa ponerle su nombre y su nivel.

Si no ponemos constructores java te crea uno **invisible** que está vacío, pero en cuanto tu escribes uno propio ya java obv no te pone el suyo automatico.

Sirve para **inicializar los atributos del objeto** (darles valor inicial) y  salta solo al ahcer el `new`.