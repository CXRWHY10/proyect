package Vision;
import Modelo.Cliente;
import java.util.List;
public class Clientevista {
    public static void mostrarClientes(List<Cliente> clientes){
        System.out.println("***Lista de Clientes ***");
        if (clientes.isEmpty());{
            System.out.println("No hay Clientes registrados");
        }
        System.out.printf("NOMBRE","CI");
        for (Cliente cliente: clientes){
            System.out.printf(cliente.getNombre(), cliente.getCI());
        }
    }
}
