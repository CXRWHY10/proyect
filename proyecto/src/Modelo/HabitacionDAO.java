package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionDAO {
    private Connection conexion;

    public HabitacionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT id, tipo, disponible FROM habitaciones";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tipo = resultSet.getString("tipo");
                boolean disponible = resultSet.getBoolean("disponible");
                Habitacion habitacion = new Habitacion(id, tipo, disponible);
                habitaciones.add(habitacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las habitaciones: " + e.getMessage(), e);
        }
        return habitaciones;
    }

    public void agregarHabitacion(String tipo, boolean disponible) throws SQLException {
        String sql = "INSERT INTO habitaciones (tipo, disponible) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            stmt.setBoolean(2, disponible);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar la habitación: " + e.getMessage(), e);
        }
    }
}
