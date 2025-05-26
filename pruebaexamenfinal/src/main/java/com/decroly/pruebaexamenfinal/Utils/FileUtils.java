package com.decroly.pruebaexamenfinal.Utils;

import com.decroly.pruebaexamenfinal.model.Producto;

import java.io.*;
import java.util.LinkedList;

public class FileUtils {
    public static void WriteFile(String fileName, LinkedList<Producto> productos) {
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false)) {
            ObjectOutputStream buffer = new ObjectOutputStream(file);
            for (Producto producto : productos) {
                buffer.writeObject(producto);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }
    }

    public static LinkedList<Producto> readFile(String fileName) {
        LinkedList<Producto> productos = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName)) {
            ObjectInputStream reader = new ObjectInputStream(file);
            while(!eof) {
                Producto p = (Producto) reader.readObject();
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
