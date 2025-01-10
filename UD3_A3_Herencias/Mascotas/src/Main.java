import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        
        System.out.println("=== SISTEMA DE INVENTARIO DE MASCOTAS ===");
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n1. Insertar animal");
            System.out.println("2. Mostrar lista de animales");
            System.out.println("3. Mostrar datos de un animal concreto");
            System.out.println("4. Mostrar todos los datos de todos los animales");
            System.out.println("5. Eliminar animal");
            System.out.println("6. Vaciar inventario");
            System.out.println("7. Salir");
            
            System.out.print("\nSeleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1:
                    insertarAnimal(inventario);
                    break;
                case 2:
                    inventario.mostrarListaAnimales();
                    break;
                case 3:
                    System.out.print("Introduzca el índice del animal: ");
                    int indice = scanner.nextInt();
                    inventario.mostrarAnimal(indice);
                    break;
                case 4:
                    inventario.mostrarTodosLosDatos();
                    break;
                case 5:
                    System.out.print("Introduzca el índice del animal a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    inventario.eliminarAnimal(indiceEliminar);
                    break;
                case 6:
                    inventario.vaciarInventario();
                    System.out.println("Inventario vaciado.");
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
    
    private static void insertarAnimal(Inventario inventario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTipo de animal a insertar:");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Loro");
        System.out.println("4. Canario");
        System.out.print("Seleccione tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Datos comunes para todos los animales
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Estado (vivo/fallecido): ");
        String estado = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();
        
        switch (tipo) {
            case 1: // Perro
                System.out.print("Raza: ");
                String raza = scanner.nextLine();
                System.out.print("¿Tiene pulgas? (true/false): ");
                boolean pulgas = scanner.nextBoolean();
                inventario.insertarAnimal(new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgas));
                break;
                
            case 2: // Gato
                System.out.print("Color: ");
                String colorGato = scanner.nextLine();
                System.out.print("¿Tiene pelo largo? (true/false): ");
                boolean peloLargo = scanner.nextBoolean();
                inventario.insertarAnimal(new Gato(nombre, edad, estado, fechaNacimiento, colorGato, peloLargo));
                break;
                
            case 3: // Loro
                System.out.print("Tipo de pico: ");
                String pico = scanner.nextLine();
                System.out.print("¿Puede volar? (Sí/No): ");
                String vuela = scanner.nextLine();
                System.out.print("Origen: ");
                String origen = scanner.nextLine();
                System.out.print("Frase que habla: ");
                String habla = scanner.nextLine();
                inventario.insertarAnimal(new Loro(nombre, edad, estado, fechaNacimiento, pico, vuela, origen, habla));
                break;
                
            case 4: // Canario
                System.out.print("Tipo de pico: ");
                String picoCanario = scanner.nextLine();
                System.out.print("¿Puede volar? (Sí/No): ");
                String vuelaCanario = scanner.nextLine();
                System.out.print("Color: ");
                String colorCanario = scanner.nextLine();
                System.out.print("¿Canta? (true/false): ");
                boolean canta = scanner.nextBoolean();
                inventario.insertarAnimal(new Canario(nombre, edad, estado, fechaNacimiento, picoCanario, vuelaCanario, colorCanario, canta));
                break;
                
            default:
                System.out.println("Tipo de animal no válido");
        }
    }
}