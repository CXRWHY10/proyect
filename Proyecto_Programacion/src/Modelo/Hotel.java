package Modelo;
import Vision.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nombre;
    private List<Habitacion>habitaciones = new ArrayList<>();
    public Hotel(String nombre){
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }
    public void agregarHabitacion(Habitacion habitacion){
        habitaciones.add(habitacion);
        System.out.println("Habitacion agregada con exito.");
    }
    public void mostrarHabitaciones() {
        System.out.println("Habitaciones disponibles en " + nombre + ":");
        for (Habitacion habitacion: habitaciones){
            System.out.println(habitacion);
        }
    }
    public Habitacion buscarHabitacion(int numero){
        for (Habitacion habitacion : habitaciones){
            if (habitacion.getNumero()== numero){
                return habitacion;
            }
        }
        return null;
    }
    public List<Habitacion> getHabitaciones(){
        return habitaciones;
    }
}
