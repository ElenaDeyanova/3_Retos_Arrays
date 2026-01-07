import java.util.Scanner;

public class ej2 {
    public static void main(String[] args) {
        int[] numeros = new int[6]; 
        Scanner lector = new Scanner(System.in); 

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Dime un numero: ");
            numeros[i] = lector.nextInt(); 
        }

        for (int n : numeros) {
            System.out.print(n);
        }
    }
}
