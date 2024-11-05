package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ClienteDatos {
    private Connection conexion;
    public ClienteDatos(Connection conexion){
        this.conexion = conexion;
    }
    public List<Cliente> obtenerDatos(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nombre, numero from clientes";
        try(PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int numero = resultSet.getInt("numero");
                Cliente cliente = new Cliente(id, nombre, numero);
               clientes.add(cliente);
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los Datos del Cliente" +e.getMessage(), e);
        }
        return clientes;
    }
    public void agregarReserva(String nombre, int numero) throws SQLException{
        String sql = "INSERT INTO clientes (nombre, numero) VALUES (?,?)";
        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, nombre);
            stmt.setInt(2, numero);
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error al obtener los Datos"+e.getMessage(),e);
        }
    }
}
