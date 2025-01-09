
import java.time.LocalDate;
import java.util.Scanner;

public class Gestion {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        final String patroncif = "[A-Z]{1}[0-9]{10}";
        Trabajador p = null;

        System.out.println("<== Bienvenido a GestoresEmpresas ==>");
        System.out.println("Procedemos a crear la empresa");

        String nombreEmpresa = MyUtils.leerTextoPantalla("Introduce el nombre de la empresa");
        String cifEmpresa = MyUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF de la empresa:");
        
        Empresa empresa = new Empresa(cifEmpresa, nombreEmpresa);
        System.out.println("Empresa creada correctamente.");

        String opcion;
        do {
            System.out.println("\n");
            System.out.println("1. Crear persona.");
            System.out.println("2. Registrar trabajador en empresa.");
            System.out.println("3. Mostrar informacion de la empresa.");
            System.out.println("4. Mostrar el numero de trabajadores actuales.");
            System.out.println("5. Mostrar informacion de todos los trabajadores.");
            System.out.println("6. Eliminar trabajador.");
            System.out.println("7. Eliminar persona.");
            System.out.println("8. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = entrada.nextLine();

            switch(opcion){
                case "1":
                    String nombre = MyUtils.leerTextoPantalla("Introduce el nombre de la persona:");
                    String dni = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI de la persona:");
                    String direccion = MyUtils.leerTextoPantalla("Introduce la direccion de la persona:");
                    LocalDate fechaNacimiento = MyUtils.leerFecha("Introduce la fecha de nacimiento de la persona:");
                    Trabajador trabajador = new Trabajador(dni, nombre, fechaNacimiento, direccion, "null");
                    p = trabajador;
                    empresa.registrarPersona(p);
                    empresa.mostrarPersonas();
                    break;
                case "2":
                if( p!=null){
                    System.out.println("Que persona quieres contratar?");
                    empresa.mostrarPersonas();
                    int i = entrada.nextInt();
                    empresa.registrarTrabajador(p, i);
                    System.out.println("Trabajador contratado correctamente.");
                } else {
                    System.out.println("Debes crear una persona(trabajador) antes.");
                }
                    break;
                case "3":
                    System.out.println("Informacion de la empresa:" + "\n" + empresa.mostrarInfoEmpresa());
                    break;
                case "4":
                    System.out.println("El numero de trabajadores actual es: "+ empresa.nTrabajadores);
                    break;
                case "5":
                    empresa.mostrarTrabajadores();
                    break;
                case "6":
                    System.out.println("Selecciona al trabajador que quieres eliminar:");
                    empresa.mostrarTrabajadores();
                    String dni1 = MyUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del trabajador:");
                    empresa.eliminarTrabajador(p, dni1);
                    System.out.println("Trabajador eliminado correctamente");
                    break;
                case "7":
                    System.out.println("Selecciona a la persona que quieres eliminar");
                    empresa.mostrarPersonas();
                    int i = entrada.nextInt();
                    empresa.eliminarPersona(p, i);
                    break;
                case "8":
                System.out.println("Saliendo de GestoresEmpresas");
                    break;
                default:
                System.out.println("Introduce un valor valido.");
            }
        }while (!opcion.equals("8"));
    }
}
