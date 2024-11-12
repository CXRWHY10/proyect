package Modelo;
public class Cliente {
    private String nombre;
    private int CI;
    public Cliente(String nombre, int CI){
        this.nombre = nombre;
        this.CI = CI;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCI() {
        return CI;
    }
}
