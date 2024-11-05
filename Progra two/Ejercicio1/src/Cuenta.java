public class Cuenta {
    protected float saldo;
    protected int numeroConsig = 0;
    protected int numerosRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;
    public Cuenta(float saldo,float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }
    public void consignar(float cantidad){
        saldo = saldo + cantidad;
        numeroConsig = numeroConsig + 1;
    }
    public void retirar (float cantidad){
        float nuevoSaldo = saldo - cantidad;
        if (nuevoSaldo >= 0){
            saldo -=cantidad;
            numerosRetiros = numerosRetiros + 1;
        }else {
            System.out.println("La cantidad a retirar excede el saldo actual");
        }
    }
    public void calcularInteres(){
        float tasaMensual = saldo * tasaAnual/12;
        float interesMensual = saldo * tasaMensual;
        saldo += interesMensual;
    }
    public void extractoMensual(){
        saldo -= comisionMensual;
        calcularInteres();
    }
}

