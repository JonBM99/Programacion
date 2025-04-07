
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        LinkedList<Producto> productos = new LinkedList<>();
        try (FileReader file = new FileReader("Recursos\\productos.csv"); BufferedReader reader = new BufferedReader(file);) {
            String linea = reader.readLine();
            while(linea != null){
                String[] productosEscrito = linea.split("/");
                Producto p =  new Producto(productosEscrito[0], productosEscrito[1], productosEscrito[2], productosEscrito[3]);
                productos.add(p);
                linea = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int pos = 0;
        boolean eof = false;
		
		try(FileInputStream fichero = new FileInputStream("Recursos\\almacen.dat");
				DataInputStream lector = new DataInputStream(fichero);)
		{
			while(!eof)
			{
				int cantidad = lector.readInt();
				double precio = lector.readDouble();
				int descuento = lector.readInt();
				int IVA = lector.readInt();
				boolean aplicarDto = lector.readBoolean();

				productos.get(pos).setCantidad(cantidad);
				productos.get(pos).setPrecio(precio);
				productos.get(pos).setDescuento(descuento);
				productos.get(pos).setIva(IVA);
				productos.get(pos).setAplicarDto(aplicarDto);
				
				if(pos < productos.size()){
					pos++;
				}
			}

		}catch(EOFException e){
			eof = true;
		}catch(IOException e){
			System.out.println(e.getMessage());
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}


        String opcion;
        do { 
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir.");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    for (Producto linea : productos) {
                        System.out.println(linea);
                    }
                break;

                case "2":
                    System.out.println("Introduce la referencia del producto a eliminar:");
                    String referencia = entrada.nextLine();
                    boolean encontrado = false;
                    for (Producto producto : productos) {
                        if (producto.getReferencia().equals(referencia)) {
                            encontrado = true;
                            producto.setCantidad(0);
                            System.out.println("Ahora no existen unidades de este producto.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ningún producto con esa referencia.");
                    }
                break;
                case "3":
                    try (FileOutputStream file = new FileOutputStream("Recursos\\almacen.dat");
                        DataOutputStream writer = new DataOutputStream(file)) {
                        for (Producto p : productos) {
                            writer.writeInt(p.getCantidad());
                            writer.writeDouble(p.getPrecio());
                            writer.writeInt(p.getDescuento());
                            writer.writeInt(p.getIva());
                            writer.writeBoolean(p.isAplicarDto());
                        }
                    } catch (IOException e) {
                        System.out.println("Error al guardar los datos: " + e.getMessage());
                    }
                    System.out.println("Datos guardados correctamente.");
                break;

                default:
                    System.out.println("Introduce un valor valido");
            }

        } while (!opcion.equals("3"));
    }
}