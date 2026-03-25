# 🗄️ [Conexión Java - MySQL con JDBC](./Jdbc.MySQL/)

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

### 🙍🏻‍♂️ La clase [`ClienteRepository`](./Jdbc.MySQL/src/aplication/ClienteRepository.java) (La Persistencia)

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

---

## 📖 Consultas con parámetros

Esto nos sirve para buscar por ejemplo el *id* de un cliente. Para evitar ataques (como la Inyección SQL) y hacer el código más limpio, usamos `?` como "huecos" que luego rellenamos.

> ⚠️ El error del `if (resultSet.next())`:
> `resultSet.first()`: A veces da problemas dependiendo del tipo de "cursor" que use la conexión.
> `resultSet.next()`: Es la forma estándar. El cursor del ResultSet empieza antes de la primera fila. Al llamar a `.next()`, se mueve a la primera fila. Si devuelve `true`, es que hay datos; si es `false`, la consulta volvió vacía.

```java
String sql = "SELECT * from Clientes WHERE id = ?";
PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setInt(1, id); // Rellenamos el primer '?' con el ID
ResultSet resultSet = preparedStatement.executeQuery();

if (resultSet.next()) { // Si hay un resultado...
    // Mapeamos el resultado al objeto Cliente
}
```

---

## 🫢 Actualización de datos

Para modificar registros, usamos la sentencia SQL `UPDATE`.

```java
public void update(Cliente cliente) {
    String sql = "UPDATE clientes SET razon_social = ?, nombre_comercial = ?, limite_credito = ? WHERE id = ?;";
    
    try (Connection connection = getConnection()) {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cliente.getRazonSocial());
        ps.setString(2, cliente.getNombreComercial());
        ps.setDouble(3, cliente.getLimiteCredito());
        ps.setInt(4, cliente.getId());
        
        ps.executeUpdate(); // Se usa executeUpdate para INSERT, UPDATE y DELETE
    } catch(SQLException e) {
        System.err.println(e.getMessage());
    }
}
```

---

## 🤔 Uso del `Optional<Cliente>`

Es una forma elegante de decir: "Oye, igual te devuelvo un cliente, o igual no hay nada (null)".

* Evita los famosos errores de `NullPointerException`.
* En el `Inicio.java`, lo compruebas con `.isPresent()`.

---

## ⚠️ Recordando y usando el **Patrón Singleton**

El objetivo de este patrón es asegurar que **solo exista una única instancia** de una clase en toda la aplicación. No queremos crear mil objetos `ClienteRepository`, sino que todos usen el mismo.

* **Constructor privado**: Nadie fuera de la clase puede hacer un `new ClienteRepository()`.
* **Atributo estático**: Guarda la única instancia que existirá.
* **Método `getInstance()`**: Es el "portero". Si la instancia no existe, la crea; si ya existe, te da la que ya tenía.

```java
private static ClienteRepository instance = null;

public static ClienteRepository getInstance(String url, String user, String password) {
    if (instance == null) {
        instance = new ClienteRepository(url, user, password);
    }
    return instance;
}
```

---

# [JDBC con UI](./Jdbc.MySQL.ConsoleApp/)

En esta ocasión estamos trabajando con una **UI** (interfaz de usuario) en consola. Como en el proyecto anterior, organizamos todo bien y separamos responsabilidades en distintas capas. Cada clase que haga su webadita pero que la haga bien 🙂‍↕️

---

## [Configuración](./Jdbc.MySQL.ConsoleApp/src/configuracion/MiConfiguracion.java)

No es seguro escribir contraseñas directamente en el código de conexión, por ende usamos un archivo externo llamado [`config.properties`](./Jdbc.MySQL.ConsoleApp/config.properties) que guarda la `url`, el `user` y el `password`.

La clase `MiConfiguracion` lee este archivo usando `BufferedReader` y la clase `Properties`.

Aplicamos el **patrón singleton** para cargar este archivo una sola vez en memoria.

---

## [El modelo](./Jdbc.MySQL.ConsoleApp/src/aplication/Cliente.java)

Este es el reflejo exacto de la tabla `clientes` de MySQL en Java.

* Tiene los mismos atributos (`id`, `razonSocial`, `nombreComercial` y `limiteCredito`)
* Contiene constructores, **getters** y **setters** para leer y escribir.
* Tiene un método `toString()` que devuelve el contenido del cliente en forma de `String`.

---

## [Núcleo de JDBC](./Jdbc.MySQL.ConsoleApp/src/aplication/ClienteRepository.java)

Se encarga **exclusivamente** de hablar con la **bbdd**.

* **Conexión**: El método `getConnection()` usa el `DriverManager` para abrir un puente con MySQL.
* **Consultas con parámetros**: Para evitar ataques (el famoso **SQL injection**) usamos `PreparedStatement` poniendo `?` como "huecos" que luego rellenamos con `setString`, `setDouble`, etc
* **Leer datos**: Hacemos `SELECT`. El resultado se guarda en un `ResultSet`. Con `while(resultSet.next())` recorremos las filas, creamos objetos `Cliente` y los metemos en un `ArrayList`.
* **Cierre seguro**: Todo va en un bloque `try-catch` y **siempre** cerramos la conexión con `connection.close()` para liberar y no bloquear la bbdd.

---

## [Lógica de negocio](./Jdbc.MySQL.ConsoleApp/src/aplication/ClienteService.java)

Es el cerebro que está entre la bbdd y el usuario.

* Contiene un método `validarCliente()` que comprueba que la razón social no esté en blanco o que el crédito no sea negativo antes de guardar nada.
* Si los datos están mal lanza una excepción (`IllegalArgumentException`) y si está bien le da permiso al `ClienteRepository` para ejecutar la acción.

---

## [UI](./Jdbc.MySQL.ConsoleApp/src/view/ClienteConsoleUI.java)

Esto es lo que se ve en consola. Dibuja los menús de forma estética y recoge lo que el usuario teclea con el uso de `Scanner`. Solo se comunica con `ClienteService`. Si el servicio da un error de validación, esta clase lo captura con el `catch` y muestra un mensaje amigable.

---

## [Punto de entrada](./Jdbc.MySQL.ConsoleApp/src/aplication/Inicio.java)

Es el `main`, simplemente obtiene los datos de `MiConfiguracion`, arranca el `ClienteService` y lanza el menú visual de `ClienteConsoleUI`.

---

> Usamos `Optional<Cliente>` para decirle tipo "igual la bbdd te devuelve un cliente o igual no". Lo usamos en el método `findById()` y evitamos los errores con esto de `NullPointerException`. En la interfaz en lugar de preguntar si es `null` preguntamos si está presente con métodos wapardos como `.ifPresentOrElse()`.
> La importancia del **Patrón Singleton** para asegurar que **solo exista una única instancia** de una clase en toda la app. No queremos abrir 80mil conexiones o leer mil veces el archivo de configuración.
> * **Constructor privado**: Nadie puede hacer un `new Clase()`.
> * **Atributo estático**: Guarda la única instancia que existira (`private static instance = null`)
> * **Método `getInstance()`**: Es como el portero, si la instancia no existe la crea. Si existe te dice que ya la tienes. Se usa en UI, Repository, Service y Configuración.
> Hoy hemos añadido también el eliminar por id, cosa nueva referente al otro día. Como en el resto, sencillamente almacenamos en una variable tipo `String` el comando para borrar en mySQL, hacemos la conexión, vemos lo valores a cumplimentar y ejecutamos la actualización:

```java
//borrar
public void deleteById(int id) {
	String sql = "DELETE FROM clientes WHERE id = ?";

	try(Connection connection = getConnection();) {

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		//valores a cumplimentar
		preparedStatement.setInt(1, id);

		//ejecuta la actualizacion
		preparedStatement.executeUpdate();

		connection.close();

	} catch(SQLException e) {
		System.err.println(e.getMessage());
	}
}
```

> Y así se vería en consola masomenos

<pre style="background-color: #1e1e1e; color: #d4d4d4; padding: 20px; border-radius: 10px; font-family: 'Courier New', Courier, monospace; line-height: 1.5; box-shadow: 0px 4px 10px rgba(0,0,0,0.3);">
<span style="color: #87CEEB;">   . ☁️  .  .  💙  .  .  ☁️  .</span>
<span style="color: #82a8fc;">  ╭──────────────────────────────────╮</span>
<span style="color: #82a8fc;">  │ </span><span style="color: #ffffff; font-weight: bold;">  ☁️ Cinnamoroll Management ☁️ </span><span style="color: #82a8fc;"> │</span>
<span style="color: #82a8fc;">  ├──────────────────────────────────┤</span>
<span style="color: #87CEEB;">    1.</span><span style="color: #ffffff;"> Listar mis clientes ✨</span>
<span style="color: #87CEEB;">    2.</span><span style="color: #ffffff;"> Buscar por ID 🔍</span>
<span style="color: #87CEEB;">    3.</span><span style="color: #ffffff;"> Buscar por Razón Social 📖</span>
<span style="color: #87CEEB;">    4.</span><span style="color: #ffffff;"> Dar de alta 🎀</span>
<span style="color: #87CEEB;">    5.</span><span style="color: #ffffff;"> Actualizar datos 📝</span>
<span style="color: #87CEEB;">    6.</span><span style="color: #ffffff;"> Eliminar cliente 🌸</span>
<span style="color: #FFB6C1;">    0.</span><span style="color: #ffffff;"> Salir 🌙</span>
<span style="color: #82a8fc;">  ╰──────────────────────────────────╯</span>
<span style="color: #87CEEB;"> ✨ Elige una opción: </span><span style="color: #ffffff;">_</span>
</pre>

---

# Spec Driven Development

Es **desarrollo guiado por especificaciones**, que es una metodología de desarrollo software en la que das specs claras y se definen **antes** de escribir código. El desarrollo se basa en cumplir exactamente estas specs. Funciona de la siguiente forma:

1. **Definir la especifiación**:
   1. *Ejemplo: El usuario puede iniciar sesión con el email y contraseñas válidos.*
   2. Se detallan condiciones, errores, límites, etc
2. **Convertir specs en pruebas (tests)**:
   1. Muchas veces se combina con *Test-Driven Development (TDD)*.
3. **Desarrollar el código**:
   1. Solo necesario para cumplir la spec
4. **Validar automáticamente**:
   1. Si el código cumple la spec = *correcto*
   2. Si no = *se corrige*

## Spec

Es un documento que describe la funcionalidad esperada, entradas y salidas, casos de uso, reglas de negocio, criterios de aceptación y ejemplos concretos (muy importante).

## RElación con otras metodologías

Muy relacionado con **Behavior-Driven Development** (specs en lenguaje natural) y TDD (specs como tests). SDD pone el foco en la spec como fuente de verdad.

**Spec**: Si el user introduce la contraseña incorrecta el sistema debe mostrar un mensaje de error. Test derivado:
```python
assert login("user@test.com", "wrongpass") == "Credenciales inválidas"
```

El código se implementa solo lo necesario para dicho test.

---

# [MVC](./MVC.ConsoleApp/)

> mvc model view control
> Vamos a hacerla app de escritorio

- **[Model domain](./MVC.ConsoleApp/src/model/domain/Cliente.java)**: De qué trata la aplicación. Si gestionáramos una app de una escuela es donde estarían las entidades aula, asignatura, profesores, alumnos, director, etc. Ponemos las estructuras de datos con la que trabaja la app.
- **[Model repository](./MVC.ConsoleApp/src/model/repository/ClienteRepository.java)**: Clases con acceso de persistencia a la aplicación.
- **[Controller](./MVC.ConsoleApp/src/controller/Inicio.java)**: Punto de entrada de la app. Es el intermediario que captura las interacciones del user en la vista y decide qué tiene que hacer, delegando el trabajo en los servicios correspondientes
- **[Model Configuration](./MVC.ConsoleApp/src/model/configuration/MiConfiguracion.java)**: Ajustes globales del sistema. Se centraliza las conexiones a la bbdd, rutas d archivos, credenciales o cualquier config inicial que la app necesite leer para arrancar correctamente
- **[Model Service](./MVC.ConsoleApp/src/model/service/ClienteService.java)**: Lógica d negocio. Se sitúa entre el controlador y el repositorio. Se aplican las reglas de la app (como validar que cierta info tenga un formato correcto y tal) antes de pedirle al repositorio que lo guarde en la bbdd
- **[View](./MVC.ConsoleApp/src/view/)**: La cara visible, bien con la UI de consola o con la de desktop

No se cambia nada del resto del código, solo le hemos incluido el cliente desktop. Vamos a trabajar con *eventos* y demás.

Los componentes básicos se basarán en **swing** que es una librería de JAVA jeje.