import java.time.LocalDate;
import java.util.Scanner;

public class Gestion {
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
    String nombre = MiUtils.leerTextoPantalla("Introduce el nombre de la empresa");
    String cif = MiUtils.comprobarPatronRepetidamente(patroncif, "Introduce el cif de la empresa");
    LocalDate fFundacion = MiUtils.leerFecha("Introduce la fecha de fundacion de la empresa");
    Empresa empresa = new Empresa(nombre, cif, fFundacion);
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
                        entrada = new Scanner(System.in);
                        String nombreD = MiUtils.leerTextoPantalla("Introduce el nombre del director");
                        LocalDate fechaNacimiento = MiUtils.leerFecha("Introduce la fecha de nacimiento del director");
                        String dni = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del director");
                        String direccion = MiUtils.leerTextoPantalla("Introduce la direccion del director");
                        String numeroSS = MiUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del director");
                        String numTelefono = MiUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del director");
                        System.out.println("Introduce el salario del director.");
                        Double salario = entrada.nextDouble();
                        Director d = new Director(nombre, fechaNacimiento, dni, numeroSS, Departamento.DIRECCION, salario, numTelefono);
                        director = d;
                        empresa.registrarDirector(director);
                    break;

                    case "2":
                        entrada = new Scanner(System.in);
                        String nombreG = MiUtils.leerTextoPantalla("Introduce el nombre del gerente");
                        LocalDate fechaNacimiento1 = MiUtils.leerFecha("Introduce la fecha de nacimiento del gerente");
                        String dni1 = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del gerente");
                        String direccion1 = MiUtils.leerTextoPantalla("Introduce la direccion del gerente");
                        String numeroSS1 = MiUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del gerente");
                        String numTelefono1 = MiUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del gerente");
                        System.out.println("Introduce el salario del director.");
                        Double salario1 = entrada.nextDouble();
                        Departamento departamento = MiUtils.menuDepartamento();
                        GerenteDep g = new GerenteDep(nombre, fechaNacimiento, dni, dni1, departamento, salario, numTelefono);
                        gerente = g;
                        empresa.registrarGerente(gerente);
                    break;
                    case "3":
                    try {
                        entrada = new Scanner(System.in);
                        String nombreT = MiUtils.leerTextoPantalla("Introduce el nombre del trabajador");
                        LocalDate fechaNacimiento = MiUtils.leerFecha("Introduce la fecha de nacimiento del trabajador");
                        String dni = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del trabajador");
                        String direccion = MiUtils.leerTextoPantalla("Introduce la direccion del trabajador");
                        String numeroSS = MiUtils.comprobarPatronRepetidamente(patronnumeroSS, "Introduce el numero de seguridad social del trabajador");
                        String numTelefono = MiUtils.comprobarPatronRepetidamente(patronnumeroTelefono, "Introduce el numero de telefono del trabajador");
                        String salario = MiUtils.leerTextoPantalla("Introduce el salario del trabajador");
                        Departamento departamento = MiUtils.menuDepartamento();
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
            Departamento departamento = MiUtils.menuDepartamento();
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
                    LocalDate fecha = MiUtils.leerFecha("Introduce el dia que quieres que sea la reunion");
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
