import Controlador.UsuarioControlador;
import Modelo.UsuarioDAO;
import Vista.UsuarioVista;
import database.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main (String[]args){
        try{
            Connection conexion = ConexionDB.getConnexion();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            UsuarioVista usuarioVista = new UsuarioVista();
            UsuarioControlador usuarioControlador = new UsuarioControlador(usuarioDAO,usuarioVista);
            Scanner sc = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("\n=== Menu de Gestion de Usuarios ===");
                System.out.println("1. Mostrar usuarios");
                System.out.println("2. Agregar usuario");
                System.out.println("0. Salir");
                System.out.print("selecciona una opcion");
                opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        usuarioControlador.ListarUsuarios();
                        break;
                    case 2:
                        usuarioControlador.agregarUsuarios();
                        break;
                    case  0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }while (opcion!= 0);
            ConexionDB.CerrarConexion();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
