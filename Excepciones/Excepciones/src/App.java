
import java.util.ArrayList;
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
        // int numero;
        // String opcion;
        // entrada = new Scanner(System.in);
        // do { 
        //     try {
        //         System.out.println("<==MENU==>");
        //         System.out.println("1.- Probar numero positivo");
        //         System.out.println("2.- Probar numero negativo");
        //         System.out.println("3.- Salir");
        //         System.out.println("Elige una opcion:");
        //         opcion = entrada.nextLine();

        //         System.out.println("Introduce un numero:");
        //         numero = entrada.nextInt();
        //         switch (opcion) {
        //             case "1":
        //                 imprimePositivo(numero);
        //                 entrada.nextLine();
        //                 break;
        //             case "2":
        //                 imprimeNegativo(numero);
        //                 entrada.nextLine();
        //                 break;
        //             case "3":
        //                 System.out.println("Saliendo del programa...");
        //                 break;  
        //             default:
        //                 System.out.println("Opcion no valida");
        //         }
        //     } catch (Exception e) {
        //         System.out.println("Error: " + e.getMessage());
        //     }
        // } while (true);

        //Ejercicio 5
        // try {
        //     Gato gato1 = new Gato("Tom", 3);
        //     gato1.toString();
        //     Gato gato2 = new Gato("Garfield", 3);
        //     gato2.toString();    
        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        // try {
        //     Gato gato3 = new Gato("Tom", 3);
        //     gato3.setNombre("Po");
        //     gato3.toString();
        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        // try {
        //     Gato gato4 = new Gato("Tom", 3);
        //     gato4.setEdad(-1);
        //     gato4.toString();
        // } catch (Exception e) {
        //     System.out.println("Error: " + e.getMessage());
        // }

        //Ejercicio 6
        entrada = new Scanner(System.in);
        ArrayList<Gato> listaGatos = new ArrayList<>();
        
        System.out.println("Introduce los datos de los gatos:");
        do {
            try {
                System.out.println("Gato " + (listaGatos.size()+1)+ ": Introduce el nombre:");
                String nombre = entrada.nextLine();
                System.out.println("Gato " + (listaGatos.size()+1)+ ": Introduce la edad:");
                String edadString = entrada.nextLine();
                int edad = Integer.parseInt(edadString); //Convertir String a int porque si pedia un int directamente al crear el siguiente dato se salta la introduccion del nombre
                
                Gato gato = new Gato(nombre, edad);
                listaGatos.add(new Gato(nombre, edad));
                System.out.println("Gato añadido correctamente");
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido no es valido");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (listaGatos.size() < 5);

        System.out.println("Los gatos introducidos son:");
        for (Gato gato : listaGatos) {
            System.out.println(gato.toString());
        }
    }
    /**
     * 
     * @param p
     * @return
     * @throws Exception
     */
    public static String imprimePositivo(int p) throws Exception{
        if(p<0){
            throw new Exception("El valor introducido es menor de 0");
        }
        return "El valor introducido es: " + p;
    }
/**
 * 
 * @param n
 * @return
 * @throws Exception
 */
    public static String imprimeNegativo(int n) throws Exception{
        if(n>=0){
            throw new Exception("El valor introducido es mayor de 0");
        }
        return "El valor introducido es: " + n;
    }
}
