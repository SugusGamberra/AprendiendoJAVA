# 🗄️ Conexión Java - MySQL con JDBC

Para poder trabajar con **bbdd** de forma particular, java necesita una **libreria** que sea capaz de entender cómo trabajar con **sql** (por ejemplo).

Cada fabricante proporciona estas librerias para que podamos usarlas en nuestros proyectos.

---

## ⬇️ Descargar el Conector

Para ello buscamos [mvn sql](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j) donde encontramos conectores java. Si existen vulnerabilidades te las muestran las páginas.

> **MVN repository** es un repo para java de librerías que podemos incorporar a nuestros proyectos para trabajar con java.

Escogemos siempre la versión más nueva y le damos al archivo `.jar` para bajarlo. Es un conector `.jar`, esto se añade al proyecto. Para mantener nuestros archivos siempre a salvo, se recomienda guardarlo en alguna carpeta que designemos para nuestras librerias ;P

---

## 🔩 Añadir el JAR al proyecto

1. En **Eclipse** hacer clic derecho sobre el **proyecto** en el que estés trabajando - `Build Path` - `Configure Build Path`.
2. Se abrirá una ventana. Vamos a la pestaña **Libraries**.
3. Seleccionamos con el ratón `Classpath` y le damos a `Add External JARs`. Buscamos nuestra libería y la seleccionamos.
4. Una vez cargada, le damos a `Apply and close`, veremos en el explorador de paquetes nuestra libreria referenciada.

---

## 🗂️ Crear la BBDD

Abrimos MySQL Workbench y creamos una bbdd:

```sql
CREATE DATABASE m0495_prg_p23;

USE m0495_prg_p23;

CREATE TABLE clientes (
    id               INT           AUTO_INCREMENT PRIMARY KEY,
    razon_social     VARCHAR(150)  NOT NULL,
    nombre_comercial VARCHAR(150),
    limite_credito   DECIMAL(15,2) NOT NULL DEFAULT 0.00
);
```

---

## 💻 Código JAVA (jdbc)

Ahora creamos el código que nos permita acceder a la bbdd.

Necesitamos saber a qué bbdd nos vamos a ir y con qué **user** y **password** nos conectamos a esa bbdd.

> *(JDBC = Java Data Base Connectivity)*

Para organizar bien el proyecto y separar responsabilidades, hemos dividido el código en tres clases principales:

### 📝 La clase [`Cliente`](./Jdbc.MySQL/src/aplication/Cliente.java) (El Modelo)

Esta clase es básicamente un reflejo de la tabla `clientes` que hemos creado en MySQL.

* Tiene los mismos atributos como variables de clase (`id`, `razonSocial`, `nombreComercial`, `limiteCredito`).
* Tiene sus constructores vacíos y con parámetros.
* Usamos métodos **Getters y Setters** para poder leer y escribir en esas variables.
* Incluimos un método `toString()` que nos permite devolver el contenido del cliente en forma de `String` (muy útil para imprimir por consola luego y ver qué datos tiene el objeto).

### 🗄️ La clase [`ClienteRepository`](./Jdbc.MySQL/src/aplication/ClienteRepository.java) (La Persistencia)

En Java, a todo lo que se encarga de la **persistencia** (guardar y leer datos en la bbdd) se le suele llamar *Repository*. Aquí está el núcleo de JDBC:

* **Conexión:** Tenemos las variables `url`, `user` y `password`. El método `getConnection()` usa el `DriverManager` de Java para devolvernos un objeto `Connection` abierto hacia MySQL.
* **Insertar datos (`create`):** Preparamos una sentencia SQL (`INSERT INTO...`). Usamos la interfaz `PreparedStatement`, que nos permite poner interrogaciones `?` en los `VALUES`. Luego le pasamos los datos del objeto cliente a esos `?` y ejecutamos la actualización con `executeUpdate()`.
* **Leer datos (`findAll`):** Hacemos un `SELECT * from Clientes`. Usamos un `Statement` para ejecutar la query y el resultado nos lo devuelve en un objeto `ResultSet` (que es como una tabla virtual). Con un bucle `while(resultSet.next())` vamos recorriendo las filas, extrayendo las columnas (por nombre o por número), creando objetos `Cliente` y metiéndolos en un `ArrayList`.
* **Manejo de errores:** Todo lo que toca la bbdd va dentro de un bloque `try-catch`. Si algo falla (la bbdd está apagada, la contraseña está mal, etc.), Java lanza una `SQLException` y la capturamos para imprimir el error.

### 🩵 La clase [`Inicio`](./Jdbc.MySQL/src/aplication/Inicio.java) (El Main)

Es el punto de entrada de nuestro programa para probar que todo lo anterior funciona.

* Definimos las constantes de conexión: la `URL` (que incluye `jdbc:mysql://localhost:3306/`, salvo que lo cambiemos siempre es el mismo en MySQL Workbench, y el nombre de nuestra bbdd), el `USER` (normalmente `root`) y el `PASSWORD` que le tengamos puesto.
* **Método `crearCliente()`:** Instanciamos objetos `Cliente`, les damos valores con los *setters*, creamos un `ClienteRepository` y llamamos al método `create` para guardarlos en MySQL.
* **Método `listaTodosLosClientes()`:** Llamamos al método `findAll()` del repositorio, guardamos el resultado en un `ArrayList` y usamos un bucle *for-each* para imprimirlos uno a uno por consola.