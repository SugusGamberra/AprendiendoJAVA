# 🧠 Scanner + Condicionales en Java

> Clase de hoy, resumidita y útil ✨

---

##  📌 Recordatorio rápido sobre tipos primitivos

En Java estamos usando tipos como `int` o `String`, pero existen muchos más (ya los tienes en [0.Fundamentos de la Programación](../0.%20Fundamentos%20de%20la%20Programación%20en%20JAVA/2.%20Variables/), así que no los repito 🫶).

En el ejemplo de clase:

```java
byte numAulas1 = 25; 
short numAulas2 = 25;
int numAulas3 = 25;
long numAulas4 = 25;
```

### 💡 Qué aprendimos?

- Todos estos tipos pueden almacenar el valor `25`, así que funcionan.
- 👉 La mejor opción es `byte` porque ocupa menos memoria.
- En desarrollo local da igual… **pero en la nube la memoria cuesta dinero**, así que debemos ser eficientes.

Elegir el tipo correcto = menos consumo ⚡

---

## 📌 Pedir datos por consola con `Scanner`

Para leer lo que escribe el user necesitamos importar previamente:

```java
import java.util.Scanner;
```

Luego creamos el objeto:

```java
Scanner peticion = new Scanner(System.in);
```

### 🔍 Qué significa esto?

- `Scanner`: Herramienta para leer datos
- `new`: Creación de nuevo objeto
- `System.in`: La *fuente* de donde vienen los datos (la consola), que también podría ser un archivo u otra fuente

```java
System.out.println("Dame un nombre:");
String nombre = peticion.next();

System.out.println("¿Cuál es tu edad?");
byte edad = peticion.nextByte();

System.out.println("La edad de " + nombre + " es " + edad + " años!");
```

---

## 📌 Condicionales (repasito rapidito 🌈)

```java
if (edad <= 16) {
    System.out.println("Debes estudiar!!");
}
else if (edad > 16 && edad <= 65) {
    System.out.println("Puedes estudiar o trabajar!");
}
else {
    System.out.println("Puedes jubilarte!");
}
```

### Se pueden meter muchos `if` dentro de otro `if`?

Sí, pero no es buena idea abusar, porque modularizar luego... te cagas. Técnicamente no hay límite.