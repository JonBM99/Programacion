
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedList<Producto> productos = new LinkedList<>();
        String opcion;
        do { 
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir.");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    try (FileReader file = new FileReader("./Recursos/productos.csv"); BufferedReader reader = new BufferedReader(file);) {
                    String linea = reader.readLine();
                    while(linea != null){
                        String[] productosEscrito = linea.split(",");
                        Producto p =  new Producto(productosEscrito[0], productosEscrito[1], productosEscrito[2], productosEscrito[3]);
                        productos.add(p);
                        linea = reader.readLine();
                    }

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    for (Producto linea : productos) {
                        System.out.println(linea);
                    }
                break;

                case "2":
                    
                break;

                case "3":
                    
                break;

                default:
                    System.out.println("Introduce un valor valido");
            }

        } while (!opcion.equals("3"));
    }
}