package com.decroly.pruebaexamenfinal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String SCHEMA = "javafx";
    private static final String USUARIO = "root";
    private static final String CLAVE = "daw12";

    public static Connection getConnection() {
        Connection con = null;

        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL+SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de acceso al driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }

        return con;
    }
}
