import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        //Ejercicio 1
        System.out.println("Introduce la cantidad de dinero en forma de multiplo de 5:");
        Scanner entrada = new Scanner(System.in);
        int dinero;
        dinero = entrada.nextInt();
        int b500 = 0;
        int b200 = 0;
        int b100 = 0;
        int b50 = 0;
        int b20 = 0;
        int b10 = 0;
        int b5 = 0;

        if (dinero >= 500) {
            b500 ++;
            b500 = dinero / 500;
            dinero %= 500;
        }
        if (dinero >= 200) {
            b200 ++;
            b200 = dinero / 200;
            dinero %= 200;
        }
        if (dinero >= 100) {
            b100 ++;
            b100 = dinero / 100;
            dinero %= 100;
        }
        if (dinero >= 50) {
            b50 ++;
            b50 = dinero / 50;
            dinero %= 50;
        }
        if (dinero >= 20) {
            b20 ++;
            b20 = dinero / 20;
            dinero %= 20;
        }
        if (dinero >= 10) {
            b10 ++;
            b10 = dinero / 10;
            dinero %= 10;
        }
        if (dinero >= 5) {
            b5 ++;
            b5 = dinero / 5;
        }
        
        System.out.println("Se necesitan " + b500 + " billetes de 500 euros");
        System.out.println("Se necesitan " + b200 + " billetes de 200 euros");
        System.out.println("Se necesitan " + b100 + " billetes de 100 euros");
        System.out.println("Se necesitan " + b50 + " billetes de 50 euros");
        System.out.println("Se necesitan " + b20 + " billetes de 20 euros");
        System.out.println("Se necesitan " + b10 + " billetes de 10 euros");
        System.out.println("Se necesitan " + b5 + " billetes de 5 euros");

        //Ejercicio 2
        String option = "";
        System.out.println("Introduce un numero");
        double num1 = entrada.nextDouble();
        System.out.println("Introduce otro numero");
        double num2 = entrada.nextDouble();

        do {
            option = entrada.nextLine();
            System.out.println("Pulsa 1 para realizar una suma.");
            System.out.println("Pulsa 2 para hacer una resta.");
            System.out.println("Pulsa 3 para realizar una multiplicacion.");            
            System.out.println("Pulsa 4 para realizar una division.");
            System.out.println("Pulsa 5 para salir del menu.");

            switch (option) {
                case "1":
                    double suma = num1 + num2;
                    System.out.println("La suma de los numeros es: " + suma);
                    break;

                case "2":
                    double resta = num1 - num2;
                    System.out.println("La resta de los numeros es: " + resta);
                    break;

                case "3":
                    double multiplicacion = num1 * num2;
                    System.out.println("La suma de los numeros es: " + multiplicacion);
                    break;

                case "4":
                    if (num2 == 0) {
                        System.out.println("No se puede hacer la division entre 0");
                    } else {
                        double division = num1 / num2;
                        System.out.println("La suma de los numeros es: " + division);
                    }
                    break;

                case "5":
                    System.out.println("Saliendo del programa. Hasta pronto");
                    break;

                default:
                    System.out.println("Introduce una opcion correcta del menu");
            }

        } while (!option.equals ("5"));
    }
}
