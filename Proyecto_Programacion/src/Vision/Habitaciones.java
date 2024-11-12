package Vision;
public class Habitaciones {
    private int numero;
    private String tipo;
    private double precios;
    public Habitaciones(int numero, String tipo, double precios){
        this.numero = numero;
        this.tipo = tipo;
        this.precios = precios;
    }
    public int getNumero() {
        return numero;
    }
    public String getTipo() {
        return tipo;
    }
    public double getPrecios() {
        return precios;
    }
    public String toString(){
        return "Habitacion "+ numero + "("+ tipo + ") - Precio: $" + precios;
    }
}
