
package sprintCapacitacion;

import java.util.Scanner;

/**
 * Menú principal con nueve opciones: ocho para las acciones indicadas en el listado
 * anterior, y una opción para salir del programa. En caso de que se ingrese una opción incorrecta,
 * se debe pedir nuevamente. El programa solo terminará una vez que ingrese la opción de salida
 */
public class MenuPrincipal {

    // VARIABLES GLOBALES
    static int idCapacitacion = 0; // Correlativo de la Capacitacion
    static int idAccicente = 0; // Correlativo del Accidente
    static int idVisitaTerreno = 0; // Correlativo del Accidente
    static int idRevision = 0; // Correlativo del Accidente

    public static void menuOpciones(Contenedor contenedora) {

        boolean salir = false;

        while (!salir) {    // Menu de opciones, funciona mientras salir sea false
            System.out.println("--------------------MENU---------------------------");
            System.out.println("Por favor escoja una de las opciones del menu:");
            System.out.println("1-. Almacenar Cliente");
            System.out.println("2-. Almacenar Profesional");
            System.out.println("3-. Almacenar Administrativo");
            System.out.println("4-. Almacenar Capacitación");
            System.out.println("5-. Eliminar Usuario");
            System.out.println("6-. Listar Usuarios");
            System.out.println("7-. Listar Usuarios por Tipo");
            System.out.println("8-. Listar Capacitaciones");
            System.out.println("9-. Salir");

            Scanner sc = new Scanner(System.in); // Variable que lee el valor introducido por consola
            String opcion = sc.nextLine();


            switch (opcion) {
                case "1":
                    Contenedor.almacenarCliente(contenedora);
                    break;
                case "2":
                    Contenedor.almacenarProfesional(contenedora);
                    break;
                case "3":
                    Contenedor.almacenarAdministrativo(contenedora);
                    break;
                case "4":
                    Contenedor.almacenarCapacitacion(idCapacitacion, contenedora);
                    break;
                case "5":

                    Contenedor.eliminarUsuario();
                    break;
                case "6":
                    Contenedor.ListarUsuarios();
                    break;
                case "7":
                    Contenedor.ListarUsuariosPorTipo(contenedora);
                    break;
                case "8":
                    Contenedor.ListarCapacitaciones();
                    break;
                case "9":
                    salir = true; // vuelve salir true y sale del bucle
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opcion ingresada no es valida");
                    break;
            } // indica que la opcion ingresada no se encuentra dentro del menu
        }
    }
}




