package Reto_3_Juegos;

import java.util.Scanner;

public class Conecta_4 {
    static char[][] tablero = new char[6][7]; 
    static Scanner lector = new Scanner(System.in); 
    public static void main(String[] args) {
        ejecutarTresEnRaya();
    }

    //===== metodos de UI ======
    static void ejecutarTresEnRaya(){// metodo que se usará como un main, pero sin serlo, de esta manera el main quedara más limpio
        char jugadorActual = 'X'; 
        int columna; 
        boolean hayGanador = false; 
        inicializarTablero(tablero); 

        while (!hayGanador && !tableroLleno(tablero)) {
            System.out.println("Turno del jugador " + jugadorActual);
            columna = pedirColumna(); 
            colocarFicha(tablero, columna, jugadorActual); 
            mostrarTablero(tablero); 
            hayGanador = hayGanador(tablero, jugadorActual); 
            if (!hayGanador) {
                jugadorActual = cambiarTurno(jugadorActual); 
            }
        }
    } 

    static void mostrarTablero(char[][] tablero){// metodo que printa el tablero BIEN
        for (int i = 0; i < 6; i++) {
            System.out.print(" ");
            for (int j = 0; j < 7; j++) {
                System.out.print(tablero[i][j]);
                if (j < 6) System.out.print(" | ");
            }
            System.out.println();
            if (i < 5) System.out.println("---+---+---+---+---+---+---");
        }
    } 
    
    static int pedirColumna(){ // pide una columna al usuario BIEN 
        int columna; 
        System.out.print("Dime la columna en la que quieres colocar tu movimiento: ");
        columna = lector.nextInt(); 

        return columna; 
    }

    //===== metodos de logica ======

    static void inicializarTablero(char[][] tablero){// inicia el tablero todo vacío BIEN
         for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Mostrar el tablero vacío
        mostrarTablero(tablero);
    } 

    static boolean esJugadaValida(char[][] tablero, int col){// comprueba que la jugada sea valida BIEN
        if (tablero[0][col] == ' ' && (col >= 0 && col < 7)) {
            return true; 
        } 
        
        return false; 
    } 

    static void colocarFicha(char[][] tablero, int col, char jugador){// Si la jugada es válida coloca la ficha BIEN    
        if (esJugadaValida(tablero, col)== true) {
           for (int i = 5; i >= 0; i--) {
                if (tablero[i][col] == ' ') {
                    tablero[i][col] = jugador;
                    break;
                }
           }
        }else{
            System.out.println("La jugada no es valida, intentalo de nuevo.");
        }
    } 
    
    static boolean hayGanador(char[][] tablero, char jugador){// Comprueba que haya ganador
        if (ganaPorColumnas(tablero, jugador) || ganaPorDiagonalesDerecha(tablero, jugador) || ganaPorFilas(tablero, jugador) || ganaPorDiagonalesIzq(tablero, jugador)) {
            System.out.println("El jugador " + jugador + " ha ganado");
            return true; 
        }
        return false; 
    } 
    
    static boolean tableroLleno(char[][] tablero){// Comprueba y avisa si el tablero esta lleno
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (tablero[i][j] == ' ') {
                    return false; 
                }
            }
        }
        System.out.println("El tablero está lleno, es un empate.");
        return true;
    } 
    
    static char cambiarTurno(char jugador){// cambia el turno de X a O BIEN
        return jugador == 'X' ? 'O' : 'X'; 
    } 

    //===== metodos auxiliares ======


    static boolean ganaPorFilas(char[][] tablero, char jugador){ // comprueba si se gana por filas 
        for (int i = 0; i < tablero.length; i++) { // y aqui se usa el length normal para recorrer las filas
        int contador = 0; 
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == jugador) {
                    contador++; 
                } else {
                    contador = 0; 
                }
                if (contador == 4) {
                    return true; 
                }
            }
        }
        
        return false; 
    }
    
    static boolean ganaPorColumnas(char[][] tablero, char jugador){// Comprueba si se gana por columnas 
        for (int col = 0; col < tablero[0].length; col++) { // se usa el tablero[0] para recorrer las columnas
        int contador = 0; 
            for (int fila = 0; fila < tablero.length; fila++) {
                if (tablero[fila][col] == jugador) {
                    contador++; 
                } else {
                    contador = 0; 
                }
                if (contador == 4) {
                    return true; 
                }
            }
        }
        
        return false;
    } 
    
    static boolean ganaPorDiagonalesDerecha(char[][] tablero, char jugador){ // comprueba si se gana por diagonales
      for (int fila = 0; fila <= tablero.length-4; fila++) {
        for (int col = 0; col <= tablero[0].length-4; col++) {
            int contador = 0; 

            for (int k = 0; k < 4; k++) {
                if (tablero[fila + k][col + k] == jugador) {
                    contador++; 
            } else {
                break;  
                }
            }

            
            if (contador == 4) {
                return true; 
            }
        }
        
      }

      return false; 
    }

    static boolean ganaPorDiagonalesIzq(char[][] tablero, char jugador){ // comprueba si se gana por diagonales
      for (int fila = 0; fila <= tablero.length -4; fila++) {
        for (int col = 3; col < tablero[0].length; col++) {
            int contador = 0; 

            for (int k = 0; k < 4; k++) {
                if (tablero[fila + k][col - k] == jugador) {
                    contador++; 
            } else {
                break;  
                }
            }

            
            if (contador == 4) {
                return true; 
            }
        }
        
      }
      return false; 
}
}

