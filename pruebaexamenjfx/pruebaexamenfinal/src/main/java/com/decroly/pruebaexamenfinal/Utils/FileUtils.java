package com.decroly.pruebaexamenfinal.Utils;

import com.decroly.pruebaexamenfinal.model.Producto_especial;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {
    public static void WriteFile(String fileName, LinkedList<Producto_especial> productos) {
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false)) {
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            for (Producto_especial producto : productos) {
                buffer.writeObject(producto);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static LinkedList<Producto_especial> readFile(String fileName) {
        LinkedList<Producto_especial> productos = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName)) {
            ObjectInputStream reader = new ObjectInputStream(file);
            while(!eof) {
                Producto_especial p = (Producto_especial) reader.readObject();
                productos.add(p);
            }
        } catch (EOFException e) {
            eof = true;
            System.out.println("Se ha leido el fichero completo");
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
        return productos;
    }
}
