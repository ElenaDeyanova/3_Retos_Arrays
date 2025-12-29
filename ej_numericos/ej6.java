import java.util.Scanner;

public class ej6 {
    public static void main(String[] args) {


        Scanner lector = new Scanner(System.in); 
        System.out.print("Cuanto de largo quieres que sea el array: ");
        int n = lector.nextInt(); 

        boolean[] numeros = alternarBooleanos(n); 
        contador(numeros);
        
    }
    static boolean[] alternarBooleanos (int n){
        boolean[] numeros = new boolean[n]; 

        for (int i = 0; i < numeros.length; i++) { // no poner el <= por que si pones el igual intenta acceder a una linea que no existe y da error. 
            int random = (int) (Math.random()* 2); 
            if(random == 1){
                numeros[i] = true; 
            } else {
                numeros [i] = false; 
            }
        }
        return numeros;  
    }

    static void contador (boolean[] a){
        int contadorT = 0; 
        int contadorF = 0; 

        for (int i = 0; i < a.length; i++) {
            if (a[i] == true) {
                contadorT++; 
            } else {
                contadorF ++; 
            }
        }

        System.out.println("Total de flase: " + contadorF);
        System.out.println("Contador de true: " + contadorT);
    }
}
