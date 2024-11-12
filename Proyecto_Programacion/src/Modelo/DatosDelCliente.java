package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DatosDelCliente {
    private static Connection conexion;
    public DatosDelCliente(Connection conexion){
        this.conexion = conexion;
    }
    public static List<Cliente> obtenerDatos(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT nombre, ci from clientes";
        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre: ");
                int CI = resultSet.getInt("ci: ");
                Cliente cliente = new Cliente(nombre,CI);
                clientes.add(cliente);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los Datos del Cliente" +e.getMessage(), e);
        }
        return clientes;
    }
    public static void agregarReserva(String nombre, int ci) throws SQLException{
        String sql = "INSERT INTO clientes (nombre, ci) VALUES (?,?)";
        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, nombre);
            stmt.setInt(2, ci);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los Datos"+e.getMessage(),e);
        }
    }
}
