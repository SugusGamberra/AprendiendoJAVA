# 🐳 POO

> Hoy se nos presenta un nuevo elemento de *POO*.
> Aunque es un poco dificil de programar y no se le pueda ver mucho la utilidad, se usa mucho esa **interfaz**
> Tenemos en cuenta que la herencia en JAVA es **simple**, no podemos heredar de 2 clases a la vez

Cib este proyecto explicamos la diferencia entre **herencia** (clases abstractas) e **interfaces** usando asi un ecosistema de animales como ejemplo!

---

## Clases abstractas vs Clases normales

Usamos `abstract` cuando una clase es demasiado generica para existir por sí misma.
* **Animal**: No puedes crear un "Animal" a secas (tipo, que sonido hace un animal? Tendras que decirme que animal, no?). Por eso es `abstract`.
* **Mamifero**: Sigue siendo abstracta porque un "Mamifero" generico tampoco existe, pero ya añade caracteristicas propias como un periodo de lactancia.
* **Perro**: Esta ya si es **concreta**, aquí si podemos hacer un `new Perro()`.

---

## Interfaces

Resuelven problemas como la **herencia simple** de java. Por ejemplo, imagina que quieres añadir el método `vuela()`. Si lo pones en `Animal`, los peces tambien volarian??? Pos no. Si lo pones en `Mamifero`, los murcielagos estarían bien, pero los perros vuelan??? Po tampoco.

La solución son las **interfaces**: Son como "contratos" de capacidades. No importa de qué familia venga el animal (ave mamifero whatever), si vuela, firma el contrato!

---

## Jerarquia del proyecto

### [`Animal`](./POO/src/animales/familias/Animal.java)

Define lo que **todos** tienen (nombre, codigo) pero deja a medias lo que no sabemos como hacen (`getSonido`).

```java
public abstract class Animal {
    private String nombre;
    // Métodos abstractos: obligan a los hijos a decidir q poner
    public abstract String getSonido(); 
    public abstract String getDieta();
}
```

### [`Interfaces`](./POO/src/animales/capacidades/)

Son los "superpoderes" q añadimos a cualquier clase sinn importar su herencia!

```java
public interface IDesplazamientoAereo {
    int getPromedioVelocidadVuelo(); // Por defecto son public y abstract
}
```

### [`Clases concretas`](./POO/src/animales/especificos/)

Aquí es donde todo se arrejunta. Un `murcielago` es un `mamifero` y a la vez es `volador`

```java
public class Murcielago extends Mamifero implements IDesplazamientoAereo {
    // Implementa lo de Animal (dieta, sonido)
    // Implementa lo de Mamifero (lactancia)
    // Implementa lo de la Interface (velocidad de vuelo)
}
```

---

## Polimorfismo

Aqui viene la utilidad de esto. La magia ocurre en `main` donde creamos un metodo que acepte cualquier cosa que vuele, sin importarle si es un periquito, un murciélago o un avión!

```java
private static void vuela(IDesplazamientoAereo volador) {
    System.out.println("Velocidad: " + volador.getPromedioVelocidadVuelo());
}
```

* `vuela(halcon)`: Funciona
* `vuela(murcielago)`: Funciona
* `vuela(perro)`: Error d compilacion (el perro no firmo el contrato d vuelo)

---

> Seguimos el proximo dia!