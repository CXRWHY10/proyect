package Controlador;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.UsuarioVista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class UsuarioControlador {
    private UsuarioDAO usuarioDAO;
    private UsuarioVista usuarioVista;
    public UsuarioControlador(UsuarioDAO usuarioDAO, UsuarioVista usuarioVista){
        this.usuarioDAO = usuarioDAO;
        this.usuarioVista = usuarioVista;
    }
    public void ListarUsuarios(){
        List<Usuario> usuarios = usuarioDAO.obtenerUsuarios();
        usuarioVista.mostrarUsuarios(usuarios);
    }
    public void agregarUsuarios()throws SQLException {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el correo: ");
        String email = sc.nextLine();

        usuarioDAO.agregarUsuario(nombre, email);
        System.out.println("Usuario agregado con exito.");
    }
}
