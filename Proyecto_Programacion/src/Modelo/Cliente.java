package Modelo;
public class Cliente {
    private String nombre;
    private String email;
    private int telefono;
    private int CI;
    public Cliente(String nombre, int CI, String email, int telefono){
        this.nombre = nombre;
        this.CI = CI;
        this.telefono= telefono;
        this.email = email;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCI() {
        return CI;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getEmail() {
        return email;
    }
}
