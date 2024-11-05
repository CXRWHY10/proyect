public class Librotexto extends Libro{
    private String curso;

    Librotexto(String titulo, String autor, double saldo, String curso) {
        super(titulo, autor, saldo);
        this.curso = curso;
    }
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("Curso: "+curso);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
