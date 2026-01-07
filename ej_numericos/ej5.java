import java.util.Scanner;

public class ej5 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in); 

        System.out.print("Dime cuantos numeros aleatorios quieres que tena el array: ");
        int n = lector.nextInt(); 

        System.out.print("Y cual quieres que sea el MINIMO: ");
        int minimo = lector.nextInt(); 

        System.out.print("Dime cual quieres que sea el rango MAXIMO: ");
        int maximo = lector.nextInt(); 

        int[] numeros = generarAleatorios(n, minimo, maximo); 

        System.out.println("Impares: " +contarParesImpares(numeros, false));
        System.out.println("Pares: " +contarParesImpares(numeros, true));

    }
    static int[] generarAleatorios (int n, int min, int max) {
        int[] numeros = new int [n]; 

        for (int i = 0; i < numeros.length; i++) {
            int random = (int) (Math.random()* max) +  min; 
            numeros[i] = random;  
            System.out.println(numeros[i]);
        }
        return numeros; 
    }

    static int contarParesImpares(int[] a, boolean pares){
        int contador = 0; 

        for (int i = 0; i < a.length; i++) {
            if ( pares == true) { // aqui me faltaba un igual 
                if (a[i] % 2 == 0) { 
                    contador++; 
                }
            } else { // no hay que comprar
                if (a[i] % 2 != 0 ) {
                    contador++; 
                }
            }
        }
        return contador; 
    }

}
