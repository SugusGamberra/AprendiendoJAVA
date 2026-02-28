# 🗒️ Text Files

> Ahora que sabemos manejar excepciones, tenemos que aprender a leer y escribir ficheros en java.
> Java es muy utilizado y ha tenido muchas versiones. De ahí la importancia de saber usarlo.

---

## [Escribir fichero](./TextFiles.v01/src/aplicacion/EscribirFichero.java)

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

## [Leer Fichero](./TextFiles.v01/src/aplicacion/LeerFichero.java)

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