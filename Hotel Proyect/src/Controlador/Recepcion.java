package Controlador;
import Modelo.Cliente;
import Modelo.ClienteDatos;
import Vista.Vision;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Recepcion {
    private ClienteDatos clienteDatos;
    private Vision vision;
    public Recepcion(ClienteDatos clienteDatos, Vision vision){
       this.clienteDatos = clienteDatos;
       this.vision = vision;
    }
    public void mostrarClientes(){
        List<Cliente> clientes = clienteDatos.obtenerDatos();
        vision.mostrarClientes(clientes);
    }
    public void agregarReserva()throws SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el numero de celular: ");
        int numero = sc.nextInt();
        clienteDatos.agregarReserva(nombre, numero);
        System.out.println("Usuario agregado con exito.");
    }
}
