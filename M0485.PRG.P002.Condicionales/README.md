# 🧠 Tipos Primitivos + Scanner + Condicionales en Java

> se me borró esto, las liadas de git y github enfin
---
## 📌 Recordatorio rápido sobre tipos primitivos

En Java estamos usando tipos como int o String, pero existen muchos más (ya los tienes en 0.Fundamentos de la Programación, así que no los repito 🫶).

En el ejemplo de clase:
```java
byte numAulas1 = 25; 
short numAulas2 = 25;
int numAulas3 = 25;
long numAulas4 = 25;
```

### 💡 ¿Qué aprendimos?

Todos estos tipos pueden almacenar el valor 25, así que funcionan.

> 👉 La mejor opción es byte porque ocupa menos memoria.

En desarrollo local da igual…
pero en la nube la memoria cuesta dinero, así que debemos ser eficientes.
Elegir el tipo correcto = menos consumo ⚡

---

## 📌 Pedir datos por consola con Scanner

Para leer lo que escribe el usuario necesitamos importar:
```java
import java.util.Scanner;
```

Luego creamos el objeto:
```java
Scanner peticion = new Scanner(System.in);
```
> 🔍 ¿Qué significa esto?
> 
> Scanner = herramienta para leer datos.
> 
> new = estamos creando un objeto nuevo.
> 
> System.in = la fuente de donde vienen los datos (la consola).

También podría ser un archivo u otra fuente.

### ✏️ Ejemplo completo:
```java
System.out.println("Dame un nombre:");
String nombre = peticion.next();

System.out.println("¿Cuál es tu edad?");
byte edad = peticion.nextByte();

System.out.println("La edad de " + nombre + " es " + edad + " años!");
```
---

## 📌 Condicionales (repasito rápido 🌈)
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

Ya los viste en Fundamentos, así que este bloque era solo una práctica rápida 💁‍♀️

### 📌 ¿Se pueden meter muchos if dentro de otro if?

Sí, totalmente.
¿Es buena idea abusar? No mucho, porque modularizar luego es una fiesta 🎪😂
Pero técnicamente no hay límite.