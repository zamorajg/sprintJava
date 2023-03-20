package sprintCapacitacion;

public class Accidente {
	private Integer idAccidente;
	private Long run;
	private String fecha;
	private Integer hora;
	private String lugar;
	private String origen;
	private String consecuencias;

	public Accidente() {

	}

	public Accidente(Integer idAccidente, Long run, String fecha, Integer hora, String lugar, String origen,
			String consecuencias) {
		this.idAccidente = idAccidente;
		this.run = run;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.origen = origen;
		this.consecuencias = consecuencias;
	}

	public int getIdAccidente() {
		return idAccidente;
	}

	public void setIdAccidente(Integer idAccidente) {
		if (idAccidente != null) {
			this.idAccidente = idAccidente;
		} else {
			System.out.println("Ingrese un identificador valido");
		}
	}

	public String getFecha() {
		return fecha;
	}

    public void Fecha(String fecha) {
    	String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";
		do {
			if (fecha.matches(regex)) {
				this.fecha = fecha;
			} else {
				System.out.println("La fecha no es valida");
			}
		} while (!fecha.matches(regex));

    }

	public int getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		do {
			if (lugar.length() > 10 && lugar.length() <= 50) {
				this.lugar = lugar;
			} else {
				System.out.println("Ingrese un lugar de accidente");
			}
		} while (lugar.isEmpty());
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		if (origen.length() <= 100) {
			this.origen = origen;
		}
	}

	public String getConsecuencias() {
		return consecuencias;
	}

	public void setConsecuencias(String consecuencias) {
		if (consecuencias.length() <= 100) {
			this.consecuencias = consecuencias;
		}
	}

	@Override
	public String toString() {
		return "Rut cliente: " + run + "\nFecha accidente: " + fecha + "\nHora: " + hora + "\nLugar: " + lugar
				+ "\nOrigen: " + origen + "\nConsecuencias: " + consecuencias;
	}

}
