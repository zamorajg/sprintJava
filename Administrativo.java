package sprintCapacitacion;


public class Administrativo extends Usuario{
	private String experienciaPrevia;
	private String area;
	protected static String[][] contenedor;  // revisar si es usuario o contenedor


	/**
	 * Constructor de la clase administrativo que recibe los datos del Objeto padre
	 * @param usuario
	 */
	public Administrativo(Usuario usuario) {
		super(usuario.getNombreUsuario(), usuario.getFechaNacimientoUsuario(), usuario.getRunUsuario());
	}
	
	public Administrativo(String nombre, String fechaNacimiento, Long run, String experienciaPrevia, String area) {
		super (nombre, fechaNacimiento, run);
		this.experienciaPrevia = experienciaPrevia;
		this.area = area;
		
		
	}
	
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		if(experienciaPrevia.length() < 101) {
		this.experienciaPrevia = experienciaPrevia;
		}else {
			System.out.println("La experiencia previa no debe exceder los 100 caracteres");
		}
	}

	public String getArea() {
		return area;
	}

	/**
	 * Valida el area de Trabajo
	 * @param area
	 */
	public void setArea(String area) {
		do {
			if (area.length() >= 4 && area.length() <=21) {
				this.area = area;
				break;
			}else {
				System.out.println("Ingrese un area mayor que 4 y menor que 20 caracteres");
			}
		} while (true);
	}

	@Override
	public String analizarUsuario() {
		return "El administrativo tiene una experiencia=" + experienciaPrevia + " y pertenece al area " + area +  super.analizarUsuario();
		
	}
	@Override
	public String toString() {
		return "Administrativo: " + super.toString() + " [getExperienciaPrevia()=" + getExperienciaPrevia() + ", getArea()=" + getArea()+ "]";
	}
}
