package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.Productos;
import com.Tipos;

public class SQLAccessProducto {

    public List<Productos> getProductos(){
        List<Productos> todosproductos = new LinkedList<>();

        String getProductosNames = "SELECT * FROM Producto";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getProductosNames);) {
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                Productos p1 = new Productos(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                todosproductos.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return todosproductos;
    }

    public List<Productos> getByReferencia(String referencia){
        List<Productos> productosReferencia = new LinkedList<>();

        String getPrRef = "SELECT * FROM Producto WHERE referencia = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getPrRef);){
            statement.setString(1, referencia);
            ResultSet dataSet = statement.executeQuery();
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia1 = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                Productos p1 = new Productos(id, referencia1, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                productosReferencia.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return productosReferencia;
    }

    public List<Productos> getByTipo(int tipo){
        List<Productos> productosTipo = new LinkedList<>();

        String getPrTipo = "SELECT * FROM Producto WHERE tipo = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getPrTipo);){
            statement.setInt(1, tipo);
            ResultSet dataSet = statement.executeQuery();
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia1 = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int tipo1 = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                Productos p2 = new Productos(id, referencia1, nombre, descripcion, tipo1, cantidad, precio, descuento, iva, aplicarDto);
                productosTipo.add(p2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return productosTipo;
    }

    public List<Productos> getByCantidad(int cant){
        List<Productos> productosCantidad = new LinkedList<>();

        String getPrCantidad = "SELECT * FROM Producto WHERE cantidad = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getPrCantidad);){
            statement.setInt(1, cant);
            ResultSet dataSet = statement.executeQuery();
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String referencia1 = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int tipo1 = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                Productos p3 = new Productos(id, referencia1, nombre, descripcion, tipo1, cantidad, precio, descuento, iva, aplicarDto);
                productosCantidad.add(p3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return productosCantidad;
    }

    public int insertProducto(Productos producto){
        int response = -1;
        String insertarProducto = "INSERT INTO Producto (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto)"+" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(insertarProducto);){
            statement.setNString(1, producto.getReferencia());
            statement.setNString(2, producto.getNombre());
            statement.setNString(3, producto.getDescripcion());
            statement.setInt(4, producto.getTipo());
            statement.setInt(5, producto.getCantidad());
            statement.setDouble(6, producto.getPrecio());
            statement.setInt(7, producto.getDescuento());
            statement.setInt(8, producto.getIva());
            statement.setBoolean(9, producto.isAplicarDto());

            response = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return response;
    }

    public int deleteById(String referencia1){
        int elements = -1;
        String sqlStatement = "DELETE FROM Producto WHERE referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement1 = connection.prepareStatement(sqlStatement);){

            statement1.setString(1, referencia1);
            elements = statement1.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return elements;
    }

    public int updateProductobyRef(Productos producto){
        int response = -1;
        String updateProducto = "UPDATE Producto SET descripcion = ?, cantidad= ?, precio= ?, descuento= ?, aplicarDto= ? WHERE referencia = ?";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(updateProducto);){
            statement.setNString(1, producto.getDescripcion());
            statement.setInt(2, producto.getCantidad());
            statement.setDouble(3, producto.getPrecio());
            statement.setInt(4, producto.getDescuento());
            statement.setBoolean(5, producto.isAplicarDto());
            statement.setNString(6, producto.getReferencia());

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public int insertTipo(Tipos tipo){
        int response = -1;
        String insertarTipo = "INSERT INTO Tipos (id, nombre)"+" VALUES (?, ?)";

        try(Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(insertarTipo);){
            statement.setInt(1, tipo.getId());
            statement.setNString(2, tipo.getNombre());

            response = statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return response;
    }
}

