package sprintCapacitacion;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Definicion:  de la Clase: Clase para mantener los Clientes que recibirán los usuarios que se capacitaran
 * @Version: 1.0
 * @Autor: Grupo Java (Jose Zamora, Benjamin, Fernanda, Javiera)
 *
 */


public class Cliente extends Usuario {
    // Creación de los atributos de la Clase Cliente
	private String nombres;
    private String apellidos;
    private int telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
	Scanner sc = new Scanner(System.in);
    ArrayList<Capacitacion> capacitaciones; // lista de Capacitaciones
    ArrayList<Accidente> accidentes; // lista de Accidentes
    ArrayList<visitaTerreno> visitasTerreno; // lista de Visitas en Terreno
    
	public Cliente(String nombre, String fechaNacimiento, Long run, String nombres, String apellidos, int telefono,
    		String afp, int sistemaSalud, String direccion, String comuna, int edad, String String) {
    	super(nombre, fechaNacimiento, run);
    	this.nombres = nombres;
    	this.apellidos = apellidos;
    	this.telefono = telefono;
    	this.afp = afp;
    	this.sistemaSalud = sistemaSalud;
    	this.direccion = direccion;
    	this.comuna = comuna;
    	this.edad = edad;
        this.capacitaciones = new ArrayList<Capacitacion>();
        this.accidentes= new ArrayList<Accidente>();
        this.visitasTerreno = new ArrayList<visitaTerreno>();
    }

    public Cliente (Usuario usuario) {

        super(usuario.getNombreUsuario(),usuario.getFechaNacimientoUsuario(),usuario.getRunUsuario());
    }

    public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		do {
            if (nombres.length() >=5 || nombres.length() <= 50) {
                this.nombres = nombres;
                break;

            } else {
                System.out.println("Ingrese nombre valido, mínimo 5 caracteres y máximo 30");
                nombres = sc.nextLine();
            }
		}while (nombres.length() >=5 || nombres.length() <= 50);
    }



	/**
     * Devuelve los apellidos del Cliente.
     *
     * @return los apellidos del Cliente.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del Cliente.
     *
     * @param apellidos  los nuevos apellidos del Cliente.
     */
    public void setApellidos(String apellidos) {
    	do { 
    	if (apellidos.length() < 5 || apellidos.length() > 30 || apellidos.isEmpty()) {
    		System.out.println("Ingrese Apellidos");
			apellidos = sc.nextLine();
    	}else if (apellidos.length() > 4 && apellidos.length() < 31 ) {
        this.apellidos = apellidos;
        break;
    	}
    	}while (true);
}
    	

    /**
     * Devuelve el telefono del Cliente.
     *
     * @return el telefono del Cliente.
     */
    public int getTelefono() {
            return telefono;
    }

    /**
     * Establece el telefono del Cliente.
     *
     * @param telefono el nuevo telefono del Cliente.
     */
    public void setTelefono(int telefono) {
    	do {    		
    	if(telefono == 0) {
    		System.out.println("Ingrese telefono");
			telefono = Integer.parseInt(sc.nextLine());
    	}else if(telefono !=0) {
        this.telefono = telefono;
        break;
    	} else {
    	    System.out.println("Ingrese un telefono valido");
    	}
    	} while (true);
    }

    /**
     * Devuelve el AFP del Cliente.
     *
     * @return el AFP del Cliente.
     */
    public String getAfp() {
        return afp;
    }

    /**
     * Establece el AFP del Cliente.
     *
     * @param afp  el nuevo AFP del Cliente.
     */
    public void setAfp(String afp) {
    	if (afp.length() >= 4 && afp.length() <= 30 ) {
    		this.afp = afp;
        } else {
            System.out.println("Ingrese una afp valida, la próxima vez");}
        	
    }

    /**
     * Devuelve el Sistema de Salud del Cliente.
     *
     * @return el Sistema de Salud del Cliente.
     */
    public int getSistemaSalud() {
        return sistemaSalud;
    }

    /**
     * Establece el requerimiento para asignar un valor a sistemaSalud(el valor
     * ingresado debe ser 1 o 2) y si no se cumple, retorna un mensaje de error
     *
     * @param sistemaSalud  el nuevo sistema de salud del Cliente.
     */
    public void setSistemaSalud(int sistemaSalud) {
        if (sistemaSalud == 1 || sistemaSalud == 2) {
            this.sistemaSalud = sistemaSalud;
        } else {
            System.out.println("Valor incorrecto. Por favor ingrese 1 o 2.");
        }
    }

    /**
     * Devuelve la dirección del Cliente.
     *
     * @return la dirección del Cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del Cliente.
     *
     * @param direccion  la nueva dirección del Cliente.
     */
    public void setDireccion(String direccion) {
    	if (direccion.length() < 70) {
        this.direccion = direccion;
    	}else {
    		System.out.println("La direccion debe tener menos de 70 caracteres ");
    	}
    }

    /**
     * Devuelve la comuna del Cliente.
     *
     * @return la comuna del Cliente.
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece la comuna del Cliente.
     *
     * @param comuna La nueva comuna del Cliente.
     */
    public void setComuna(String comuna) {
    	if (comuna.length() < 51) {
        this.comuna = comuna;
    	}else {
    		System.out.println("La comuna debe tener menos de 50 caracteres");
    	}
    }

    /**
     * Devuelve la edad del Cliente.
     *
     * @return la edad del Cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del Cliente.
     *
     * @param edad la nueva edad del Cliente.
     */
    public void setEdad(int edad) {
    	do {
    	if ( edad < 0 || edad > 150) {
    		System.out.println("Ingrese Edad");
			edad = Integer.parseInt(sc.nextLine());
    	}
    	else if(edad >= 0 && edad < 151) {
        this.edad = edad;
        break;
    	}
    	}while ( true);
    }
    
    /**
     * Devuelve la cantidad de accidentes asociadas al Cliente.
     *
     * @return cantidad de accidentes del cliente.
     */
    
   // public int getCantidadAccidentes() {
	//	return cantidadAccidentes;}
    
    /**
     * Establece la cantidad de accidentes por cliente.
     *
     * @param accidentes del Cliente.
     */

	//public void setCantidadAccidentes(int cantidadAccidentes) {
	//	this.cantidadAccidentes = cantidadAccidentes;}

    /**
     * Devuelve una representación en cadena de la instancia de la clase Cliente
     *
     * @return Una representación en cadena de la instancia de la clase Cliente
     */
    @Override
    public String toString() {
        return "Cliente: " + super.toString() + " [nombre = " + nombres + ", apellidos = " + apellidos + ", telefono = " + telefono
                + ", afp = " + afp + ", sistemaSalud = " + sistemaSalud + ", direccion = " + direccion + ", comuna = " + comuna
                + ", edad = " + edad + "]";
    }
    
	@Override
	public String analizarUsuario() {
		return "Los datos del Cliente= dirección = " + direccion + ", comuna = " + comuna +  super.analizarUsuario();
		
	}
    


}

