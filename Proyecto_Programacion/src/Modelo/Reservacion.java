package Modelo;

import Vision.Habitacion;
public class Reservacion {
    private Cliente cliente;
    private Habitacion habitaciones;
    private int dias;
    public Reservacion(Cliente cliente, Habitacion habitaciones, int dias){
        this.cliente = cliente;
        this.habitaciones = habitaciones;
        this.dias = dias;
    }

    public Reservacion(int i, Cliente cliente, Habitacion habitacion, String fechaInicio, String fechaFin) {
    }

    public  double CalcularCosto (){
        return habitaciones.getPrecios() * dias;
    }
    public String toString(){
        return "Reserva para " + cliente.getNombre() + " en " + habitaciones + " por " + dias + " dias. Costo total: $" + CalcularCosto();
    }
}
