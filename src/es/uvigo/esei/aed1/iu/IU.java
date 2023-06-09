/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
import java.util.Collection;
import java.util.Scanner;

public class IU {
    private final Scanner teclado;

    public IU() {
        teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un num. de teclado
     * 
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int leeNum(String msg) {
        while (true) {
            String str = leeString(msg);
            
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException _e) {
                System.out.println("Entrada no válida. Debe ser un entero.");
            }
        }
    }
    
    /// Lee un número en el intervalo [min, max_ex)
    /// Importante, el minimo es inclusivo, el máximo exclusivo
    public int leerIntRango(String msg, int min, int max_ex) {
        int x = min - 1;
        while (x < min || x >= max_ex) {
            x = leeNum(msg);
            if (x < min || x >= max_ex) { // Tener que comprobar dos veces la condición es malo (se podría usar un break pero bueno)
                System.err.println(String.format("Número incorrecto. El valor debe estar entre %i y %i.", min, max_ex));
            }
        }
        return x;
    }

    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public String[] pedirDatosJugadores(){
        int numJugadores = leerIntRango("Introduce el número de jugadores (3 / 4)", 3, 5);
        
        String[] nombres = new String[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            nombres[i] = leeString("Nombre del jugador " + (i + 1) + ": ");
        }
        
        return nombres;
    }

    public void mostrarJugador(Jugador jugador){
        System.out.println(jugador);
    }

    public void mostrarJugadores(Jugador[] jugadores){
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].toString(i + 1));
        }
    }
}
