import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        List <Producto> productos = new LinkedList<>();
        Producto producto = null;
        String opcion;
        System.out.println("Menú");
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Eliminar producto por codigo.");
        System.out.println("4. Guardar producto en el fichero.");
        System.out.println("5. Salir.");
        opcion = entrada.nextLine();
        do { 
            switch (opcion) {
                case "1":
                    crearProducto();
                    productos.add(producto);
                    break;
                case "2":
                    System.out.println("Productos registrados: ");
                    for (Producto p : productos) {
                        System.out.println(p);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != "5");
        
        




    }
    public static void crearProducto(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Vamos a crear un producto");
        System.out.println("Introduce el código del producto: ");
        String codigo = entrada.nextLine();
        System.out.println("Introduce el nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la cantidad del producto: ");
        int cantidad = entrada.nextInt();
        System.out.println("Introduce el precio del producto: ");   
        double precio = entrada.nextDouble();
        Producto producto = new Producto(codigo, nombre, cantidad, precio);
        System.out.println("Producto creado: " + producto);
    }
}