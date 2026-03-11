# 🗒️ Text Files

> Ahora que sabemos manejar excepciones, tenemos que aprender a leer y escribir ficheros en java.
> Java es muy utilizado y ha tenido muchas versiones. De ahí la importancia de saber usarlo.

---

## ✍🏻 [Escribir fichero](./TextFiles.v01/src/aplicacion/EscribirFichero.java)

Usamos `FileWriter` para escribir.

```java
void escribir(String rutaFichero, String contenido) {

	try {
		
		FileWriter fileWriter = new FileWriter(rutaFichero);
		
		// creamos el contenido y cerramos el fichero
		fileWriter.write(contenido);
		fileWriter.close();
		
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}
   }
```

Cada carácter que lee lo guarda en el disco, y esto es una de las cosas que más lentas son. Para acelerar esto se usa una clase que acumula todos los caracteres que puede recordar los vuelca en el disco a la vez, es la clase `BufferedWriter`.

Instanciamos el `FileWriter` y, a continuación, el `BufferedWriter` para que almacene la secuencia.

Podemos añadir `Scanner` para que el usuario introduzca también lo que quiera y que se refleje en el archivo.

Para **añadir información** a un fichero que exista ponemos `true` en `fileWriter`. Si no se pone ningún parámetro sobreescribe el fichero:

```java
// Con 'true' no sobreescribimos, se añade lo nuevo al final del fichero
FileWriter fileWriter = new FileWriter(rutaFichero, true);

// Usamos BufferedWriter porque tira menos del disco y es más rápido
BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

// Recorremos el contenido y lo escribimos línea a línea
for(String linea : contenido) {
    bufferedWriter.write(linea);
    bufferedWriter.write("\n"); // Añadimos el salto de línea pa que no salga todo junto
}

// ¡Es vital cerrar siempre el fichero al terminar!
bufferedWriter.close();
```

---

## 👓 [Leer Fichero](./TextFiles.v01/src/aplicacion/LeerFichero.java)

Para leer ficheros, aplicamos la misma lógica de optimización que al escribir. En lugar de leer directamente del disco con `FileReader`, lo envolvemos en un `BufferedReader` para que la lectura sea mucho más rápida.

La forma correcta de hacerlo es leer el archivo línea por línea dentro de un bucle `do-while`. El bucle se detendrá cuando la línea sea `null`, lo que significa que hemos llegado al final del documento.

```java
FileReader fileReader = new FileReader(rutaFichero);

// Lo envolvemos para que sea más rápido
BufferedReader bufferedReader = new BufferedReader(fileReader);

String linea;
StringBuilder sb = new StringBuilder(); // Para ir concatenando todo el texto

// Leemos hasta que no haya más líneas (hasta que devuelva null)
do {
    linea = bufferedReader.readLine();
    
    if (linea != null) {
        sb.append(linea);
        sb.append("\n");
    }
} while(linea != null);

// Guardamos todo el contenido en un String y cerramos los ficheros
String contenidoFinal = sb.toString();

fileReader.close();
bufferedReader.close();
```

---

## ⚙️ Fichero de propiedades

Hasta ahora hemos **hardcodeado**, es decir, hemos puesto dentro del código las rutas y tal. Ahora vamos a aprender a hacer un **archivo de propiedades** que nos permita buscar la ruta que tengamos dentro para escribir o leer un fichero.

### Config externa

En vez de escribir las rutas directamente en el código usamos **archivo** llamado [`config.properties`](./TextFiles.v01/config.properties) con una estructura definida. Esto permite cambiar el comportamiento del programa (como la ruta del archivo o si queremos sobreescribir datos) sin necesidad de volver a compilar el código!

- `ruta`: Define dónde se encuentra el archivo.txt
- `agregar`: Un flag (1 o 0 para sí y no) que indica si queremos añadir texto al final del archivo o borrar lo anterior.

### [Flujo de trabajo](./TextFiles.v01/src/configuraciones/MiConfiguracion.java)

- **Carga de propiedades**: Se usa la clase `java.util.Properties` para mapear el archivo de texto a pares clave-valor.
- **Uso de Buffers**: Para la escritura implementamos `BufferedWriter`. Es más óptimo ya que no "ataca" el disco por cada carácter como vimos, sino que acumula datos en memoria antes d escribir.
- **Persistencia**: El método `escribir` recibe un boolean (`append`) que determina si el `FileWriter` debe posicionarse al final del archivo o empezar desde 0.

> ⚠️ **TIP**: En el código proporcionado x el profe a la hora de agregar ponemos `== "1"`, esto puede dar dolor d cabeza, yo voy a respetar el código tal cual, pero si me dejas a mi sola uso `.equals()`xk en JAVA el `==` a veces falla y da x saco:

```java
public boolean getAgregar() {
    String agregar = properties.getProperty("agregar", "0");
    //esto es lo q yo haria:
    if ("1".equals(agregar)) {
        return true;
    } else {
        return false;
    }
}
```

---

# Path (NIO)

Hemos dejado atrás las clases antiguas de Java (el paquete `java.io` clásico) para usar **NIO (New I/O)**, que está en el paquete `java.nio`. Es más moderno, rápido y flexible.

* `Path` y `Paths`: Es el sustituto moderno de la antigua clase `File`. Representa la ruta del archivo en tu disco duro. Se crea facilísimo: `Path path = Paths.get(rutaFichero);`

---

## ✍️ [Escribir Ficheros](./TextFiles.v02/src/aplicacion/EscribirFichero.java) (`Files.newBufferedWriter`)

Para escribir, hemos usado un `BufferedWriter`. La ventaja es que **NIO** te permite instanciarlo de golpe con un método estático, pasándole toda la configuración de una vez.

**Conceptos clave al escribir**:

* **Encoding explícito (BUENA PRÁCTICA)**: Con `StandardCharsets.UTF_8`. Esto le dice a Java exactamente cómo traducir los caracteres a bytes. Si no lo pones, el sistema usa el suyo por defecto y al abrirlo en otro PC con otra codificación, las tildes o las 'ñ' se verán como símbolos raros.
* `StandardOpenOption`: Son las "reglas" de cómo se abre el archivo:
  * `CREATE`: Si el archivo no existe, lo crea.
  * `APPEND`: Añade el texto al final del archivo sin borrar lo que ya hay.
  * `TRUNCATE_EXISTING`: Machaca el archivo; borra lo que había y escribe lo nuevo.
* `newLine()`: En lugar de meter un `\n` a mano (que en Windows a veces da guerra), el `BufferedWriter` tiene este método que mete el salto de línea perfecto según el sistema operativo en el que estés.

---

## 📖 [Leer Ficheros](./TextFiles.v02/src/aplicacion/LeerFichero.java) (`Files.newBufferedReader`)

La lectura es súper parecida, pero usando un `BufferedReader`.

**Conceptos clave al leer**:

* **El bucle de lectura**: Usamos el clásico `while((linea = bufferedReader.readLine()) != null)`. Esto lee línea por línea hasta que se queda sin texto (y devuelve null).
* `StringBuilder`: Super importante! En vez de ir sumando `String` con el símbolo `+` (lo cual consume muchísima memoria en Java), cogemos `StringBuilder` y su método `.append()`. Es la forma más óptima de juntar todo el texto del fichero en una sola variable.

---

## ⚙️ [Archivos de Propiedades](./TextFiles.v02/src/configuraciones/MiConfiguracion.java) (`.properties`)

Esto es vital para no hardcodear rutas, contraseñas o configuraciones.

* **Para qué sirve?**: Sacas variables como la ruta del archivo (`C:/.../fichero.txt`) a un archivo de texto externo ([`config.properties`](./TextFiles.v02/config.properties)). Así, si cambias de ordenador, solo modificas el archivo `.properties` sin tener que tocar el código Java ni volver a compilar.
* **Clase `Properties`**: Es una clase especial de Java que funciona como un diccionario. Le pasas el lector del archivo (`properties.load(bufferedReader)`) y luego sacas los valores con `properties.getProperty("clave", "valor_por_defecto")`.

> Proximo día probaremos una optimización, no sé si será el `Patrón Singleton` o **bloques estáticos** para que el archivo de configuración se lea solo una vez al arrancar el programa y no cada que creas un objeto `MiConfiguracion`... Ya veremos :P

---

# [Generar documentación](./TextFiles.v02/src/ProyectoMagia/)

Para que esto funcione es necesario comentar el código como toca!!

1. A nivel de proyecto creamos una carpeta.
2. Dentro, arrastramos ficheros que tengamos.
3. En **Eclipse**, arriba donde File, Edit, etc, le damos a `Project` - `Generate Javadoc`. Marcamos todo público, seleccionamos la carpeta de destino y le damos a `Next`.
4. Le damos un nombre y pasamos a `next` y `finish`.

Esto nos habrá generado una documentación recopilada por clases.

Voy a hacer un ejemplo chiquitísimo por mi cuenta para que veáis cómo se hace con una clase [`LectorRunas`](./TextFiles.v02/src/ProyectoMagia/LectorRunas.java).

Ahora si abrimos [`index.html`](./TextFiles.v02/DocManual/index.html) veremos la docu montada!

---

# Patrón Singleton

Lo que haremos hoy es una modificación para que llame a una instancia de la configuración en diferentes sitios.

En la clase [`main`](./TextFiles.v02/src/aplicacion/Main.java) instanciamos `MiConfiguracion mc = new MiConfiguracion();`. Nada me impide volver a instanciarlo tantas veces como quiera/necesite. Esto implica que esta clase `mc` y `mc2` estaría en memoria 2 veces.

Para evitar que se llame cuando quieran, en [`MiConfiguracion`](./TextFiles.v02/src/configuraciones/MiConfiguracion.java) el método público de `MiConfiguracion` quiero que lo pueda llamar en cualquier lado con solo una instancia y reutilizarla. Para ello usamos lo que dijeeee el **PATRON SINGLETON**!!!! VAMOSSSS ESE PEDAZO DE PREDICTTTT!!!! (si, estoy tomando apuntes y escribiendo esto a la vez que veo las clases muejeje)

La cosa es conseguir que aunque sea privado lo podamos llamar desde cualquier otro lado.

```java
// PATRON SINGLETON
private MiConfiguracion() {
	cargarPropiedades();
}

/* Ahora lo que hacemos es crear una variable privada de esta clase
 * Luego creamos un metodo publico estatico para poderlo llamar sin pasar x la clase
 * que devolvera una variable q llamaremos getInstance
 * Dentro hacemos comprobaciones
 */

private static MiConfiguracion instance = null;

public static MiConfiguracion getInstance() {
	if (instance == null) {
		instance = new MiConfiguracion();
	}
	
	return instance;
}
// fin patron singleton
```

Esto son cosas tipo ingeniería de software, truquitos wapardos.