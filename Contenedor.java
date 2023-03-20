package sprintCapacitacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Contenedor {
	public static ArrayList<Asesoria> asesorias = new ArrayList<Asesoria>();;
	public static ArrayList<Capacitacion> capacitaciones = new ArrayList<Capacitacion>();;
	public static Scanner sc = new Scanner(System.in);
	public static String input = "";
	public static boolean existe = false;

	private  Contenedor contenedora;

	/**
	 * Método que permite crear un nuevo Usuario que estara asociado ay sea a un Cliente, profesional o Administrativo
	 * 
	 * @param contenedora
	 */
	
	public static Usuario  ingresarUsuario(Contenedor contenedora) {
		long run =0;
		Usuario user = new Usuario();
		do{
			System.out.println("Ingrese un rut numérico menor a 99.999.999(*)");
			input = sc.nextLine();
			if (esNumerico(input)) {
				run = Long.parseLong(input);
				if (buscarRut(input)==false) {
					user.setRunUsuario(run);
					break;
				}else {
					System.out.println("El rut ingresado ya se encuentra registrado,ingrese otro rut");
					MenuPrincipal.menuOpciones(contenedora);
				}

			}
		}while( input.trim().isEmpty());

		do {
			System.out.println("Ingrese el nombre de Usuario(*): ");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un nombre vacío.Ingrese un nombre Valido");
			else
				user.setNombreUsuario(input);

		}while (input.trim().isEmpty());


		do {
			System.out.println("Ingrese la fecha de Nacimiento del Usuario(DD/MM/AAAA)(*):");
			input = sc.nextLine();
			if (input.isEmpty())
				System.out.println("!!Ingreso, vacío no permitido");
			else
				user.setFechaNacimientoUsuario(input);
		} while(input.trim().isEmpty());


		//Contenedor.asesorias.add(user);
		System.out.println("El Usuario ha sido guardado exitosamente.Ingrese los datos del Cliente");

		return user;


}
	
	public static void almacenarCliente(Contenedor contenedora) {
		Usuario usuario = ingresarUsuario(contenedora);

		// Ingreso los datos del Cliente
		Cliente cliente = new Cliente(usuario);

		// Solicito los nombres del Cliente
		do {
			System.out.println("Ingrese los nombres del Cliente(*): ");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un nombre vacío.Ingrese un nombre Valido");
			else
				cliente.setNombres(input);

		}while (input.trim().isEmpty());

		// Solicito los apellidos del Cliente
		do {
			System.out.println("Ingrese los apellidos del Cliente(*): ");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un nombre vacío.Ingrese un apellido Valido");
			else
				cliente.setApellidos(input);

		}while (input.trim().isEmpty());

		// Solicito el teléfono del cliente
		do {
			System.out.println("Ingrese nro Telefónico Formato Númerico, Ej: 951025250(*)");
			input = sc.nextLine();
			if (esNumerico(input)) {
				cliente.setTelefono(Integer.parseInt(input));
				break;
			} else {
				System.out.println("El Teléfono no tiene el formato indicado");

			}

		}while( input.trim().isEmpty());

		// Solicito el AFP del cliente
		System.out.println("Ingrese el AFP del Cliente:");
		input = sc.nextLine();
		cliente.setAfp(input);
		// Solicito el sistema de Salud
		do {
			System.out.println("Ingrese Sistema de salud: 1 (Fonasa) o 2 (Isapre), debe ser solo una de las dos\n" +
					"opciones indicadas)");
			input = sc.nextLine();
			if (esNumerico(input)) {
				cliente.setSistemaSalud(Integer.parseInt(input));
				break;
			} else {
				System.out.println("El sistema Salud solo acepta 1(Fonasa) ó 2(Isapre)");

			}

		}while( input.trim().isEmpty());
		// Solicito la dirección
		System.out.println("Ingrese Dirección del Cliente: ");
		input = sc.nextLine();
		cliente.setDireccion(input);
		// Solicito la comuna
		System.out.println("Ingrese la Comuna del Cliente: ");
		input = sc.nextLine();
		cliente.setComuna(input);
		// Solicito la edad
		do {
			System.out.println("Ingrese la edad del cliente.");
			input = sc.nextLine();
			if (esNumerico(input)) {
				cliente.setEdad(Integer.parseInt(input));
				break;
			} else {
				System.out.println("El Teléfono no tiene el formato indicado");

			}

		}while( input.trim().isEmpty() || (input.trim().length()>= 10 && input.trim().length()<=0));

		System.out.println("El Cliente ha sido guardado exitosamente.");
		Asesoria clienteA = (Asesoria) cliente;
		// asesorias.add(cliente);

		asesorias.add(clienteA);
	}

	/**
	 * Método que permite agregar un nuevo Profesional a la lista de instancias de
	 * la interface asesoria
	 * 
	 * @param contenedora
	 */
	public static void almacenarProfesional(Contenedor contenedora) {
		Usuario usuario = ingresarUsuario(contenedora);

		// Ingreso los datos del Profesional
		Profesional profesional = new Profesional(usuario);

		// Solicito el titulo
		do {
			System.out.println("Ingrese el título del profesional(*): ");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un título vacío.Ingrese un título valido");
			else
				profesional.setTitulo(input);

		}while (input.trim().isEmpty() );

		// Solicito la fecha de Ingreso
			System.out.println(" Ingrese la fecha de Ingreso del Profesional(DD/MM/AAAA):");
			input = sc.nextLine();
			if (input.isEmpty())
				System.out.println("!!Ingreso, vacío no permitido");
			else
				profesional.setFechaIngreso(input);

		System.out.println("El Profesional ha sido guardado exitosamente.");

		Asesoria profesionalA = (Asesoria)profesional;
		// asesorias.add(profesionales);

		asesorias.add(profesionalA);
	}

	/**
	 * Método que permite agregar un nuevo Administrativo a la lista de instancias
	 * de la interface asesoria
	 * 
	 * @param contenedora
	 */
	public static  void almacenarAdministrativo(Contenedor contenedora) {
		Usuario usuario = ingresarUsuario(contenedora);

		// Solicito el Area
		Administrativo administrativo = new Administrativo(usuario);
		do {
			System.out.println("Ingrese el área de Trabajo:(*): ");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un area de trabajo vacío.Ingrese un area valida");
			else
				administrativo.setArea(input);

		}while (input.trim().isEmpty());

		// Solicito la Experiencia Previa
		System.out.println("Ingrese la Experiencia Previa: ");
		input = sc.nextLine();
		administrativo.setExperienciaPrevia(input);

		Asesoria administrativoA = (Asesoria)administrativo;
		// asesorias.add(administrativos);

		System.out.println("El Administrativo ha sido guardado exitosamente.");

		asesorias.add(administrativoA);
	}

	/**
	 * Método que permite agregar un nuevo Capacitación a la lista de instancias de
	 * la clase capacitación
	 * 
	 * @param idCapacitacion
	 * @param contenedora
	 */
	public static void almacenarCapacitacion(int idCapacitacion, Contenedor contenedora) { // Ojo cambiar por int Run


		// Ingreso los datos de la Capacitacion
		Capacitacion capacitacion = new Capacitacion();
		// Identificador: obligatorio, número interno de la capacitación manejado por la
		// empresa
		capacitacion.setIdCapacitacion(idCapacitacion++);
		// RUT cliente: obligatorio
		do{
			System.out.println("Ingrese el rut que recibira la capacitación en formato numérico menor a 99.999.999(*)");
			input = sc.nextLine();
			if (esNumerico(input)) {
				long run = Long.parseLong(input);
				if (buscarRut(input)==false) {
					System.out.println("El rut ingresado, no existe ,ingrese otro rut");
					MenuPrincipal.menuOpciones(contenedora);
				}else {
					capacitacion.setRun(run);
					break;
				}

			}
		}while( input.trim().isEmpty());
		// Día: texto, día de la semana. Debe ser un valor permitido entre “lunes” y
		// “Domingo”(en ese formato)
		System.out.println("Ingrese el Día de la semana. Debe ser un valor permitido entre “lunes” y “Domingo”");
		input = sc.nextLine();
		capacitacion.setDia(input);
		// Hora: debe ser una hora válida del día, en formato HH:MM (hora desde 0 a23,
		// minutos entre 0 y 59)
		System.out.println("Ingrese la Hora de la capacitación : debe ser una hora válida del día, en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59)");
		input = sc.nextLine();
		capacitacion.setHora(input);
		// Lugar: obligatorio, mínimo 10 caracteres, máximo 50

		do {
			System.out.println("Ingrese el lugar de la Capacitación(*), mínimo 10 caracteres, máximo 50");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud.ingreso un Lugar vacío.Ingrese un Lugar de Capacitación Valido");
			else
				capacitacion.setLugar(input);

		}while(input.trim().isEmpty());
		// Duración: máximo 70 caracteres
		System.out.println("Ingrese la Duración de la capacitación: máximo 70 caracteres.");
		input = sc.nextLine();
		capacitacion.setDuracion(input);
		// Cantidad de asistentes: obligatorio, número entero menor que 1000
		do {
			System.out.println("Ingrese la cantidad de asistentes(*), número entero menor que 1000");
			input = sc.nextLine();
			if (input.trim().isEmpty())
				System.out.println("Ud, No ingreso la cantidad de Asistentes.Ingrese un número válido");
			else
				capacitacion.setCantAsistentes(Integer.parseInt(input));

		}while(input.trim().isEmpty());




		capacitaciones.add(capacitacion);
	}

	/**
	 * Método que permite eliminar un usuario desde la lista de interfaces de
	 * asesoria de acuerdo con el run del Usuario
	 * 
	 */
	public static void eliminarUsuario() {
		System.out.println(" Ingrese el RUN del Usuario a Eliminar:");
		input = sc.nextLine();
		//int run = Integer.parseInt(input);

		// Iterar sobre la lista de Interface de asesoria y buscar el objeto que tenga
		// el mismo rut
		for (Iterator<Asesoria> iter = asesorias.iterator(); iter.hasNext();) {
			Asesoria asesora = iter.next();
			String datos = asesora.analizarUsuario();
			int index = datos.indexOf(":"); // encuentra el indice del primer carácter ':'
			String salida = datos.substring(index + 2); // obtiene los caracteres después de los dos puntos
			System.out.println("rut "+salida);
			if (salida.equals(input.trim())) {
				existe = true;
				iter.remove(); // Elimina el objeto de la lista
				System.out.println("Usuario eliminado Satisfactoriamente.");
				break;
			}

		}
		if (existe == false)
			System.out.println("El rut a eliminar no existe, intentelo con un rut válido");
	}

	/**
	 * Método que permite desplegar la lista de usuarios, independientemente del
	 * tipo este metodo solo desplega los datos de la clase usuario
	 *
	 */
	public static void ListarUsuarios() {
		for (Asesoria user : asesorias) {
			System.out.println(user.toString());

		}
		

	}

	/**
	 * Método que lista los usuarios por tipo (Cliente, Administrador, Profesional y
	 * retorna los datos respectivos según el tipo
	 *
	 */
	public static void ListarUsuariosPorTipo(Contenedor contenedora) {

		//while (true) {    // Menu de opciones, funciona mientras salir sea false
			System.out.println("-------------Seleccione el Tipo de Cliente a listar:--------------------");
			System.out.println("1-.Cliente");
			System.out.println("2-.Profesional");
			System.out.println("3-.Administrativo");
			Scanner sc = new Scanner(System.in); // Variable que lee el valor introducido por consola
			String opcion = sc.nextLine();

			for (Asesoria user : asesorias) {

					if (user instanceof Cliente & opcion.equals("1")) {
						Cliente varCliente = (Cliente) user;
						System.out.println("Cliente: " + varCliente.analizarUsuario());
					}

					if (user instanceof Profesional & opcion.equals("2")) {
						Profesional varProfesional = (Profesional) user;
						System.out.println("Profesional: " + varProfesional.analizarUsuario());
					}

					if (user instanceof Administrativo & opcion.equals("3")) {
						Administrativo varAdministrativo = (Administrativo) user;
						System.out.println("Administrativo: " + varAdministrativo.analizarUsuario());
					}



			}
		//}

	}

	/**
	 * Capacitaciones registradas en la lista lista de Capacitaciones del Cliente,
	 * junto con los datos del Cliente al que esta asociada dicha capacitación
	 *
	 */
	public static void ListarCapacitaciones() {
		String datos ="";
		String runStr = "";

		for (Capacitacion capacitacion : capacitaciones) {


			long run = capacitacion.getRunClienteCapa();
			runStr= run+"";

			for (Iterator<Asesoria> iter = asesorias.iterator(); iter.hasNext();) {
				Asesoria asesora = iter.next();
				datos = asesora.analizarUsuario();
				int index = datos.indexOf(":"); // encuentra el indice del primer carácter ':'
				String salida = datos.substring(index + 2);


				if(salida.trim().equals(runStr.trim())){

					System.out.println(capacitacion.toString() + " y el cliente asociado es: " + datos);
					runStr="";
				}


			}


		}

	}

	public static void mostrarCliente(String run) {

		// Iterar sobre la lista de Interface de asesoría y buscar el objeto que tenga
		// el mismo rut
		for (Iterator<Asesoria> iter = asesorias.iterator(); iter.hasNext();) {
			Asesoria asesora = iter.next();
			String datos = asesora.analizarUsuario();
			int index = datos.indexOf(":"); // encuentra el indice del primer carácter ':'
			String salida = datos.substring(index + 2); // obtiene los caracteres después de los dos puntos

			if (salida.equals(run)) {
				existe = true;
				//System.out.println(datos);
			}

		}
		if (existe == false)
			System.out.println("El rut solicitado no existe");
	}

	/**
	 * @param run run del Usuario tipo String
	 * @return boolean
	 */
	public static boolean buscarRut(String run) {
		for (Iterator<Asesoria> iter = asesorias.iterator(); iter.hasNext();) {
			Asesoria asesora = iter.next();
			String datos = asesora.analizarUsuario();
			int index = datos.indexOf(":"); // encuentra el indice del primer carácter ':'
			String salida = datos.substring(index + 2); // obtiene los caracteres después de los dos puntos

			if (salida.equals(run)) {
				return  true;

			}

		}

		return false;
	}


	/**
	 * Metodo que me valida si el string introducido por consola es numérico
	 * @param str
	 * @return
	 */
	public static boolean esNumerico(String str) {
		try {
			long d = Long.parseLong(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	
	
}
