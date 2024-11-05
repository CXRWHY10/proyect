public class PruebaLibro {
    public static void main (String[]args){
        Libro libro1= new Libro("El principito","Antoine de Saint-Exupery",20);
        libro1.imprimirInfo();
        Librotexto librotexto = new Librotexto("Algebra de Baldor","Aurelio Baldor",50,"Algebra lineal");
        librotexto.imprimirInfo();
        LibroTextoUN libroTextoUN = new LibroTextoUN("Calculo 1","Santiago Relos",40,"1er Semestre","Tecnologia");
        libroTextoUN.imprimirInfo();
        Novela novela = new Novela("100 Años de Soledad","Gabriel Garcia Marquez",90,"Realista");
        novela.imprimirInfo();
    }
}
