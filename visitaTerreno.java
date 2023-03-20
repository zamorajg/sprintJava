package sprintCapacitacion;

public class visitaTerreno {
    private int idVisita;
    private Long rutCliente;
    private String diaAccidente;
    private String hora;
    private String lugar;
    private String comentarios;

    private Revision revision;

    public visitaTerreno() {
    }

    public visitaTerreno(int idVisita, Long rutCliente, String diaAccidente, String hora, String lugar, String comentarios) {
        this.idVisita = idVisita;
        this.rutCliente = rutCliente;
        this.diaAccidente = diaAccidente;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
        this.revision = new Revision();

    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public long getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Long rutCliente) {
        do {

            if (rutCliente <= 99999999) {
                this.rutCliente = rutCliente;
            }
            else {
                System.out.println("No puede exceder 99.999.999");
            }
        }while(rutCliente==null);
    }

        public String getDiaAccidente() {
        return diaAccidente;
    }

    /**
     * Metodo que valida la fecha del accidente en el formato DD/MM/AAAA bajo una expresión regular
     * @param diaAccidente retorna la fecha en el formato indicado
     */
    public void setDiaAccidente(String diaAccidente) {
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";

        if (diaAccidente.matches(regex)) {
            this.diaAccidente = diaAccidente;
        }
        else {
            System.out.println("La fecha no es valida, debe ingresarla en este formato DD/MM/AAAA");
        }

    }

    public String getHora() {
        return hora;
    }

    /**
     * Metodo que establece la hora del accidente en el formato DD/MM/AAAA, atraves de una expresión regular
     * @param hora valor del tipo String
     */
    public void setHora(String hora) {
        String regex = "^(0?[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        if (hora.matches(regex)) {
            this.hora = hora;
        }
        else {
            System.out.println("La hora introducida debe estar en el siguiente formato: HH:MM");
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios.length()>100)
            this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "visitaTerreno{" +
                "idVisita=" + idVisita +
                ", rutCliente='" + rutCliente + '\'' +
                ", diaAccidente='" + diaAccidente + '\'' +
                ", hora='" + hora + '\'' +
                ", Lugar='" + lugar + '\'' +
                ", Comentarios='" + comentarios + '\'' +
                '}';
    }
}
