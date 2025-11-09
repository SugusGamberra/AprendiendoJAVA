# 🚗 Simulación de Clases y Métodos: Público vs Privado

En esta sesión trabajamos con el ejemplo de **un coche** para entender mejor la **visibilidad de los métodos** y el **encapsulamiento** 🧠  

La idea es pensar en cómo, como conductores, usamos el coche sin necesidad de ver ni tocar cómo funcionan sus sistemas internos.  
Del mismo modo, en programación, **solo accedemos a lo público**, mientras que lo **privado** ocurre “por dentro”.

---

## 🧩 Estructura del Proyecto

El proyecto se organiza en **paquetes** (`packages`), que equivalen a **carpetas** en el disco duro:

| Carpeta / Package | Contenido | Descripción |
|--------------------|------------|--------------|
| `simulacion/` | `coche.java`, `conductor.java` | Simulación del funcionamiento básico de un coche. |
| `taxista/` | `taxistas.java` | Ejemplo adicional que reutiliza la clase `coche` desde otro package. |
| `bin/` | Archivos `.class` | Código compilado que ejecuta la **JVM (Java Virtual Machine)**. |

🔹 **Nota:**  
Eclipse muestra los packages con un icono blanco cuando están vacíos.  
Cuando añadimos una clase dentro, el icono cambia y el archivo `.java` aparece físicamente en el disco.  
En la carpeta `bin`, ese mismo archivo se transforma en `.class`, que es lo que **realmente ejecuta la JVM** (no el `.java`).

---

## ⚙️ Clase `coche`

Ejemplo simplificado:

```java
package simulacion;

public class coche {

    public static void ponerEnMarcha() {
        encendidoElectronica();
        inicioMecanico();
    }

    public static void acelerar() {
        aumentoCaudalGasolina();
        actualizacionContadorVelocidad();
    }

    public static void frenar() {
        activacionElectronicaFrenos();
        activacionMecanicaFrenado();
    }

    public static void detener() {
        detencionSistemasElectronicos();
        detencionSistemasMecanicos();
    }

    // Métodos internos (privados)
    private static void encendidoElectronica() { ... }
    private static void inicioMecanico() { ... }
}
```

**🧠 Explicación**: 

- Los métodos *públicos* (`public`) son los que podemos “accionar” desde fuera, igual que un conductor en un coche:
    - `ponerEnMarcha()`, `acelerar()`, `frenar()`, `detener()`.
- Los métodos *privados* (`private`) representan el funcionamiento interno:
    - `encendidoElectronica()`, `inicioMecanico()`, a`ctivacionMecanicaFrenado()`...
- Aunque no los veamos, *sí se ejecutan internamente* cuando usamos los métodos públicos.
    → Igual que el conductor no ve el motor funcionando, pero sabe que está actuando.

---

## 👨‍✈️ Clase `conductor`

```java
package simulacion;

public class conductor {
    public static void main(String[] args) {
        coche.ponerEnMarcha();
        coche.acelerar();
        coche.frenar();
        coche.detener();
    }
}
```

Aquí solo podemos llamar los **métodos públicos** del coche!! Los internos (privados) **NO** son accesibles porque están encapsulados dentro de la clase `coche`.

---

## 🚕 Clase `taxistas` y uso de otros packages

```java
package taxista;

import simulacion.coche;

public class taxistas {
    public static void main(String[] args) {
        coche.ponerEnMarcha();
        coche.acelerar();
        coche.frenar();
        coche.detener();
    }
}
```

- Usamos `import simulacion.coche;` para **reutilizar** código de otro paquete.
- Los taxistas pueden usar las mismas funciones del coche (*públicas*) pero **NO** acceder al interior del motor (*métodos privados*).
- Es como usar un -horno- o -tostadora-: Tienes una interfaz externa pero su mecanismo interior está protegido.

---

# 🧩 Conclusión

Este ejemplo ilustra la **importancia** de separar la interfaz externa (`public`) de la lógica interna (`private`).

Es el **fundamento de la programación modular y segura** que evita errores y mantiene un código limpio y escalable :P

> ✨ Un buen código es como la vida misma: el conductor no necesita entender qué pasa en el motor constantemente para conducir un coche!!