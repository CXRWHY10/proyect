package Burbuja;
public class Burbuja {
    public static void main(String[]args) {
        int[] array = {14, 8, 12, 4, 9, 5, 10 , 20 ,3};
        Escribir(array);
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length - 1 ; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Escribir(array);
    }
    public static void Escribir(int [] array ){
        int n = array.length;
        for(int i = 0; i < n ; i ++){
            if (i == 0){
                System.out.print("[");
            }
            System.out.print(" "+ array[i]+ " ");
            if (i < n - 1){
                System.out.print(",");
            }
            if (i == n - 1){
                System.out.print("]");
            }
        }
        System.out.println(" ");
    }
}
