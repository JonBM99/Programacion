package com.decroly.daw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Introduce tu edad: ");
		Scanner entrada = new Scanner(System.in);
		int edad = entrada.nextInt();
		if (edad >= 18) {
			System.out.println("Eres mayor de edad");
		}
		
		//Ejercicio 2
		System.out.println("Introduce tu edad: ");
		int edad1 = entrada.nextInt();
		if (edad1 >= 18) {
			System.out.println("Eres mayor de edad");
		} else if (edad1 < 18){
			System.out.println("Eres menor de edad");
		}
		
		//Ejercicio 3
		for (int i=1;i<=20;i++) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n");
		
		//Ejercicio 4
		for (int i=2;i<=200;i=i+2) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n");
		
		//Ejercicio 5
		for (int i=1;i<=200;i++) {
			if (i % 2 == 0) {
			System.out.print(i + " ");}
		}
		
		System.out.print("\n");
		
		//Ejercicio 6
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		int num = entrada.nextInt();
		for (int cont1=1;cont1<=num;cont1++) {
		System.out.print(cont1 + " ");
		}
		
		System.out.println("\n");
		
		//Ejercicio 7
		System.out.println("Introduce la calificacion: ");
		entrada = new Scanner(System.in);
		int nota;
		nota = entrada.nextInt();
		
		if (nota < 5) {
			System.out.println("Insuficiente");
			}
		else if (nota < 6) {
			System.out.println("Suficiente");
			}
		else if (nota < 7) {
			System.out.println("Bien");
			}
		else if (nota < 9) {
			System.out.println("Notable");
			}
		else if (nota <= 10){
			System.out.println("Sobresaliente");
			}
		
		//Ejercicio 8 
		System.out.println("Introduce un numero positivo:");
		entrada = new Scanner(System.in);
		int facto;
		facto = entrada.nextInt();
		if (facto < 0) {
			System.out.println("No se puede hacer el factorial");
		} 
		else {
			int factorial = 1;
			for (int i = 1; i <= facto; i++) {
				factorial *= i; // factorial = factorial * i;
			}
			System.out.println("El factorial es " + facto + " es: " + factorial);
		}
		
		//Ejericicio 9
		System.out.println("Introduce la hora: ");
		entrada = new Scanner(System.in);
		int hora;
		hora = entrada.nextInt();
		System.out.println("Introduce los minutos: ");
		entrada = new Scanner(System.in);
		int minutos;
		minutos = entrada.nextInt();
		System.out.println("Introduce los segundos: ");
		entrada = new Scanner(System.in);
		int segundos;
		segundos = entrada.nextInt();
		
		if (hora > 23) {
			System.out.println("No se puede realizar.");
		}
		if (minutos > 59) {
			System.out.println("No se puede realizar.");
		}
		if (segundos > 59) {
			System.out.println("No se puede realizar.");
		}
		
		segundos++;
		if(segundos == 60) {
			segundos = 0; minutos ++;			
		}
		if (minutos == 60) {
			minutos = 0; hora ++;
		}
		if (hora >= 24) {
			hora = 0 ;
		}
		
		System.out.println("La nueva hora, minutos y segundos es: " + hora +":" + minutos +":" + segundos);
		
		//Ejercicio 10
		int intro = 0;
		boolean negativos = false;
		while (intro < 10) {
			System.out.println("Introduce un numero no nulo: ");
			entrada = new Scanner(System.in);
			int numeros;
			numeros = entrada.nextInt();
		
			if (numeros == 0) {
				System.out.println("Repite los numero y revisa que no haya un 0");
				continue;
				}
			if (numeros < 0) {
			negativos = true;
			}
			
			intro++;
		 }
		
		if (negativos == true) {
		System.out.println("Se ha leido al menos un numero negativo.");}
		else {System.out.println("No se ha leido ningun numero negativo");}
		
		//Ejericicio 11
		int intro1 = 0;
		int positivo = 0;
		int negativo = 0;
		while (intro1 < 10) {
			System.out.println("Introduce un numero no nulo: ");
			entrada = new Scanner(System.in);
			int numeros;
			numeros = entrada.nextInt();
						
			if (numeros == 0) {
				System.out.println("Repite los numero y revisa que no haya un 0");
					continue;
			}
			intro1 ++;
			
			if (numeros < 0) {
				negativo ++;
			}
			else {
				positivo ++;
			}
		}
			System.out.println("Se han leido " + positivo +" numeros positivos");
			System.out.println("Se han leido " + negativo +" numeros negativos");
		
		//Ejercicio 12
			
	}
}

