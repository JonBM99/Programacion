import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}\\d{8}";
        final String patrondni = "\\d{8}[A-Z{1}]";

        System.out.println("Bienvenido a GestionVideoDaw.");
        int opcion;
        do { 
            System.out.println("1. Crear y registrar VideoClub");
            System.out.println("2. Registrar pelicula");
            System.out.println("3. Crear y registrar cliente");
            System.out.println("4. Alquilar pelicula");
            System.out.println("5. Devolver película");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja pelicula");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    String cif = myUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF del videoclub");
                    entrada.nextLine();
                    String direccion = myUtils.leerTextoPantalla("Introduce la direccion del videoclub");
                    VideoDaw v1 = new VideoDaw(cif, direccion, LocalDate.now());
                    System.out.println(v1.mostrarInfoVideoclub());
                    break;
                case 2:
                    String titulo = myUtils.leerTextoPantalla("Introduce el titulo de la pelicula");
                    GeneroPelicula genero = myUtils.menuGenero();
                    Pelicula p1 = new Pelicula(titulo, genero);
                    System.out.println(p1.mostrarInfoPelicula());
                    break;
                case 3:
                    String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del cliente"); 
                    String nombre = myUtils.leerTextoPantalla("Introduce el nombre del cliente");
                    String direccionCliente = myUtils.leerTextoPantalla("Introduce la direccion del cliente");
                    LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del cliente con el siguiente formato: DD/MM/YYYY");
                    Cliente cliente1 = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                    cliente1.registrarCliente(cliente1);
                    System.out.println(cliente1.mostrarInfoCliente());
                    break;
                case 4:
                    String pelicula = myUtils.leerTextoPantalla("Introduce la pelicula que se va a alquilar.");
                    String cliente = myUtils.leerTextoPantalla("Introduce el cliente que va a alquilar la pelicula.");
                    
                    break;

                default:
                    System.out.println("Introduce un valor valido.");
            }
        } while (opcion!=8);
    }

}
