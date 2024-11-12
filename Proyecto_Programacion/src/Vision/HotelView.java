package Vision;

import java.util.Scanner;

public class HotelView {
    private Scanner scanner;
    public HotelView(){
        scanner = new Scanner(System.in);
    }
    public Habitacion Cantidad(){
        System.out.println("Ingrese el numero de la habitacion: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
    }
}
