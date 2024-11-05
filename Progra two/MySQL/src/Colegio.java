import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Colegio {
    public static void main(String[] args) {
        MySQLConnection dbConnection = new MySQLConnection();
        Connection conexion = dbConnection.getConnection();

        int opcion;
        Scanner sc = new Scanner(System.in);
        String nombre,primerApellido,segundoApellido,telefono,email;
        do {
            System.out.println("----MENU----");
            System.out.println("1. Agregar Cuenta");
            System.out.println("2. Mostrar a los Estudiantes");
            System.out.println("3. Modificar Datos del Estudiante");
            System.out.println("4. Eliminar al Estudianet");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (conexion != null) {
                        sc.nextLine();
                        System.out.println("DATOS DEL ESTUDIANTE");
                        System.out.println("Ingrese el Nombre");
                        nombre= sc.nextLine();
                        System.out.println("Ingrese el primer apellido");
                        primerApellido = sc.nextLine();
                        System.out.println("Ingrese el segundo apellido");
                        segundoApellido = sc.nextLine();
                        System.out.println("Ingrese el Telefono");
                        telefono = sc.nextLine();
                        System.out.println("Ingrese el Correo");
                        email = sc.nextLine();

                        String sql = "INSERT INTO estudiantes(nombre,primerApellido,segundoApellido,telefono,email) VALUES (?,?,?,?,?)";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                            stmt.setString(1, nombre);
                            stmt.setString(2,primerApellido);
                            stmt.setString(3,segundoApellido);
                            stmt.setString(4,telefono);
                            stmt.setString(5, email);
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
                        String sql = "SELECT id,nombre ,primerApellido, segunodApellido, telefono, email FROM estudiantes";
                        try(PreparedStatement stmt = conexion.prepareStatement(sql);
                            ResultSet rs = stmt.executeQuery()){
                            System.out.println("----LISTA DE ESTUDIANTES----");
                            while (rs.next()){
                                System.out.println(rs.getInt("id"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("primer apellido"));
                                System.out.println(rs.getString("segundo apellido"));
                                System.out.println(rs.getString("telefono"));
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
                        String sql = "UPDATE estudiantes SET nombre = ? ,primerApellido = ?, segundoApellido = ?, telefono = ?,email = ?, WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.println("Ingrese el ID del estudinate: ");
                            int idCliente = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nuevo nombre");
                            String nuevoNombre = sc.nextLine();
                            System.out.println("Nuevo apellido");
                            String nuevoApellido = sc.nextLine();
                            System.out.println("Nuevo apellido");
                            String nuevoApellido2 = sc.nextLine();
                            System.out.println("Nuevo telefono");
                            String nuevoTelefono = sc.nextLine();
                            System.out.println("Nuevo correo");
                            String nuevoEmail = sc.nextLine();
                            stmt.setString(1, nuevoNombre);
                            stmt.setString(2, nuevoApellido);
                            stmt.setString(3, nuevoApellido2);
                            stmt.setString(4, nuevoTelefono);
                            stmt.setString(5, nuevoEmail);
                            stmt.setInt(6, idCliente);
                            int filasActualizadas = stmt.executeUpdate();
                            if (filasActualizadas > 0){
                                System.out.println("Datos actualizados correctamente");
                            }else {
                                System.out.println("No se encontro un estudiante con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al actualizar los datos "+ e.getMessage());
                        }
                    }
                    break;
                case 4 :
                    if (conexion != null){
                        String sql = "DELETE FROM estudiantes WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.print("Ingrese el ID del Estudiante a eliminar");
                            int idCliente = sc.nextInt();
                            stmt.setInt(1, idCliente);
                            int filasEliminadas = stmt.executeUpdate();
                            if (filasEliminadas > 0){
                                System.out.println("Estudiante eliminado correctamente");
                            }else {
                                System.out.println("No se encontro un estudiante con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al eliminar el estudiante: "+ e.getMessage());
                        }
                    }
                    break;
                }
        }while (opcion != 0);
    }
}
