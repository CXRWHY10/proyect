import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MySQLConnection dbConnection = new MySQLConnection();
        Connection conexion = dbConnection.getConnection();

        int opcion;
        Scanner sc = new Scanner(System.in);
        String nombre,email,telefono;
        do {
            System.out.println("----MENU----");
            System.out.println("1. Agregar Cuenta");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Modificar Datos del Clientes");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (conexion != null) {
                        sc.nextLine();
                        System.out.println("DATOS DEL CLIENTE");
                        System.out.println("Ingrese el Nombre");
                        nombre= sc.nextLine();
                        System.out.println("Ingrese el Correo");
                        email = sc.nextLine();
                        System.out.println("Ingrese el Telefono");
                        telefono = sc.nextLine();

                        String sql = "INSERT INTO clientes(nombre,email,telefono) VALUES (?,?,?)";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                            stmt.setString(1, nombre);
                            stmt.setString(2, email);
                            stmt.setString(3,telefono);
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
                        String sql = "SELECT id,nombre, email, telefono FROM clientes";
                        try(PreparedStatement stmt = conexion.prepareStatement(sql);
                            ResultSet rs = stmt.executeQuery()){
                            System.out.println("----LISTA DE CLIENTES----");
                            while (rs.next()){
                                System.out.println(rs.getInt("id"));
                                System.out.println(rs.getString("nombre"));
                                System.out.println(rs.getString("email"));
                                System.out.println(rs.getString("telefono"));
                                System.out.println("--------------------------");
                            }
                        }catch (SQLException e){
                            System.out.println(e);
                        }
                    }
                    break;
                case 3 :
                    if (conexion != null){
                        String sql = "UPDATE clientes SET nombre = ? ,email = ?, telefono = ?, WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.println("Ingrese el ID del cliente: ");
                            int idCliente = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Nuevo nombre");
                            String nuevoNombre = sc.nextLine();
                            System.out.println("Nuevo correo");
                            String nuevoEmail = sc.nextLine();
                            System.out.println("Nuevo telefono");
                            String nuevoTelefono = sc.nextLine();
                            stmt.setString(1, nuevoNombre);
                            stmt.setString(2, nuevoEmail);
                            stmt.setString(3, nuevoTelefono);
                            stmt.setInt(4, idCliente);
                            int filasActualizadas = stmt.executeUpdate();
                            if (filasActualizadas > 0){
                                System.out.println("Datos actualizados correctamente");
                            }else {
                                System.out.println("No se encontro un cliente con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al actualizar los datos "+ e.getMessage());
                        }
                    }
                    break;
                case 4 :
                    if (conexion != null){
                        String sql = "DELETE FROM cliente WHERE id = ?";
                        try (PreparedStatement stmt = conexion.prepareStatement(sql)){
                            System.out.print("Ingrese el ID del cliente a eliminar");
                            int idCliente = sc.nextInt();
                            stmt.setInt(1, idCliente);
                            int filasEliminadas = stmt.executeUpdate();
                            if (filasEliminadas > 0){
                                System.out.println("Cliente eliminado correctamente");
                            }else {
                                System.out.println("No se encontro un cliente con ese ID");
                            }
                        }catch (SQLException e){
                            System.out.println("Error al eliminar el cliente: "+ e.getMessage());
                        }
                    }
                    break;
            }
        }while (opcion != 0);
    }
}