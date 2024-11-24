package Modelo;

import java.sql.*;

public class ReservaDAO {
    private Connection conexion;

    public ReservaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarReserva(Cliente cliente, Habitacion habitacion) throws SQLException {
        String sql = "INSERT INTO reservas (cliente_id, habitacion_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setInt(2, habitacion.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar la reserva: " + e.getMessage(), e);
        }
    }

    public void eliminarReserva(int reservaId) throws SQLException {
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, reservaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la reserva: " + e.getMessage(), e);
        }
    }
}
