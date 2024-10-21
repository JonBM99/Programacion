package com.decroly.daw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Ejercicio 1
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Introduce una cadena de texto: ");
        String texto = entrada.nextLine();
        String [] palabras = texto.split(" ");

        for (String palabra : palabras) {
            System.out.println(palabra);
        }


        //Ejercicio 2
        System.out.println("Introduce una cadena de texto: ");
        String cadena1 = entrada.nextLine();
        System.out.println("Introduce otra cadena de texto(puede ser la misma): ");
        String cadena2 = entrada.nextLine();

        System.out.println("¿Son iguales las cadenas? " + cadena1.equalsIgnoreCase(cadena2));


        //Ejercicio 3
        System.out.println("Introduce nombre: ");
        String nombre = entrada.nextLine();
        System.out.println("Introduce primer apellido: ");
        String apellido = entrada.nextLine();
        System.out.println("Introduce segundo apellido: ");
        String apellido2 = entrada.nextLine();

        String user = nombre.substring(0,3)
                    + apellido.substring(0,3)
                    + apellido2.substring(0,3);
        System.out.println("El codigo del usuario es: " + user.toUpperCase());

        
        //Ejercicio 4
        System.out.println("Introduce una frase: ");
        String frase = entrada.nextLine().toLowerCase();
        int i = 0, e = 0, a = 0, o = 0, u = 0;
        
        for (char c : frase.toCharArray()) {
            if (c == 'a'){
                a ++;
            } else if (c == 'e'){
                e ++;
            } else if (c == 'i'){
                i ++;
            } else if (c == 'o'){
                o ++;
            } else if(c == 'u'){
                u ++;
            }
        }
        System.out.println("Hay " + a + " a en la frase");
        System.out.println("Hay " + e + " e en la frase");
        System.out.println("Hay " + i + " i en la frase");
        System.out.println("Hay " + o + " o en la frase");
        System.out.println("Hay " + u + " u en la frase");

        
        //Ejercicio 5
        System.out.print("Introduce una frase: ");
        String frase1 = entrada.nextLine().replaceAll(" ","").toLowerCase();
        
        boolean espalindromo = true;
        int longitud = frase1.length();
        
        for (int j = 0; j < longitud / 2; j++) {
            if (frase1.charAt(j) != frase1.charAt(longitud - 1 - j)){
                espalindromo = false;
            }
        }

        if (espalindromo){
            System.out.println("La frase es un palindromo");
        } else{
            System.out.println("La frase no es un palindromo");
        }
    }
}

