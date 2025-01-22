import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();//Crea un arraylist de productos.
        Producto producto = new Producto("Portatil", 1);
        Producto producto1 = new Producto("Monitor", 2);
        Producto producto2 = new Producto("Movil", 3);
        Producto producto3 = new Producto("Teclado", 4);
        Producto producto4 = new Producto("Raton", 5);

        productos.add(producto);//Añadir los productos al arraylist.
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        
        System.out.println("Productos en el arraylist: ");
        Iterator <Producto> itera = productos.iterator();//Mostrar productos usando iterator.
        Producto cadaProducto;
        while (itera.hasNext()){
            cadaProducto = itera.next();
            System.out.println(cadaProducto);
        }

        productos.remove(producto2);//Eliminar un producto del arraylist.
        productos.remove(producto3);

        Producto productoNuevo = new Producto("Impresora", 6);
        productos.add(2, productoNuevo);//Añadir un producto en la posicion 2.

        System.out.println("\n" + "Productos en el arraylist: ");
        Iterator <Producto> itera1 = productos.iterator();
        Producto cadaProducto1;
        while (itera1.hasNext()){
            cadaProducto1 = itera1.next();
            System.out.println(cadaProducto1);
        }

        productos.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())); //Ordenar alfabéticamente los productos con compareTo y sort.
        System.out.println("\n" + "Productos ordenados alfabéticamente en la arraylist: ");
        Iterator <Producto> itera2 = productos.iterator();
        while (itera2.hasNext()){
            Producto cadaProducto2 = itera2.next();
            System.out.println(cadaProducto2);
        }

        
        LinkedList<Producto> productos1 = new LinkedList<>();//Crea una linkedlist de productos.

        productos1.add(producto);//Añadir los productos a la linkedlist.
        productos1.add(producto1);
        productos1.add(producto2);
        productos1.add(producto3);
        productos1.add(producto4);

        System.out.println("\n" + "Productos en la linkedlist: ");
        Iterator <Producto> itera3 = productos1.iterator();//Mostrar productos usando iterator.
        Producto cadaProducto3;
        while (itera3.hasNext()){
            cadaProducto3 = itera3.next();
            System.out.println(cadaProducto3);
        }

        productos1.remove(producto2);//Eliminar un producto de la linkedlist.
        productos1.remove(producto3);

        Producto productoNuevo1 = new Producto("Impresora", 6);
        productos1.add(2, productoNuevo1);//Añadir un producto en la posicion 2.

        System.out.println("\n" + "Productos en la linkedlist: ");
        Iterator <Producto> itera4 = productos1.iterator();
        Producto cadaProducto4;
        while (itera4.hasNext()){
            cadaProducto4 = itera4.next();
            System.out.println(cadaProducto4);
        }

        productos1.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())); //Ordenar alfabéticamente los productos con compareTo y sort.
        System.out.println("\n" + "Productos ordenados alfabéticamente en la linkedlist: ");
        Iterator <Producto> itera5 = productos1.iterator();
        while (itera5.hasNext()){
            Producto cadaProducto5 = itera5.next();
            System.out.println(cadaProducto5);
        }
        
        productos1.clear();// Elimina todos los valores del LinkedList
    }
}
