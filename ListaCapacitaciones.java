package sprintCapacitacion;

import java.util.ArrayList;

public class ListaCapacitaciones {
    ArrayList<Capacitacion> listaCapacitaciones;

    public ArrayList<Capacitacion> getListaCapacitaciones() {
        return listaCapacitaciones;
    }

    public void setListaCapacitaciones(ArrayList<Capacitacion> listaCapacitaciones) {
        this.listaCapacitaciones = listaCapacitaciones;
    }

    public ListaCapacitaciones() { // Constructor de la clase listado que instancia un arreglo de usuarios
        this.listaCapacitaciones =new ArrayList<Capacitacion>();
    }

    public void agregar(Capacitacion capacitacion){ // Metodo que permite agregar Usuarios al listado
        listaCapacitaciones.add(capacitacion);
    }


    public void mostrarCapacitaciones() { // metodo que permite mostrar los diferentes tipos de Usuarios añadidos
        for (int i = 0; i < listaCapacitaciones.size(); i++) {

            System.out.println(listaCapacitaciones.get(i).toString()); // Ojo debe tenet un método que muestre las capacitaciones
            listaCapacitaciones.get(i).getRunClienteCapa();

        }
    }


}
