// Version 1.0

package sprintCapacitacion;


import java.util.Scanner;

/**
 * Definicion: Clase usuario, utilizada como la clase padre que heredan las clases Cliente, Profesional, Administrativo
 * Version: 1.0
 * @Autor: Grupo Java (Jose Zamora, Benjamin, Fernanda, Javiera)
 *
 **/
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Usuario implements Asesoria {

	private  String nombreUsuario; // nombres que identifica al usuario
	private  String fechaNacimientoUsuario; // fecha de nacimiento del usuario
	private  Long runUsuario; // RUN del usuario (menor a 99.999.999)
	Scanner sc = new Scanner(System.in);

	// Constructor con todos los parametros.
	public Usuario(String nombre, String fechaNacimiento, Long run) {
		this.nombreUsuario = nombre;
		this.fechaNacimientoUsuario = fechaNacimiento;
		this.runUsuario = run;

	}

	public Usuario() {
	}

	/**
	 * Devuelve el nombre del Usuario.
	 *
	 * @return nombre el nombre del Usuario.
	 */
	public  String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el nombre del Usuario
	 *
	 * @param nombre el nuevo nombre del Usuario
	 */

	public void setNombreUsuario(String nombre) {
		do {

			if (nombre.length() >= 10 && nombre.length() <= 50 ) {

				this.nombreUsuario = nombre;
				break;
			}else {
				System.out.println("Ingrese nombre valido, mínimo 10 caracteres y máximo 50");
				nombre = sc.nextLine();


			} 

		} while (true);

	}

	/**
	 * Devuelve la fechaNacimiento del Usuario.
	 *
	 * @return fechaNacimiento la fechaNacimiento del Usuario.
	 */

	public  String getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	/**
	 * Establece la fechaNacimiento del Usuario
	 *
	 * @param fechaNacimiento la nueva fechaNacimiento del Usuario.
	 */

	public void setFechaNacimientoUsuario(String fechaNacimiento) {
		String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";
		do{

				if (fechaNacimiento.trim().matches(regex)) {

					this.fechaNacimientoUsuario = fechaNacimiento;
					break;
				}else if(fechaNacimiento.trim().length()<10){
					System.out.println("La fecha no es valida, debe ingresarla en este formato DD/MM/AAAA");
					fechaNacimiento = sc.nextLine();
				}else if(fechaNacimiento.trim().length()== 0){
					System.out.println("La fecha no es valida, debe ingresarla en este formato DD/MM/AAAA");
					fechaNacimiento = sc.nextLine();
				} else {
					System.out.println("La fecha no es valida, debe ingresarla en este formato DD/MM/AAAA");
					fechaNacimiento = sc.nextLine();
				}
		} while (true);
	}
	// Solicita y retorna el valor de rut.
	/**
	 * Devuelve el rut del Usuario
	 *
	 * @return rut del Usuario
	 */
	public Long getRunUsuario() {
		return runUsuario;
	}

	/**
	 * Establece el run del Usuario
	 *
	 * @param run el nuevo run del Usuario.
	 */
	public void setRunUsuario(Long run) {

		do {
			if (run >=99999999) {
				System.out.println("Ingrese rut valido, menor a 99.999.999");
				String input = sc.nextLine();
				run = Long.parseLong(input);
			}else {

				this.runUsuario = run;
				break;
			}

			}while (true);
			
		}

	public Integer calcularEdad(String fechaNacimiento) {
		// Parsear la fecha de nacimiento a un objeto LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);

		// Obtener la edad actual
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		return periodo.getYears();
	}



	@Override
	public String toString() {
		return "Usuario [getNombre()=" + getNombreUsuario() + ", getFechaNacimiento()=" + getFechaNacimientoUsuario() + ", getRun()="
				+ getRunUsuario() +  "]";
	}

	public String mostrarEdad() {
		return "El Usuario: " + nombreUsuario + " tiene " + calcularEdad(fechaNacimientoUsuario);
	}

	public String analizarUsuario() {
		return "Usuario = " + nombreUsuario + ", rut: " + runUsuario;
	}
}
