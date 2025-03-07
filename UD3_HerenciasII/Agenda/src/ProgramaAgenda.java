import java.util.Scanner;

public class ProgramaAgenda {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    Agenda agenda = new Agenda();
    int opcion = 0;

    do {
        System.out.println("<=== MENU AGENDA ===>");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
        opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                String nombre;
                do {
                    System.out.print("Ingresa el nombre del contacto: ");
                    nombre = entrada.nextLine();
                    if (agenda.existeContacto(nombre)) {
                        System.out.println("Dos contactos no pueden tener el mismo nombre.");
                    }
                } while (agenda.existeContacto(nombre));
                System.out.print("Ingresa el numero de teléfono: ");
                String  telefono = entrada.nextLine();
                Contactos contacto = new Contactos(nombre, telefono);
                agenda.agregarContacto(contacto);
                System.out.println("Contacto agregado correctamente.");
                break;
            case 2:
                System.out.println("<==== CONTACTOS ====>");
                agenda.listarContactos();
                break;
            case 3:
                System.out.print("Ingresa el nombre del contacto a buscar: ");
                String nombreBuscar = entrada.nextLine();
                int indice = agenda.buscarContacto(nombreBuscar);
                if (indice != -1) {
                    System.out.println("Contacto encontrado: " + agenda.getContacto(indice));
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 4:
                System.out.print("Ingresa el nombre del contacto a eliminar: ");
                String nombreEliminar = entrada.nextLine();
                boolean eliminado = agenda.eliminarContacto(nombreEliminar);
                if (eliminado) {
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("Contacto no encontrado.");
                }
                break;
            case 5:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Ingresa una opcion valida.");
                break;
        }
    } while (opcion != 5);
    }
}