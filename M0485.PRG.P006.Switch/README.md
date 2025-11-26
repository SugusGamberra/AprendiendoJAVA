# 🔁 SWITCH

El `switch` es la alternativa limpia a las cadenas larguiiiisimas y anidadiiiiisimas de los `if/ else if`. Si en if deciamos "si tengo esto haz aquello", aquí decimos "en el caso de tener esto, hazme aquello", casi igual vaya.

Con el _switch_ **comparamos una variable contra varios valores** y ejecutamos bloques según el caso. Como verás, es muy útil para muuuuchos casos ;) y no te deja el código tan guarro ni tan lioso :P

---

## ✅ Ventajas rápidas

- Código más legible que millones de `if` anidados.
- Más eficiente cuando comparas contra muchos valores!
- Con JAVA moderno puedes agrupar casos (ej: `case 1, 2, 3:`) para evitar ocupar mucho espacio

---

## 🧾 Reglas importantes a tener en cuenta

- **Sin `break`**: La ejecución _"cae"_ desde el caso válido hasta el final (**FALL-THROUGH**). Útil si buscas ejecutar varios casos seguidos.
- **Con `break`**: Evitas el **fall-through** y actúa como un `return` del `switch`.
- Hay un `default` que actúa como el `else` si ningún caso coincide.
- Conviene normalizar cadenas (`toLowerCase()` o `toUpperCase()`) antes de comparar para evitar problemas de mayus/minusculas!

---

## ✂️ Ejemplos (mira el repo para ver mejores ejemplos)

### `switch` sin `break` (fall-through)

```java
int dia = 1;

switch (dia) {
    case 1:
        System.out.println("Lunes");
    case 2:
        System.out.println("Martes");
    case 3:
        System.out.println("Miércoles");
    default:
        System.out.println("Dia no estipulado");
}
```
> ⚠️ Útil si quieres ejecutar todos los casos a partir de uno (ej. listado desde el día X).
> En este caso pedimos el día 1 así que listaría todos los casos ;D

### `switch` con `break` (forma HABITUAAAAL!!)

```java
int dia = 1;

switch (dia) {
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    default:
        System.out.println("Dia no estipulado");
}
```
> ✅ Aquí cada caso es independiente.
> Aunque elijamos desde el día 1 se para ahí por el `break;`

### `switch` con `string` y `metodo` (normalización)

```java
String color = RoJo;
color = color.toLowerCase();

switch (color) {
    case "rojo": System.out.println("red"); break;
    case "azul": System.out.println("azul"); break;
    default: System.out.println("ese color ta feo, no esta en el sistema");
}
```
> Si no normalizas (mayus y minusculas) tendrias que cubrir `"Rojo"`, `"rojo"`, `"ROJO"`, `"RojO"`, etc, con millones de casos
> Es es un rollazo x.x

---

## 📌 Mis consejos (Buenas prácticas)

- Usa `switch` cuando comparas **una variable** con **constantes conocidas**
- Si la lógica necesita condiciones complejas usa `if/else if`!
- Normaliza cadenas antes de comparar con `métodos`!
- Evita el `fall-through` accidental: ponle `breaks` salvo que literal **QUIERAS** el efecto de encadenamiento
- En operaciones numéricas evita mezclar tipos sin `casting` explícito (si trabajas con `byte`, `short`, `float`...)

---

> Y yastaria!! Es muy sencillo y muy diver de usar!!
> No es lo mismo que el if, y no es que switch sea mejor que if NI VICEVERSA!
> Hay que saber CUÁNDO usarlos y CÓMO usarlos ;)