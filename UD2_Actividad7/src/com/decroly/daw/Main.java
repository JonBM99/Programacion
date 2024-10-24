package com.decroly.daw;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    Scanner entrada = new Scanner (System.in);
    Random random = new Random();
    int puntosplayer = 0;
    int puntosia = 0;
    
    String[] opciones = {"P", "L", "T"};

    System.out.println("Elige tu jugada");
    System.out.println("Introduce P si quieres sacar piedra, L si quieres papel, T si quieres tijeras, S si quieres ver resultados y salir del juego");
    
        while(true){
            String elecciondelusuario = entrada.nextLine().toUpperCase();
            if(elecciondelusuario.equals("S")){
                System.out.println("El resultado final es: " + "Puntos Jugador: " + puntosplayer + " vs Puntos IA: " + puntosia  + "." + "\n" + "Gracias por jugar");
            break;
            }
            
            String elecciondelaia = opciones[random.nextInt(3)];
                       
            if(elecciondelusuario.equals(elecciondelaia)){
                System.out.println("Empate");
            } else if((elecciondelusuario.equals("P") && elecciondelaia.equals("T")) ||
            (elecciondelusuario.equals("L") && elecciondelaia.equals("P")) ||
            (elecciondelusuario.equals("T") && elecciondelaia.equals("L"))){
                System.out.println("Ganaste");
                puntosplayer ++;
            }else{
                System.out.println("Perdiste");
                puntosia ++;
            }
        }
    }
}
