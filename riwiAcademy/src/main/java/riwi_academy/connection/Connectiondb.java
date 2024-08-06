package riwi_academy.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectiondb {
    public static Connection getConnection(){
        Connection connection = null;

        var dataBase = "riwiAcademyDB";
        var url = "jdbc:mysql://localhost:3306/" + dataBase;
        var user = "root";
        var password = "Rlwl2023.";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("the connection to the DB is not possible: " + e.getMessage()) ;
        }
        return connection;

    }
    // PRUEBA DE QUE SE PUEDE CONECTAR LA BASE DE DATOS
    public static void main(String[] args) {
        var connection = Connectiondb.getConnection();
        if (connection != null)
            System.out.println("the connection was succesfull " + connection);
        else
            System.out.println("ERROR TO CONECT");
    }
}
