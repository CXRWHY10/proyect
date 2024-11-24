package Modelo;

public class Habitacion {
    private int id;
    private String tipo;
    private boolean disponible;

    public Habitacion(int id, String tipo, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
