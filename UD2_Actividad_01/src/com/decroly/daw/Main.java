package com.decroly.daw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejericio 1
		System.out.println("Buenos dias!");
		
		//Ejercicio 2
		int lado1=5;
		System.out.println("Area del cuadrado: " + lado1 * lado1);
		
		//Ejercicio 3
		System.out.println("Introduce el lado del cuadrado: ");
		Scanner entrada = new Scanner(System.in);
		int lado2 = entrada.nextInt();
		int area = lado2 * lado2;
		System.out.println("El area del cuadrado es:  " + area);
		
		//Ejercicio 4
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		int num1 = entrada.nextInt();
		//Entrada de un numero por teclado
		
		System.out.println("Introduce otro numero: ");
		entrada = new Scanner(System.in);
		int num2 = entrada.nextInt();
		//Entrada de otro numero por teclado
		
		int suma = (num1 + num2);
		int resta = (num1 - num2);
		int producto = (num1 * num2);
		int division = (num1 / num2);
		//Operaciones
		
		System.out.println("La suma de los numeros es: " + suma);
		System.out.println("La resta de los numeros es: " + resta);
		System.out.println("El producto de los numeros es: " + producto);
		System.out.println("La division de los numeros es: " + division);
		//Resultados
		
		//Ejercicio 5
		System.out.println("Introduce el radio de la circuferencia: ");
		entrada=new Scanner(System.in);
		double radio = entrada.nextInt();
		//Entrada del radio por teclado
		
		double pi = Math.PI;
		double longcircun = (2 * pi * radio);
		double areacircle = (pi * Math.pow(radio, 2));
		double volsphere = ((4.0 / 3.0) * pi * Math.pow(radio, 3));
		//Operaciones
		
		System.out.println("La longitud de la circunferencia es: " + longcircun);
		System.out.println("El area del circulo es: " + areacircle);
		System.out.println("El volumen de la esfera es: " + volsphere);
		//Resultados
		
		//Ejercicio 6
		System.out.println("Introduce el precio con descuento del producto: ");
		entrada = new Scanner(System.in);
		double preciodesc = entrada.nextInt();
		//Entrada precio con descuento
		
		System.out.println("Introduce el precio real del producto: ");
		entrada = new Scanner(System.in);
		double precioreal = entrada.nextInt();
		//Entrada precio real
		
		double descuento = (((precioreal - preciodesc) / precioreal) * 100);
		//Operacion
		
		System.out.println("El descuento en % es: " + descuento);
		//Resultados
		
		//Ejercicio 7
		System.out.println("Introduce las millas marinas: ");
		entrada = new Scanner(System.in);
		double millasmar = entrada.nextInt();
		//Entrada millas marinas
		
		double metros = (millasmar * 1852.0 );
		//Operacion
		
		System.out.println("Son " + metros + " metros");
		//Resultado
		
		//Ejercicio 8
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		double num3 = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
		entrada = new Scanner(System.in);
		double num4 = entrada.nextInt();
		//Entrada numeros
		
		double mayor = Math.max(num3, num4);
		double menor = Math.min(num3, num4);
		//Operacion
		
		System.out.println("El numero mayor es: " + mayor);
		System.out.println("El numero menor es: " + menor);
		//Resultados
		
		//Ejericio 9
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		double num5 = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
		entrada = new Scanner(System.in);
		double num6 = entrada.nextInt();
		//Entrada numeros
		
		System.out.println("¿Son iguales? " + (num5 == num6));
		System.out.println("¿El primer numero es mayor? " + (num5 > num6));
		//Resultados
		
		//Ejercicio 10
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		double num7 = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
		entrada = new Scanner(System.in);
		double num8 = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
		entrada = new Scanner(System.in);
		double num9 = entrada.nextInt();
		//Entrada numeros
		
		double mayor1 = Math.max(num7, num8);
		double mayor2 = Math.max(mayor1, num9);
		//Operaciones
		
		System.out.println("El numero mayor es: " + Math.max(mayor1, mayor2));
		//Resultado
		 
		
		//Ejercicio 11
		System.out.println("Introduce un numero: ");
			entrada = new Scanner(System.in);
			double num10 = entrada.nextInt();
		System.out.println("Introduce un numero diferente a 0: ");
			entrada = new Scanner(System.in);
			double num11 = entrada.nextInt();
		//Entrada numeros
			
		double suma1 = (num10 + num11);
		double resta1 = (num10 - num11);
		double producto1 = (num10 * num11);
		double division1 = (num10 / num11);
		//Operaciones
		
		System.out.println("La suma de los numeros es: " + suma1);
		System.out.println("La resta de los numeros es: " + resta1);
		System.out.println("El producto de los numeros es: " + producto1);
		System.out.println("La division de los numeros es: " + division1);
		//Resultados
			
		//Ejercicio 12 
		System.out.println("Introduce un numero: ");
			entrada = new Scanner(System.in);
			double num12 = entrada.nextInt();
		System.out.println("Introduce otro numero: ");
			entrada = new Scanner(System.in);
			double num13 = entrada.nextInt();
		//Entrada numeros
		
		double mayor3 = Math.max(num12, num13);
		//Operacion
	
		System.out.println("El numero mayor es: " + mayor);
		//Resultado
		
		
		//Ejercicio 13
		System.out.println("Introduce un numero: ");
		entrada = new Scanner(System.in);
		double num14 = entrada.nextInt();
		//Entrada numero
		
		System.out.println("El numero es negativo " + (num14 < 0));
		//Resultado
		}
}
