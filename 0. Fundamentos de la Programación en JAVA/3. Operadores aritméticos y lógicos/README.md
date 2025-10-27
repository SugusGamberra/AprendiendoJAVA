# OPERADORES ARITMETICOS

Estos son los simbolitos que le dicen a JAVA que operacion aritmetica debe realizar con los valores (ya sean literales o almacenados en variables).

## Operadores básicos

- Suma: +
- Resta: - 
- Multiplicación: *
- División: /
- Módulo o resto: % (devuelve el resto de una división)

Aquí viene la importancia de declarar las variables como toca:

int resultado = 7 / 2;

Su resultado es sin decimales, si queremos decimales la declaramos como un doouble!!!

double resultadoDecimales = 7.0 / 2;

## Que pasa con la concatenación y el simbolo "+"?

Como en otros lenguajes el simbolito + tiene doble funcion:

1. Concatenar: Si los números van despues del texto se convierte en texto!

System.out.println("La edad es: " + 25 + 5);
// Te mostraría "La edad es: 255"

2. Sumar

// Si los numeros estan antes del texto si te hace el cálculo

System.out.println(25 + 5 + " es la edad");
// Te devuelve "30 es la edad".

// Lo mejor, usale pareentesis!!

System.out.println("La edad es: " + (25+5));


## Asignación aritmética (abreviaturas)

- += : a = a + b 
- -= : a = a - b
- *= : a = a * b
- /= : a = a / b
- %= : a = a % b

## Incremento y decremento

- ++ : Incremento
- -- : Decremento

int vidas = 3;
vidas--
vidas++

### Post-incremento vs Pre-incremento

- Post-incremento (i++): El valor de la variable se usa primero en la operacion y despues se incrementa.
- Pre-incremento (++i): El valor de la variable se incrementa primero y despues se usa en la operacion.

## Prioridad de operadores

El orden importa más que el tamaño ñ.ñ

Per sé JAVA hace primero multiplicaciones, divisiones y el resto, luego hace sumas y restas. Si quieres priorizar un orden concreto debes usar paréntesis, lo que esté dentro se calculará primero!

- Normal: 10 + 5 * 2 = 20 (Primero hace 5*2 y despues suma el resultado con 10)
- Con paréntesis: (10 + 5) * 2 = 30 (Primero hace 10+5 y luego multiplica el resultado por 2)

Ya estaría todo! En un futuro haré una carpeta con ejercicios para que practiques lo que se va viendo ;3

Mientras échale un vistazo al [código](./operadoresAritmeticos/src/operadoresAritmeticosPackage/operadoresAritmeticos.java) para que puedas ir viendo lo que explico y lo puedas probar por tu cuenta!