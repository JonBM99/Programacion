package com.decroly.daw;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    Scanner entrada = new Scanner (System.in);
    Random random = new Random();
    int puntosplayer = 0;
    int puntosia = 0;
    
    String[] opciones = {"P", "L", "T", "K", "Z"};
    boolean juegoActivo = true;

    System.out.println("Elige tu jugada");
    System.out.println("Introduce P si quieres sacar piedra, L si quieres papel, T si quieres tijeras, K si quieres Spock, Z si quieres lagarto o S si quieres ver resultados y salir del juego");
        
        do{
            String elecciondelusuario = entrada.nextLine().toUpperCase();

            String elecciondelaia = opciones[random.nextInt(opciones.length)];

            if(elecciondelaia.equals("P")){
                System.out.println("La IA ha elegido: Piedra");
            }
            if(elecciondelaia.equals("L")){
                System.out.println("La IA ha elegido: Papel");
            }
            if(elecciondelaia.equals("T")){
                System.out.println("La IA ha elegido: Tijeras");
            }
            if(elecciondelaia.equals("K")){
                System.out.println("La IA ha elegido: Spock");
            }
            if(elecciondelaia.equals("Z")){
                System.out.println("La IA ha elegido: Lagarto");
            }
                       
            if(elecciondelusuario.equals(elecciondelaia)){
                System.out.println("Empate, introduce otro valor para seguir jugando o S para salir");
            } else if((elecciondelusuario.equals("T") && elecciondelaia.equals("L")) ||
            (elecciondelusuario.equals("L") && elecciondelaia.equals("P")) ||
            (elecciondelusuario.equals("P") && elecciondelaia.equals("Z")) ||
            (elecciondelusuario.equals("Z") && elecciondelaia.equals("K")) ||
            (elecciondelusuario.equals("K") && elecciondelaia.equals("T")) ||
            (elecciondelusuario.equals("T") && elecciondelaia.equals("Z")) ||
            (elecciondelusuario.equals("Z") && elecciondelaia.equals("P")) ||
            (elecciondelusuario.equals("L") && elecciondelaia.equals("K")) ||
            (elecciondelusuario.equals("K") && elecciondelaia.equals("P")) ||
            (elecciondelusuario.equals("P") && elecciondelaia.equals("T"))){
                System.out.println("Ganaste, introduce otro valor para seguir jugando o S para salir");
                puntosplayer ++;
            } else{
                System.out.println("Perdiste, introduce otro valor para seguir jugando o S para salir");
                puntosia ++;
            }

            if(elecciondelusuario.equals("S")){
                if(puntosplayer < puntosia){
                    System.out.println("El resultado final es: " + "Puntos Jugador: " + puntosplayer + " vs Puntos IA: " + puntosia  + ". Te ha ganado la IA." + "\n" + "Gracias por jugar");
                } else if(puntosia == puntosplayer){
                    System.out.println("El resultado final es: " + "Puntos Jugador: " + puntosplayer + " vs Puntos IA: " + puntosia  + ". Habeis quedado empate." + "\n" + "Gracias por jugar");
                } else {
                    System.out.println("El resultado final es: " + "Puntos Jugador: " + puntosplayer + " vs Puntos IA: " + puntosia  + ". Has ganado a la IA" + "\n" + "Gracias por jugar");
                }
                juegoActivo = false;
            }
        } while((juegoActivo == true));
    }
}
