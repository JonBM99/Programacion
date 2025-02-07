
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner entrada = new Scanner (System.in);
        int a;
        //Ejercicio 1
        // try {
        //     System.out.println("Introduce un numero:");
        //     a = entrada.nextInt();
        //     System.out.println("Valor introducido:" + a);
        // } catch (InputMismatchException e) {
        //     System.out.println("Valor introducido incorrecto");
        // }
        
        //Ejercicio 2
        int b;
        // try {
        //     System.out.println("Introduce un numero:");
        //     a = entrada.nextInt();
        //     System.out.println("Introduce otro numero:");
        //     b = entrada.nextInt();
        //     int division = a / b;
        //     System.out.println("La division entre los dos numeros tiene como resultado: " + division);
        // } catch (InputMismatchException e) {
        //     System.out.println("Valor introducido no valido");
    
        // } catch(ArithmeticException e){
        //     System.out.println("Introduce un valor en el segundo numero diferente a 0");
        // }

        //Ejercicio 3
        // double [] numeros = new double[5];

        // for (int i = 0; i < numeros.length; i++) {
        //     try {
        //         entrada = new Scanner(System.in); 
        //         System.out.println("Introduce un numero " +(i+1) + ":");
        //         numeros[i] = entrada.nextDouble();
        //     } catch (InputMismatchException e) {
        //         System.out.println("El valor introducido no es valido.");
        //     }
        // }
        // for (double num : numeros) {
        //     System.out.println("Los numeros introducidos son: " + num);
        // }

        //Ejericio 4
        int numero;
        String opcion;
        entrada = new Scanner(System.in);
        do { 
            try {
                System.out.println("<==MENU==>");
                System.out.println("1.- Probar numero positivo");
                System.out.println("2.- Probar numero negativo");
                System.out.println("3.- Salir");
                System.out.println("Elige una opcion:");
                opcion = entrada.nextLine();

                System.out.println("Introduce un numero:");
                numero = entrada.nextInt();
                switch (opcion) {
                    case "1":
                        imprimePositivo(numero);
                        entrada.nextLine();
                        break;
                    case "2":
                        imprimeNegativo(numero);
                        entrada.nextLine();
                        break;
                    case "3":
                        System.out.println("Saliendo del programa...");
                        break;  
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (true);

        //Ejercicio 5
        











        
    }
    public static void imprimePositivo(int p) throws IllegalArgumentException{
        if(p<0){
            throw new IllegalArgumentException("El valor introducido es menor de 0");
        }
        System.out.println("El valor introducido es: " + p);
    }

    public static void imprimeNegativo(int n) throws IllegalArgumentException{
        if(n>=0){
            throw new IllegalArgumentException("El valor introducido es mayor de 0");
        }
        System.out.println("El valor introducido es: " + n);
    }
}
