import java.util.Scanner;

public class ProgramaAgenda {
    
    
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Agenda agenda = new Agenda();
    int opcion;

    do {
        System.out.println("<=== MENU AGENDA ===>");
        System.out.println("1. Agregar contacto persona");
        System.out.println("2. Agregar contacto empresa");
        System.out.println("3. Mostrar contactos");
        System.out.println("4. Buscar contacto persona");
        System.out.println("5. Buscar contacto empresa");
        System.out.println("6. Eliminar contacto persona");
        System.out.println("7. Eliminar contacto empresa");
        System.out.println("8. Salir");
        System.out.print("Ingrese una opción: ");
        opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                String nombre;
                do {
                    System.out.print("Ingresa el nombre del contacto: ");
                    nombre = entrada.nextLine();
                    if (agenda.existeContactoPersona(nombre)) {
                        System.out.println("Dos contactos de persona no pueden tener el mismo nombre.");
                    }
                } while (agenda.existeContactoPersona(nombre));
                System.out.print("Ingresa el numero de teléfono: ");
                String  telefono = entrada.nextLine();
                System.out.print("Ingresa la fecha de cumpleaños: "); 
                String cumpleaños = entrada.nextLine();
                ContactoPersona contacto = new ContactoPersona(nombre, telefono, cumpleaños);
                agenda.agregarContacto(contacto);
                System.out.println("Contacto agregado correctamente.");
                break;
            case 2:
                String nombreEmpresa;
                do {
                    System.out.print("Ingresa el nombre del contacto: ");
                    nombreEmpresa = entrada.nextLine();
                    if (agenda.existeContactoEmpresa(nombreEmpresa)) {
                        System.out.println("Dos contactos de empresa no pueden tener el mismo nombre.");
                    }
                } while (agenda.existeContactoEmpresa(nombreEmpresa));
                System.out.print("Ingresa el numero de teléfono: ");
                String telefonoEmpresa = entrada.nextLine();
                System.out.print("Ingresa la pagina web: ");
                String paginaweb = entrada.nextLine();
                ContactoEmpresa contactoEmpresa = new ContactoEmpresa(nombreEmpresa, telefonoEmpresa, paginaweb);
                agenda.agregarContacto(contactoEmpresa);
                System.out.println("Contacto agregado correctamente.");
                break;
            case 3:
                System.out.println("<==== CONTACTOS ====>");
                agenda.listarContactos();
                break;
            case 4:
                System.out.print("Ingresa el nombre del contacto de persona a buscar: ");
                String nombreBuscar = entrada.nextLine();
                int indice = agenda.buscarContactoPersona(nombreBuscar);
                if (indice != -1) {
                    System.out.println("Contacto encontrado: " + agenda.getContacto(indice));
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 5:
                System.out.print("Ingresa el nombre del contacto de empresa a buscar: ");
                String nombreBuscar1 = entrada.nextLine();
                int indice1 = agenda.buscarContactoEmpresa(nombreBuscar1);
                if (indice1 != -1) {
                    System.out.println("Contacto encontrado: " + agenda.getContacto(indice1));
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 6:
                System.out.print("Ingresa el nombre del contacto persona a eliminar: ");
                String nombreEliminar = entrada.nextLine();
                boolean eliminado = agenda.eliminarContactoPersona(nombreEliminar);
                if (eliminado) {
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 7:
                System.out.print("Ingresa el nombre del contacto empresa a eliminar: ");
                String nombreEliminar1 = entrada.nextLine();
                boolean eliminado1 = agenda.eliminarContactoEmpresa(nombreEliminar1);
                if (eliminado1) {
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 8:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Ingresa una opcion valida.");
                break;
        }
    } while (opcion != 8);
    }
}