
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List <Libro> Biblioteca = new LinkedList<>();
        Libro l = null;
        Scanner entrada = new Scanner(System.in);
        String opcion;
        do { 
            System.out.println("1. Crear Libro y registrarlo en la biblioteca.");
            System.out.println("2. Mostrar Libros existentes por (ISBN, titulo, autor, fecha)");
            System.out.println("3. Eliminar Libro por ISBN");
            System.out.println("4. Guardar Libros en el fichero");
            System.out.println("5. Guardar y salir");
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Introduce el ISBN del libro");
                    String isbn = entrada.nextLine();
                    System.out.println("Introduce el titulo del libro");
                    String titulo = entrada.nextLine();
                    System.out.println("Introduce el autor del libro");
                    String autor = entrada.nextLine();
                    System.out.println("Introduce la fecha de publicacion del libro");
                    String fechaPublicacion = entrada.nextLine();
                    Libro libro = new Libro(isbn, titulo, autor, fechaPublicacion);
                    l = libro;
                    Biblioteca.add(l);
                break;
                case "2":
                String opcion2;
                do {
                    System.out.println("Busqueda de libros:");
                    System.out.println("Pulsa 1 para buscr por isbn");
                    System.out.println("Pulsa 2 para buscar por titulo");
                    System.out.println("Pulsa 3 para buscar por autor");
                    System.out.println("Pulsa 4 para buscar por fecha de publicacion");
                    System.out.println("Pulsa 5 para volver al menu principal");
                    opcion2 = entrada.nextLine();
                    switch(opcion2){
                        case "1":
                            System.out.println("Introduce el ISBN del libro a buscar");
                            String isbnBuscar = entrada.nextLine();
                            for (Libro l1 : Biblioteca) {
                                if (l1.getIsbn().equals(isbnBuscar)) {
                                    System.out.println(l1);
                                }
                            }
                        break;
                        case "2":
                            System.out.println("Introduce el titulo del libro a buscar");
                            String tituloBuscar = entrada.nextLine();
                            for (Libro l1 : Biblioteca) {
                                if (l1.getTitulo().equals(tituloBuscar)) {
                                    System.out.println(l1);
                                }
                            }
                        break;
                        case "3":
                            System.out.println("Introduce el autor del libro a buscar");
                            String autorBuscar = entrada.nextLine();
                            for (Libro l1 : Biblioteca) {
                                if (l1.getAutor().equals(autorBuscar)) {
                                    System.out.println(l1);
                                }
                            }
                        break;
                        case "4":
                            System.out.println("Introduce la fecha de publicacion del libro a buscar");
                            String fechaBuscar = entrada.nextLine();
                            for (Libro l1 : Biblioteca) {
                                if (l1.getFechaPublicacion().equals(fechaBuscar)) {
                                    System.out.println(l1);
                                }
                            }
                        break;
                        case "5":
                            System.out.println("Saliendo al menu principal");
                        break;
                    }
                } while (!opcion2.equals("5"));
                break;
                case "3":
                    System.out.println("Introduce el ISBN del libro a eliminar");
                    String isbnBuscar1 = entrada.nextLine();
                    for (Libro l1 : Biblioteca) {
                        if (l1.getIsbn().equals(isbnBuscar1)) {
                            Biblioteca.remove(l1);
                        }
                    }
                break;
                case"4":
                    try (FileOutputStream file = new FileOutputStream(".\\Resources\\Biblioteca.dat"); ObjectOutputStream buffer = new ObjectOutputStream(file)){
                        buffer.writeObject(l);
                    } catch (IOException e) {
                        System.out.println("Se ha producido un error " + e.getMessage());
                    }
                break;
                case "5":
                    System.out.println("Saliendo de biblioteca");
                    break;
                default:
                    throw new IllegalArgumentException("Introduce un valor valido");
            }
        } while (!opcion.equals("5"));
        
    }
}
