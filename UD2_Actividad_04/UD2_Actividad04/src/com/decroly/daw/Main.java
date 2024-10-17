package com.decroly.daw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
       
        //Ejercicio 1
        Scanner entrada = new Scanner (System.in);
        // double[] numeros = new double [10];

        // for (int i = 0; i < numeros.length; i++) {
        //     System.out.println("Ingrese el numero " + (i + 1) + ": ");
        //     numeros[i] = entrada.nextDouble();
        // }

        // for (double numero : numeros) {
        //     System.out.println("(Los numeros introducidos son:)");
        //     System.out.println(numero);
        // }

        // //Ejercicio 2
        // double[] numeros1 = new double [10];
        // double suma = 0;

        // for (int i= 0; i < numeros1.length; i++) {
        //     System.out.println("Ingrese el numero "+ (i + 1) + ": ");
        //     numeros1[i] = entrada.nextDouble();
        //     suma += numeros1[i];
        // }

        // System.out.println("La suma de los numeros es: " + suma);

        // //Ejericicio 3
        // double[] numeros2 = new double [10];

        // System.out.println("Por favor, ingrese 10 numeros reales:");
        // for (int i = 0; i < 10; i++) {
        //     System.out.print("Numero " + (i + 1) + ": ");
        //     numeros2[i] = entrada.nextDouble();
        // }

        // double max = numeros2[0];
        // double min = numeros2[0];

        // for (int i = 1; i < numeros2.length; i++) {
        //     if (numeros2[i] > max) {
        //         max = numeros2[i];
        //     }
        //     if (numeros2[i] < min) {
        //         min = numeros2[i];
        //     }
        // }
        // System.out.println("El maximo es: " + max);
        // System.out.println("El minimo es: " + min);

        // //Ejercicio 4
        // int[] numeros3 = new int [20];
        // int sumapos = 0;
        // int sumaneg = 0;

        // System.out.println("Por favor, ingrese 20 numeros reales:");
        // for (int i = 0; i < 20; i++) {
        //     System.out.println("Numero " + (i + 1) + ": ");
        //     numeros3 [i] = entrada.nextInt();
            
        //     if(numeros3[i] < 0){
        //         sumaneg += numeros3[i];
        //     } else {
        //         sumapos += numeros3[i];
        //     }
        // }
        // System.out.println("La suma de los numeros negativos es: " + sumaneg);
        // System.out.println("La suma de los numeros positivos es: " + sumapos);

        //Ejercicio 5
        // double numeros4 [] = new double[20];
        // double suma1 = 0;

        // System.out.println("Por favor, ingrese 20 numeros reales: ");
        // for (int i = 0; i < 20; i++){
        //     System.out.println("Numero " + (i + 1) + ": ");
        //     numeros4 [i] = entrada.nextDouble();
        //     suma1 += numeros4[i];
        //     }

        //     double media = suma1 / numeros4.length;
        //     System.out.println("La media es: " + media);

        //Ejercicio 6
        // System.out.println("Introduce el valor de n:" );
        // int n = entrada.nextInt();
        // System.out.println("Introduce el valor de m:" );
        // int m = entrada.nextInt();

        // int[] array = new int [n];

        // for (int i = 0; i < n ; i++){
        //     array[i] = m;
        // }
        // System.out.println("El array es: ");
        // for (int i = 0; i < n; i++){
        //     System.out.println("Posicion " + i+ ": " + array[i]);
        // }
        
        //Ejericio 7
        // System.out.println("Introduce el valor de P:" );
        // int p = entrada.nextInt();
        // System.out.println("Introduce el valor de Q:" );
        // int q = entrada.nextInt();
        
        // if (p > q){
        //     System.out.println("q tiene que ser mayor que p");
        //     return;
        // } 
        
        // int[] array1 = new int [q - p + 1];
        // for(int i = 0; i < array1.length; i++){
        //     array1 [i] = p + i;
        // }

        // System.out.println("El array es: ");
        // for (int i = 0; i < array1.length; i++){
        //     System.out.println("Posicion " + i+ ": " + array1[i]);
        // }

        //Ejercicio 8
        // double reales [] = new double [100];
        // for (int i = 0; i < reales.length; i++){
        //     reales [i] = Math.random();
        // }

        // System.out.println("Introduce un numero real entre 0.0 y 1.0");
        // double r = entrada.nextDouble();

        // System.out.println("Los valores en el array que son iguales o superiores a " + r + " son: ");
        // for (int i = 0; i < reales.length; i++){
        //     if (reales[i] > r) {
        //     System.out.println(reales[i]);               
        //     }
        // }

        //Ejericio 9
        // int enteros [] = new int [100];       // for (int i = 0; i < reales.length; i++){
            
        // for (int i = 0; i < enteros.length; i++) {
        //     enteros [i] = (int)(1 + Math.random() * 10);
        // }

        // System.out.println("El array enteros es: ");
        // for (int i = 0; i < enteros.length; i++) {
        //     System.out.println(enteros[i]);     
        // }

        // System.out.println("Introduce un numero entre 0 y 10");
        // int t = entrada.nextInt();

        // boolean encontrado = false;
        // System.out.println("El valor " + t + " aparece en las posiciones: ");
        // for (int i = 0; i < enteros.length; i++) {
        //     if (enteros[i] == t) {
        //         System.out.println(i + " ");
        //         encontrado = true;
        //     }
        // }

        // if (!encontrado) {
        //     System.out.println("No se ha encontrado el valor en el array");
        // } else{
        //     System.out.println();
        // }

        //Ejercicio 10
        // System.out.println("Introduce el valor de n");
        // int n = entrada.nextInt();

        // double[] alturas = new double[n];
        // for (int i = 0; i < n; i++) {
        //     System.out.println("Ingrese el valor " + (i + 1) + ": ");
        //         alturas[i] = entrada.nextDouble();
        // }

        // double suma = 0;
        // double alturamax = alturas[0];
        // double alturamin = alturas[0];

        // for (double altura : alturas) {
        //     suma += altura;
        //     if( altura > alturamax){
        //         alturamax = altura;
        //     }
        //     if( altura < alturamin){
        //         alturamin = altura;
        //     }
        // }
        // double alturamedia = suma / n;
        
        // int porencimamedia = 0;
        // int pordebajomedia = 0;
        // for(double altura : alturas){
        //     if(altura > alturamedia){
        //         porencimamedia ++;
        //     } else{
        //         pordebajomedia ++;
        //     }
        // }
        // System.out.println("La altura media es: " + alturamedia);
        // System.out.println("La altura maxima es: " + alturamax);
        // System.out.println("La altura minima es: " + alturamin);
        // System.out.println("Hay " + porencimamedia + " personas por encima de la media de altura");
        // System.out.println("Hay " + pordebajomedia + " personas por debajo de la media de altura");

        //Ejercicio 11
        
    }
}
