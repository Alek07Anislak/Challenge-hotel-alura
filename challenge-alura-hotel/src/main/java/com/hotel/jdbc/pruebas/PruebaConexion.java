package com.hotel.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    
    public static void main(String[] args) throws SQLException  {
        Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                    "root", 
                    "5966438012MySQL");
        System.out.println("Cerrando la conexión, pero que Mina no se cierre!!!!!!!!!");            

        con.close();            
    }
}
