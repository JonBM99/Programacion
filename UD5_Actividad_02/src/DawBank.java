import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        

        System.out.println("Vamos a crear un cliente para la cuenta.");
        System.out.println("Introduzca el nombre del cliente.");
        String nombre = entrada.nextLine();
        System.out.println("Introduzca el DNI del cliente.");
        String dni = entrada.nextLine();
        LocalDate fechaNacimiento = leerFecha("Introduce la fecha de nacimiento del cliente en formato dd/mm/yyyy");
        System.out.println("Introduzca el teléfono del cliente.");
        String telefono = entrada.nextLine();
        System.out.println("Introduzca el email del cliente.");
        String email = entrada.nextLine();
        System.out.println("Introduzca la dirección del cliente.");
        String direccion = entrada.nextLine();
        Cliente cliente = new Cliente(nombre, dni, fechaNacimiento, telefono, email, direccion);

        CuentaBancaria cuenta = new CuentaBancaria(iban, cliente);

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
                    System.out.println("Nombre: " + cliente.getNombre() + " IBAN: " + cuenta.getIban() + " Saldo: " + cuenta.getSaldo() + "EUR");
                    break;
                case "2":
                    System.out.println("El IBAN es: " + cuenta.getIban());
                    break;
                case "3":
                    System.out.println("El titular de la cuenta es: " + cliente.getNombre());
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
                    System.out.println(cuenta.mostrarMovimiento());
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
    public static LocalDate leerFecha(String mensaje){
        Scanner entrada = new Scanner(System.in);
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nEscribe tu fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = entrada.next();
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
}
}
