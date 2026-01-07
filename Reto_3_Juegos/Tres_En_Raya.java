package Reto_3_Juegos;

import java.util.*;

public class Tres_En_Raya {
    static char[][] tablero = new char[3][3]; 
    static Scanner lector = new Scanner(System.in); 
    public static void main(String[] args) {
        ejecutarTresEnRaya();


    }

    // metodos de pantalla / teclado

    static void ejecutarTresEnRaya(){// metodo que se usará como un main, pero sin serlo, de esta manera el main quedara más limpio
        char jugadorActual = 'X'; 
        int fila, columna; 
        boolean hayGanador = false; 
        inicializarTablero(tablero); 

        while (!hayGanador && !tableroLleno(tablero)) {
            System.out.println("Turno del jugador " + jugadorActual);
            fila = pedirFila(); 
            columna = pedirColumna(); 
            colocarFicha(tablero, fila, columna, jugadorActual); 
            mostrarTablero(tablero); 
            hayGanador = hayGanador(tablero, jugadorActual); 
            if (!hayGanador) {
                jugadorActual = cambiarTurno(jugadorActual); 
            }
        }
    } 
    static void mostrarTablero(char[][] tablero){// metodo que printa el tablero
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---+---+---");
        }
    } 
    
    static int pedirFila(){ // pide una fila al usuario 
        int fila; 
        System.out.print("Dime la fila en la que quieres colocar tu movimiento: ");
        fila = lector.nextInt(); 
        
        return fila; 
    }
    
    static int pedirColumna(){ // pide una columna al usuario

        int columna; 
        System.out.print("Dime la columna en la que quieres colocar tu movimiento: ");
        columna = lector.nextInt(); 

        return columna; 
    }

    
    static void mostrarMensaje(String msg){// muestra mensaje  ¿?
        System.out.println(msg);
    } 

    // metodos de logica

    static void inicializarTablero(char[][] tablero){// inicia el tablero todo vacío 
         for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Mostrar el tablero vacío
        mostrarTablero(tablero);
    } 
    static boolean esJugadaValida(char[][] tablero, int fila, int col){// comprueba que la jugada sea valida, es decir que esté vacío y que este en el 3x3
        
        if (tablero[fila][col] == ' ' && (fila >= 0 && fila < 3) && (col >= 0 && col < 3)) {
            return true; 
        } else{
            System.out.println("La jugada no es valida, intentalo de nuevo.");
        }
        

        return false; 
    } 

    static void colocarFicha(char[][] tablero, int fila, int col, char jugador){// Si la jugada es válida coloca la ficha en el lugar que se ha indicado
        if (esJugadaValida(tablero, fila, col)== true) {
            tablero[fila][col] = jugador; 
        }else{
            System.out.println("La jugada no es valida, intentalo de nuevo.");
        }
    } 
    static boolean hayGanador(char[][] tablero, char jugador){// Comprueba que haya ganador
        if (ganaPorColumnas(tablero, jugador) || ganaPorDiagonales(tablero, jugador) || ganaPorFilas(tablero, jugador)) {
            System.out.println("El jugador " + jugador + " ha ganado");
            return true; 
        }
        return false; 
    } 
    static boolean tableroLleno(char[][] tablero){// Comprueba y avisa si el tablero esta lleno
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; 
                }
            }
        }
        System.out.println("El tablero está lleno, es un empate.");
        return true;
    } 
    static char cambiarTurno(char jugador){// cambia el turno de X a O 
        return jugador == 'X' ? 'O' : 'X'; 
    } 

    // metodos auxiliares

    static boolean ganaPorFilas(char[][] tablero, char jugador){ // comprueba si se gana por filas 
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; 
            }
        }
        return false;
    }
    static boolean ganaPorColumnas(char[][] tablero, char jugador){// Comprueba si se gana por columnas 
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true; 
            }
        }
        return false;
    } 
    static boolean ganaPorDiagonales(char[][] tablero, char jugador){ // comprueba si se gana por diagonales
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }
        return false;
    }
}
    
    