# 🌟 Operador Ternario + Casting + Comprobar par-impar en Java

## 🧩 Operador ternario

Hasta ahora veníamos usando `if/else` para validar condiciones. Hoy veremos su **versión compacta**.

### 📌 Que es?

Es una forma **más corta** de escribir una condición **SIMPLE**, su estructura es:

```bash
(condicion) ? valorTrue : valorFalse
```

> 👉 Solo sirve cuando hay **UNA ÚNICA CONDICIÓN**!!!! Si la lógica tiene muchas ramas debemos volver al `if/else if/else`.

### ✏️ Ejemplo reducido

```java
String resultado = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
```

Podemos usarlo directamente dentro de un `println`:

```java
System.out.println((edad >= 18) ? "Mayor" : "Menor");
```

> 🤓 **Importante**:
> - Hace lo mismo que un `if`, pero ahorra líneas.
> - Útil cuando solo hay 2 opciones!
> - Poco recomendable si la expresión se empieza a volver compleja x.x
> - Aún así se puede anidar!!!

### ✏️ Ejemplo ternario anidado

Esto para cuestión de gustos, es legible, comprensible, más reducido...

```java
String franjaEdad = (edad >= 90) ? "Muy mayor uwu" :
							(edad >= 80) ? "Octogenario" :
								(edad >= 70) ? "Septuagenario" :
									"Aún un yogurin ñ.ñ";
```

---

## 📌 Operadores matemáticos

Están todos en este [ENLACE](../0.%20Fundamentos%20de%20la%20Programación%20en%20JAVA/3.%20Operadores%20aritméticos%20y%20lógicos/)

Lo único que comentaré aquí por añadir contenido nuevo es el tema de los **CASTINGS**:

Los resultados se guardan en una variable `short`, ya que esta si operas con ella se vuelve to creisi hay que **CASTEARLA**.

**Castear** es convertir entre tipos primitivos!

### ✏️ Micro-snippet ilustrativo

```java
resultado = (short) (edad+2);
resultado = (short) (edad*2);
resultado = (short) (edad%2);
```

> 🔍 **Detalles importantes**:
> - En java cuando mezclamos distintos tipos (`byte`, `short`, `float`...) el lenguaje puede obligarnos a **convertir** el resultado manualmente.
> - `(short)` es un **casting** para ajustar el tipo de dato resultante.

---

## 🎯 Como saber si un numero es par o impar?

Usamos el operador `%`, que devuelve el _resto_ de una división.

Si `edad % 2 == 0` → es par.
Si no → es impar.

### ✔️ Con if

```java
if (edad % 2 == 0) {
			tipo = "par";
		} else {
			tipo = "impar";
		}
```

### ✔️ Con ternario

```java
String tipo2 = (edad % 2 == 0) ? "Edad es par!" : "Edad es impar!";
```

---

#### 😼 Tip!!

En Eclipse puedes usar

```bash
Source → Format
```

Para que Eclipse te coloque bien el sangrado, llaves, saltos de línea, etc. Esto mantiene tu proyecto **limpio** y facil de leer :P

---

> La semana que viene los switch, si quieres adelantar visita este [ENLACE](../0.%20Fundamentos%20de%20la%20Programación%20en%20JAVA/4.%20Estructuras%20de%20control%20de%20flujos/) !!
> Pasa buena semanaaa ;D