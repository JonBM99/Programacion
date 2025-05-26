package com.decroly.pruebaexamenfinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SQLAccess {
    public static List<Producto> getProductos() {
        List<Producto> productos = new LinkedList<>();
        //Sentencia a la base de datos
        String getProducts = "SELECT * FROM Producto";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getProducts);){
            while (dataSet.next()){
                int id = dataSet.getInt("id");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("descripcion");
                double precio = dataSet.getDouble("precio");
                Tipo tipo = Tipo.valueOf(dataSet.getString("tipo"));

                Producto p = new Producto(id, nombre, descripcion, precio, tipo);
                productos.add(p);
            }
        }catch (Exception e){
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return productos;
    }

    public static List<Producto> getProductosbyName(String nombredelproducto){
        List<Producto> productos = new LinkedList<>();
        //Sentencia a la base de datos
        String getProducts = "SELECT * FROM Producto WHERE nombre = ?";
        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getProducts);){
            statement.setString(1, nombredelproducto);
            ResultSet dataSet = statement.executeQuery();
            while (dataSet.next()){
                int id = dataSet.getInt("id");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("descripcion");
                double precio = dataSet.getDouble("precio");
                Tipo tipo = Tipo.valueOf(dataSet.getString("tipo"));

                Producto p = new Producto(id, nombre, descripcion, precio, tipo);
                productos.add(p);
            }
        } catch (Exception e){
            System.out.println("Error al obtener los productos: " + e.getMessage());
        }
        return productos;
    }

    public static int añadirProducto(Producto producto){
        int response = -1;
        String añadirProducto = "INSERT INTO Producto (id, nombre, descripcion, precio, tipo) VALUES (?,?,?,?,?)";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(añadirProducto);) {
            statement.setInt(1, producto.getId());
            statement.setNString(2, producto.getNombre());
            statement.setNString(3, producto.getDescripcion());
            statement.setDouble(4, producto.getPrecio());
            statement.setNString(5, producto.getTipo().name());

            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    public static int eliminarProducto(Producto producto){
        int response = -1;
        String eliminarProducto = "DELETE FROM Producto WHERE id = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(eliminarProducto);) {
            statement.setInt(1, producto.getId());
            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }

    public static int editarProducto(Producto producto){
        int response = -1;
        String editarProducto = "UPDATE Producto SET nombre = ?, descripcion = ?, precio = ?, tipo = ? WHERE id = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(editarProducto);) {
            statement.setNString(2, producto.getNombre());
            statement.setNString(3, producto.getDescripcion());
            statement.setDouble(4, producto.getPrecio());
            statement.setNString(5, producto.getTipo().name());
            statement.setInt(1, producto.getId());

            response = statement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return response;
    }
}
