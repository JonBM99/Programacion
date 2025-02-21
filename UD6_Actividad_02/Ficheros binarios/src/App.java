import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        List <Producto> productos = new LinkedList<>();
        

        String opcion;
        do { 
            System.out.println("Menú");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto por codigo.");
            System.out.println("4. Guardar producto en el fichero.");
            System.out.println("5. Salir.");
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    Producto producto = crearProducto();
                    productos.add(producto);
                    break;
                case "2":
                    System.out.println("Productos registrados: ");
                    for (Producto p : productos) {
                        System.out.println(p);
                    }
                    break;
                case "3":
                    System.out.println("Introduce el código del producto a eliminar: ");
                    String codigo = entrada.nextLine();
                    for (Producto p : productos) {
                        if (Integer.valueOf(p.getCodigo()).equals(Integer.valueOf(codigo))) {
                            productos.remove(p);
                            break;
                        }
                    }
                    break;
                case "4":
                        try (FileOutputStream fichero = new FileOutputStream("Ficheros binarios\\resources\\almacen.dat", false); DataOutputStream escritor = new DataOutputStream(fichero)) {
                            for (Producto prod : productos) {
                                escritor.writeInt(prod.getCodigo());
                                escritor.writeUTF(prod.getNombre());
                                escritor.writeInt(prod.getCantidad());
                                escritor.writeDouble(prod.getPrecio());
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    break; 
                case "5":
                    System.out.println("Hasta luego");
                    break;}
        } while (!opcion.equals("5"));
        entrada.close();
        }

    public static Producto crearProducto(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Vamos a crear un producto");
        System.out.println("Introduce el nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la cantidad del producto: ");
        int cantidad = entrada.nextInt();
        System.out.println("Introduce el precio del producto: ");   
        double precio = entrada.nextDouble();
        Producto producto = new Producto(nombre, cantidad, precio);
        System.out.println("Producto creado: " + producto);
        return producto;
    }
}
