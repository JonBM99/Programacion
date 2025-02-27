
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        VideoDaw videoclub = null;
        Cliente cliente = null;
        Pelicula pelicula = null;
        Videojuego videojuego = null;

        System.out.println("Bienvenido a GestionVideoDaw");
        String opcion;
        do { 
            System.out.println("1. Crear y registrar VideoClub");
            System.out.println("2. Registrar articulo");
            System.out.println("3. Crear y registrar cliente");
            System.out.println("4. Alquilar articulo");
            System.out.println("5. Devolver articulo");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja articulo");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = entrada.nextLine();

            switch(opcion){
                case "1":
                    entrada = new Scanner (System.in);
                    String cif = myUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF del videoclub");
                    String direccion = myUtils.leerTextoPantalla("Introduce la direccion del videoclub");
                    VideoDaw v = new VideoDaw(cif, direccion);
                    videoclub = v;
                    System.out.println(videoclub.toString());
                    break;
                case "2":
                    if(videoclub!=null){
                        entrada = new Scanner(System.in);
                        System.out.println("Pulsa 1 para registrar una pelicula, 2 para un videojuego");
                        String opcion1 = entrada.nextLine();
                        try {
                            switch (opcion1) {
                                    case "1":
                                        System.out.println("Registrar pelicula");
                                        String titulo = myUtils.leerTextoPantalla("Introduce el titulo de la pelicula");
                                        Genero_Peliculas genero_Peliculas = myUtils.menuGeneroPeliculas();
                                        Pelicula p = new Pelicula(titulo, genero_Peliculas);
                                        videoclub.registrarPelicula(p);
                                        pelicula = p;
                                        System.out.println(p.toString());
                                    break;
                                    case "2":
                                        System.out.println("Registrar videojuego");
                                        String titulo1 = myUtils.leerTextoPantalla("Introduce el titulo del videojuego");
                                        Genero_Videojuegos genero_Videojuegos = myUtils.menuGeneroVideojuegos();
                                        Videojuego v1= new Videojuego(titulo1, genero_Videojuegos);
                                        videoclub.registrarVideojuego(v1);
                                        videojuego = v1;
                                        System.out.println(v1.toString());
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                break;
                case "3":
                    if(videoclub != null){
                        entrada = new Scanner (System.in);
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del cliente"); 
                        String nombre = myUtils.leerTextoPantalla("Introduce el nombre del cliente");
                        String direccion1 = myUtils.leerTextoPantalla("Introduce la direccion del cliente");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del cliente con el siguiente formato: DD/MM/YYYY");
                        LocalDate hoy = LocalDate.now();
                        Period mayorEdad = Period.between(fechaNacimiento, hoy);
                        if(mayorEdad.getYears() >= 18){
                            try {
                            Cliente c = new Cliente(dni, nombre, direccion1, fechaNacimiento);
                            cliente = c;
                            videoclub.registrarCliente(cliente);
                            System.out.println(cliente.toString());
                            } catch (ClienteYaRegistradoException e) {
                                System.out.println(e.getMessage());
                            }
                        } else{
                        System.out.println("La edad minima para registrarse como cliente es de 18.");
                        }
                    } else{
                        System.out.println("Antes de registrar un cliente, crea un videoclub.");
                    }
                    break;
                case "4":
                    if(videoclub != null) {
                        entrada = new Scanner (System.in);
                        System.out.println("Quien va a alquilar?");
                        System.out.println(videoclub.mostrarClientes());
                        int c1 = entrada.nextInt();
                        System.out.println(videoclub.mostrarArticulosNoAlquilados(videoclub));
                        int v1 = entrada.nextInt();
                        videoclub.alquilarArticulo(v1, c1);
                        System.out.println(cliente.mostrarArticulosAlquilados());
                    }
                break;
                case "5":
                if(videoclub != null) {
                    entrada = new Scanner (System.in);
                    System.out.println("Quien va a devolver?");
                    System.out.println(videoclub.mostrarClientes());
                    int c1 = entrada.nextInt();
                    System.out.println(cliente.mostrarArticulosAlquilados());
                    int v1 = entrada.nextInt();
                    videoclub.devolverArticulo(v1, c1);
                    System.out.println(videoclub.mostrarArticulosNoAlquilados(videoclub));
                }
                break;
                case "6":
                    if(videoclub != null && cliente != null){
                        entrada = new Scanner (System.in);
                        System.out.println("Selecciona el cliente que quieres dar de baja.");
                        System.out.println(videoclub.mostrarClientes());
                        int codSocio = entrada.nextInt();
                        videoclub.darBajaCliente(codSocio);
                    }
                break;
                case "7":
                    if(videoclub != null && (pelicula != null || videojuego != null)){
                        entrada = new Scanner (System.in);
                        System.out.println("Selecciona el articulo que quieres dar de baja.");
                        System.out.println(videoclub.mostrarArticulosNoAlquilados(videoclub));
                        int a2 = entrada.nextInt();
                        videoclub.darBajaArticulo(a2);
                    }
                break;
                case "8":
                    System.out.println("Saliendo de GestionVideoDaw");
                    break;
            }
        } while (!opcion.equals("8"));
    }
}

