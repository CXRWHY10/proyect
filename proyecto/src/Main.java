import Controlador.HotelControlador;
import Modelo.HabitacionDAO;
import Modelo.ReservaDAO;
import Modelo.ClienteDAO;
import Vista.HotelVista;
import Database.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try {
            Connection conexion = ConexionDB.getConnexion();
            HabitacionDAO habitacionDAO = new HabitacionDAO(conexion);
            ReservaDAO reservaDAO = new ReservaDAO(conexion);
            ClienteDAO clienteDAO = new ClienteDAO(conexion);
            HotelVista hotelVista = new HotelVista();
            HotelControlador hotelControlador = new HotelControlador(habitacionDAO, reservaDAO, clienteDAO, hotelVista);
            Scanner sc = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("=== HOTEL AURA ===");
                System.out.println("1. Mostrar habitaciones");
                System.out.println("2. Agregar datos del cliente");
                System.out.println("3. Agregar reserva");
                System.out.println("4. Eliminar reserva");
                System.out.println("0. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        hotelControlador.listarHabitaciones();
                        break;
                    case 2:
                        hotelControlador.agregarCliente();
                        break;
                    case 3:
                        hotelControlador.agregarReserva();
                        break;
                    case 4:
                        hotelControlador.eliminarReserva();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion != 0);
            ConexionDB.CerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

