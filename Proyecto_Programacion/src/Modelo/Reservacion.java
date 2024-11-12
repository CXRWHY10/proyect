package Modelo;

import Vision.Habitaciones;
public class Reservacion {
    private Cliente cliente;
    private Habitaciones habitaciones;
    private int dias;
    public Reservacion(Cliente cliente, Habitaciones habitaciones, int dias){
        this.cliente = cliente;
        this.habitaciones = habitaciones;
        this.dias = dias;
    }
    public  double CalcularCosto (){
        return habitaciones.getPrecios() * dias;
    }
    public String toString(){
        return "Reserva para " + cliente.getNombre() + " en " + habitaciones + " por " + dias + " dias. Costo total: $" + CalcularCosto();
    }
}
