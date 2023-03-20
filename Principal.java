package sprintCapacitacion;


/**
 * Clase Principal, la que tendrá como objetivo crear una instancia de la clase
 * Contenedor, lo que creará con ello las dos listas que considera esta clase.
 */
public class Principal {

	public static void main(String[] args) {

       Contenedor contenedora = new Contenedor();
    
       MenuPrincipal.menuOpciones(contenedora);


	}

}
