public class Libro {
    private double saldo;
    private String Titulo;
    private String autor;
    Libro(String titulo, String autor, double saldo){
        this.Titulo = titulo;
        this.autor = autor;
    }
    public void imprimirInfo(){
        System.out.println("Titulo: "+Titulo+", Autor: "+autor+", Precio: "+saldo);
    }
    public double getSaldo() {
        return saldo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }
}
