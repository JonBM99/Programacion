package com.decroly.daw;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
    
    //Ejercicio 1
    int [][] matriz = new int[5][5];
    int numero = 1;

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz.length; j++) {
        matriz[i][j] = numero++;
        }
    }
    for (int i = 0; i < matriz.length; i++) {
        System.out.println("Fila "+ i + ": " );
        for (int j = 0; j < matriz.length; j++) {
            System.out.println(matriz[i][j] + " ");
        }
    }
    
    
    //Ejercicio 2
    int [][] matriz1 = new int [10][10];

    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1.length; j++) {
        matriz1[i][j] = (i + 1) * (j +1);
        }
    }

    for (int i = 0; i < matriz1.length; i++) {
        System.out.println("Fila "+ i + ": " );
        for (int j = 0; j < matriz1.length; j++) {
            System.out.println(matriz1[i][j] + "\t");
        }
    }
    

    //Ejericio 3
    Scanner entrada = new Scanner (System.in);
    System.out.println("Introduce el valor para n:");
    int n = entrada.nextInt();
    System.out.println("Introduce un valor para m: ");
    int m = entrada.nextInt();
    
    int [][] matriz2 =  new int [n][m];

    System.out.println("Introduce los valores de la matriz:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++){
            System.out.println("Valor en la posicion:" + i + j);
            matriz2 [i][j] =  entrada.nextInt();
        }
    }
    int nulo = 0;
    int mayor = 0;
    int menor = 0;

    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++){
            if (matriz2[i][j] == 0){
                nulo ++;
            }else if (matriz2[i][j] < 0) {
                mayor ++;
            }else{
                menor ++;
            }
        }
    }
    System.out.println("Hay " + nulo + " valores iguales a cero.");
    System.out.println("Hay " + mayor + " valores mayores a cero.");
    System.out.println("Hay " + menor + " valores menores a cero.");


    //Ejercicio 4
    int alumnos = 4;
    int asignaturas = 5;
    double [][] calificaciones = new double[alumnos][asignaturas];
    for (int i = 0; i < alumnos; i++) {
        System.out.println("Introduce las notas del alumno " + (1 + i) + " : ");
        for (int j = 0; j < asignaturas; j++) {
            System.out.println("Asignatura " + (j + 1) + " : ");
            calificaciones[i][j] = entrada.nextDouble();
        }
    }

    for (int i = 0; i < alumnos; i++) {
        double notamin = calificaciones[i][0];
        double notamax = calificaciones[i][0];
        double suma = 0;
        for (int j = 0; j < asignaturas; j++) {
            notamin = Math.min(notamin, calificaciones[i][j]);
            notamax = Math.max(notamax, calificaciones[i][j]);
            suma += calificaciones[i][j];
        }
        System.out.println("Resultados para alumno: " + (i + 1) + " : ");
        System.out.println("La nota minima es: " + notamin);
        System.out.println("La nota maxima es: " + notamax);
        System.out.println("La nota media es: " + suma/asignaturas);
    }


    //Ejercicio 5
    System.out.println("Introduce el numero de trabajadores:");
    int q = entrada.nextInt();
    double sueldos[][] = new double [q][2];
    for (int i = 0; i < q; i++) {
        System.out.println("El trabajador " + (i + 1) + " :");
        System.out.println("Introduce 0 para genero masculino y 1 para genero femenino");
        sueldos [i][0] = entrada.nextDouble();
        System.out.println("Sueldo: ");
        sueldos [i][1] = entrada.nextDouble();     
    }

    double sumamasc = 0;
    double sumafem = 0;
    int masc = 0;
    int fem = 0;

    for (int i = 0; i < q; i++) {
        if (sueldos[i][0] == 0){
            masc ++;
            sumamasc += sueldos[i][1];
        } else{
            fem ++ ;
            sumafem += sueldos[i][1];
        }
    }
    System.out.println("El sueldo medio de los hombres es: " + sumamasc/masc);
    System.out.println("El sueldo medio de las mujeres es: " + sumafem/fem);

    if(sumamasc/masc > sumafem/fem){
        System.out.println("Existe una brecha salarial a favor de los hombres");
    }else{
        System.out.println("Existe una brecha salarial a favor de las mujeres");
    }

}
}
