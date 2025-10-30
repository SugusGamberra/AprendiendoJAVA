# ESTRUCTUTAS DE COPNTROL DE FLUJOS

De momento estamos ejecutando código línea por línea. Estas estructuras nos sirven para saltar lineas, repetir bloques o ejecutar código con condicionales!

### Operadores de comparación

- Igual que: ==
- Distinto que: !=
- Mayor que: >
- Mayor o igual que: >=
- Menor que: <
- Menor o igual que: <=

### Operadores lógicos

- Y: &&
    - if (edad >= 18 && esEstudiante_daw) // es verdadero (true) si ambos son true
- O: ||
    - if (edad > 65 || esEstudiante_daw) // Al menos una debe ser true
- No: !
    - if (!tieneEntrada) // Si tieneEntrada es true, !tieneEntrada seria false

## Condicionales

### If/Else

Si se cumple esta condicion haz esto, si no, haz lo otro!

int edad = 20;

if (edad >= 18) {
    System.out.println("Eres mayor de edad!!");
} else {
    System.out.println("tas chikito uwu no puedes pasar!!!");
}

### Else if

int nota = 7;

if (nota == 10) {
    System.out.println("boh, fieroteeee!!");
} else if (nota >= 6) {
    System.out.println("not bad");
} else if (nota == 5) {
    System.out.println("por los pelosssss");
} else {
    System.out.println("palmaste colega :c");
}

### Switch

En vez de andar repitiendo else ifs 80 millones de veces tenemos los switch :3

String comando = "atacar";

switch (comando) {
    case "atacar":
        System.out.println("Has lanzado un ataque");
        break;
    case "defender":
        System.out.println("Te has defendido!");
        break;
    case "usarItem":
        System.out.println("Abres la mochila...");
        break;
    default:
        System.out.println("No se reconoce este comando");
}

### Enhanced switch (JAVA 14+)

Si corres un java superior a 14 tu switch es mucho mas limpio :3 No necesita breaks, lo hace la flechita esa :3

String comando = "atacar";

switch (comando) {
    case "atacar" -> System.out.println("Has lanzado un ataque");
    case "defender" -> System.out.println("Te has defendido!");
    case "usarItem" -> System.out.println("Abres la mochila...");
    default -> System.out.println("No se reconoce este comando");
}

## Bucles

Cuiiiidao con los bucles infinitos, usamos breaks (rompe el bucle y se sale) y continue (se salta lo que queda de la iteracion y pasa a la siguiente).

### While

Mientras se cumple esta condicion hazme esto

int contador = 1;

while (contador <= 5) {
    System.out.println("El contador vale: " + contador);
    contador++;
}

System.out.println("El bucle while ha terminado!");

### Do...while

De esta forma ves que en el do se ejecuta si o si la primera vez a pesar de la condicion que le hemos puesto, la condicion del contador menor o igual a 5 la mira al final, por lo que lo ejecuta, le suma 1 al contador (quedando 101) y dice al final vale, paro ya que el resultado es mayor que 5.

int contador = 100;

do {
    System.out.println("El contador vale: " + contador);
    contador++;
} while (contador <= 5);

System.out.println("El bucle do-while ha terminado! El contador vale: " + contador);

### For

Sirve para contar!

for (int i = 0; i < 5; i++) {
    System.out.println("Repeticion del numero " + i);
}

### For each

Este sirve para recorrer colecciones :3

String[] lstInvitados = {"Sahoro", "Gemma", "Anastasio", "Alisa Melano"};

for (String nombre : lstInvitados) {
    System.out.println("Bienvenide mi estimade " + nombre);
}

System.out.println("Lista finalizada");

Tienes el [código](./controlFlujos/src/controlFlujosPackage/controlFlujos.java) a tu disposicion! Echale un vistazo :3