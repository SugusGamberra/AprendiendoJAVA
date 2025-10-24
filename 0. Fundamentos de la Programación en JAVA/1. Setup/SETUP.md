# 🛠️ Preparando el Entorno (SETUP)

Holaaa! Este es el paso más aburrido pero más necesario! Yo te propongo estos pasos pero, si eres una persona muy visual, te recomiendo buscar tutoriales en youtube!

## JDK

### Qué es?

Es el motor que hace que JAVA funcione. Es lo primero que tenemos que tener ready, FUNDAMENTAL!! Es como el kit de herramientas de un albañil. Sin él no te puede levantar un muro!! Si leíste el [README](0. Fundamentos de la Programación en JAVA/README.md) lo tendrás ya bajado! Ejecuta el archivo que has descargado y yasta, sigue indicaciones si te las da en la instalación y listo!

Para ver si tu PC reconoce JAVA abre tu terminal (le das a inicio en tu PC y en el buscador pon CMD o Símbolo del sistema, a ese le das). 

Escribe en el cmd lo siguiente:

java -version

Le das a enter y te debería salir la versión que instalaste. Si no te sale ni te rayes, mira bien dónde instalaste JAVA y decirle a tu pc "oe está aquí instalada", su PATH vaya. Es más coñazo y técnico de hacer... si te pasa, busca un tutorial (como configurar path java en tal SO).

## Instalación del IDE que hayas elegido!

Un IDE es el entorno de desarrollo integrado: el programita donde picas código.

### 🥇 ECLIPSE

El que yo usaré ;3

1.  **Descarga:** Ve a [EnlaceDescarga](https://eclipseide.org) y descarga el instalador.
2.  **Instala:** Cuando ejecutes el instalador de Eclipse, **OJITOOOO!** Te preguntará qué tipo de Eclipse quieres.
    * Debes seleccionar: **"Eclipse IDE for Java Developers"**.
    * Elige la carpeta donde quieres instalarlo.
3.  **Workspace (Espacio de Trabajo):** La primera vez que lo abres, te preguntará dónde quieres guardar tus proyectos (el "Workspace"). Elige una carpeta que te sea fácil de recordar.

### 🥈 Opción 2: Visual Studio Code (El Navaja Suiza)

1.  **Descarga:** [EnlaceDescarga](https://code.visualstudio.com/)
2.  **Instala:** Es una instalación sencilla de "Next" y "Finish".
3.  **El Toque Mágico (Extensiones):** VS Code necesita ayudita para ser un IDE de Java.
    * Ábrelo y ve al icono de **Extensiones** (el cuadrado ese dividido en 4 cuadrados con uno puesto como un rombo).
    * Busca **"Extension Pack for Java"** y haz clic en **Instalar**.
    * Esto instalará todo lo necesario (depurador, ayuda con el código, etc.)
    4. **Listo!**: Ya es empezar a jugar ;P

### 🥉IntelliJ IDEA

1.  **Descarga:** Ve al enlace oficial y baja la **"Community Edition"** (es la gratisss): [EnlaceDescarga](https://www.jetbrains.com/idea/download/)
2.  **Instala:**
    * Ejecuta el instalador.
    * Te preguntará si quieres crear un acceso directo, y si quieres asociar los archivos `.java` con él. **Marca la opción de asociar `.java`**.
    * Sigue dando a "Next" y finaliza.
3.  **Listo:** Al abrirlo, te pedirá configurar cosillas y tal, eso a tu gusto ;P

## Tu primer proyecto en JAVA

Da igual cuál hayas elegido, nos vamos a cerciorar de que el IDE se comunica con el JDK:

1. Abre tu IDE
2. Crea un nuevo proyecto, da igual dónde elijas guardarlo! Yo le nombraré al archivo como ProbandoJDK.java (depende del IDE hará o no falta ponerle la extensión .java a tu archivo jeje)
3. Copia y pega este codigo:

// Probando el JDK

public class ProbandoJDK {
    // Para que te vayas ubicando, esto es donde empieza tu programa
    public static void main(String[] args) {
        // Ahora le daremos la instruccion pa que muestre un texto en la consola
        System.out.println("Hola JDK, estas ahi???");
    }
}

Según tu IDE podrás darle a un botón de JDK o en la misma terminal decirle "oye pásame esto por pantalla", por eso te recomiendo Eclipse, porque yo lo voy a enfocar todo esto a ese IDE :,) por lo general tos funcionan igual asi que nite :3 es por ello que voy a profundicar ahora mismitico en el paso a paso de ECLIPSE:

1. Abre Eclipse.
2. Se abrirá una ventana que te dará a elegir dónde ubicar tu espacio de trabajo. Te recomiendo crear una carpeta solo para ello! Te iré guiando proyecto a proyecto con estos pasos para que tengas todo siempre organizado, aunque ya te lo aprendas de memoria!!! Así que crea tu carpeta de trabajo dentro del workspace, ponle algo como AprendiendoFundamentosJAVA, y dentro de esta carpeta crea otra que se llame ProbandoJDK. Ya seleccionas esa en el launcher de eclipse y le das a "Launch".
3. Se te abrirá ya tu proyecto! Así que dale ahora a File - New - Project... - Se te abre una ventana emergente y la primera opción (si lo tienes todo bien) será "Java Project", seleccionas esa, le das a Next. Dale un nombre a tu proyecto, yo pondré ProbandoJDK y le das a Finish.
4. Te dirá si quieres abrir la perspectiva de JAVA, eso es que te pone los botoncitos en la barra de tareas que son concretos y útiles para JAVA. Yo le doy siempre a "Open perspective".
5. Verás que se te han abierto las carpetas en el Package Explorer, despliega y verás 2 subcarpetas, clic derecho en la que se llama "src" - New - Package - nombralo, yo le pondré "PJDKPackage", y le das a finish. 
6. Clic derecho de nuevo en "src" - New - Class - Nombralo como quieras (yo le pondre ProbandoJDK) y abajo marca "public static_void main(String[] args)". Dale a Finish!
7. Verás que te abre ya con todo casi hecho, sencillamente en la parte que verás // TODO blablabla , desde ahí puedes empezar a poner tu código. Yo desde ahí pondré unos comentarios para que tu puedas ver [mi código](./1.%Setup/ProbandoJDK/src/ProbandoJDK.java) explicado y palante!
8. Una vez hayas puesto tu "System.out.println("Hola mundo o lo q quieras poner");" dale al botoncito verde de play arriba y verás abajo en la consola que debería haber salido tu mensaje ;3
9. Listoooo!! A que es sencillito??

Nos vemos en la proxima leccion!! besissss!!
