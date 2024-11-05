package Modelo;
public class Cliente {
    private int id;
    private String nombre;
    private int numero;
    public Cliente(int id, String nombre,int numero){
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
}
