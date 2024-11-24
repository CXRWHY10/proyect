package Modelo;

public class Reserva {
    private int id;
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva(int id, Cliente cliente, Habitacion habitacion) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
}
