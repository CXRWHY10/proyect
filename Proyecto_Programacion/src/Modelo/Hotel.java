package Modelo;
import Vision.Habitacion;
import java.util.ArrayList;
public class Hotel {
    private String nombre;
    private ArrayList<Habitacion>habitaciones;
    public Hotel(String nombre){
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
    }
    public void agregarHabitacion(Habitacion habitaciones){
        habitaciones.add(habitacion);
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
    public ArrayList<Habitacion>getHabitaciones(){
        return habitaciones;
    }
}
