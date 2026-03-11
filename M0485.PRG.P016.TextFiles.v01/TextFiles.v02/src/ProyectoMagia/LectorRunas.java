/**
 * Esta clase representa un lector de runas sencillo.
 * Sirve para dar un pequeño mensaje diario.
 * * @author SugusGamberra
 * @version 1.0
 */

package ProyectoMagia;

public class LectorRunas {

    /**
     * Saca una runa del día personalizada para quien consulta.
     * * @param consultante El nombre de la persona que pide la runa.
     * @return Un mensaje de texto con el significado de la runa del día.
     */
    public String sacarRunaDiaria(String consultante) {
        return "¡Hola " + consultante + "! Tu runa de hoy es Fehu: mucha abundancia y luz para ti.";
    }
    
}