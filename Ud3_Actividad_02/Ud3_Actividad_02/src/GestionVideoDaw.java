import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        VideoDaw v1 = null;
        Cliente cliente = null;
        Pelicula pelicula = null;

        System.out.println("Bienvenido a GestionVideoDaw.");
        String opcion;
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
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    String cif = myUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF del videoclub");
                    String direccion = myUtils.leerTextoPantalla("Introduce la direccion del videoclub");
                    VideoDaw videoclub = new VideoDaw(cif, direccion);
                    v1 = videoclub;
                    System.out.println(videoclub.mostrarInfoVideoclub());
                    break;
                case "2":
                    if(v1 != null){
                        entrada = new Scanner (System.in);
                        System.out.println("Registrar Pelicula");
                        String titulo = myUtils.leerTextoPantalla("Introduce el titulo de la pelicula");
                        Genero genero = myUtils.menuGenero();
                        Pelicula p = new Pelicula(titulo, genero);
                        v1.registrarPelicula(p);
                        pelicula = p;
                        System.out.println(p.mostrarInfoPelicula());
                    } else{
                        System.out.println("Antes de registrar una pelicula, cree un videoclub.");
                    }
                    break;
                case "3":
                entrada = new Scanner (System.in);
                    if(v1 != null){
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del cliente"); 
                        String nombre = myUtils.leerTextoPantalla("Introduce el nombre del cliente");
                        String direccionCliente = myUtils.leerTextoPantalla("Introduce la direccion del cliente");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del cliente con el siguiente formato: DD/MM/YYYY");
                        LocalDate hoy = LocalDate.now();
                        Period mayorEdad = Period.between(fechaNacimiento, hoy);
                        if(mayorEdad.getYears() > 18){
                            Cliente c = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                            v1.registrarCliente(c);
                            cliente = c;
                            System.out.println(c.mostraInfocliente());
                        } else{
                        System.out.println("La edad minima para registrarse como cliente es de 18.");
                        }
                    } else{
                        System.out.println("Antes de registrar un cliente, crea un videoclub.");
                    }
                    break;
                case "4":
                entrada = new Scanner (System.in);
                    if(v1!=null || cliente != null || pelicula != null){
                        System.out.println("Quien va a alquilar la pelicula?");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        System.out.println("Que pelicula quieres alquilar?");
                        v1.mostrarPeliculasNoAlquiladas(v1);
                        int p1 = entrada.nextInt();
                        v1.alquilarPelicula(c, p1);
                        v1.posicionCliente(c).addPelicula(v1.posicionPelicula(p1));
                        v1.posicionCliente(c).mostrarPeliculas();
                    } else{
                        System.out.println("Antes de alquilar una pelicula, registrala en el videoclub.");
                    }
                    break;
                case "5":
                entrada = new Scanner (System.in);
                    if(v1 != null && cliente != null && pelicula != null){
                        System.out.println("Selecciona el cliente que quiere devolver una pelicula.");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        System.out.println("Que pelicula va a devolver");
                        v1.mostrarPeliculasAlquiladas();
                        int p1 = entrada.nextInt();
                        v1.devolverPelicula(c, p1);
                        v1.posicionCliente(c).quitarPelicula(v1.posicionPelicula(p1));
                        v1.posicionCliente(c).mostrarPeliculas();
                        LocalDateTime fechaDevolucion = LocalDateTime.now();
                        Period dias = Period.between(pelicula.getFechaAlquiler().toLocalDate(), fechaDevolucion.toLocalDate());
                        if(dias.getDays() >= 2){
                            System.out.println("Has excedido el tiempo de alquiler. Deberas pagar una multa.");
                        }
                    } else{
                        System.out.println("Antes de devolver una pelicula, registrala en el videoclub.");
                    }
                    break;
                case "6":
                    if(v1 != null && cliente != null){
                        System.out.println("Selecciona el cliente que quieres dar de baja.");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        v1.darBajaCliente(cliente, c);
                    } else{
                        System.out.println("Para dar de baja a un cliente primero tienes que registrarlo.");
                    }
                    break;
                case "7":
                    if(v1 != null && pelicula != null){
                        System.out.println("Selecciona la pelicula que quieres dar de baja.");
                        v1.mostrarPeliculasNoAlquiladas(v1);
                        int p = entrada.nextInt();
                        v1.darBajaPelicula(pelicula, p);
                    } else{
                        System.out.println("Para dar de baja a una pelicula primero tienes que registrarla.");
                    }
                    break;
                case "8":
                    System.out.println("Saliendo de GestionVideoDaw");
                    break;
                default:
                    System.out.println("Introduce un valor valido.");
            }
        } while (!opcion.equals("8"));
    }

}