import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
    import java.util.regex.Pattern;
    
    public class myUtils {
    
        Scanner entrada = new Scanner(System.in);
    
        public static void imprimir(String mensaje){
            System.out.println(mensaje);
        }
    
        public static String leerTextoPantalla(String mensaje){
            Scanner entrada = new Scanner(System.in);
            System.out.println(mensaje);
            String valor = entrada.nextLine();
            return valor;
        }
        public static LocalDate leerFecha(String mensaje){
            Scanner entrada = new Scanner(System.in);
            String texto;
            DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("\nEscribe tu fecha de nacimiento en formato DD/MM/AAAA");
            String dateString = entrada.next();
            LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
            return fechaLocalDate;
    }
    
        public static boolean comprobarPatron(String patron, String texto)
        {
            boolean isOk = false;
            Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
            Matcher mat = pat.matcher(texto);
            isOk = mat.matches();
            return isOk;
        }
    
        public static String comprobarPatronRepetidamente(String patron, String mensaje){
            boolean isOk = false;
            String texto;
            do { 
                texto = myUtils.leerTextoPantalla(mensaje);
                isOk = myUtils.comprobarPatron(patron, texto);
                if(!isOk){
                    myUtils.imprimir("El formato es incorrecto");
                }
            } while (!isOk);
            return texto;
        }

        public static GeneroPelicula menuGenero(){
            Scanner entrada = new Scanner(System.in);

            GeneroPelicula genero =  null;
            System.out.println("Seleccione el genero de la pelicula:");
            for (int i = 0; i < GeneroPelicula.values().length; i++) {
                System.out.println((i+1) + ". " + GeneroPelicula.values()[i]);
            }
            System.out.println("Introduce el nombre del genero");
            int opcion = entrada.nextInt();
            if (opcion >= 1 && opcion <= GeneroPelicula.values().length){
                genero = GeneroPelicula.values()[opcion - 1];
                System.out.println("El genero seleccionado es: " + genero);
            }
            return genero;
        }
    }