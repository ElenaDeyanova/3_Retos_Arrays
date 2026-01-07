import java.util.Scanner;

public class ej4 {
    public static void main(String[] args) {
        int[] numeros = new int[6]; 
        Scanner lector = new Scanner(System.in); 

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Dime un numero: ");
            numeros[i] = lector.nextInt(); 
        }

        System.out.println("Maximo: " + maximo(numeros));
        System.out.println("Minimo: " + minimo(numeros));
    }
    static int maximo(int[] a){
        int max = 0; 

        for (int i = 0; i < a.length; i++) {
            if (max <= a[i]) {
                max = a[i]; 
            }
        }
        return max; 
    }

    static int minimo (int[] a) {
        int min = 1; 

        for (int i = 0; i < a.length; i++) {
            if (min >= a[i]) {
                min = a[i]; 
            }
        }
        return min; 
    }
}
