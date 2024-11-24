package Modelo;
import java.sql.*;
public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }
    public void agregarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, email) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                cliente.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar el cliente: " + e.getMessage(), e);
        }
    }

    public void eliminarCliente(int clienteId) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, clienteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el cliente: " + e.getMessage(), e);
        }
    }
}
