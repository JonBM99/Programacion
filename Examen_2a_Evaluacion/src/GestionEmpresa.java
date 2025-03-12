import java.time.LocalDate;
import java.util.Scanner;

public class GestionEmpresa {
public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    final String patroncif = "[A-Z]{1}[0-9]{8}";
    final String patrondni = "[0-9]{8}[A-Z]{1}";
    final String patronnumeroSS = "[0-9]{10}";
    final String patronnumeroTelefono = "[0-9]{9}";
    Trabajador trabajador = null;
    GerenteDep gerente = null;
    Director director = null;

    System.out.println("Creemos la empresa:");
    String nombre = myUtils.leerTextoPantalla("Introduce el nombre de la empresa");
    String cif = myUtils.comprobarPatronRepetidamente(patroncif, "Introduce el cif de la empresa");
    Empresa empresa = new Empresa(nombre, cif);
    System.out.println("Empresa creada correctamente");

    
    System.out.println("Bienvenido a GestionEmpresa");
    String opcion;
    do { 
        System.out.println("1. Registrar trabajador en empresa");
        System.out.println("2. Mostrar informacion general de la empresa");
        System.out.println("3. Mostrar el numero de trabajadores actuales y el organigrama de la empresa");
        System.out.println("4. Mostrar informacion de un departamento");
        System.out.println("5. Eliminar trabajador de la empresa");
        System.out.println("6. Agenda Director");
        System.out.println("7. Salir de la aplicacion");
        opcion = entrada.nextLine();

        switch (opcion) {
            case "1":
                entrada = new Scanner(System.in);
                System.out.println("1.Crear director");
                System.out.println("2.Crear gerenteDep");
                System.out.println("3.Crear trabajador");
                String opcion1 = entrada.nextLine();
                switch (opcion1) {
                    case "1":
                    try {
                        entrada = new Scanner(System.in);
                        String nombreD = myUtils.leerTextoPantalla("Introduce el nombre del director");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Introduce la fecha de nacimiento del director");
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del director");
                        String direccion = myUtils.leerTextoPantalla("Introduce la direccion del director");
                        String numeroSS = myUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del director");
                        String numTelefono = myUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del director");
                        String salario = myUtils.leerTextoPantalla("Introduce el salario del director");
                        Director d = new Director(nombreD, dni, fechaNacimiento, direccion, numeroSS, dni, salario, null, numTelefono);
                        director = d;
                        empresa.registrarDirector(director);
                    } catch (DirectorYaRegistradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    case "2":
                    try {
                        entrada = new Scanner(System.in);
                        String nombreG = myUtils.leerTextoPantalla("Introduce el nombre del gerente");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Introduce la fecha de nacimiento del gerente");
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del gerente");
                        String direccion = myUtils.leerTextoPantalla("Introduce la direccion del gerente");
                        String numeroSS = myUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del gerente");
                        String numTelefono = myUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del gerente");
                        String salario = myUtils.leerTextoPantalla("Introduce el salario del gerente");
                        Departamento departamento = myUtils.menuDepartamento();
                        GerenteDep g = new GerenteDep(nombreG, dni, fechaNacimiento, direccion, numeroSS, numTelefono, salario, departamento, 0);
                        gerente = g;
                        empresa.registrarGerente(gerente);
                    } catch (GerenteYaRegistradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case "3":
                    try {
                        entrada = new Scanner(System.in);
                        String nombreT = myUtils.leerTextoPantalla("Introduce el nombre del trabajador");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Introduce la fecha de nacimiento del trabajador");
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del trabajador");
                        String direccion = myUtils.leerTextoPantalla("Introduce la direccion del trabajador");
                        String numeroSS = myUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del trabajador");
                        String numTelefono = myUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del trabajador");
                        String salario = myUtils.leerTextoPantalla("Introduce el salario del trabajador");
                        Departamento departamento = myUtils.menuDepartamento();
                        Trabajador t = new Trabajador(nombreT, dni, fechaNacimiento, direccion, numeroSS, numTelefono, salario, departamento); 
                        trabajador = t;
                        empresa.registrarTrabajador(trabajador);
                    } catch (TrabajadorYaRegistradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    default:
                        System.out.println("Introduce un valor valido.");
                }
            break;
            
        case "2":
            System.out.println(empresa.toString());
            System.out.println(empresa.mostrarTrabajadores());
        break;
        
        case "3":
            System.out.println("El numero de empleados es: " + empresa.numeroEmpleados());
            System.out.println(empresa.mostrarTrabajadores());
        break;
        
        case "4":
            entrada = new Scanner(System.in);
            System.out.println("Selecciona el departamento del que quieres mostrar sus trabajadores");
            Departamento departamento = myUtils.menuDepartamento();
            System.out.println(empresa.mostrarTrabajadoresPorDepartamento(departamento));
        break;
        
        case "5":
            entrada = new Scanner(System.in);
            System.out.println("Introduce el dni del trabajador que quieres dar de baja");
            System.out.println(empresa.mostrarTrabajadores());
            String dni = entrada.nextLine();
            empresa.eliminarTrabajador(dni); 
        break;
        
        case "6":
            entrada = new Scanner(System.in);
            System.out.println("1.Reunion");
            System.out.println("2.Fuera de la oficina");
            System.out.println("3.Convocar a toda la empresa");
            String opcion2 = entrada.nextLine();
            switch(opcion2){
                case "1":
                    System.out.println(empresa.reunirEmpresa());
                break;
                    
                case "2":
                    System.out.println(empresa.mostrarTrabajadoresFuera());
                break;

                case "3":
                    entrada = new Scanner(System.in);
                    LocalDate fecha = myUtils.leerFecha("Introduce el dia que quieres que sea la reunion");
                    System.out.println("Se convoca a toda la empresa el dia: " + fecha + "a la hora resevada para las reuniones.");
                break;

                default:
                    System.out.println("Introduce un valor valido.");
            }
        break;
        
        case "7":
            System.out.println("Saliendo del programa");
        break;
            default:
                System.out.println("Introduce un valor valido.");
        }
    } while (!opcion.equals("7"));
}
}
