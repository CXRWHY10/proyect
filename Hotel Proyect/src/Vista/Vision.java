package Vista;
import Modelo.Cliente;
import java.util.List;
public class Vision {
    public void mostrarClientes(List<Cliente> clientes){
        System.out.println("***Lista de Clientes ***");
        if clientes.isEmpty();{
            System.out.println("No hay Clientes registrados");
        } else {
            System.out.printf("NOMBRE","NUMERO");
            for (Cliente cliente: clientes){
                System.out.printf(cliente.getNombre(), cliente.getNumero());
            }
        }
    }
}
