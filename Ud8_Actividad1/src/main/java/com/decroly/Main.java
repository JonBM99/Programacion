package com.decroly;

import java.util.List;
import java.util.Scanner;

import com.Productos;
import com.Tipos;

public class Main {
    public static void main(String[] args) {
        SQLAccessProducto miInventarioData = new SQLAccessProducto();

        Scanner entrada = new Scanner(System.in);
        String opcion;

        do { 
            System.out.println("1. Mostrar todos los productos del inventario");
            System.out.println("2. Busca producto por referencia");
            System.out.println("3. Busca producto por tipo");
            System.out.println("4. Busca producto por cantidad");
            System.out.println("5. Insertar un nuevo producto");
            System.out.println("6. Eliminar producto por referencia");
            System.out.println("7. Actualizar producto");
            System.out.println("8. Insertar un nuevo tipo de producto");
            System.out.println("9. Salir");
            opcion = entrada.nextLine();
            
            switch(opcion){
                case "1":
                    List<Productos> productos = miInventarioData.getProductos();
                    for (Productos todos : productos) {
                        System.out.println(todos);
                    }
                break;

                case "2":
                    System.out.println("Introduce la referencia del producto:");
                    String referencia = entrada.nextLine();

                    List<Productos> productosbyref = miInventarioData.getByReferencia(referencia);
                    for (Productos p : productosbyref) {
                        System.out.println(p);
                    }
                break;

                case "3":
                    System.out.println("Introduce el tipo del producto:");
                    int tipo = entrada.nextInt();
                    
                    List<Productos> productosbyTipo = miInventarioData.getByTipo(tipo);
                    for (Productos p : productosbyTipo) {
                        System.out.println(p);
                    }
                break;

                case "4":
                    System.out.println("Introduce la cantidad");
                    int cant = entrada.nextInt();

                    List<Productos> productosbyCantidad = miInventarioData.getByCantidad(cant);
                    for (Productos p : productosbyCantidad) {
                        System.out.println(p);
                    }
                break;

                case "5":
                    entrada = new Scanner(System.in);
                    System.out.println("Introduce la referencia del producto");
                    entrada = new Scanner(System.in);
                    String ref = entrada.nextLine();
                    System.out.println("Introduce el nombre del producto");
                    String nombre = entrada.nextLine();
                    System.out.println("introduce la descripcion del producto");
                    String descripcion = entrada.nextLine();
                    System.out.println("Introduce el tipo del producto");
                    int tipo1 = entrada.nextInt();
                    System.out.println("Introduce la cantidad");
                    int cantidad = entrada.nextInt();
                    System.out.println("Introduce el precio del producto");
                    double precio = entrada.nextDouble();
                    System.out.println("Introduce el descuento");
                    int descuento = entrada.nextInt();
                    System.out.println("Introduce el IVA");
                    int iva = entrada.nextInt();
                    System.out.println("Tiene descuento? s/n");
                    entrada = new Scanner(System.in);
                    String valor= entrada.nextLine();
                    boolean isAplicarDto = false;
                    if(valor.equalsIgnoreCase("s")){
                        isAplicarDto = true;
                    }
                    Productos nuevo = new Productos(ref, nombre, descripcion, tipo1, cantidad, precio, descuento, iva, isAplicarDto);
                    int response = miInventarioData.insertProducto(nuevo);
                    System.out.println("Se han insertado " + response + "elementos.");
                break;

                case "6":
                    System.out.println("Introduce la referencia del producto a eliminar");
                    String referencia1 = entrada.nextLine();
                    miInventarioData.deleteById(referencia1);
                break;

                case "7":
                    System.out.println("Introduce la referencia del producto a actualizar");
                    String referencia2 = entrada.nextLine();

                    System.out.println("introduce la descripcion del producto");
                    String descripcion1 = entrada.nextLine();
                    System.out.println("Introduce la cantidad");
                    int cantidad1 = entrada.nextInt();
                    System.out.println("Introduce el precio del producto");
                    double precio1 = entrada.nextDouble();
                    System.out.println("Introduce el descuento");
                    int descuento1 = entrada.nextInt();
                    System.out.println("Tiene descuento? s/n");
                    entrada = new Scanner(System.in);
                    String valor1= entrada.nextLine();
                    boolean isAplicarDto1 = false;
                    if(valor1.equalsIgnoreCase("s")){
                        isAplicarDto1 = true;
                    }
                    Productos update = new Productos(referencia2, descripcion1, cantidad1, precio1, descuento1, isAplicarDto1);
                    miInventarioData.updateProductobyRef(update);
                break;

                case "8":
                    System.out.println("Introduce el id del tipo que quieres crear");
                    int id2 = entrada.nextInt();
                    entrada = new Scanner(System.in);
                    System.out.println("Introduce el nombre del tipo que quieres crear");
                    String nombreTipo = entrada.nextLine();
                    Tipos nuevoTipo = new Tipos(id2, nombreTipo);
                    miInventarioData.insertTipo(nuevoTipo);
                    
                break;
            }
        } while (!opcion.equals("9"));
    }
}