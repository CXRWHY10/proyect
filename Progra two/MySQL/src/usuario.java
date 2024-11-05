import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class usuario {
    public static void main(String[] args) {
        MySQLConnection dbConnection = new MySQLConnection();
        Connection conexion = dbConnection.getConnection();

        int opcion;
        Scanner sc = new Scanner(System.in);
        String nombre,email;
        do {
            System.out.println("----MENU----");
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Mostrar Usuario");
            System.out.println("3. Modificar Datos del Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (conexion != null) {
                        sc.nextLine();
                        System.out.println("DATOS DEL USUARIO");
                        System.out.println("Ingrese el Nombre");
                        nombre= sc.nextLine();
                        System.out.println("Ingrese el Correo");
                        email = sc.nextLine();;

                        String sql = "INSERT INTO usuario(nombre,email) VALUES (?,?,?)";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                            stmt.setString(1, nombre);
                            stmt.setString(2, email);
                            stmt.executeUpdate();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo");
                    break;
                case 2:
                    if (conexion != null){
                        String sql = "SELECT id,nombre, email FROM usuario ";
                        try(PreparedStatement stmt = conexion.prepareStatement(sql);
                            ResultSet rs = stmt.executeQuery()){
                            System.out.println("----LISTA DE CLIENTES----");
                            while (rs.next()){
                                System.out.println(rs.getInt("id"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("email"));
                                System.out.println("--------------------------");
                            }
                        }catch (SQLException e){
                            System.out.println(e);
                        }
                    }
                    break;
                case 3 :
                    if (conexion != null){
                        String sql = "UPDATE usuario SET nombre = ? ,email = ?, WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.println("Ingrese el ID del usuario: ");
                            int idUsuario = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nuevo nombre");
                            String nuevoNombre = sc.nextLine();
                            System.out.println("Nuevo correo");
                            String nuevoEmail = sc.nextLine();
                            stmt.setString(1, nuevoNombre);
                            stmt.setString(2, nuevoEmail);
                            stmt.setInt(3, idUsuario);
                            int filasActualizadas = stmt.executeUpdate();
                            if (filasActualizadas > 0){
                                System.out.println("Datos actualizados correctamente");
                            }else {
                                System.out.println("No se encontro un usuario con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al actualizar los datos "+ e.getMessage());
                        }
                    }
                    break;
                case 4 :
                    if (conexion != null){
                        String sql = "DELETE FROM usuario WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.print("Ingrese el ID del usuario a eliminar");
                            int idCliente = sc.nextInt();
                            stmt.setInt(1, idCliente);
                            int filasEliminadas = stmt.executeUpdate();
                            if (filasEliminadas > 0){
                                System.out.println("Usuario eliminado correctamente");
                            }else {
                                System.out.println("No se encontro un usuario con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al eliminar Usuario: "+ e.getMessage());
                        }
                    }
                    break;
            }
        }while (opcion != 0);
    }
}
