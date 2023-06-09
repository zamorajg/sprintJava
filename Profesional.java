package sprintCapacitacion;

/**
 * Clase hija de la Clase Usuario que registra a un profesional
 */
public class Profesional extends Usuario {
	private String titulo;
	private String fechaIngreso;
	protected static String[][] contenedor; // revisar si es contenedor o usuario

	/**
	 * Contenedor de la clase profesional que contiene los datos del padre
	 * @param usuario
	 */
	public Profesional(Usuario usuario){
		super(usuario.getNombreUsuario(),usuario.getFechaNacimientoUsuario(),usuario.getRunUsuario());

	}


	public Profesional(String nombre, String fechaNacimiento, Long run, String titulo, String fechaIngreso) {
		super(nombre, fechaNacimiento, run);
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;		
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		do {
			if (titulo.length() >= 10 && titulo.length() <= 50 ) {
				this.titulo = titulo;
				break;
			}else {
				System.out.println("El titulo ingresado debe tener al menos 10 caracteres y no exceder de 50.");
				titulo = sc.nextLine();
		    }
		} while (true);
	}
	
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	
	public void setFechaIngreso(String fechaIngreso) {
		
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";

        if (fechaIngreso.matches(regex)) {
        	this.fechaIngreso = fechaIngreso;
        }
        else {
            System.out.println("La fecha no es valida, debe ingresarla en este formato DD/MM/AAAA,la próxima vez");

        }
	}

	@Override
	public String analizarUsuario() {
		return "El profesional posee el titulo de " + titulo + " y su fecha de ingreso es " + fechaIngreso + " "+ super.analizarUsuario() ;
		
	}
	@Override
	public String toString() {
		return "Profesional: " + super.toString() + " [titulo=" + titulo + ", fechaIngreso=" + fechaIngreso + "]";
	}

}
