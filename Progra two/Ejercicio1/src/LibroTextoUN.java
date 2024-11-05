public class LibroTextoUN extends Librotexto{
    private String facultad;

    LibroTextoUN(String titulo, String autor, double saldo, String curso, String facultad) {
        super(titulo, autor, saldo, curso);
        this.facultad = facultad;
    }
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Facultad: "+facultad);
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
}
