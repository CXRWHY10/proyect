package Controlador;
import Modelo.Cliente;
import Modelo.DatosDelCliente;
import Modelo.Reservacion;
import Vision.Clientevista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Recepcion {
    private DatosDelCliente datosDelCliente;
    private Clientevista clientevista;
    public Recepcion(DatosDelCliente datosDelCliente, Clientevista clientevista){
        this.datosDelCliente = datosDelCliente;
        this.clientevista = clientevista;
    }
    public void mostrarClientes(){
        List<Cliente> clientes = DatosDelCliente.obtenerDatos();
        Clientevista.mostrarClientes(clientes);
    }
    public void agregarReserva()throws SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el CI:  ");
        int ci = sc.nextInt();
        System.out.print("Ingrese el Telefono: ");
        int Telefono = sc.nextInt();
        System.out.print("Ingrese el email: ");
        String email = sc.nextLine();
        DatosDelCliente.agregarReserva(nombre, ci, email, Telefono);
        System.out.println("Usuario agregado con exito.");
    }

    public void agregarReservacion(Reservacion reservacion) {
    }
}
