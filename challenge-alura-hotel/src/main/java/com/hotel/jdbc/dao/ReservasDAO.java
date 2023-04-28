package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.hotel.jdbc.modelo.Reservas;

public class ReservasDAO {
    private Connection con;

    public ReservasDAO(Connection con) { //CONSTRUCTOR
        this.con = con;
    }


    public List<Reservas> listar() {
        
        try {
            
            final PreparedStatement stmt = con.prepareStatement("SELECT * FROM RESERVAS");
            
            try(stmt) {
                
                final ResultSet rs = stmt.executeQuery();
                
                try(rs) {

                    while (rs.next()) {

                        var reservas=new Reservas(rs.getInt("ID"),
                                                  rs.getDate("FECHAENTRADA"),
                                                  rs.getDate("FECHASALIDA"),
                                                  rs.getDouble("VALOR"),
                                                  rs.getString("FORMAPAGO"));

                    }
                    
                    

                 }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }    

}
