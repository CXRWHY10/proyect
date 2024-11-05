public class Novela extends Libro{
    private String tipo;
    Novela(String titulo, String autor, double saldo, String tipo) {
        super(titulo, autor, saldo);
        this.tipo= tipo;
    }
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("tipo: "+tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
