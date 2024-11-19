import Controlador.Recepcion;
import Modelo.Cliente;
import Modelo.Hotel;
import Modelo.Reservacion;
import Vision.Clientevista;
import Vision.Habitacion;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("Hotel 'AURA' ");
        Clientevista clienteVista = new Clientevista();
        Habitacion habitacionVista = new Habitacion();
        Recepcion recepcion = new Recepcion();
        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Crear Reservación");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Agregar Habitación");
            System.out.println("4. Mostrar Habitaciones");
            System.out.println("5. Mostrar Reservaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("=== Crear Reservación ===");
                    System.out.print("Ingrese la fecha de inicio de la reservación: ");
                    String fechaInicio = sc.nextLine();
                    System.out.print("Ingrese la fecha de fin de la reservación: ");
                    String fechaFin = sc.nextLine();
                    Cliente cliente = new Cliente(1, "Cliente ", new DatosCliente());
                    Habitacion habitacion = new Habitacion(1, "101", 5);
                    Reservacion reservacion = new Reservacion(1, cliente, habitacion, fechaInicio, fechaFin);
                    recepcion.agregarReservacion(reservacion);
                    break;
                case 2:
                    System.out.println("\n=== Agregar Cliente ===");
                    String nombreCliente = clienteVista.obtenerDatos();
                    DatosCliente datosCliente = clienteVista.obtenerDatos();
                    cliente = new Cliente(1, nombreCliente, datosCliente);
                    break;
                case 3:
                    System.out.println("\n=== Agregar Habitación ===");
                    habitacion = habitacionVista.obtenerDatosHabitacion();
                    recepcion.agregarHabitacion(habitacion);
                    break;
                case 4:
                    System.out.println("\n=== Habitaciones ===");
                    for (Habitacion hab : recepcion.getHabitaciones()) {
                        System.out.println("Número: " + hab.getNumero() + ", Tipo: " + hab.getTipo());
                    }
                    break;
                case 5:
                    System.out.println("\n=== Reservaciones ===");
                    for (Reservacion res : recepcion.getReservaciones()) {
                        System.out.println("Cliente: " + res.getCliente().getNombre() + ", Habitación: " + res.getHabitacion().getNumero() + ", Fecha Inicio: " + res.getFechaInicio() + ", Fecha Fin: " + res.getFechaFin());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
