package Vista;
import Modelo.Habitacion;
import java.util.List;
public class HotelVista {
    public void mostrarHabitaciones(List<Habitacion> habitaciones) {
        System.out.println("\n *** Lista de Habitaciones ***");
        if (habitaciones.isEmpty()) {
            System.out.println("No hay habitaciones disponibles.");
        } else {
            System.out.printf("%5s %15s %15s\n", "ID", "TIPO", "DISPONIBLE");
            for (Habitacion habitacion : habitaciones) {
                System.out.printf("%5s %15s %15s\n", habitacion.getId(), habitacion.getTipo(), habitacion.isDisponible() ? "Sí" : "No");
            }
        }
    }
}
