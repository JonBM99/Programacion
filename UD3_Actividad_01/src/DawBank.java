import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido a DawBank");
        System.out.println("Procedamos a crear su cuenta");

        String iban;
        System.out.println("Introduzca su IBAN.");
        do { 
            iban = entrada.nextLine();
        } while (!ibanValido(iban));
        

        System.out.println("Introduzca el titular de la cuenta");
        String titular = entrada.nextLine();
        
        CuentaBancaria cuenta = new CuentaBancaria(iban, titular);

        String opcion;
        entrada = new Scanner(System.in);
        do { 
            System.out.println("\nMenú principal:");
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. IBAN");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Titular: " + cuenta.getTitular() + " IBAN: " + cuenta.getIban() + " Saldo: " + cuenta.getSaldo() + "EUR");
                    break;
                case "2":
                    System.out.println("El IBAN es: " + cuenta.getIban());
                    break;
                case "3":
                    System.out.println("El titular de la cuenta es: " + cuenta.getTitular());
                    break;
                case "4" :
                    System.out.println("El saldo actual de la cuenta es: " + cuenta.getSaldo() + "EUR");
                    break;
                case "5":
                    System.out.println("Va a realizar un ingreso. Escriba la cantidad a ingresar.");
                    entrada = new Scanner(System.in);
                    double ingreso = entrada.nextDouble();
                    entrada.nextLine(); //liberar buffer PREGUNTAR
                    cuenta.ingreso(ingreso);
                    break;
                case "6":
                    System.out.println("Va a realizar una retirada de dinero. Escriba la cantidad a retirar.");
                    entrada = new Scanner(System.in);
                    double retirada = entrada.nextDouble();
                    entrada.nextLine(); //liberar buffer PREGUNTAR
                    cuenta.retirada(retirada);
                    break;
                case "7":
                    cuenta.mostrarMovimiento();
                    break;
                case "8":
                    System.out.println("Saliendo del programa DawBank");
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
        } while (!opcion.equals("8"));
    }

    private static boolean ibanValido(String iban){
        return iban.matches("[A-Z]{2}\\d{22}");
    }
}
